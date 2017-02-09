package com.godsungchun.mongodb.example.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dream on 2016-12-22.
 */
@Controller
@RequestMapping(value = "admin/blog")
public class BlogContentsPageController {
	@RequestMapping(value = "/release/index")
	public String blogReleaseIndex() throws Exception {
		return "admin/blog/release/index";
	}
}
