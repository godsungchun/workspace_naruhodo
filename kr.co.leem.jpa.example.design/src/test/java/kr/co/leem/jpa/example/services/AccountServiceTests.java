package kr.co.leem.jpa.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.leem.jpa.example.configs.AppConfig;
import kr.co.leem.jpa.example.constants.AccountDataType;
import kr.co.leem.jpa.example.constants.Result;

import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.entities.account.Account;
import kr.co.leem.jpa.example.entities.account.AccountData;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-06-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@Order(value = 1)
public class AccountServiceTests {
	@Autowired
	private AccountService accountService;

	@Test
	public void test01RegUserData() {
		try {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setLoginId("scleem");
			accountDTO.setAge(37);
			accountDTO.setName("Leem SungChun");
			accountDTO.setCreatedBy("admin");
			accountDTO.setCreatedDate(new Date().getTime());
			accountDTO.setEmail("dream7904@gmail.com");

			accountService.save(accountDTO);

			accountDTO = new AccountDTO();
			accountDTO.setLoginId("admin");
			accountDTO.setAge(37);
			accountDTO.setName("Leem SungChun");
			accountDTO.setCreatedBy("admin");
			accountDTO.setCreatedDate(new Date().getTime());
			accountDTO.setEmail("dream7904@gmail.com");

			accountService.save(accountDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
