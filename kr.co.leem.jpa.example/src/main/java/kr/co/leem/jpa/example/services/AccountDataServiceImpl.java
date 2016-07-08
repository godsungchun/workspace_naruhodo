package kr.co.leem.jpa.example.services;

import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.AccountDataDTO;
import kr.co.leem.jpa.example.entities.AccountData;
import kr.co.leem.jpa.example.entities.QAccountData;
import kr.co.leem.jpa.example.repositories.AccountDataRepository;
import kr.co.leem.jpa.example.repositories.querydsl.jpql.AccountDataJPQLCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-06-20.
 */
@Service
public class AccountDataServiceImpl implements AccountDataService {
	@Autowired
	private AccountDataRepository accountDataRepository;

	@Autowired
	private AccountDataJPQLCriteria accountDataJPQLCriteria;

	@Override
	public void findAll(AccountDataDTO accountDataDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception {
		Iterable<AccountData> rows = accountDataRepository.findAll(QAccountData.accountData.accountDataPK.loginId.eq(accountDataDTO.getLoginId()));

		resultMap.put(Result.ResultType.rows, rows);
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	@Override
	public void save(AccountData accountData, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception {
		resultMap.put(Result.ResultType.row, accountDataRepository.save(accountData));
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	@Override
	public void delete(AccountDataDTO accountDataDTO) throws Exception {
		accountDataJPQLCriteria.delete(accountDataDTO);
	}
}
