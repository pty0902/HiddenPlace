package com.phoenix.hiddenplace;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import com.phoenix.hiddenplace.dao.UserDao;
import com.phoenix.hiddenplace.domain.User;

public class UserDaoTest {

	@Inject
	private UserDao dao;
	
	@Test
	public void testCreate() throws Exception {

		User user = new User();
		user.setUserId("phoenix1234@naver.com");
		user.setUserPw("abc1234");
		user.setUserNickname("피닉스");
		user.setUserPhoneNum("01012341234");
		dao.create(user);

	}

}
