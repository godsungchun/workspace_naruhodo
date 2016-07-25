package kr.co.leem.jpa.example.services;

import kr.co.leem.jpa.example.dto.BlogDTO;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-07-22.
 */
public interface BlogService {
	void save(BlogDTO blogDTO, ConcurrentHashMap<String, Object> resultMap) throws Exception;
}
