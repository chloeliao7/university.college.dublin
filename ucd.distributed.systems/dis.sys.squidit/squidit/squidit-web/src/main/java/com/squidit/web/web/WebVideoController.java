package com.squidit.web.web;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.squidit.web.model.VideoMultipartResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class WebVideoController {
  
  @Autowired
  private DiscoveryClient discoveryClient;
  
  // Parent URL
  @GetMapping("/")
  public String videoIndex() {
    return "videoShowMainPage";
  }
  
  // Main URL
  @GetMapping("/videoMain")
  public String videoMain() {
    return "videoShowMainPage";
  }
  
  // Video Upload URL
  @GetMapping("/video/videoUpload")
  public String videoUpload(Model model) {
    return "videoShowUploadPage";
  }
  
  // ===========================================================================
  // VIDEO UPLOAD Functionality - POST CLIENT UPLOAD
  // STEP 1.
  // direct /video/videoUpload >> /mongo/mongoCreate
  // create database and upload the file
  // ===========================================================================
  
  @RequestMapping(value = "/video/videoUpload", method = RequestMethod.POST)
  public String videoUpload(@RequestPart("file") final MultipartFile[] files) throws IOException {
    LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
    ResponseEntity<String> response;
    HttpStatus httpStatus = HttpStatus.CREATED;
    try {
      for (MultipartFile file : files) { if (!file.isEmpty()) map.add("file", new VideoMultipartResource(file.getInputStream(), file.getOriginalFilename())); }
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.MULTIPART_FORM_DATA);
      List<ServiceInstance> instances = discoveryClient.getInstances("monitor-service");  // Contact Monitor Service to see which database to contact
      ServiceInstance serviceInstance = instances.get(0);
      String baseUrl = serviceInstance.getUri().toString();
      baseUrl = baseUrl + "/monitor/monitorServiceStatus";
      RestTemplate restTemplate = new RestTemplate();
      
      String mongoUrl = contactMonitor(baseUrl);
      
      HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
      response = restTemplate.postForEntity(mongoUrl, requestEntity, String.class);
      
    } catch (HttpStatusCodeException e) {
      httpStatus = HttpStatus.valueOf(e.getStatusCode().value());
      
    } catch (Exception e) {
      httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
      
    }
    return "videoShowMainPage";
  }
  
  // ===========================================================================
  // Will contact back monitor and sent its URL
  // ===========================================================================
  
  public String contactMonitor(String monitorUrl) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity entity = new HttpEntity<>(headers); // Contact monitor-sevice which returns url of which Mongo to choose
    ResponseEntity<String> response = restTemplate.exchange(monitorUrl, HttpMethod.GET, entity, String.class);
    
    return response.toString();
  }
  
  // ===========================================================================
  // GET ALL FILES FROM MONGO & VIDEO RESPONSE
  // >> Step 2.a take /video/videoShowAll
  // >> retrieve ALL file names from /mongo/mongoRetrieve - SEND TO videoShowFile.html
  // 1. videoShowAll will host the form ()
  // ===========================================================================
  
  @GetMapping("/video/videoShowAll")
  public String videoShowAll(Model model) {
    List<ServiceInstance> instances = discoveryClient.getInstances("mongo-service3");
    ServiceInstance serviceInstance = instances.get(0);
    String baseUrl = serviceInstance.getUri().toString();
    baseUrl = baseUrl + "/mongo/mongoRetrieve/";
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity entity = new HttpEntity<>(headers);
    ArrayList<String> allVideoArray = new ArrayList<>();
    ResponseEntity<List> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, List.class);
    
    for (int i = 0; i < response.getBody().size(); i++) {
      
      allVideoArray.add(response.getBody().get(i).toString());
    }
    
    
    model.addAttribute("videoNames", allVideoArray);
    return "videoShowAllPage";
  }
  
  // ===========================================================================
  // GET VIDEO RESPONSE Step 2.b take /video/videoShowFile >> retrieve file name from /mongo/mongoRetrieve/{filename}
  // >> Video source tag calls this method, returns a video to display
  // >>  in HTML - it will call this file
  // EMBEDED IN VIDEO videoShowFilePage
  // source tag from videoShowFilePage will get fileNameForm it from videoShowFile
  // ===========================================================================
  
  @RequestMapping(value = "video/videoShowFile/{fileNameForm}", method = RequestMethod.GET)
  public ResponseEntity<?> wrongURL(@PathVariable("fileNameForm") String fileNameForm) throws IOException {
    
    List<ServiceInstance> instances = discoveryClient.getInstances("mongo-service3");
    ServiceInstance serviceInstance = instances.get(0);
    String baseUrl = serviceInstance.getUri().toString();
    
    String[] answer = fileNameForm.split("\\.");
    
    baseUrl = baseUrl + "/mongo/mongoRetrieve/" + answer[0] + "/" + answer[1];
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity entity = new HttpEntity<>(headers);
    ResponseEntity<Resource> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, Resource.class); // checks mongoMainController.
    InputStreamResource inputStreamResource = new InputStreamResource(response.getBody().getInputStream());
    InputStream inputStream = response.getBody().getInputStream();
    HttpHeaders responseHeader = new HttpHeaders();
    responseHeader.setContentLength(response.getBody().contentLength());
    return new ResponseEntity<>(inputStreamResource, responseHeader, HttpStatus.OK);
  }
  
  // ===========================================================================
  // This is the page that will show the video file - videoShowFile will be embeded in videoShowFilePage
  // ===========================================================================
  
  @RequestMapping(value = "/video/videoForm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  // public String videoForm(@RequestBody String fileNameForm, Model model) {
    public String videoForm(@RequestBody String fileNameForm, Model model) {
      
      // Split on = sign
      String[] answer = fileNameForm.split("=");
      
      model.addAttribute("fileNameForm", answer[1]);
      return "videoShowFilePage";
    }
    
    // ===========================================================================
    // DELETE MONGO DATABASE - FROM MONGO SERVER
    // ===========================================================================
    
    @GetMapping("/video/mongoDeleteDB")
    public String mongoDeleteDB(Model model) {
      List<ServiceInstance> instances = discoveryClient.getInstances("mongo-service");
      ServiceInstance serviceInstance = instances.get(0);
      String baseUrl = serviceInstance.getUri().toString();
      baseUrl = baseUrl + "/mongo/mongoDeleteDB";
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
      HttpEntity entity = new HttpEntity<>(headers);
      
      ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class);
      return "videoShowMainPage";
    }
  }
  