package kr.co.leem.jpa.example.services;

import kr.co.leem.jpa.example.dto.AccountDTO;
import kr.co.leem.jpa.example.entities.account.Account;
import kr.co.leem.jpa.example.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dream on 2016-07-19.
 */
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	@Override
	public Account save(AccountDTO accountDTO) throws Exception {
		Account account = accountDTO.dtoToEntity();

		return accountRepository.save(account);
	}
}
