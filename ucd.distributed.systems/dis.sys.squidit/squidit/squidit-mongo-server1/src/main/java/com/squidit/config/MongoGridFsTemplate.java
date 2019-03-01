package com.squidit.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;


@Configuration
public class MongoGridFsTemplate extends AbstractMongoConfiguration {
  
  @Value("${squidit-mongodb1.address}")
  private String mongoAddress;
  
  @Value("${squidit-mongodb1.database}")
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
