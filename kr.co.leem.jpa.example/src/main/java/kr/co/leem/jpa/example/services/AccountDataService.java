package kr.co.leem.jpa.example.services;

import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.AccountDataDTO;
import kr.co.leem.jpa.example.entities.AccountData;
import org.springframework.data.domain.Pageable;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-06-20.
 */
public interface AccountDataService {
	void findAll(AccountDataDTO accountDataDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception;
	void save(AccountData accountData, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception;
	void delete(AccountDataDTO accountDataDTO) throws Exception;
}
