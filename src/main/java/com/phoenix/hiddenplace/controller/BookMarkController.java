package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phoenix.hiddenplace.service.MyHiddenPlaceService;

@Controller
public class BookMarkController {

	private static final Logger logger = LoggerFactory.getLogger(MyHiddenPlaceController.class);

	@Inject
	private MyHiddenPlaceService service;

	//즐겨찾기 화면 메서드
	@RequestMapping(value="/bookmark/BookMarkView")
	   public String selectAllBookMark() {
		   
	      return "/views/bookmark/bookmarkView";
	   }

}
