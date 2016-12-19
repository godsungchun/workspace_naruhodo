package com.godsungchun.spring.repositories;

import com.godsungchun.spring.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Dream on 2016-12-12.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, QueryDslPredicateExecutor<Account> {
	
}
