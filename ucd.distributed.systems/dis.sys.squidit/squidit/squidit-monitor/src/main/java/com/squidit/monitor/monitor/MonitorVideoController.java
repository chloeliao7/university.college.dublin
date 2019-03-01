package com.squidit.monitor.monitor;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.*;
import com.squidit.monitor.monitor.SlotChooser;

@Controller
public class MonitorVideoController {
  
  @Autowired
  private DiscoveryClient discoveryClient;
  public ArrayList<String> mongoUrls = new ArrayList<>();
  public HashMap<Integer, Integer> totalServerObjects = new HashMap<>();
  
  // ===========================================================================
  // WILL CALL ALL SERVICES AND MOTOR THEIR STATES FROM MONGO
  // ===========================================================================
  
  @GetMapping("/monitor/monitorServiceStatus")
  public String monitorServiceStatus(Model model) throws IOException {
    String responseUrl = "";
    
    List<ServiceInstance> instances = discoveryClient.getInstances("mongo-service");
    
    for (int i = 0; i < instances.size(); i++) {
      RestTemplate restTemplate = new RestTemplate();
      ServiceInstance serviceInstance = instances.get(i);
      String baseUrl = serviceInstance.getUri().toString();
      mongoUrls.add(baseUrl);
      baseUrl = baseUrl + "/mongo/mongoMonitorStatus";
      HttpHeaders headers = new HttpHeaders();
      headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
      HttpEntity entity = new HttpEntity<>(headers);
      ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class);
      ObjectMapper mapper = new ObjectMapper();
      String tempResponse = response.getBody();
      JsonNode mongoMonitorObj = mapper.readTree(tempResponse); // Hold slot number of what database to pick and also its totals
      
      totalServerObjects.put(mongoMonitorObj.get(0).get("mongoUrlSlot").asInt(), mongoMonitorObj.get(0).get("totalSize").asInt());
    }
    
    SlotChooser slotChooser = new SlotChooser();
    
    int slot = slotChooser.getSlot(totalServerObjects);
    
    responseUrl = mongoUrls.get(slot);
    
    return responseUrl;
  }
}
