package com.godsungchun.mongodb.example.configs;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

/**
 * Created by Dream on 2016-08-25.
 */
@Configuration
@EnableTransactionManagement
@EnableMongoRepositories(basePackages = "com.godsungchun.mongodb.example.repositories.mongodb")
public class MongoDbConfig {
	@Bean
	public MongoClient mongoClient() throws Exception {
		MongoClient mongoClient = new MongoClient("localhost");
		
		return mongoClient;
	}
	
	@Bean
	public MongoDbFactory getMongoDbFactory() throws Exception {
		MongoCredential credential = MongoCredential.createCredential("godsungchun", "blog", "asdf1234".toCharArray());
		ServerAddress serverAddress = new ServerAddress("localhost", 27017);
		
		MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));
		
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "blog");
		
		return simpleMongoDbFactory;
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(getMongoDbFactory());
	}
}
