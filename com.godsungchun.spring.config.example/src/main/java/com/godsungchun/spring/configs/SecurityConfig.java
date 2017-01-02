package com.godsungchun.spring.configs;

import com.godsungchun.spring.security.AccountUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Dream on 2016-12-12.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		return bCryptPasswordEncoder;
	}
	
	@Bean
	public UserDetailsService accountUserDetailService() throws Exception {
		UserDetailsService userDetailsService = new AccountUserDetailService();
		
		return userDetailsService;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/index", "/login", "/logout", "/favicon.ico", "/resources/**", "/webjar/**","/rest/auth/**")
				.permitAll()
			.anyRequest()
				.authenticated()
			.and()
				.formLogin()
					.usernameParameter("signInId")
					.passwordParameter("pwd")
					.loginPage("/login")
					.permitAll()
					.defaultSuccessUrl("/main/index")
			.and()
				.logout()
				.logoutUrl("/logout").deleteCookies("JSESSIONID")
				.deleteCookies("JSESSIONID").permitAll()
				.permitAll()
			.and()
				.sessionManagement()
				.sessionFixation()
				.migrateSession()
				.invalidSessionUrl("/login")
				.maximumSessions(1)
				.expiredUrl("/login")
				.maxSessionsPreventsLogin(true);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/webjars/**");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.eraseCredentials(true).userDetailsService(this.accountUserDetailService()).passwordEncoder(this.passwordEncoder());
	}
}
