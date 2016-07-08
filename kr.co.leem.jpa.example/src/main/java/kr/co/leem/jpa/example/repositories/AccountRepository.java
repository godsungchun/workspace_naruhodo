package kr.co.leem.jpa.example.repositories;

import kr.co.leem.jpa.example.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dream on 2016-06-18.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String>, QueryDslPredicateExecutor<Account> {
	List<Account> findAllByRegDateBetweenOrderByRegDateDesc(Long fromDate, Long toDate) throws Exception;
	Page<Account> findAllByRegDateBetweenOrderByRegDateDesc(Pageable pageable, Long fromDate, Long toDate) throws Exception;
}
