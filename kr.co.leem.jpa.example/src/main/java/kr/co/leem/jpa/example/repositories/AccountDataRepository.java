package kr.co.leem.jpa.example.repositories;

import kr.co.leem.jpa.example.entities.AccountData;
import kr.co.leem.jpa.example.entities.embedded.AccountDataPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dream on 2016-06-20.
 */
@Repository
public interface AccountDataRepository extends JpaRepository<AccountData, AccountDataPK>, QueryDslPredicateExecutor<AccountData> {

}
