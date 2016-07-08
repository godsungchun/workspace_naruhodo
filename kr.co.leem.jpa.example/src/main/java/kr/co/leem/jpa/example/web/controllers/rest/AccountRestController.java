package kr.co.leem.jpa.example.web.controllers.rest;

import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-06-20.
 */
@RestController
@RequestMapping(value = "rest/account")
public class AccountRestController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "findAll")
	public ConcurrentHashMap<Result.ResultType, Object> findAll(Pageable pageable, AccountDTO accountDTO) throws Exception {
		ConcurrentHashMap<Result.ResultType, Object> resultMap = new ConcurrentHashMap<>();

		accountService.findAll(pageable, accountDTO, resultMap);

		resultMap.put(Result.ResultType.resultCode, Result.ResultValue.success);

		return resultMap;
	}

	@RequestMapping(value = "findOne")
	public ConcurrentHashMap<Result.ResultType, Object> findOne(AccountDTO accountDTO) throws Exception {
		ConcurrentHashMap<Result.ResultType, Object> resultMap = new ConcurrentHashMap<>();

		accountService.findOne(accountDTO, resultMap);

		resultMap.put(Result.ResultType.resultCode, Result.ResultValue.success);

		return resultMap;
	}
}
