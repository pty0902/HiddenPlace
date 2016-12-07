$('head').append('<script src=\'/resources/js/user/userDao.js\'><\/script>');

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
		
		var requestUrl = 'mypageView.html';
		
		document.location = requestUrl;
		
	};
	
	// 즐겨찾기 페이지요청 controller 메서드
	this.requestBookmarkUrl = function() {
		
		var requestUrl = 'userBookMarkView.html';
		
		document.location = requestUrl;
		
	};

	// 회원가입
	this.requestUserInsert = function(newUser) {

		var isSuccess = dao.userInsert(newUser);

		if (isSuccess) {
			alert("회원가입 성공");
			requestLoginUrl(); // 로그인 페이지로 이동
		} else {
			alert("회원가입 실패");
		}

	};

	// 닉네임 중복확인
	this.requestNicknameCheck = function(nickname) {

		var nicknameCheck = dao.nicknameCheck(nickname);
		var isSuccess = false;

		if (nicknameCheck === 'success') {
			alert("사용가능한 닉네임입니다.");
			isSuccess = true;
		}
		if (nicknameCheck === 'fail') {
			alert("이미 사용중인 닉네임입니다.");
			isSuccess = false;
		}

		return isSuccess;
	}

	// 회원가입 이메일 인증번호 전송
	this.requestEmailSend = function(email, certificationNum) {

		var emailSendCheck = dao.emailSend(email, certificationNum);
		var isSuccess = false;

		if (emailSendCheck === 'success') {
			alert("인증번호가 전송되었습니다.");
			isSuccess = true;
		} else if (emailSendCheck === 'fail') {
			alert("이미 사용중인 이메일입니다.");
			isSuccess = false;
		}
		return isSuccess;

	}

	// 비밀번호 찾기(변경) 페이지요청 controller 메서드
	this.requestForgetPwUpdateUrl = function(email) {

		var requestUrl = 'forgetPwUpdateView/' + email;

		document.location = requestUrl;

	};

	// 비밀번호 찾기 (변경)
	this.requestForgetPwUpdate = function(email, newPw) {

		var isSuccess = dao.forgetPwUpdate(email, newPw);
		if (isSuccess === 'success') {
			alert("비밀번호가 변경되었습니다.");
			requestLoginUrl(); // 로그인 페이지로 이동
		} else {
			alert("비밀번호를 변경하는데 오류가 발생하였습니다.");
		}
	}

	// 비밀번호 찾기 이메일 인증번호 전송
	this.requestForgetPwEmailSend = function(email, certificationNum) {

		var emailSendCheck = dao.forgetEmailSend(email, certificationNum);
		var isSuccess = false;

		if (emailSendCheck === 'success') {
			alert("인증번호가 전송되었습니다.");
			isSuccess = true;
		} else if (emailSendCheck === 'fail') {
			alert("존재하지 않는 이메일입니다.");
			isSuccess = false;
		}

		return isSuccess;

	}

	// 로그인
	this.requestLogin = function(user) {

		var isSuccess = dao.userLogin(user);

		return isSuccess;

	};

	// 회원정보 수정 (닉네임만 변경)
	this.requestUserUpdateN = function(email, nowPw, newNickname) {

		var isSuccess = dao.userUpdateN(email, nowPw, newNickname);

		return isSuccess;

	};
	
	// 회원정보 수정 
	this.requestUserUpdateP = function(email, nowPw, newPw, newNickname) {

		var isSuccess = dao.userUpdateP(email, nowPw, newPw, newNickname);

		return isSuccess;

	};

	// 회원탈퇴
	this.requestUserDelete = function(email, pw) {

		var isSuccess = dao.userDelete(email, pw);
		
		alert(isSuccess);
		if (isSuccess === 'success') {
			alert("회원 탈퇴가 완료되었습니다.");
			// 메인홈페이지 url 메서드
		} else if (isSuccess === 'fail') {
			alert("회원님의 비밀번호가 일치하지 않습니다.");
		}
		return isSuccess;

	};

}