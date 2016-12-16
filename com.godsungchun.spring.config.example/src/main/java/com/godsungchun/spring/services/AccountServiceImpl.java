package com.godsungchun.spring.services;

import com.godsungchun.spring.entities.Account;
import com.godsungchun.spring.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-12-12.
 */
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public void findAll(ConcurrentHashMap<String, Object> resultMap) throws Exception {
		List<Account> rows = accountRepository.findAll();
		
		resultMap.put("rows", rows);
		
	}
	
	@Override
	public void save(Account account) throws Exception {
		accountRepository.save(account);
	}
	
	@Override
	public void delete(Account account) throws Exception {
		
	}
	
	@Override
	public void count(Account account) throws Exception {
		
	}
}
