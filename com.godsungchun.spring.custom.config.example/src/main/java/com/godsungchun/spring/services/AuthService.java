package com.godsungchun.spring.services;

import com.godsungchun.spring.entities.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Dream on 2016-12-19.
 */
public interface AuthService {
	public void login(HttpServletRequest request, HttpServletResponse response, Account account) throws Exception;
	public void logout(HttpSession httpSession) throws Exception;
}
