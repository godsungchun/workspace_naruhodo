package com.godsungchun.spring.security;

import com.godsungchun.spring.entities.Account;
import com.godsungchun.spring.repositories.AccountRepository;
import com.godsungchun.spring.security.domains.AccountUser;
import com.godsungchun.spring.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.godsungchun.spring.entities.QAccount.account;
/**
 * Created by Dream on 2016-12-12.
 */
@Service
public class AccountUserDetailService implements UserDetailsService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		Account row = accountRepository.findOne(account.signInId.eq(s));
		
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new AccountUser(s, row.getPwd(), grantedAuthorities, row);
	}
}
