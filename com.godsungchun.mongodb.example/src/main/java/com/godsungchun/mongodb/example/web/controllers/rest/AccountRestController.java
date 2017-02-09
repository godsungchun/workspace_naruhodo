package com.godsungchun.mongodb.example.web.controllers.rest;

import com.godsungchun.mongodb.example.constants.Result.*;
import com.godsungchun.mongodb.example.entities.mongodb.Account;
import com.godsungchun.mongodb.example.params.FindParams;
import com.godsungchun.mongodb.example.services.mongodb.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-11-16.
 */
@RestController
@RequestMapping(value = "rest/account")
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "findAll")
	public Map<Type, Object> findAll(Pageable pageable, FindParams findParams) throws Exception {
		ConcurrentHashMap<Type, Object> resultMap = new ConcurrentHashMap<>();
		
		accountService.findAll(findParams, findParams.getPageRequest(), resultMap);
		
		resultMap.put(Type.resultCode, Value.success);
		
		return resultMap;
	}
	
	@RequestMapping(value = "findOne")
	public Map<Type, Object> findOne(@RequestBody Account account) throws Exception {
		ConcurrentHashMap<Type, Object> resultMap = new ConcurrentHashMap<>();
		
		accountService.findOne(account, resultMap);
		
		resultMap.put(Type.resultCode, Value.success);
		
		return resultMap;
	}
	
	@RequestMapping(value = "save")
	public Map<Type, Object> save(@RequestBody Account account) throws Exception {
		ConcurrentHashMap<Type, Object> resultMap = new ConcurrentHashMap<>();
		
		accountService.save(account, resultMap);
		
		resultMap.put(Type.resultCode, Value.success);
		
		return resultMap;
	}
}
