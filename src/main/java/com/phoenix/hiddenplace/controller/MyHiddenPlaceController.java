package com.phoenix.hiddenplace.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.service.MyHiddenPlaceService;

@Controller
@RequestMapping("/myhiddenplace/*")
public class MyHiddenPlaceController {

	private static final Logger logger = LoggerFactory.getLogger(MyHiddenPlaceController.class);

	@Inject
	private MyHiddenPlaceService service;

	//request 내알못 목록 컨트롤러
	@RequestMapping(value ="/myHiddenPlaceSelectAll", method = RequestMethod.GET)
	public String selectAllMHP(MyHiddenPlace myHiddenPlace, RedirectAttributes rttr) throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectAll";

	}

	//내알못 글쓰기 컨트롤러
	@RequestMapping(value ="/myHiddenPlaceInsert", method = RequestMethod.GET)
	public String inertMHP(MyHiddenPlace myHiddenPlace, RedirectAttributes rttr) throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceInsert";

	}

	//내알못 글쓰기 컨트롤러
	@RequestMapping(value ="/myHiddenPlaceUpdate", method = RequestMethod.GET)
	public String updateMHP(MyHiddenPlace myHiddenPlace, RedirectAttributes rttr) throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceUpdate";

	}

	//request 내알못 조회 컨트롤러
	@RequestMapping(value ="/myHiddenPlaceSelectOne", method = RequestMethod.GET)
	public String selectOneMHP() throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectOne";

	}      

}
