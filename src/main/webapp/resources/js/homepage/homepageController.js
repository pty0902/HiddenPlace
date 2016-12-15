function HomepageController() {
//	where 홈페이지 from header
	this.requestHomepageUrl = function() {

		var requestUrl = "/";

		document.location = requestUrl;

	};
	
//	where 회원정보관리 from header
	this.requestMypageUrl = function() {

		var requestUrl = "/user/mypageView";

		document.location = requestUrl;

	};
	
//	where 즐겨찾기 from header
	this.requestBookmarkUrl = function() {

		var requestUrl = "/bookmark/userBookmarkView";

		document.location = requestUrl;

	};
	
//	where 로그인페이지 from header
	this.requestLoginUrl = function() {

		var requestUrl = "/user/loginView";

		document.location = requestUrl;

	};
	
}