package com.phoenix.hiddenplace.dao;

import com.phoenix.hiddenplace.domain.User;

public interface UserDao {

	// 회원가입
	public void create(User user) throws Exception;

	// 닉네임 중복확인
	public String nicknameCheck(String nickname) throws Exception;

	
}
