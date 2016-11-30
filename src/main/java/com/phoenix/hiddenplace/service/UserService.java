package com.phoenix.hiddenplace.service;

import com.phoenix.hiddenplace.domain.User;

public interface UserService {

	// 회원가입
	public void create(User user) throws Exception;

	// 닉네임 중복확인
	public String nicknameCheck(String nickname) throws Exception;

}
