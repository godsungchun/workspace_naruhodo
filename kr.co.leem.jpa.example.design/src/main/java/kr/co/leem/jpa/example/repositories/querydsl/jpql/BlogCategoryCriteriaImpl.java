package kr.co.leem.jpa.example.repositories.querydsl.jpql;

import com.mysema.query.jpa.impl.JPAUpdateClause;
import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.BlogCategoryDTO;
import kr.co.leem.jpa.example.entities.blog.QBlogCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-07-21.
 */
@Repository
public class BlogCategoryCriteriaImpl implements BlogCategoryCriteria {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long saveChangeStatus(BlogCategoryDTO blogCategoryDTO) throws Exception {
		QBlogCategory blogCategory = QBlogCategory.blogCategory;
		JPAUpdateClause jpaUpdateClause = new JPAUpdateClause(entityManager, blogCategory);

		jpaUpdateClause.set(blogCategory.enabled, blogCategoryDTO.getEnabled());
		jpaUpdateClause.where(blogCategory.seq.eq(blogCategoryDTO.getSeq()));

		return jpaUpdateClause.execute();
	}
}
