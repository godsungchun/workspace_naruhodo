package com.godsungchun.mongodb.example.services.mongodb.impl;

import com.godsungchun.mongodb.example.constants.Result.*;
import com.godsungchun.mongodb.example.constants.Types.*;
import com.godsungchun.mongodb.example.params.FindParams;
import com.godsungchun.mongodb.example.entities.mongodb.Account;
import com.godsungchun.mongodb.example.entities.mongodb.QAccount;
import com.godsungchun.mongodb.example.repositories.mongodb.AccountRepository;
import com.godsungchun.mongodb.example.services.mongodb.AccountService;
import com.godsungchun.mongodb.example.services.security.AccountUserDetail;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-11-15.
 */
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void regDefaultAccount() throws Exception {
		Long count = accountRepository.count();
		
		if (count < 1L) {
			Account account = new Account();
			account.setLoginId("admin");
			account.setName("임성천");
			account.setEmail("godsungchun@gmail.com");
			account.setCreatedDate(new Date());
			account.setCreatedByName("임성천");
			account.setPwd(bCryptPasswordEncoder.encode("godsungchun"));
			Account row = accountRepository.save(account);
		}
	}
	
	@Override
	public void findAll(FindParams findParams, Pageable pageable, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		Page<Account> pages = accountRepository.findAll(whereBuilder(findParams), pageable);
		
		findParams.setPages(pages, resultMap);
	}
	
	@Override
	public void findOne(Account account, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		QAccount qAccount = QAccount.account;
		
		if (StringUtils.isNotEmpty(account.getId())) {
			booleanBuilder.and(qAccount.id.eq(account.getId()));
		} else if (StringUtils.isNotEmpty(account.getLoginId())) {
			booleanBuilder.and(qAccount.loginId.eq(account.getLoginId()));
		}
		
		Account row = accountRepository.findOne(booleanBuilder);
		
		resultMap.put(Type.row, row);
	}
	
	@Override
	public void save(Account account, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		Account accountRow = accountRepository.findOne(account.getId());
		
		if (accountRow != null) {
			if (StringUtils.isEmpty(account.getPwd())) {
				account.setPwd(accountRow.getPwd());
			} else {
				String pwd = account.getPwd();
				
				account.setPwd(bCryptPasswordEncoder.encode(pwd));
			}
		}
		
		if (StringUtils.isNotEmpty(account.getId())) {
			AccountUserDetail currentAccountRow = (AccountUserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			account.setLastModifiedDate(new Date());
			account.setLastModifiedByName(currentAccountRow.getAccount().getName());
		}
		
		Account row = accountRepository.save(account);
		
		resultMap.put(Type.row, row);
	}
	
	@Override
	public void save(List<Account> accounts, ConcurrentHashMap<Type, Object> resultMap) throws Exception {
		List<Account> rows = accountRepository.save(accounts);
		
		resultMap.put(Type.rows, rows);
	}
	
	private BooleanBuilder whereBuilder(FindParams findParams) throws Exception {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		QAccount qAccount = QAccount.account;
		
		AccountFind accountFindTypeValue = findParams.getAccountFindType();
		
		if (accountFindTypeValue != null && StringUtils.isNotEmpty(findParams.getKeyword())) {
			if (accountFindTypeValue == AccountFind.created) {
				booleanBuilder.and(qAccount.createByName.eq(findParams.getKeyword()));
			} else if (accountFindTypeValue == AccountFind.lastModified) {
				booleanBuilder.and(qAccount.lastModifiedByName.eq(findParams.getKeyword()));
			} else if (accountFindTypeValue == AccountFind.loginId) {
				booleanBuilder.and(qAccount.loginId.eq(findParams.getKeyword()));
			} else {
				booleanBuilder.and(qAccount.email.eq(findParams.getKeyword()));
			}
		}
		
		if (findParams.getFindDateType() != null && findParams.getFromDate() != null && findParams.getToDate() != null) {
			if (findParams.getFindDateType() == FindDate.created) {
				booleanBuilder.and(qAccount.createdDate.between(findParams.getFromDate(), findParams.getToDate()));
			} else {
				booleanBuilder.and(qAccount.lastModifiedDate.between(findParams.getFromDate(), findParams.getToDate()));
			}
		}
		
		return booleanBuilder;
	}
}
