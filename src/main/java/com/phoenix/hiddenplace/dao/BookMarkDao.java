package com.phoenix.hiddenplace.dao;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;

public interface BookMarkDao {

	 
	 // 즐겨찾기 선택삭제
	 public void bookMarkDelete(String nums) throws Exception;

	 // 즐겨찾기 등록
	 public void bookmarkInsert(MyHiddenPlace myHiddenPlace) throws Exception;
	 
}
