package com.godsungchun.mongodb.example.repositories.mongodb;

import com.godsungchun.mongodb.example.entities.mongodb.BlogContents;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Dream on 2016-11-15.
 */
@Repository
public interface BlogContentsRepository extends MongoRepository<BlogContents, String>, QueryDslPredicateExecutor<BlogContents> {
}
