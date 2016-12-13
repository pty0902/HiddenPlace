package com.phoenix.hiddenplace.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phoenix.hiddenplace.dao.BookMarkDao;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;

@Service
public class BookMarkServiceImpl implements BookMarkService {

	@Inject
	private BookMarkDao dao;

	

	@Override
	public void bookMarkDelete(String nums) throws Exception {
		System.out.println("서비스출력");
		dao.bookMarkDelete(nums);
	}
	
	//즐겨찾기 등록(홈페이지)
	@Override
	public void bookmarkInsertMHP(MyHiddenPlace myHiddenPlace) throws Exception {
		System.out.println("insert ServiceImpl까지 온다~~");
		dao.bookmarkInsertMHP(myHiddenPlace);
	}
	
	//즐겨찾기 해제(홈페이지)
	@Override
	public void bookmarkDeleteMHP(MyHiddenPlace myHiddenPlace) throws Exception {
		dao.bookmarkDeleteMHP(myHiddenPlace);
	}
	
}
