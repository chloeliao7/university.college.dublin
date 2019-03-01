package com.squidit.model;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.InputStreamResource;

public class MongoMultipartResource extends InputStreamResource {
  private final String filename;
  
  public MongoMultipartResource(InputStream inputStream, String filename) {
    super(inputStream);
    this.filename = filename;
  }
  
  @Override
  public String getFilename() {
    return this.filename;
  }
  @Override
  public long contentLength() throws IOException {
    return -1;
  }
}