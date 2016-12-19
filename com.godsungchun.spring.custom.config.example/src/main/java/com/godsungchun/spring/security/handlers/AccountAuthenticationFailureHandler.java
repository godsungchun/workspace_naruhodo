package com.godsungchun.spring.security.handlers;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dream on 2016-12-19.
 */
public class AccountAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	public AccountAuthenticationFailureHandler(String defaultFailureUrl) {
		super(defaultFailureUrl);
	}
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		System.out.println("**** LoginFailure ****");
		super.onAuthenticationFailure(request, response, exception);
	}
}
