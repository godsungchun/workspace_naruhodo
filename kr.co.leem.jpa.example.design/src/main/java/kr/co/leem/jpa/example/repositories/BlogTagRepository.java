package kr.co.leem.jpa.example.repositories;

import kr.co.leem.jpa.example.entities.blog.BlogTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Dream on 2016-07-22.
 */
@Repository
public interface BlogTagRepository extends JpaRepository<BlogTag, Long>, QueryDslPredicateExecutor<BlogTag> {
}
