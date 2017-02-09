package com.godsungchun.mongodb.example.services.mongodb;

import com.godsungchun.mongodb.example.constants.Result.*;
import com.godsungchun.mongodb.example.entities.mongodb.BlogSectionCode;
import com.godsungchun.mongodb.example.params.FindParams;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-11-15.
 */
public interface BlogSectionCodeService {
	void findAll(FindParams findParams, Pageable pageable, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void findOne(BlogSectionCode blogSectionCode, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void save(BlogSectionCode blogSectionCode, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void save(List<BlogSectionCode> blogSectionCodes, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void getParentCodes(ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void checkDuplicatedSectionCode(BlogSectionCode blogSectionCode, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void generateSectionCode(BlogSectionCode blogSectionCode, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
	void findAllTreeData(FindParams findParams, ConcurrentHashMap<Type, Object> resultMap) throws Exception;
}
