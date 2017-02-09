package com.godsungchun.mongodb.example.services.mongodb;

import com.godsungchun.mongodb.example.constants.Result.*;
import com.godsungchun.mongodb.example.entities.mongodb.BlogContents;
import com.godsungchun.mongodb.example.params.FindParams;
import org.springframework.data.domain.Pageable;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-11-15.
 */
public interface BlogContentsService {
	void findAll(FindParams findParams, Pageable pageable, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void findOne(BlogContents blogContents, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void save(BlogContents blogContents, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
}
