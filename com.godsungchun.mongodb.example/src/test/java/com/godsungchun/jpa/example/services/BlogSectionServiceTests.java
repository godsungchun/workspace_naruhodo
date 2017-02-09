package com.godsungchun.jpa.example.services;

import com.godsungchun.mongodb.example.configs.AppConfig;
import com.godsungchun.mongodb.example.configs.MongoDbConfig;
import com.godsungchun.mongodb.example.constants.Result;
import com.godsungchun.mongodb.example.entities.mongodb.BlogSectionCode;
import com.godsungchun.mongodb.example.entities.mongodb.model.ParentSectionCode;
import com.godsungchun.mongodb.example.repositories.mongodb.BlogSectionCodeRepository;
import com.godsungchun.mongodb.example.services.mongodb.BlogSectionCodeService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-12-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, MongoDbConfig.class})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class BlogSectionServiceTests {
	@Autowired
	private BlogSectionCodeService blogSectionCodeService;
	
	@Autowired
	private BlogSectionCodeRepository blogSectionCodeRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	//@Test
	public void test01Save() {
		blogSectionCodeRepository.deleteAll();
		
		List<BlogSectionCode> rows = new ArrayList<>();
		BlogSectionCode blogSectionCode1 = new BlogSectionCode();
		blogSectionCode1.setName("정치");
		blogSectionCode1.setCode("10000000");
		blogSectionCode1.setCode1("1000");
		blogSectionCode1.setCode2("0000");
		blogSectionCode1.setEnabled(true);
		blogSectionCode1.setCreateByName("임성천");
		blogSectionCode1.setCreatedDate(new Date());
		blogSectionCode1.setParentCode(null);
		
		this.sleep();
		
		BlogSectionCode blogSectionCode2 = new BlogSectionCode();
		blogSectionCode2.setName("사회");
		blogSectionCode2.setCode("10000001");
		blogSectionCode2.setCode1("1000");
		blogSectionCode2.setCode2("0001");
		blogSectionCode2.setEnabled(true);
		blogSectionCode2.setCreateByName("임성천");
		blogSectionCode2.setCreatedDate(new Date());
		blogSectionCode2.setParentCode("10000000");
		
		this.sleep();
		
		BlogSectionCode blogSectionCode3 = new BlogSectionCode();
		blogSectionCode3.setName("청문회");
		blogSectionCode3.setCode("10000002");
		blogSectionCode3.setCode1("1000");
		blogSectionCode3.setCode2("0002");
		blogSectionCode3.setEnabled(true);
		blogSectionCode3.setCreateByName("임성천");
		blogSectionCode3.setCreatedDate(new Date());
		blogSectionCode3.setParentCode("10000000");
		
		this.sleep();
		
		BlogSectionCode blogSectionCode4 = new BlogSectionCode();
		blogSectionCode4.setName("경제");
		blogSectionCode4.setCode("10010000");
		blogSectionCode4.setCode1("1001");
		blogSectionCode4.setCode2("0000");
		blogSectionCode4.setEnabled(true);
		blogSectionCode4.setCreateByName("임성천");
		blogSectionCode4.setCreatedDate(new Date());
		blogSectionCode4.setParentCode(null);
		
		this.sleep();
		
		BlogSectionCode blogSectionCode5 = new BlogSectionCode();
		blogSectionCode5.setName("주식");
		blogSectionCode5.setCode("10010001");
		blogSectionCode5.setCode1("1001");
		blogSectionCode5.setCode2("0001");
		blogSectionCode5.setEnabled(true);
		blogSectionCode5.setCreateByName("임성천");
		blogSectionCode5.setCreatedDate(new Date());
		blogSectionCode5.setParentCode("10010001");
		
		this.sleep();
		
		BlogSectionCode blogSectionCode6 = new BlogSectionCode();
		blogSectionCode6.setName("물가");
		blogSectionCode6.setCode("10010002");
		blogSectionCode6.setCode1("1001");
		blogSectionCode6.setCode2("0002");
		blogSectionCode6.setEnabled(true);
		blogSectionCode6.setCreateByName("임성천");
		blogSectionCode6.setCreatedDate(new Date());
		blogSectionCode6.setParentCode("10010002");
		
		this.sleep();
		
		rows.add(blogSectionCode1);
		rows.add(blogSectionCode2);
		rows.add(blogSectionCode3);
		rows.add(blogSectionCode4);
		rows.add(blogSectionCode5);
		rows.add(blogSectionCode6);
		
		this.sleep();
		
		ConcurrentHashMap<Result.Type, Object> resultMap = new ConcurrentHashMap<>();
		
		try {
			blogSectionCodeService.save(rows, resultMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sleep() {
		try {
			Thread.sleep(2000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test02SectionCodeTreeTest() {
		ConcurrentHashMap<Result.Type, Object> resultMap = new ConcurrentHashMap<>();
		
		try {
			blogSectionCodeService.findAllTreeData(null, resultMap);
			List<ParentSectionCode> rows = (List<ParentSectionCode>)resultMap.get(Result.Type.rows);
			System.out.println(rows.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
