package com.godsungchun.spring.web.controllers.rest;

import com.godsungchun.spring.commons.constants.Result;
import com.godsungchun.spring.entities.Account;
import com.godsungchun.spring.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-12-12.
 */
@RestController
@RequestMapping(value = "rest/auth")
public class AuthRestController {
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "login")
	public ConcurrentHashMap<Result.Code, Object> login(HttpServletRequest request, HttpServletResponse response, Account account) throws Exception {
		ConcurrentHashMap<Result.Code, Object> resultMap = new ConcurrentHashMap<>();
		
		authService.login(request, response, account);
		
		resultMap.put(Result.Code.resultCode, Result.Value.success);
		
		return resultMap;
	}
	
	@RequestMapping(value = "logout")
	public ConcurrentHashMap<Result.Code, Object> logout(HttpSession httpSession) throws Exception {
		ConcurrentHashMap<Result.Code, Object> resultMap = new ConcurrentHashMap<>();
		
		authService.logout(httpSession);
		
		resultMap.put(Result.Code.resultCode, Result.Value.success);
		
		return resultMap;
	}
}
