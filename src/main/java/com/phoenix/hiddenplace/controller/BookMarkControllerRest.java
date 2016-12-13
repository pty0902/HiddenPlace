package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.service.BookmarkService;

@RestController
@RequestMapping(value = "/bookmark")
public class BookmarkControllerRest {

	@Inject
	private BookmarkService service;

	//즐겨찾기페이지 선택 삭제
	@RequestMapping(value = "/selectedDeleteMHP", method = RequestMethod.GET)
	public ResponseEntity<String> bookmarkCheckDelete(String nums) throws Exception {
		
		ResponseEntity<String> entity = null;
		
		try {
			service.bookmarkDelete(nums);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//즐겨찾기 등록(홈페이지)
	@RequestMapping(value = "/insertBookmarkMHP", method = RequestMethod.GET)
	public ResponseEntity<String> insertBookmarkMHP(MyHiddenPlace myHiddenPlace) throws Exception {

		ResponseEntity<String> entity = null;
		
		try {
			service.bookmarkInsertMHP(myHiddenPlace);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	//즐겨찾기 해제(홈페이지)
		@RequestMapping(value = "/deleteBookmarkMHP", method = RequestMethod.GET)
		public ResponseEntity<String> deleteBookmarkMHP(MyHiddenPlace myHiddenPlace) throws Exception {

			ResponseEntity<String> entity = null;
			
			try {
				service.bookmarkDeleteMHP(myHiddenPlace);
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
			}
			
			return entity;
			
		}

}

