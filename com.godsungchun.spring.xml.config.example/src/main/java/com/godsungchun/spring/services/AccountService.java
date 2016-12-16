package com.godsungchun.spring.services;

import com.godsungchun.spring.entities.Account;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-12-12.
 */
public interface AccountService {
	void findAll(ConcurrentHashMap<String, Object> resultMap) throws Exception;
	void save(Account account) throws Exception;
	void delete(Account account) throws Exception;
	void count(Account account) throws Exception;
}
