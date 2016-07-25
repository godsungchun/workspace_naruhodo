package kr.co.leem.jpa.example.services;

import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.BlogCategoryDTO;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-07-20.
 */
public interface BlogCategoryService {
	void save(BlogCategoryDTO blogDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception;
	void findAll(BlogCategoryDTO blogDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception;
	void saveChangeStatus(BlogCategoryDTO blogCategoryDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception;
}
