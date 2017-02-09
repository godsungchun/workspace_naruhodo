package com.godsungchun.jpa.example.services;

import com.godsungchun.mongodb.example.configs.AppConfig;
import com.godsungchun.mongodb.example.configs.MongoDbConfig;
import com.godsungchun.mongodb.example.entities.mongodb.Account;
import com.godsungchun.mongodb.example.services.mongodb.AccountService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Dream on 2016-11-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, MongoDbConfig.class})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class AccountServiceTests {
	@Autowired
	private AccountService accountService;
	
	@Test
	public void test01Save() {
		try {
			accountService.regDefaultAccount();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
