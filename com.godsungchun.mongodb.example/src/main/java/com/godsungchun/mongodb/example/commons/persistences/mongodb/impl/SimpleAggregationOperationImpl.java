package com.godsungchun.mongodb.example.commons.persistences.mongodb.impl;

import com.godsungchun.mongodb.example.commons.persistences.mongodb.SimpleAggregationOperation;
import com.godsungchun.mongodb.example.entities.mongodb.BlogSectionCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dream on 2017-01-19.
 */
@Repository
public class SimpleAggregationOperationImpl<T> implements SimpleAggregationOperation<T> {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public <S extends T> S minMax(Sort.Direction direction, Class collectionClass, Class targetClass, String property, String parentCode, String... groupByProperty) throws Exception {
		AggregationOperation aggregationOperationSort = Aggregation.sort(direction, groupByProperty);
		AggregationOperation aggregationOperationGroup = Aggregation.group(groupByProperty).first(property).as(property).first("code").as("code");
		AggregationOperation aggregationOperationProjection = Aggregation.project(property, "code");
		AggregationOperation aggregationOperationLimit = Aggregation.limit(1);
		
		List<AggregationOperation> aggregationOperations = new ArrayList<>();
		
		if (StringUtils.isNotEmpty(parentCode)) {
			AggregationOperation aggregationOperationMatch = Aggregation.match(Criteria.where("parentCode").in(parentCode));
			
			aggregationOperations.add(aggregationOperationMatch);
		}
		
		aggregationOperations.add(aggregationOperationGroup);
		aggregationOperations.add(aggregationOperationSort);
		aggregationOperations.add(aggregationOperationProjection);
		aggregationOperations.add(aggregationOperationLimit);

		Aggregation aggregation = Aggregation.newAggregation(aggregationOperations);
		
		AggregationResults<S> rows = mongoTemplate.aggregate(aggregation, collectionClass, targetClass);
		
		return rows.getMappedResults().get(0);
	}
}
