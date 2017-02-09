package com.godsungchun.mongodb.example.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dream on 2017-01-09.
 */
@Controller
@RequestMapping(value = "admin/dashboard")
public class DashboardPageController {
	@RequestMapping(value = "index")
	public String dashboardIndex() throws Exception {
		return "admin/dashboard/index";
	}
}
