package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.hiddenplace.domain.User;
import com.phoenix.hiddenplace.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserControllerRest {

	@Inject
	private UserService service;

	// 회원가입
	@RequestMapping(value = "/userInsertView", method = RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestBody User user) {

		System.out.println("회원가입 컨트롤러RESTFUL");
		System.out.println(user.toString());
		ResponseEntity<String> entity = null;

		try {
			service.create(user);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 닉네임 중복확인
	@RequestMapping(value = "/nicknameCheck")
	public ResponseEntity<String> nicknameCheck(@RequestBody String nickname) {

		System.out.println("회원가입 컨트롤러RESTFUL");
		System.out.println(nickname);
		ResponseEntity<String> entity = null;
		String success = "";
		try {
			success = service.nicknameCheck(nickname);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;

	}
	// 회원가입
	// @RequestMapping(value = "/userInsertView", method = RequestMethod.POST)
	// public String insert(@RequestBody User user, RedirectAttributes rttr) throws Exception {
	//
	// System.out.println(user.toString());
	//
	// service.create(user);
	//
	// rttr.addFlashAttribute("result", "success");
	//
	// return "redirect:/views/user/userInsertView";
	// }

}
