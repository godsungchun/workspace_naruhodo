package com.godsungchun.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dream on 2016-12-14.
 */
@Controller
@RequestMapping(value = "main")
public class MainController {
	@RequestMapping(value = "index")
	public String index() throws Exception {
		return "main/index";
	}
}
