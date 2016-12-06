package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/userInsertView")
	public String Insert() throws Exception {

		return "/views/user/userInsertView";

	}

}
