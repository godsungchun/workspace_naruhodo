package com.godsungchun.mongodb.example.repositories.mongodb;

import com.godsungchun.mongodb.example.entities.mongodb.ResourceRelation;
import com.mongodb.Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dream on 2016-11-15.
 */
@Repository
public interface ResourceRelationRepository extends MongoRepository<ResourceRelation, String> {
}
