package com.godsungchun.spring.security.domains;

import com.godsungchun.spring.entities.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Dream on 2016-12-12.
 */
public class AccountUser extends User {
	private Account account;
	
	public AccountUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Account account) {
		super(username, password, true, true, true, true, authorities);
	}
}
