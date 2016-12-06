$('head').append('<script src=\'../../../resources/js/user/userDao.js\'><\/script>');

//user controller 객체
function UserController() {

	var dao = new UserDao();

	//	로그아웃 controller 메서드
	this.requestLogout = function(userId) {

		var isSuccess = dao.userLogout(userId);
		return isSuccess;

	};

	// 로그인 페이지요청 controller 메서드
	this.requestLoginUrl = function() {
		
		var requestUrl = 'userLoginView.html';
		
		document.location = requestUrl;
		
	};
	
	// 회원가입 페이지요청 controller 메서드
	this.requestUserInsertUrl = function() {
		
		var requestUrl = 'userInsertView.html';
		
		document.location = requestUrl;
		
	};
	
	// 마이페이지 페이지요청 controller 메서드
	this.requestMypageUrl = function() {
		
		var requestUrl = 'myPageView.html';
		
		document.location = requestUrl;
		
	};
	
	// 회원정보관리 페이지요청 controller 메서드
	this.requestMyInfoUrl = function() {
		
		var requestUrl = '.html';
		
		document.location = requestUrl;
		
	};
	
	// 즐겨찾기 페이지요청 controller 메서드
	this.requestBookmarkUrl = function() {
		
		var requestUrl = 'userBookMarkView.html';
		
		document.location = requestUrl;
		
	};

}