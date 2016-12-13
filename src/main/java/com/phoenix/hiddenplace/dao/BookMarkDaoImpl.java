package com.phoenix.hiddenplace.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;

@Repository
public class BookmarkDaoImpl implements BookmarkDao {

	@Inject	
	private SqlSession sqlSession;

	private static String namespace = "com.phoenix.hiddenplace.mapper.bookmarkMapper";


	@Override
	public void bookmarkDelete(String nums) throws Exception {
		sqlSession.delete(namespace + ".bookmarkDelete", nums);
	}
	
	//즐겨찾기 등록(홈페이지)
	@Override
	public void bookmarkInsertMHP(MyHiddenPlace myHiddenPlace) throws Exception {
		sqlSession.insert(namespace + ".bookmarkInsertMHP", myHiddenPlace);
	}
	
	//즐겨찾기 해제(홈페이지)
	@Override
	public void bookmarkDeleteMHP(MyHiddenPlace myHiddenPlace) throws Exception {
		sqlSession.delete(namespace + ".bookmarkDeleteMHP", myHiddenPlace);
	}


}
