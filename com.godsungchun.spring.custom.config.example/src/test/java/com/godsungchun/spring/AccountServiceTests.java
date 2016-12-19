package com.godsungchun.spring;

import com.godsungchun.spring.configs.AppConfig;
import com.godsungchun.spring.configs.JpaConfig;
import com.godsungchun.spring.entities.Account;
import com.godsungchun.spring.services.AccountService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void test01() throws Exception {
		Account account = new Account();
		account.setSignInId("godsungchun");
		account.setName("임성천");
		account.setPwd(passwordEncoder.encode("dt0415"));
		account.setEmail("godsungchun@gmail.com");
		
		accountService.save(account);
	}
}
