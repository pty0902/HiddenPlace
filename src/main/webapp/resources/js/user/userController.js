$('head').append('<script src=\'../../../resources/js/user/userDao.js\'><\/script>');

//user controller 객체
function UserController() {

	var dao = new UserDao();

	// 회원가입
	this.requestUserInsert = function(newUser) {
		var isSuccess = dao.userInsert(newUser);

		if (isSuccess) {
			alert("회원가입 성공");
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

	// 이메일 인증 1
	this.requestEmailSend = function(email, certificationNum) {

		var emailSendCheck = dao.emailSend(email, certificationNum);
		var isSuccess = false;
		alert(emailSendCheck);
		if (emailSendCheck === 'success') {
			alert("이메일이 전송되었습니다.");
			isSuccess = true;
		} else if (emailSendCheck === 'fail') {
			alert("이미 사용중인 이메일입니다.");
			isSuccess = false;
		}

		return isSuccess;
	}

	// 이메일 인증 2
	this.requestEmailCheck = function(userInputNum, certificationNum) {

		var emailCheck = dao.emailCheck(userInputNum, certificationNum);
		var isSuccess = false;
		
		if (emailCheck === 'success') {
			alert("이메일 인증에 성공하였습니다.");
			isSuccess = true;
		} else if (emailCheck === 'fail') {
			alert("인증번호를 올바르게 입력해주세요.");
			isSuccess = false;
		}

		return isSuccess;

	}
	//	로그인 controller 메서드
	this.requestLogin = function(user) {

		var isSuccess = dao.userLogin(user);
		return isSuccess;

	};

	// 회원정보 수정
	this.requestUpdate = function(user) {

		var isSuccess = dao.update(user);

		return isSuccess;

	};

	// 회원탈퇴
	this.requestDelete = function(delete_pw) {

		var isSuccess = dao.test(delete_pw);
		return isSuccess;

	};

}