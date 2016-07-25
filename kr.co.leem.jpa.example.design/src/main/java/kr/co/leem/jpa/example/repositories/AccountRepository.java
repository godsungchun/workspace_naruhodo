package kr.co.leem.jpa.example.repositories;

import kr.co.leem.jpa.example.entities.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Dream on 2016-07-19.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String>, QueryDslPredicateExecutor<Account> {

}
