package com.godsungchun.mongodb.example.services.mongodb;

import com.godsungchun.mongodb.example.constants.Result.*;
import com.godsungchun.mongodb.example.params.FindParams;
import com.godsungchun.mongodb.example.entities.mongodb.Account;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-11-15.
 */
public interface AccountService {
	void regDefaultAccount() throws Exception;
	void findAll(FindParams findParams, Pageable pageable, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void findOne(Account account, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void save(Account account, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void save(List<Account> accounts, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
}
