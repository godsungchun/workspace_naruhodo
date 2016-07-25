package kr.co.leem.jpa.example.services;

import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.entities.account.Account;
import kr.co.leem.jpa.example.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dream on 2016-07-19.
 */
public interface AccountService {
	Account save(AccountDTO accountDTO) throws Exception;
}
