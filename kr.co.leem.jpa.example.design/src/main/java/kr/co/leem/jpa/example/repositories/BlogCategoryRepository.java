package kr.co.leem.jpa.example.repositories;

import kr.co.leem.jpa.example.entities.blog.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Dream on 2016-07-20.
 */
@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Long>, QueryDslPredicateExecutor<BlogCategory> {
}
