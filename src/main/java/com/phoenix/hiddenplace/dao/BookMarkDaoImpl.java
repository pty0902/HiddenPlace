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
	
	@Override
	public void bookmarkInsert(MyHiddenPlace myHiddenPlace) throws Exception {
		sqlSession.insert(namespace + ".bookmarkInsert", myHiddenPlace);
	}

}
