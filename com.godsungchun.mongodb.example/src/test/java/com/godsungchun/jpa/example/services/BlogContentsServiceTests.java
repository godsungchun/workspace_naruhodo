package com.godsungchun.jpa.example.services;

import com.godsungchun.mongodb.example.configs.AppConfig;
import com.godsungchun.mongodb.example.configs.MongoDbConfig;
import com.godsungchun.mongodb.example.constants.Result;
import com.godsungchun.mongodb.example.constants.Types;
import com.godsungchun.mongodb.example.entities.mongodb.BlogContents;
import com.godsungchun.mongodb.example.entities.mongodb.BlogSectionCode;
import com.godsungchun.mongodb.example.entities.mongodb.prop.blogContents.ApproveProperty;
import com.godsungchun.mongodb.example.entities.mongodb.prop.blogContents.SectionCodeProperty;
import com.godsungchun.mongodb.example.params.FindParams;
import com.godsungchun.mongodb.example.repositories.mongodb.BlogContentsRepository;
import com.godsungchun.mongodb.example.services.mongodb.BlogContentsService;
import com.godsungchun.mongodb.example.services.mongodb.BlogSectionCodeService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.IteratorUtils;
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
public class BlogContentsServiceTests {
	@Autowired
	private BlogContentsService blogContentsService;
	
	@Autowired
	private BlogSectionCodeService blogSectionCodeService;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private BlogContentsRepository blogContentsRepository;
	
	@Test
	public void save() {
		ConcurrentHashMap<Result.Type, Object> resultMap = new ConcurrentHashMap<>();
		
		blogContentsRepository.deleteAll();
		
		BlogContents blogContents1 = new BlogContents();
		blogContents1.setEnabled(true);
		blogContents1.setCreatedDate(new Date());
		blogContents1.setCreateByName("임성천");
		
		try {
			List<BlogSectionCode> a = IteratorUtils.toList(this.getBlogSectionCodes().iterator());
			
			blogContents1.setBlogContentsSectionsCodesRefs(a);
			blogContents1.setSectionCodeProperties(this.convertToSectionProperties(a));
			blogContents1.setContents("내용");
			blogContents1.setTitle("제목-1");
			blogContents1.setSubTitle("부제목-1");
			
			ApproveProperty approveProperty = new ApproveProperty();
			approveProperty.setApproved(false);
			
			blogContents1.setApproveProperty(approveProperty);
			
			List<String> tags = new ArrayList<>();
			
			tags.add("태그 - 1");
			tags.add("태그 - 2");
			tags.add("태그 - 3");
			
			blogContents1.setTags(tags);
			
			blogContentsService.save(blogContents1, resultMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<SectionCodeProperty> convertToSectionProperties(Iterable<BlogSectionCode> blogSectionCodes) throws Exception {
		List<SectionCodeProperty> rows = new ArrayList<>();
		
		for (BlogSectionCode blogSectionCode : blogSectionCodes) {
			SectionCodeProperty row = new SectionCodeProperty();
			BeanUtils.copyProperties(row, blogSectionCode);
			
			rows.add(row);
		}
		
		return rows;
	}
	
	public Iterable<BlogSectionCode> getBlogSectionCodes() throws Exception {
		ConcurrentHashMap<Result.Type, Object> resultMap = new ConcurrentHashMap<>();
		
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		FindParams findParams = new FindParams();
		List<String> values = new ArrayList<>();
		values.add("10000001");
		values.add("10000002");
		
		findParams.setValues(values);
		findParams.setBlogSectionCodeFind(Types.BlogSectionCodeFind.codes);
		findParams.setEnablePageable(false);
		Iterable<BlogSectionCode> rows = null;
		
		try {
			blogSectionCodeService.findAll(findParams, null, resultMap);
			
			rows = (Iterable<BlogSectionCode>)resultMap.get(Result.Type.rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	@Test
	public void testFindAll() throws Exception {
		getBlogSectionCodes();
	}
	
	/*@Test
	public void test02FindAll() throws Exception {
		QBlogContents qBlogContents = QBlogContents.blogContents;
		
		blogContentsRepository.findAll(qBlogContents.blogContentsSections.any().code1.eq(""));
	}
	*/
}
