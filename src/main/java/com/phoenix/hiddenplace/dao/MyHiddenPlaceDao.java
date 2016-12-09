package com.phoenix.hiddenplace.dao;

import java.util.List;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;
import com.phoenix.hiddenplace.domain.Theme;

public interface MyHiddenPlaceDao {
	public void insert(MyHiddenPlace myHiddenPlace)throws Exception;
	
	public MyHiddenPlace selectOne(Integer num)throws Exception;

	List<MyHiddenPlace> list(PageMaker pageMaker) throws Exception;//내알못 목록
	
	List<MyHiddenPlace> bestMHP() throws Exception;//내알못 베스트 4
	
	public int listCount(PageMaker pageMaker);
	
	public List<Theme> themeList() throws Exception; //목록페이지에 테마 버튼 호출
	
}
