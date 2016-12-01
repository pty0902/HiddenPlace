$('head').append('<script src=\'../../../resources/js/user/userDao.js\'><\/script>');

// user controller 객체
function UserController() {

	var dao = new UserDao();

	// 회원가입 controller 메서드
	this.requestUserInsert = function(newUser) {

		var isSuccess = dao.userInsert(newUser);

		if (isSuccess) {
			alert("회원가입 성공");
		} else {
			alert("회원가입 실패");
		}

	};

	// 닉네임 중복확인 controller 메서드
	this.requestNicknameCheck = function(nickname) {

		var isSuccess = dao.nicknameCheck(nickname);

		if (isSuccess) {
			alert("사용가능한 닉네임입니다.");
		} else {
			alert("사용불가능한 닉네임입니다.");
		}

		return isSuccess;
	}

	// 이메일 인증 controller 메서드 1
	this.requestEmailSend = function(email, certificationNum) {

		var isSuccess = dao.emailSend(email, certificationNum);

		return isSuccess;

	}
	// 이메일 인증 controller 메서드 2
	this.requestEmailCheck = function(userInputNum, certificationNum) {

		var isEmailCheck = dao.emailCheck(userInputNum, certificationNum);

		return isEmailCheck;

	}
	// 로그인 controller 메서드
	this.requestLogin = function(id, pw) {

		var isSuccess = dao.userLogin(id, pw);

		return isSuccess;

	}

	// 글수정뷰 controller 메서드
	this.requestUpdate = function(user) {
		
		var isSuccess = dao.updateDao(user);
		
		return isSuccess;

	};

}