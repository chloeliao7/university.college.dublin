package com.squidit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoGridFsTemplate extends AbstractMongoConfiguration {
  
  @Value("${squidit-mongodb3.address}")
  private String mongoAddress;
  
  @Value("${squidit-mongodb3.database}")
  private String mongoDatabase;
  
  @Bean
  public GridFsTemplate gridFsTemplate() throws Exception {
    return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
  }
  
  @Override
  protected String getDatabaseName() {
    return mongoDatabase;
  }
  
  @Override
  public Mongo mongo() throws Exception {
    return new MongoClient(mongoAddress);
  }
}
