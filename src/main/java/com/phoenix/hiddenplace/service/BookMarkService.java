package com.phoenix.hiddenplace.service;

import java.util.List;

import com.phoenix.hiddenplace.domain.Bookmark;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;

public interface BookmarkService {

	// 즐겨찾기 등록
	public void bookmarkInsertMHP(MyHiddenPlace myHiddenPlace) throws Exception;

	// 즐겨찾기 해제
	public void bookmarkDeleteMHP(MyHiddenPlace myHiddenPlace) throws Exception;

	// 북마크 선택삭제
	public void bookmarkDelete(String nums) throws Exception;

	// 내알못 즐겨찾기 리스트 소환
	public List<Bookmark> bookmarkMHPAll(PageMaker pageMaker) throws Exception;

	// 마이루트 즐겨찾기 리스트 소환
	public List<Bookmark> bookmarkMRAll(String userId) throws Exception;
	
	//즐겨찾기 페이징
	public int listCount(PageMaker pageMaker);

}
