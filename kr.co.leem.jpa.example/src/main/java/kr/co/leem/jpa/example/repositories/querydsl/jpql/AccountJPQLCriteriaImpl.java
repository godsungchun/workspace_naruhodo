package kr.co.leem.jpa.example.repositories.querydsl.jpql;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.entities.Account;
import kr.co.leem.jpa.example.entities.QAccount;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * QueryDSL JPQL Base Querying.
 *
 * Created by Dream on 2016-06-20.
 */
@Repository
public class AccountJPQLCriteriaImpl implements AccountJPQLCriteria {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<Account> findAll(Pageable pageable, AccountDTO accountDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception {
		JPQLQuery jpqlQuery = new JPAQuery(entityManager);
		JPQLQuery baseQuery = jpqlQuery.from(QAccount.account).where(this.getAccountsWhereBuilder(accountDTO));
		Long count = baseQuery.count();

		jpqlQuery.offset(pageable.getOffset());
		jpqlQuery.limit(pageable.getPageSize());

		List<Account> accountsByJpql = baseQuery.list(QAccount.account);

		return new PageImpl(accountsByJpql, pageable, count);
	}

	private BooleanBuilder getAccountsWhereBuilder(AccountDTO accountDTO) throws Exception {
		BooleanBuilder booleanBuilder = new BooleanBuilder();

		if (StringUtils.isNotEmpty(accountDTO.getLoginId())) {
			booleanBuilder.and(QAccount.account.loginId.eq(accountDTO.getLoginId()));
		}

		return booleanBuilder;
	}
}
