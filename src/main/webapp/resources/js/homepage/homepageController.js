function HomepageController() {
	
	var userDao = new UserDao();
	
	// where 홈페이지 from header
	this.requestHomepageUrl = function() {

		var requestUrl = "/";

		document.location = requestUrl;

	};

	// where 회원정보관리 from header
	this.requestMypageUrl = function() {

		var userId = localStorage.getItem("userId");
		var requestUrl = "/user/mypageView";

		var isSuccess = userDao.mypageAuth(userId);

		if (isSuccess === "success") {
			document.location = requestUrl;
		} else if (isSuccess === "fail") {
			alert("일반 회원가입 사용자만 회원 정보를 수정할 수 있습니다.");
		}

	};

	// where 즐겨찾기 from header
	this.requestBookmarkUrl = function() {

		var requestUrl = "/bookmark/userBookmarkView";

		document.location = requestUrl;

	};

	// where 로그인페이지 from header
	this.requestLoginUrl = function() {

		var requestUrl = "/user/loginView";

		document.location = requestUrl;

	};

}