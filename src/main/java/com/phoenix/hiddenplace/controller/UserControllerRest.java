package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.hiddenplace.domain.User;
import com.phoenix.hiddenplace.service.UserService;
import com.phoenix.hiddenplace.util.Email;
import com.phoenix.hiddenplace.util.EmailSender;

@RestController
@RequestMapping(value = "/user")
public class UserControllerRest {

	@Inject
	private UserService service;
	@Inject
	private Email email;
	@Inject
	private EmailSender emailSender;
	@Inject
	private PasswordEncoder passwordEncoder;

	// 회원가입
	@RequestMapping(value = "/userInsertView", method = RequestMethod.POST)
	public ResponseEntity<String> insert(User user) {

		System.out.println("회원가입 컨트롤러RESTFUL");
		System.out.println(user.toString());
		ResponseEntity<String> entity = null;

		try {
			user.setUserPw(passwordEncoder.encode(user.getUserPw()));
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
	public ResponseEntity<String> nicknameCheck(String nickname) {

		System.out.println("닉네임 중복확인 컨트롤러RESTFUL");
		ResponseEntity<String> entity = null;
		String checkNickname = null;
		try {
			checkNickname = service.nicknameCheck(nickname); // 사용가능한 닉네임, 불가능하다면 null
			if (checkNickname == null) {
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;

	}

	// 이메일 인증번호 발송
	@RequestMapping(value = "/emailSend", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> emailSend(HttpServletRequest request, @RequestParam("email") String reqEmail,
			@RequestParam("certificationNum") String certificationNum) {

		ResponseEntity<String> entity = null;
		try {
			String checkEmail = service.emailCheck(reqEmail);

			if (checkEmail == null) {
				String content = "인증 번호 : " + certificationNum; // 인증번호
				String reciver = reqEmail; // 수신자 이메일
				email.setSubject("이메일 인증 확인용 메일입니다.");
				email.setContent(content);
				email.setReciver(reciver);

				emailSender.SendEmail(email);

				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;

	}

	// 이메일 인증번호 확인
	@RequestMapping(value = "/emailCheck", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> emailCheck(@RequestParam("userInputNum") String userInputNum,
			@RequestParam("certificationNum") String certificationNum) {
		// 사용자가 입력한 인증번호와 메일로 보낸 인증번호가 같은지 비교
		ResponseEntity<String> entity = null;
		try {
			System.out.println(userInputNum);
			// 메일로 보낸 인증번호와 사용자가 입력한 인증번호를 비교해 인증결과를 entity에 저장
			if (certificationNum.equals(userInputNum)) {
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
