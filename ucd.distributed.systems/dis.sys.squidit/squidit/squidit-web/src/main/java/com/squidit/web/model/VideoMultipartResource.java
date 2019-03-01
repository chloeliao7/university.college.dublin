package com.squidit.web.model;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.InputStreamResource;


public class VideoMultipartResource extends InputStreamResource {
  private final String filename;
  public VideoMultipartResource(InputStream inputStream, String filename) {
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