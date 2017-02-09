package com.godsungchun.mongodb.example.repositories.mongodb;

import com.godsungchun.mongodb.example.entities.mongodb.BlogSectionCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Dream on 2016-11-15.
 */
@Repository
public interface BlogSectionCodeRepository extends MongoRepository<BlogSectionCode, String>, QueryDslPredicateExecutor<BlogSectionCode> {
}
