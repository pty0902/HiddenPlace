package com.phoenix.hiddenplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.phoenix.hiddenplace.domain.MyRoute;

@Service
public class MyRouteDaoImpl implements MyRouteDao {

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.phoenix.hiddenplace.mapper.MyRouteMapper";
	
	@Override
	public List<MyRoute> bestMR() throws Exception {
		return sqlSession.selectList(namespace + ".bestMR");
		
	}

}
