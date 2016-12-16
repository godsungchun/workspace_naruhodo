package com.godsungchun.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dream on 2016-12-12.
 */
@Controller
public class DefaultController {
	@RequestMapping(value = {"/", "login", "index"})
	public String index() throws Exception {
		return "login";
	}
}
