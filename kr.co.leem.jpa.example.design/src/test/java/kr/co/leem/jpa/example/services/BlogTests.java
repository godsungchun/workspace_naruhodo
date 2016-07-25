package kr.co.leem.jpa.example.services;

import kr.co.leem.jpa.example.configs.AppConfig;
import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.BlogCategoryDTO;
import kr.co.leem.jpa.example.entities.account.Account;
import kr.co.leem.jpa.example.entities.blog.BlogCategory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-07-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@Order(value = 2)
public class BlogTests {
	@Autowired
	private BlogCategoryService blogCategoryService;

	@Test
	public void test01SaveBlogCategory() {
		try {
			ConcurrentHashMap<Result.ResultType, Object> resultMap = new ConcurrentHashMap<>();
			BlogCategoryDTO blogCategoryDTO = new BlogCategoryDTO();
			blogCategoryDTO.setName("일반2");
			blogCategoryDTO.setEnabled(true);
			blogCategoryDTO.setCreatedDate(new Date().getTime());

			BlogCategory blogCategory = blogCategoryDTO.dtoToEntity();

			Account createdBy = new Account();

			createdBy.setLoginId("admin");
			blogCategory.setCreatedBy(createdBy);

			//blogCategoryService.save(blogCategory, resultMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test02FindAll() {
		try {
			ConcurrentHashMap<Result.ResultType, Object> resultMap = new ConcurrentHashMap<>();

			BlogCategoryDTO blogCategoryDTO = new BlogCategoryDTO();

			blogCategoryService.findAll(blogCategoryDTO, resultMap);

			if (resultMap.get(Result.ResultType.rows) != null) {
				List<BlogCategory> rows = (List<BlogCategory>)resultMap.get(Result.ResultType.rows);
				System.out.println(rows.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test03SaveChangeStatus() {
		try {
			ConcurrentHashMap<Result.ResultType, Object> resultMap = new ConcurrentHashMap<>();

			BlogCategoryDTO blogCategoryDTO = new BlogCategoryDTO();
			blogCategoryDTO.setSeq(2L);
			blogCategoryDTO.setEnabled(false);

			blogCategoryService.saveChangeStatus(blogCategoryDTO, resultMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
