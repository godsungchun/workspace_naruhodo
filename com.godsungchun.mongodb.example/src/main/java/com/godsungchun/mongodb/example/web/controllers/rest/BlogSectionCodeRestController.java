package com.godsungchun.mongodb.example.web.controllers.rest;

import com.godsungchun.mongodb.example.constants.Result;
import com.godsungchun.mongodb.example.entities.mongodb.BlogSectionCode;
import com.godsungchun.mongodb.example.params.FindParams;
import com.godsungchun.mongodb.example.services.mongodb.BlogSectionCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-12-21.
 */
@RestController
@RequestMapping(value = "rest/blogSection")
public class BlogSectionCodeRestController {
	@Autowired
	private BlogSectionCodeService blogSectionCodeService;
	
	@RequestMapping(value = "findAll")
	public ConcurrentHashMap<Result.Type, Object> findAll(@RequestBody FindParams findParams, Pageable pageable) throws Exception {
		ConcurrentHashMap<Result.Type, Object> resultMap = new ConcurrentHashMap<>();
		
		blogSectionCodeService.findAll(findParams, pageable, resultMap);
		
		resultMap.put(Result.Type.resultCode, Result.Value.success);
		
		return resultMap;
	}
	
	@RequestMapping(value = "save")
	public ConcurrentHashMap<Result.Type, Object> save(@RequestBody BlogSectionCode blogSectionCode) throws Exception {
		ConcurrentHashMap<Result.Type, Object> resultMap = new ConcurrentHashMap<>();
		
		blogSectionCodeService.save(blogSectionCode, resultMap);
		
		resultMap.put(Result.Type.resultCode, Result.Value.success);
		
		return resultMap;
	}
	
	@RequestMapping(value = "getParentCodes")
	public ConcurrentHashMap<Result.Type, Object> get() throws Exception {
		ConcurrentHashMap<Result.Type, Object> resultMap = new ConcurrentHashMap<>();
		
		blogSectionCodeService.getParentCodes(resultMap);
		
		resultMap.put(Result.Type.resultCode, Result.Value.success);
		
		return resultMap;
	}
	
	@RequestMapping(value = "findAllTreeData")
	public ConcurrentHashMap<Result.Type, Object> findAllTreeData() throws Exception {
		ConcurrentHashMap<Result.Type, Object> resultMap = new ConcurrentHashMap<>();
		
		blogSectionCodeService.findAllTreeData(null, resultMap);
		
		resultMap.put(Result.Type.resultCode, Result.Value.success);
		
		return resultMap;
	}
}
