package kr.co.leem.jpa.example.services;

import kr.co.leem.jpa.example.configs.AppConfig;
import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.entities.Account;
import kr.co.leem.jpa.example.repositories.AccountRepository;
import kr.co.leem.jpa.example.repositories.basic.AccountBasicCriteria;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dream on 2016-06-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class DummyTests {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountBasicCriteria accountBasicCriteria;

	/*@Test
	public void test01SaveAccount() {
		List<Account> accountParams = new ArrayList<>();

		for (int i = 0; i < 30; i++) {
			Account account = new Account();

			String name = "test0" + (i + 1);
			account.setLoginId("test0" + (i + 1));
			account.setAge(30);
			account.setEmail(name + "@gmail.com");
			account.setRegBy("godSungChun");
			account.setName(name);
			account.setRegDate(new Date().getTime());

			accountParams.add(account);
		}

		accountRepository.save(accountParams);
	}*/

	@Test
	public void test02FindAll() {
		PageRequest pageRequest = new PageRequest(0, 10);
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setLoginId("test01");
		accountDTO.setAge(30);
		try {
			accountBasicCriteria.findAll(pageRequest, accountDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
