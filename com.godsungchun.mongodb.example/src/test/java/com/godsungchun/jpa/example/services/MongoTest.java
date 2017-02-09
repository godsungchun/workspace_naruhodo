package com.godsungchun.jpa.example.services;

import com.godsungchun.mongodb.example.commons.persistences.mongodb.SimpleAggregationOperation;
import com.godsungchun.mongodb.example.configs.AppConfig;
import com.godsungchun.mongodb.example.configs.MongoDbConfig;
import com.godsungchun.mongodb.example.entities.mongodb.BlogSectionCode;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by Dream on 2017-01-19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, MongoDbConfig.class})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class MongoTest {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private SimpleAggregationOperation<BlogSectionCode> ab;
	
	@Test
	public void testValue() throws Exception {
		BlogSectionCode blogSectionCode = ab.minMax(Sort.Direction.DESC, BlogSectionCode.class, BlogSectionCode.class, "code2", "10000000", "code2");
		
		System.out.println(blogSectionCode);
	}
	
	public class ResultValue {
		String code1;
		String code2;
		
		public String getCode1() {
			return code1;
		}
		
		public void setCode1(String code1) {
			this.code1 = code1;
		}
		
		public String getCode2() {
			return code2;
		}
		
		public void setCode2(String code2) {
			this.code2 = code2;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(NumberFormat.getInstance().parse("0001"));
		/*DecimalFormat decimalFormat = new DecimalFormat("0000");
		
		System.out.println(decimalFormat.format(111));*/
	}
}
