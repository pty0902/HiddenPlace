package com.phoenix.hiddenplace.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;

@Repository
public class BookMarkDaoImpl implements BookMarkDao {

	@Inject	
	private SqlSession sqlSession;

	private static String namespace = "com.phoenix.hiddenplace.mapper.BookMarkMapper";


	@Override
	public void bookMarkDelete(String nums) throws Exception {
		System.out.println("Dao출력");
		sqlSession.delete(namespace + ".bookMarkDelete", nums);
		
	}
	
	//즐겨찾기 등록(홈페이지)
	@Override
	public void bookmarkInsertMHP(MyHiddenPlace myHiddenPlace) throws Exception {
		System.out.println("DaoImpl까지 온다~~");
		sqlSession.insert(namespace + ".bookmarkInsertMHP", myHiddenPlace);
		
	}
	
	//즐겨찾기 해제(홈페이지)
	@Override
	public void bookmarkDeleteMHP(MyHiddenPlace myHiddenPlace) throws Exception {
		
		sqlSession.delete(namespace + ".bookmarkDeleteMHP", myHiddenPlace);
		
	}


}
