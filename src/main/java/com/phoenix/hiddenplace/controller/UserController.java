package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	// 회원가입
	@RequestMapping(value = "/userInsertView", method = RequestMethod.GET)
	public String insertGET() {

		System.out.println("userInsertView 호출");

		return "/views/user/userInsertView";
	}

}
