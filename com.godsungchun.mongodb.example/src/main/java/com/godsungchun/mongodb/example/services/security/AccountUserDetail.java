package com.godsungchun.mongodb.example.services.security;

import com.godsungchun.mongodb.example.entities.mongodb.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Dream on 2017-01-04.
 */
public class AccountUserDetail extends User {
	private Account account;
	
	public AccountUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, Account account) {
		super(username, password, authorities);
		this.account = account;
	}
	
	public AccountUserDetail(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Account account) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
}
