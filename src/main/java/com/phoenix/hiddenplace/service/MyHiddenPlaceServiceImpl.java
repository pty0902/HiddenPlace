package com.phoenix.hiddenplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.phoenix.hiddenplace.dao.MyHiddenPlaceDao;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;

@Service
public class MyHiddenPlaceServiceImpl implements MyHiddenPlaceService {

	@Inject
	private MyHiddenPlaceDao dao;

	@Override
	public void insert(MyHiddenPlace myHiddenPlace) throws Exception {
		dao.insert(myHiddenPlace);		
	}
	@Override
	public List<MyHiddenPlace> list(PageMaker pageMaker) throws Exception {

		return dao.list(pageMaker); 
	}

	@Override
	public int listCount(PageMaker pageMaker) throws Exception {

		return dao.listCount(pageMaker);
	}

	@Override
	public List<MyHiddenPlace> bestMHP(String userId) throws Exception {
		return dao.bestMHP(userId); 
	}
	
	
	@Override
	public String store(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		String a = "a";
		return a;
	}
	
	@Override
	public List<MyHiddenPlace> bookmarkAll(String userId) throws Exception {
		return dao.bookmarkAll(userId); 
	}

}
