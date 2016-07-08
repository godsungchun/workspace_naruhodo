package kr.co.leem.jpa.example.services;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.entities.Account;
import kr.co.leem.jpa.example.entities.QAccount;

import kr.co.leem.jpa.example.repositories.AccountRepository;
import kr.co.leem.jpa.example.repositories.basic.AccountBasicCriteria;
import kr.co.leem.jpa.example.repositories.querydsl.jpql.AccountJPQLCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-06-18.
 */
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountJPQLCriteria accountJPQLCriteria;

	@Autowired
	private AccountBasicCriteria accountBasicCriteria;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void findAll(Pageable pageable, AccountDTO accountDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception {
		/* Method Name Base Querying */
		List<Account> accountsByMethodName = accountRepository.findAllByRegDateBetweenOrderByRegDateDesc(accountDTO.getFromDate(), accountDTO.getToDate());

		/* QueryDSL Base Querying */
		Iterable<Account> accountsByJpa = accountRepository.findAll(QAccount.account.regDate.desc());
		Page<Account> accountsByPageable = accountRepository.findAll(QAccount.account.loginId.eq(accountDTO.getLoginId()), pageable);
		/* JPQLQuery Base Querying */
		Page<Account> accountByJpql = accountJPQLCriteria.findAll(pageable, accountDTO, resultMap);

		Page<Account> accountByBasic = accountBasicCriteria.findAll(pageable, accountDTO);

		resultMap.put(Result.ResultType.rowsByMethodName, accountsByMethodName);
		resultMap.put(Result.ResultType.rowsByJpa, accountsByJpa);
		resultMap.put(Result.ResultType.rowsByPageable, accountsByPageable);
		resultMap.put(Result.ResultType.rowsByJpql, accountByJpql);
		resultMap.put(Result.ResultType.rowsByBasic, accountByBasic);

	}

	@Override
	public void findOne(AccountDTO accountDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception {
		Account account = accountRepository.findOne(accountDTO.getLoginId());

		/* Method Name Base Querying */
		JPQLQuery jpqlQuery = new JPAQuery(entityManager);

		Account accountByJpql = jpqlQuery.from(QAccount.account).where(QAccount.account.loginId.eq(accountDTO.getLoginId())).singleResult(QAccount.account);

		resultMap.put(Result.ResultType.rowByJpa, account);
		resultMap.put(Result.ResultType.rowByJpql, accountByJpql);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void save(Account account, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception {
		resultMap.put(Result.ResultType.row, accountRepository.save(account));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void delete(AccountDTO accountDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception {
		accountRepository.delete(accountDTO.getLoginId());
	}
}
