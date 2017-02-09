package com.godsungchun.mongodb.example.commons.persistences.mongodb;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Component;

/**
 * Created by Dream on 2017-01-19.
 */
public interface SimpleAggregationOperation<T> {
	<S extends T> S minMax(Sort.Direction direction, Class collectionClass,Class targetClass, String property, String parentCode, String... groupByProperty) throws Exception;
}
