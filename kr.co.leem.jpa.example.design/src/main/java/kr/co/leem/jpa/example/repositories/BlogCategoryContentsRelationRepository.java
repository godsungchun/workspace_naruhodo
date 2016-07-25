package kr.co.leem.jpa.example.repositories;

import kr.co.leem.jpa.example.entities.blog.BlogCategoryContentsRelation;
import kr.co.leem.jpa.example.entities.blog.BlogContentsRelation;
import kr.co.leem.jpa.example.entities.blog.embedded.BlogCategoryContentRelationPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Dream on 2016-07-22.
 */
@Repository
public interface BlogCategoryContentsRelationRepository extends JpaRepository<BlogCategoryContentsRelation, BlogCategoryContentRelationPK>, QueryDslPredicateExecutor<BlogCategoryContentsRelation> {

}
