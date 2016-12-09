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
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<String> insert(User user) {

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
	@RequestMapping(value = "/forgetPwUpdateView", method = RequestMethod.POST)
	public ResponseEntity<String> forgetPwUpdate(String email, String newPw) {
		System.out.println(email);
		System.out.println(newPw);
		ResponseEntity<String> entity = null;
		try {
			String updatePw = passwordEncoder.encode(newPw); // 비밀번호 암호화(변경할 비밀번호)
			User user = new User();
			user.setUserId(email);
			user.setUserPw(updatePw);
			service.pwUpdate(user);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
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

		System.out.println("로그인된 ID : " + user.getUserId());
		System.out.println("로그인된 PW : " + user.getUserPw());

		model.addAttribute("user", user);
	}

	// 회원수정
	@RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
	public ResponseEntity<String> userUpdate(String email, String nowPw, String newPw, String newNickname) throws Exception {

		ResponseEntity<String> entity = null;
		try {
			Login login = new Login();
			login.setUserId(email); // 현재 로그온 상태의 아이디
			User searchUser = service.login(login); // 현재 로그인한 아이디의 유저 정보를 가져옴(id,pw) 없다면 null

			if (searchUser != null && passwordEncoder.matches(nowPw, searchUser.getUserPw())) { // 비밀번호 일치
				searchUser.setUserNickname(newNickname); // 현재 입력되어 있는 닉네임
				if (newPw == null) { // 닉네임만 변경하였을 경우
					service.modify(searchUser);
				} else { // 닉네임, 비밀번호 변경
					searchUser.setUserPw(passwordEncoder.encode(newPw)); // 변경할 비밀번호
					service.modify(searchUser);
				}
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else { // 비밀번호 불일치
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 회원탈퇴
	@RequestMapping(value = "/userDelete", method = RequestMethod.POST)
	public ResponseEntity<String> deleteUser(User user) {

		ResponseEntity<String> entity = null;
		try {
			Login login = new Login();
			login.setUserId(user.getUserId()); // 현재 로그온 상태의 아이디
			User searchUser = service.login(login); // 현재 로그인한 아이디의 유저 정보를 가져옴(id,pw) 없다면 null
			// 검색한 유저 정보가 존재 AND 검색한 유저의 비밀번호와 입력한 비밀번호가 일치하는지
			if (searchUser != null && passwordEncoder.matches(user.getUserPw(), searchUser.getUserPw())) { // 비밀번호 일치
				service.delete(searchUser); // id와 입력한 비밀번호가 일치하는 컬럼을 삭제(회원탈퇴)
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else { // 비밀번호 불일치
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
