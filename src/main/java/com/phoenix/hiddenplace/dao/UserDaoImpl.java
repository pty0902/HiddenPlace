package com.phoenix.hiddenplace.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phoenix.hiddenplace.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Inject
	private SqlSession session;

	private static String namespace = "com.phoenix.hiddenplace.mappers.UserMapper";

	@Override
	public void create(User user) throws Exception {
		
		session.insert(namespace + ".create", user);
		
	}

	@Override
	public String nicknameCheck(String nickname) throws Exception {

		return session.selectOne(namespace + ".nicknameCheck", nickname);

	}

}
