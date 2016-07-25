package kr.co.leem.jpa.example.controllers;

import kr.co.leem.jpa.example.configs.AppConfig;
import kr.co.leem.jpa.example.configs.MvcConfig;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Dream on 2016-06-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, MvcConfig.class})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class AccountRestControllerTests {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
		//this.mock = MockMvcBuilders.webAppContextSetup(wac).build();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void test01RestAccountFindAll() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test02RestAccountFindAll() {
		/*try {
			Date date = new Date();
			Date fromDate = DateUtils.addDays(date, -10);

			MultiValueMap<String, String> param = new LinkedMultiValueMap<>();

			param.add("page", "1");
			param.add("size", "10");
			param.add("loginId", "godSungChun");
			param.add("fromDate", String.valueOf(fromDate.getTime()));
			param.add("toDate", String.valueOf(date.getTime()));

			mockMvc.perform(MockMvcRequestBuilders.get("/rest/account/findAll").params(param)).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	@Test
	public void test03RestAccountFindOne() {
		/*try {
			MultiValueMap<String, String> param = new LinkedMultiValueMap<>();

			param.add("loginId", "godSungChun");

			mockMvc.perform(MockMvcRequestBuilders.get("/rest/account/findOne").params(param)).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
