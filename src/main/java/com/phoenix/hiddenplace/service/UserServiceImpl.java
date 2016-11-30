package com.phoenix.hiddenplace.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phoenix.hiddenplace.dao.UserDao;
import com.phoenix.hiddenplace.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao dao;

	@Override
	public void create(User user) throws Exception {

		dao.create(user);
		
	}

	@Override
	public String nicknameCheck(String nickname) throws Exception {

		return dao.nicknameCheck(nickname);

	}

}
