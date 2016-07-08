package kr.co.leem.jpa.example.services;

import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.entities.Account;
import org.springframework.data.domain.Pageable;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-06-18.
 */
public interface AccountService {
	void findAll(Pageable pageable, AccountDTO accountDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception;
	void findOne(AccountDTO accountDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception;
	void save(Account account, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception;
	void delete(AccountDTO accountDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception;
}
