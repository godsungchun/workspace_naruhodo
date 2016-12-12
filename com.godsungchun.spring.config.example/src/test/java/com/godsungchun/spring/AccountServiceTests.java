package com.godsungchun.spring;

import com.godsungchun.spring.configs.AppConfig;
import com.godsungchun.spring.configs.JpaConfig;
import com.godsungchun.spring.services.AccountService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-12-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, JpaConfig.class})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class AccountServiceTests {
	@Autowired
	private AccountService accountService;
	@Test
	public void test01() throws Exception {
		ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();
		
		accountService.findAll(resultMap);
	}
}
