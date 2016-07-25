package kr.co.leem.jpa.example.services;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import kr.co.leem.jpa.example.commons.utils.StringUtils;
import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.BlogCategoryDTO;
import kr.co.leem.jpa.example.entities.account.Account;
import kr.co.leem.jpa.example.entities.blog.BlogCategory;
import kr.co.leem.jpa.example.entities.blog.QBlogCategory;
import kr.co.leem.jpa.example.repositories.BlogCategoryRepository;
import kr.co.leem.jpa.example.repositories.querydsl.jpql.BlogCategoryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-07-20.
 */
@Service
public class BlogCategoryServiceImpl implements BlogCategoryService {
	@Autowired
	private BlogCategoryRepository blogCategoryRepository;

	@Autowired
	private BlogCategoryCriteria blogCategoryCriteria;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public void save(BlogCategoryDTO blogCategoryDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception {
		BlogCategory blogCategory = blogCategoryDTO.dtoToEntity();

		Account account = new Account();

		if (blogCategoryDTO.getSeq() == null && StringUtils.isNotEmpty(blogCategoryDTO.getCreatedBy())) {
			account.setLoginId("admin");
			blogCategory.setCreatedBy(account);
		} else {
			account.setLoginId("admin");
			blogCategory.setLastModifiedBy(account);
		}

		resultMap.put(Result.ResultType.row, blogCategoryRepository.save(blogCategory));
	}

	@Override
	public void findAll(BlogCategoryDTO blogCategoryDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception {
		resultMap.put(Result.ResultType.rows, blogCategoryRepository.findAll(findAllWhereBuilder(blogCategoryDTO)));
	}

	@Transactional
	@Override
	public void saveChangeStatus(BlogCategoryDTO blogCategoryDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception {
		Long result = blogCategoryCriteria.saveChangeStatus(blogCategoryDTO);
		System.out.println(result);
	}

	private BooleanBuilder findAllWhereBuilder(BlogCategoryDTO blogCategoryDTO) throws Exception {
		BooleanBuilder booleanBuilder = new BooleanBuilder();

		if (blogCategoryDTO.getEnabled() == null) {
			blogCategoryDTO.setEnabled(true);
		}

		booleanBuilder.and(QBlogCategory.blogCategory.enabled.eq(blogCategoryDTO.getEnabled()));

		if (StringUtils.isNotEmpty(blogCategoryDTO.getName())) {
			String value = "%" + StringUtils.escapeDbWildcard(blogCategoryDTO.getName()) + "%";

			booleanBuilder.and(QBlogCategory.blogCategory.name.like(value));
		}

		return booleanBuilder;
	}
}
