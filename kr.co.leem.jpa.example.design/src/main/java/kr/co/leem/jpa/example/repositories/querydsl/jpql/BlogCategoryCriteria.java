package kr.co.leem.jpa.example.repositories.querydsl.jpql;

import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.BlogCategoryDTO;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-07-21.
 */
public interface BlogCategoryCriteria {
	Long saveChangeStatus(BlogCategoryDTO blogCategoryDTO) throws Exception;
}
