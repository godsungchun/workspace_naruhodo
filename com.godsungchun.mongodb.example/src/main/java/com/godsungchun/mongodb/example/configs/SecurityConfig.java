package com.godsungchun.mongodb.example.configs;

import com.godsungchun.mongodb.example.services.security.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.session.*;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.session.SimpleRedirectSessionInformationExpiredStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-11-23.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean(name = "authenticationManager")
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return this.authenticationManager();
	}
	
	@Bean
	ConcurrentSessionFilter concurrentSessionFilter() throws Exception {
		SessionInformationExpiredStrategy sessionInformationExpiredStrategy = new SimpleRedirectSessionInformationExpiredStrategy("/login");
		ConcurrentSessionFilter concurrentSessionFilter = new ConcurrentSessionFilter(sessionRegistry(), sessionInformationExpiredStrategy);
		
		return concurrentSessionFilter;
	}
	
	@Bean
	public SecurityContextRepository securityContextRepository() {
		HttpSessionSecurityContextRepository repo = new HttpSessionSecurityContextRepository();
		
		return repo;
	}
	
	@Bean
	public AuthenticationService authenticationService(){
		return new AuthenticationService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		SessionRegistry sessionRegistry = new SessionRegistryImpl();
		
		return sessionRegistry;
	}
	
	@Bean
	public CompositeSessionAuthenticationStrategy sas() {
		ConcurrentSessionControlAuthenticationStrategy concurrentSessionControlAuthenticationStrategy = new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry());
		
		concurrentSessionControlAuthenticationStrategy.setMaximumSessions(1);
		concurrentSessionControlAuthenticationStrategy.setExceptionIfMaximumExceeded(true);
		
		SessionFixationProtectionStrategy sessionFixationProtectionStrategy = new SessionFixationProtectionStrategy();
		sessionFixationProtectionStrategy.setMigrateSessionAttributes(true);
		
		RegisterSessionAuthenticationStrategy sessionAuthenticationStrategy = new RegisterSessionAuthenticationStrategy(sessionRegistry());
		
		List<SessionAuthenticationStrategy> delegateStrategies = new ArrayList<SessionAuthenticationStrategy>();
		
		delegateStrategies.add(concurrentSessionControlAuthenticationStrategy);
		delegateStrategies.add(sessionFixationProtectionStrategy);
		delegateStrategies.add(sessionAuthenticationStrategy);
		
		CompositeSessionAuthenticationStrategy compositeSessionAuthenticationStrategy = new CompositeSessionAuthenticationStrategy(delegateStrategies);
		
		return compositeSessionAuthenticationStrategy;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilter(concurrentSessionFilter())
				.authorizeRequests()
				.antMatchers("/login", "/logout", "/resources/**", "/webjar/**","/rest/auth/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin().loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/logout").permitAll()
				.and()
				.sessionManagement()
				.sessionAuthenticationStrategy(sas());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/webjars/**");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.eraseCredentials(true).userDetailsService(this.authenticationService()).passwordEncoder(this.passwordEncoder());
	}
}
