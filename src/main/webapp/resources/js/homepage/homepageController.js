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

		var requestUrl = "/views/bookmark/userBookmarkView.html";

		document.location = requestUrl;

	};
	
}