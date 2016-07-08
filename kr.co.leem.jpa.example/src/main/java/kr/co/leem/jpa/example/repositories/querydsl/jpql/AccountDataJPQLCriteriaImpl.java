package kr.co.leem.jpa.example.repositories.querydsl.jpql;

import com.mysema.query.jpa.impl.JPADeleteClause;
import kr.co.leem.jpa.example.dto.AccountDataDTO;
import kr.co.leem.jpa.example.entities.QAccountData;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * QueryDSL JPQL Base Querying.
 *
 * Created by Dream on 2016-06-21.
 */
@Repository
public class AccountDataJPQLCriteriaImpl implements AccountDataJPQLCriteria {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void delete(AccountDataDTO accountDataDTO) throws Exception {
		JPADeleteClause sqlDeleteClause = new JPADeleteClause(entityManager, QAccountData.accountData).where(QAccountData.accountData.accountDataPK.loginId.eq(accountDataDTO.getLoginId()));
		sqlDeleteClause.execute();
	}

}
