package com.godsungchun.mongodb.example.services.security;

import com.godsungchun.mongodb.example.entities.mongodb.Account;
import com.godsungchun.mongodb.example.entities.mongodb.QAccount;
import com.godsungchun.mongodb.example.repositories.mongodb.AccountRepository;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Dream on 2016-11-16.
 */
@Service
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		QAccount qAccount = QAccount.account;
		Account account = accountRepository.findOne(qAccount.loginId.eq(userName));
		
		String id = account.getLoginId();
		String pwd = account.getPwd();
		
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		AccountUserDetail user = new AccountUserDetail(id, pwd, authorities, account);
		
		return user;
	}
}
