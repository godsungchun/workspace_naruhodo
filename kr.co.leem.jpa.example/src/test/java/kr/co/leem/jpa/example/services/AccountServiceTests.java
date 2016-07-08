package kr.co.leem.jpa.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.leem.jpa.example.configs.AppConfig;
import kr.co.leem.jpa.example.constants.AccountDataType;
import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.dto.AccountDataDTO;
import kr.co.leem.jpa.example.entities.Account;
import kr.co.leem.jpa.example.entities.AccountData;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AccountServiceTests {
	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountDataService accountDataService;

	@Test
	public void test01AccountSave() {
		ConcurrentHashMap<Result.ResultType, Object> resultMap = new ConcurrentHashMap<>();

		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setLoginId("godSungChun");
		accountDTO.setName("임성천");
		accountDTO.setEmail("dream7904@godSungChun.com");
		accountDTO.setAge(38);
		accountDTO.setRegDate(new Date().getTime());
		accountDTO.setRegBy("godSungChun");

		try {
			Account account = accountDTO.dtoToEntity();
			accountService.save(account, resultMap);

			Account savedAccount = (Account)resultMap.get(Result.ResultType.row);
			Assert.assertEquals(savedAccount.getLoginId(), "godSungChun");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test02AccountFindAll() {
		ConcurrentHashMap<Result.ResultType, Object> resultMap = new ConcurrentHashMap<>();

		AccountDTO accountDTO = new AccountDTO();
		Date fromDate = DateUtils.addDays(new Date(), -1);
		accountDTO.setFromDate(fromDate.getTime());
		accountDTO.setToDate(new Date().getTime());
		accountDTO.setLoginId("godSungChun");

		try {
			PageRequest pageRequest = new PageRequest(0, 10);

			accountService.findAll(pageRequest, accountDTO, resultMap);

			List<Account> rowsByMethodName = (List<Account>)resultMap.get(Result.ResultType.rowsByMethodName);
			List<Account> rowsByJpa = (List<Account>)resultMap.get(Result.ResultType.rowsByJpa);
			Page<Account> rowsByPageable = (Page<Account>)resultMap.get(Result.ResultType.rowsByPageable);
			Page<Account> rowsByJpql = (Page<Account>)resultMap.get(Result.ResultType.rowsByJpql);

			Assert.assertEquals(rowsByMethodName.size(), 1);
			Assert.assertEquals(rowsByJpa.size(), 1);
			Assert.assertEquals(rowsByPageable.getTotalElements(), 1);
			Assert.assertEquals(rowsByJpql.getTotalElements(), 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test03AccountDataFindAllByLoginId() {
		ConcurrentHashMap<Result.ResultType, Object> resultMap = new ConcurrentHashMap<>();
		AccountDataDTO accountDataDTO = new AccountDataDTO();
		accountDataDTO.setLoginId("godSungChun");
		try {
			accountDataService.findAll(accountDataDTO, resultMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test04AccountDataSave() {
		try {
			AccountDataDTO accountDataDTO = new AccountDataDTO();
			accountDataDTO.setLoginId("godSungChun");
			accountDataDTO.setAccountDataType(AccountDataType.basic);

			ConcurrentHashMap<String, Object> accountDataValueMap = new ConcurrentHashMap<>();

			List<ConcurrentHashMap<String, String>> roles = new ArrayList<>();

			for (int i = 0; i < 10; i++) {
				ConcurrentHashMap<String, String> roleMap = new ConcurrentHashMap<>();
				roleMap.put("role", "role" + (i + 1));
				roles.add(roleMap);
			}

			accountDataValueMap.put("fileName", "data.json");
			accountDataValueMap.put("roles", roles);

			ObjectMapper objectMapper = new ObjectMapper();
			accountDataDTO.setValue(objectMapper.writeValueAsString(accountDataValueMap));

			ConcurrentHashMap<Result.ResultType, Object> resultMap = new ConcurrentHashMap<>();

			AccountData accountData = accountDataDTO.dtoToEntity();
			accountDataService.save(accountData, resultMap);
			AccountData resultAccountData = (AccountData)resultMap.get(Result.ResultType.row);

			Assert.assertEquals(resultAccountData.getAccountDataPK().getLoginId(), accountDataDTO.getLoginId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test05AccountDataDelete() {
		try {
			AccountDataDTO accountDataDTO = new AccountDataDTO();
			accountDataDTO.setLoginId("godSungChun");

			accountDataService.delete(accountDataDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test06AccountDelete() {
		ConcurrentHashMap<Result.ResultType, Object> resultMap = new ConcurrentHashMap<>();

		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setLoginId("godSungChun");

		try {
			accountService.delete(accountDTO, resultMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
