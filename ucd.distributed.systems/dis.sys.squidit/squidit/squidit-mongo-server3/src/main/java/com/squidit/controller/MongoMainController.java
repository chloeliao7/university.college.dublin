package com.squidit.controller;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.util.JSONSerializers;
import com.mongodb.util.ObjectSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
 


@RestController
@RequestMapping("/mongo")
public class MongoMainController {
  private final GridFsTemplate gridFsTemplate;
  GridFsOperations gridOperations;
  public List<InputStream> streams = new ArrayList<InputStream>();
  
  @Autowired
  public MongoMainController(GridFsTemplate gridFsTemplate) {
    this.gridFsTemplate = gridFsTemplate;
  }
  private Optional<GridFSDBFile> maybeLoadFile(String name) {
    GridFSDBFile file = gridFsTemplate.findOne(getFilenameQuery(name));
    return Optional.ofNullable(file);
  }
  
  @GetMapping("mongoMonitorStatus")
  @RequestMapping(value = "mongoMonitorStatus", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> mongoMonitorStatus() throws IOException {
    // Create counter to see how many videos database has
    int counter = 0;
    ObjectMapper mapper = new ObjectMapper();
    ArrayNode arrayNode = mapper.createArrayNode();
    ObjectNode objectNode1 = mapper.createObjectNode();
    
    List<GridFSDBFile> videoShowFileList = gridFsTemplate.find(new Query(Criteria.where("metadata.type").is("video")));
    List<String> filesNames = new ArrayList<>();
    
    for (GridFSDBFile fileListNames : videoShowFileList) {
      counter = counter + 1;
      objectNode1.put("fileName " + counter, fileListNames.getFilename());
      
    }
    
    objectNode1.put("mongoName", "mongo-server3");
    objectNode1.put("mongoUrlSlot", 2);
    objectNode1.put("totalSize", counter);
    
    arrayNode.add(objectNode1);

    
    
    return new ResponseEntity<String>(arrayNode.toString(), HttpStatus.OK);
  }
  
  // ===========================================================================
  // MONGO OPERATION MAPPING -  FIND ONE VIDEO
  // ===========================================================================
  
  public GridFsResource getUploadedFileResource(String fileNameForm) {
    GridFSDBFile file = this.gridFsTemplate.findOne(new Query(Criteria.where("filename").is(fileNameForm)));
    return new GridFsResource(file);
  }
  
  // we need to work on this one
  @RequestMapping(value = "/mongoRetrieve/{fileNameForm}/{extension}", method = RequestMethod.GET)
  public ResponseEntity<InputStreamResource> mongoRetrieveFile(@PathVariable("fileNameForm") String fileNameForm, @PathVariable("extension") String extension) throws IOException {
    
    
    fileNameForm = fileNameForm + "." + extension;
    
    
    
    GridFsResource resource = getUploadedFileResource(fileNameForm);
    try {
      return ResponseEntity.ok().contentType(MediaType.parseMediaType("video/mp4")).contentLength(resource.contentLength()).body(resource);
    } catch (IOException e) { return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
  }
  
  // ===========================================================================
  // MONGO OPERATION - CREATE MONGO DB
  // ===========================================================================
  
  @RequestMapping(value = "mongoCreate", method = RequestMethod.POST)
  public HttpEntity<byte[]> mongoCreate(@RequestParam("file") MultipartFile file) {
    DBObject metaData = new BasicDBObject();
    String fileName = file.getOriginalFilename();
    
    
    try {
      Optional<GridFSDBFile> existing = maybeLoadFile(fileName);
      if (existing.isPresent()) { gridFsTemplate.delete(getFilenameQuery(fileName)); }
      metaData.put("type", "video");
      metaData.put("size", file.getSize());
      gridFsTemplate.store(file.getInputStream(), fileName, metaData);
    } catch (IOException e) { return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }
  
  // ===========================================================================
  //  MONGO OPERATION MAPPING - RETRIEVE ALL FILES FROM DB
  // ===========================================================================
  
  private static Query getFilenameQuery(String name) { return Query.query(GridFsCriteria.whereFilename().is(name)); }
  
  @GetMapping("mongoRetrieve")
  @RequestMapping(value = "mongoRetrieve", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<String>> mongoRetrieve() throws IOException {
    
    List<GridFSDBFile> videoShowFileList = gridFsTemplate.find(new Query(Criteria.where("metadata.type").is("video")));
    List<String> filesNames = new ArrayList<>();
    
    for (GridFSDBFile fileListNames : videoShowFileList) {
      filesNames.add(fileListNames.getFilename());
      
    }
    return new ResponseEntity<List<String>>(filesNames, HttpStatus.OK);
  }
  
  // ===========================================================================
  // MONGO OPERATION -  DELETE DATABASE
  // ===========================================================================
  
  @GetMapping("mongoDeleteDB")
  public ResponseEntity mongoDeleteDB() {
    MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
    DB db = mongoClient.getDB("squidit-mongodb2");
    db.dropDatabase();
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }
}
