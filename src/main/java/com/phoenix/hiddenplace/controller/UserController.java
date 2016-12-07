package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {
<<<<<<< HEAD

	@RequestMapping(value = "/userInsertView")
	public String Insert() throws Exception {

		return "/views/user/userInsertView";

=======

	@Inject
	private UserService service;


	@RequestMapping(value="/loginview")
	public String loginView() {

		return "/views/user/userLoginView";
	}

	@RequestMapping(value="/userInsertview")
	public String userInsertview() {
		return "/views/user/userInsertView";
>>>>>>> refs/remotes/dongjin1204/master
	}

}
