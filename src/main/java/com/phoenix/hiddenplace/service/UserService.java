package com.phoenix.hiddenplace.service;

import com.phoenix.hiddenplace.domain.Login;
import com.phoenix.hiddenplace.domain.User;

public interface UserService {

	// 회원가입
	public void create(User user) throws Exception;

	// 닉네임 중복확인
	public String nicknameCheck(String nickname) throws Exception;

	// 이메일 중복확인
	public String emailCheck(String email) throws Exception;

	// 비밀번호 변경
	public void pwUpdate(User user) throws Exception;

	// 로그인
	public User login(Login login) throws Exception;

	// 회원정보 수정
	public void modify(User user) throws Exception;

	// 회원탈퇴
	public void delete(User user) throws Exception;

}
