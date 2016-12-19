package com.godsungchun.spring.services;

import com.godsungchun.spring.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dream on 2016-12-19.
 */
@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecurityContextRepository securityContextRepository;
	
	@Autowired
	@Qualifier("sessionRegistry")
	private SessionRegistry sessionRegistry;
	
	@Autowired
	@Qualifier("sas")
	private SessionAuthenticationStrategy sessionAuthenticationStrategy;
	
	public void login(HttpServletRequest request, HttpServletResponse response, Account account) throws Exception {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(account.getSignInId(), account.getPwd());
		
		Authentication auth = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		sessionAuthenticationStrategy.onAuthentication(auth, request, response);
		
		securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);
	}
	
	@Override
	public void logout(HttpSession httpSession) throws Exception {
		String sessionId = httpSession.getId();
		httpSession.invalidate();
		
		SessionInformation sessionInformation = sessionRegistry.getSessionInformation(sessionId);
		
		if (sessionInformation != null) {
			sessionRegistry.getSessionInformation(httpSession.getId()).expireNow();
		}
	}
}
