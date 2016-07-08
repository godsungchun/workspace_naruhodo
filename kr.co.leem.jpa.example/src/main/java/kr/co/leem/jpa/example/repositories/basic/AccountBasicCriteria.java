package kr.co.leem.jpa.example.repositories.basic;


import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Dream on 2016-06-29.
 */
public interface AccountBasicCriteria {
	Long count(AccountDTO accountDTO) throws Exception;
	Page<Account> findAll(Pageable pageable, AccountDTO accountDTO) throws Exception;
}
