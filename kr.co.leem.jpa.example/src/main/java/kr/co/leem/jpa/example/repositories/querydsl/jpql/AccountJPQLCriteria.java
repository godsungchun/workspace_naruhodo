package kr.co.leem.jpa.example.repositories.querydsl.jpql;

import kr.co.leem.jpa.example.constants.Result;
import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-06-20.
 */
@Repository
public interface AccountJPQLCriteria {
	Page findAll(Pageable pageable, AccountDTO accountDTO, ConcurrentHashMap<Result.ResultType, Object> resultMap) throws Exception;
}
