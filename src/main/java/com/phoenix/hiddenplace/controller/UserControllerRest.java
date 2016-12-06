package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.hiddenplace.domain.Login;
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
	@RequestMapping(value = "/userInsert", method = RequestMethod.POST)
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
				email.setSubject("HiddenPlace 회원가입 이메일 인증 확인 메일입니다.");
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

	//

	// 비밀번호 찾기 이메일 인증번호 발송
	@RequestMapping(value = "/forgetEmailSend", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> forgetEmailSend(HttpServletRequest request, @RequestParam("email") String reqEmail,
			@RequestParam("certificationNum") String certificationNum) {

		ResponseEntity<String> entity = null;
		try {
			String checkEmail = service.emailCheck(reqEmail);

			if (checkEmail != null && checkEmail.equals(reqEmail)) {
				String content = "인증 번호 : " + certificationNum; // 인증번호
				String reciver = reqEmail; // 수신자 이메일
				email.setSubject("HiddenPlace 비밀번호 찾기 이메일 인증 확인 메일입니다.");
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

	// 비밀번호 찾기 (변경)
	@RequestMapping(value = "/forgetPwUpdate", method = RequestMethod.POST)
	public ResponseEntity<String> forgetPwUpdate(String email, String newPw) {

		ResponseEntity<String> entity = null;
		try {
			String updatePw = (passwordEncoder.encode(newPw)); // 비밀번호 암호화(변경할 비밀번호)
			User user = new User();
			user.setUserId(email);
			user.setUserPw(updatePw);
			service.pwUpdate(user);

			// entity = new ResponseEntity<String>("success", HttpStatus.OK);
			// entity = new ResponseEntity<String>("fail", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(Login login, HttpSession session, Model model) throws Exception {

		System.out.println(login.getUserId());
		System.out.println(login.getUserPw());
		
		User user = service.login(login); // 로그인된 user

		if (user == null) {
			return;
		}
		
		System.out.println("로그인된 ID : "+user.getUserId() );
		System.out.println("로그인된 PW : "+user.getUserPw());
		
		model.addAttribute("user", user);
	}

	// // 회원탈퇴
	// @RequestMapping(value = "/deleteUser")
	// public ResponseEntity<String> deleteUser(@RequestParam("userPw") String userPw) {
	//
	// System.out.println("deleteUser 파일 호출");
	// ResponseEntity<String> entity = null;
	//
	// try {
	// service.delete(userPw);
	//
	// entity = new ResponseEntity<String>("success", HttpStatus.OK);
	// } catch (Exception e) {
	// e.printStackTrace();
	// entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	// }
	// return entity;
	// }
}
