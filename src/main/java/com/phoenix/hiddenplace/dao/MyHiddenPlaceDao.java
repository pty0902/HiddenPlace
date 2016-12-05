package com.phoenix.hiddenplace.dao;

import java.util.List;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;

public interface MyHiddenPlaceDao {
	public void insert(MyHiddenPlace myHiddenPlace)throws Exception;
	
	public MyHiddenPlace selectOne(Integer num)throws Exception;

	List<MyHiddenPlace> list(PageMaker pageMaker) throws Exception;//내알못 목록
	
	List<MyHiddenPlace> bestMHP() throws Exception;//내알못 베스트 3
	
	public int listCount(PageMaker pageMaker);
	
}
