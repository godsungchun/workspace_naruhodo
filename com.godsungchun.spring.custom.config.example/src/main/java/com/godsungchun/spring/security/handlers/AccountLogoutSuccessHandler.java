package com.godsungchun.spring.security.handlers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dream on 2016-12-19.
 */
public class AccountLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	private SessionRegistry sessionRegistry;
	
	
	public AccountLogoutSuccessHandler(SessionRegistry sessionRegistry) {
		this.sessionRegistry = sessionRegistry;
	}
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		System.out.println("**** LoginSuccess ****");
		
		List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(authentication.getPrincipal(), true);
		
		for (SessionInformation sessionInformationRow : sessionInformations) {
			sessionInformationRow.expireNow();
		}
		
		super.onLogoutSuccess(request, response, authentication);
	}
}
