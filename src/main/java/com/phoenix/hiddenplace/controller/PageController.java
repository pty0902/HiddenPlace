/*package com.phoenix.hiddenplace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyHiddenPlaceController.class);

	//request 내알못 목록 컨트롤러
	@RequestMapping(value ="/myhiddenplace/myHiddenPlaceSelectAll", method = RequestMethod.GET)
	public String selectAllMHP(MyHiddenPlace myHiddenPlace, RedirectAttributes rttr) throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectAll";

	}

	//내알못 글쓰기 컨트롤러
	@RequestMapping(value ="/myhiddenplace/myHiddenPlaceInsert", method = RequestMethod.GET)
	public String inertMHP(MyHiddenPlace myHiddenPlace, RedirectAttributes rttr) throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceInsert";

	}

	//request 내알못 조회 컨트롤러
	@RequestMapping(value ="/myhiddenplace/myHiddenPlaceSelectOne", method = RequestMethod.GET)
	public String selectOneMHP() throws Exception {

		return "/views/myhiddenplace/myHiddenPlaceSelectOne";

	}      

	//나만의 루트 조회 메서드
	@RequestMapping(value="/myroute/myRouteSelectOne")
	public String myRouteSelectOne() {

		return "/views/myroute/myRouteSelectOne";

	}

	// 회원가입 페이지 요청
	@RequestMapping(value = "/user/userInsertView")
	public String userInsert() throws Exception {
		System.out.println();
		return "/views/user/userInsertView";
	}

	// 로그인 페이지 요청
	@RequestMapping(value = "/user/loginView")
	public String userLogin() throws Exception {

		return "/views/user/loginView";
	}

	// 비밀번호 찾기 페이지 요청
	@RequestMapping(value = "/user/forgetPwView")
	public String forgetPw() throws Exception {

		return "/views/user/forgetPwView";
	}

	// 비밀번호 찾기(변경) 페이지 요청 + 이메일 파라미터에 담아오기
	@RequestMapping(value = "/user/forgetPwUpdateView/{email}")
	public String forgetPwUpdateGET() throws Exception {

		return "/views/user/forgetPwUpdateView";
	}

	// 마이페이지(회원정보관리) 페이지 요청
	@RequestMapping(value = "/user/mypageView")
	public String mypage() throws Exception {

		return "/views/user/mypageView";
	}
	
	// 홈페이지(로고클릭) 페이지 요청
	@RequestMapping(value = "/homepage/homepageView")
	public String homepage() throws Exception {

		return "/views/homepage/homepageView";
	}

}
*/