package com.godsungchun.mongodb.example.web.controllers.rest;

import com.godsungchun.mongodb.example.constants.Result.*;
import com.godsungchun.mongodb.example.entities.mongodb.Account;
import com.godsungchun.mongodb.example.services.mongodb.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-11-16.
 */
@RestController
@RequestMapping(value = "rest/auth")
public class AuthRestController {
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecurityContextRepository securityContextRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	@Qualifier("sessionRegistry")
	private SessionRegistry sessionRegistry;
	
	@Inject
	@Qualifier("sas")
	private SessionAuthenticationStrategy sessionAuthenticationStrategy;
	
	@RequestMapping(value = "login")
	public Map<Type, Object> login(HttpServletRequest request, HttpServletResponse response, Account account) throws Exception {
		Map<Type, Object> resultMap = new ConcurrentHashMap<>();
		
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(account.getLoginId(), account.getPwd());
			
			Authentication auth = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			sessionAuthenticationStrategy.onAuthentication(auth, request, response);
			
			securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);
			
			resultMap.put(Type.resultCode, Value.success);
		} catch (Exception e) {
			resultMap.put(Type.resultCode, Value.fail);
			e.printStackTrace();
		}
		
		return resultMap;
	}
	
	@RequestMapping(value = "logout")
	public ConcurrentHashMap<Type, Object> login(HttpSession httpSession) throws Exception {
		ConcurrentHashMap<Type, Object> resultMap = new ConcurrentHashMap<>();
		
		String sessionId = httpSession.getId();
		
		httpSession.invalidate();
//		this.logout(sessionId, resultMap);
		
		resultMap.put(Type.resultCode, Value.success);
		
		return resultMap;
	}
	
	public void logout(String sessionId, ConcurrentHashMap<Type, Object> resultMap) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal == null) {
			resultMap.put(Type.resultCode, Value.emptySession);
		} else {
			for (SessionInformation row : sessionRegistry.getAllSessions(principal, true)) {
				row.expireNow();
			}
		}
		
		resultMap.put(Type.resultCode, Value.success);
		
	}
}
