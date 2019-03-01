package com.squidit.web.model;

public class Video {
  private String videoId;
  private String ownerId;
  private String ownerName;
  private byte[] videoShowFile;
  
  
  // ===========================================================================
  // VIDEO GETTERS = VIDEO MODEL
  // ===========================================================================
  
  public String getVideoId() { return videoId; }
  public byte[] getvideoShowFile() { return videoShowFile; }
  public String getOwnerId() { return ownerId; }
  public String getOwnerName() { return ownerName; }
  
  // ===========================================================================
  // VIDEO SETTERS = VIDEO MODEL
  // ===========================================================================
  
  public void setvideoShowFile(byte[] videoShowFile) { this.videoShowFile = videoShowFile; }
  public void setVideoId(String videoId) { this.videoId = videoId; }
  public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
  public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
}
