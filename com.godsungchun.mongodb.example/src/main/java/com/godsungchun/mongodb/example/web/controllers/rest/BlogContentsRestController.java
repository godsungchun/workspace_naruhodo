package com.godsungchun.mongodb.example.web.controllers.rest;

import com.godsungchun.mongodb.example.constants.Result;
import com.godsungchun.mongodb.example.entities.mongodb.BlogContents;
import com.godsungchun.mongodb.example.params.FindParams;
import com.godsungchun.mongodb.example.services.mongodb.BlogContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-12-22.
 */
@RestController
@RequestMapping(value = "rest/blogContents")
public class BlogContentsRestController {
	@Autowired
	private BlogContentsService blogContentsService;
	
	@RequestMapping(value = "findAll")
	public ConcurrentHashMap<Result.Type, Object> findAll(@RequestBody FindParams findParams, Pageable pageable) throws Exception {
		ConcurrentHashMap<Result.Type, Object> resultMap = new ConcurrentHashMap<>();
		
		blogContentsService.findAll(findParams, pageable, resultMap);
		
		resultMap.put(Result.Type.resultCode, Result.Value.success);
		
		return resultMap;
	}
	
	@RequestMapping(value = "findOne")
	public ConcurrentHashMap<Result.Type, Object> findOne(@RequestBody BlogContents blogContents) throws Exception {
		ConcurrentHashMap<Result.Type, Object> resultMap = new ConcurrentHashMap<>();
		
		blogContentsService.findOne(blogContents, resultMap);
		
		resultMap.put(Result.Type.resultCode, Result.Value.success);
		
		return resultMap;
	}
	
	@RequestMapping(value = "save")
	public ConcurrentHashMap<Result.Type, Object> save(@RequestBody BlogContents blogContents) throws Exception {
		ConcurrentHashMap<Result.Type, Object> resultMap = new ConcurrentHashMap<>();
		
		blogContentsService.save(blogContents, resultMap);
		
		resultMap.put(Result.Type.resultCode, Result.Value.success);
		
		return resultMap;
	}
}
