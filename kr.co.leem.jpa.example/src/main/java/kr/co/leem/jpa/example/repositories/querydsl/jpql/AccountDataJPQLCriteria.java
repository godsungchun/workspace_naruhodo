package kr.co.leem.jpa.example.repositories.querydsl.jpql;

import kr.co.leem.jpa.example.dto.AccountDataDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Dream on 2016-06-21.
 */
public interface AccountDataJPQLCriteria {
	public void delete(AccountDataDTO accountDataDTO) throws Exception;

}
