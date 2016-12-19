package com.godsungchun.spring.web.controllers;

import com.godsungchun.spring.commons.constants.Result;
import com.godsungchun.spring.entities.Account;
import com.godsungchun.spring.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-12-19.
 */
@Controller
@RequestMapping(value = "auth")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ConcurrentHashMap<Result.Code, Object> login(HttpServletRequest request, HttpServletResponse response, Account account) throws Exception {
		ConcurrentHashMap<Result.Code, Object> resultMap = new ConcurrentHashMap<>();
		
		authService.login(request, response, account);
		
		resultMap.put(Result.Code.resultCode, Result.Value.success);
		
		return resultMap;
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public ConcurrentHashMap<Result.Code, Object> logout(HttpSession httpSession) throws Exception {
		ConcurrentHashMap<Result.Code, Object> resultMap = new ConcurrentHashMap<>();
		
		authService.logout(httpSession);
		
		resultMap.put(Result.Code.resultCode, Result.Value.success);
		
		return resultMap;
	}
}
