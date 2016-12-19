package com.godsungchun.spring.security.handlers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dream on 2016-12-19.
 */
public class AccountAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	public AccountAuthenticationSuccessHandler(String defaultTargetUrl) {
		super(defaultTargetUrl);
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		System.out.println("**** LoginSuccess ****");
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
