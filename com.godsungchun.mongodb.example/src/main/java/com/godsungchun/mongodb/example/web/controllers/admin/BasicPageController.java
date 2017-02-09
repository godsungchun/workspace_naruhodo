package com.godsungchun.mongodb.example.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dream on 2017-01-09.
 */
@Controller
@RequestMapping(value = "admin/basic")
public class BasicPageController {
	@RequestMapping(value = "account/index")
	public String accountIndex() throws Exception {
		return "admin/basic/account/index";
	}
	
	@RequestMapping(value = "account/popup/edit")
	public String accountPopupEdit() throws Exception {
		return "admin/basic/account/popup/edit";
	}
	
	@RequestMapping(value = "sectionCode/index")
	public String sectionCodeIndex() throws Exception {
		return "admin/basic/sectionCode/index";
	}
}
