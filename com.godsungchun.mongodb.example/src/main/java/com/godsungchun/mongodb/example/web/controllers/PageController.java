package com.godsungchun.mongodb.example.web.controllers;

import com.godsungchun.mongodb.example.services.mongodb.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dream on 2016-11-16.
 */
@Controller
public class PageController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = {"/", "login"})
	public String login() throws Exception {
		accountService.regDefaultAccount();
		
		return "login";
	}
}
