package kr.co.leem.jpa.example.repositories.basic;

import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.entities.Account;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Java JPA Basic Criteria Querying.
 *
 * Created by Dream on 2016-06-29.
 */
@Repository
public class AccountBasicCriteriaImpl implements AccountBasicCriteria {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<Account> findAll(Pageable pageable, AccountDTO accountDTO) throws Exception {
		Long count = count(accountDTO);

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(String.class);

		Root root = criteriaQuery.from(Account.class);
		criteriaQuery.where(whereQuery(accountDTO, criteriaBuilder, root, criteriaQuery).toArray(new Predicate[]{}));

		criteriaQuery.select(root);
		List<Account> rows = entityManager.createQuery(criteriaQuery).getResultList();

		Page page = new PageImpl(rows, pageable, count);

		return page;
	}

	@Override
	public Long count(AccountDTO accountDTO) throws Exception {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(String.class);

		Root root = criteriaQuery.from(Account.class);
		criteriaQuery.select(criteriaBuilder.count(root.get("loginId")));
		criteriaQuery.where(whereQuery(accountDTO, criteriaBuilder, root, criteriaQuery).toArray(new Predicate[]{}));

		Object count = entityManager.createQuery(criteriaQuery).getSingleResult();
		Long resultCount = 0L;

		if (count != null) {
			resultCount = (Long)count;
		}

		return resultCount;
	}

	private List<Predicate> whereQuery(AccountDTO accountDTO, CriteriaBuilder criteriaBuilder, Root root, CriteriaQuery criteriaQuery) throws Exception {
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (StringUtils.isNotEmpty(accountDTO.getLoginId())) {
			predicates.add(criteriaBuilder.equal(root.get("loginId"), accountDTO.getLoginId()));
		}

		if (accountDTO.getAge() != null && accountDTO.getAge() > 0) {
			predicates.add(criteriaBuilder.equal(root.get("age"), accountDTO.getAge()));
		}

		return predicates;
	}
}
