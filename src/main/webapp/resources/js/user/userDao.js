//user dao 객체
function UserDao() {
	
	// 로그아웃 메서드
	this.userLogout = function(userId) {

		try {
			
			$.ajax({
				url : '/user/logout',
				async : false,
				type : 'get',
				data : {
					userId : userId
				},
				dataType : 'xml',
				success : function(data) {
					var messageValue = $(data).find('message').text();
					var	isSuccess = eval('(' + messageValue + ')');
				}
			});
			
		} catch (e) {
			console.log('userDao 객체 : userLogoutDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};
	
	// 회원가입
	this.userInsert = function(newUser) {
		try {
			$.ajax({
				url : '/user/insert', // 홈페이지 불러올 주소
				async : false, // false: 동기, true: 비동기
				type : 'post', // 요청방식	 get or post
				data : {
					userId : newUser.userId,
					userPw : newUser.userPw,
					userNickname : newUser.userNickname,
					userPhoneNum : newUser.userPhoneNum
				},
				dataType : 'text', // 서버에서 보내오는 데이터 타입
				success : function(data) { // 서버에서 보내오는 데이터

					isSuccess = data;

				}
			});
		} catch (e) {
			console.log('userDao 객체 : userInsert 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;
	};

	// 닉네임 중복확인
	this.nicknameCheck = function(nickname) {

		try {

			$.ajax({
				url : '/user/nicknameCheck', // 닉네임 중복 체크할 곳
				async : false, // false: 동기, true: 비동기
				type : 'post',
				data : {
					nickname : nickname
				},
				dataType : 'text', // 서버에서 보내오는 데이터 타입
				success : function(data) { // 서버에서 보내오는 데이터 // data = success

					isSuccess = data;

				}
			});
		} catch (e) {
			console.log('userDao 객체 : nickNameCheck 메서드에서 예외 발생');
			console.log(e.message);
		}
		return isSuccess;
	};

	// 이메일로 인증코드 전송
	this.emailSend = function(email, certificationNum) {

		try {
			$.ajax({
				url : '/user/emailSend',
				async : false, // false: 동기, true: 비동기
				type : 'post',
				data : {
					email : email,
					certificationNum : certificationNum
				},
				dataType : 'text', // 서버에서 보내오는 데이터 타입
				success : function(data) {

					isSuccess = data;
				}
			});
		} catch (e) {
			console.log('userDao 객체 : emailSend 메서드에서 예외 발생');
			console.log(e.message);
		}
		return isSuccess;

	};

	// 비밀번호 찾기 (변경)
	this.forgetPwUpdate = function(email, newPw) {

		try {
			$.ajax({
				url : '/user/forgetPwUpdate',
				async : false, // false: 동기, true: 비동기
				type : 'post',
				data : {
					email : email,
					newPw : newPw
				},
				dataType : 'text', // 서버에서 보내오는 데이터 타입
				success : function(data) {

					isSuccess = data; // success or fail

				}
			});
		} catch (e) {
			console.log('userDao 객체 : forgetPw 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;
	};

	// 비밀번호 찾기 이메일 인증번호 전송
	this.forgetEmailSend = function(email, certificationNum) {

		try {
			$.ajax({
				url : '/user/forgetEmailSend',
				async : false, // false: 동기, true: 비동기
				type : 'post',
				data : {
					email : email,
					certificationNum : certificationNum
				},
				dataType : 'text', // 서버에서 보내오는 데이터 타입
				success : function(data) {

					isSuccess = data;
				}
			});
		} catch (e) {
			console.log('userDao 객체 : forgetEmailSend 메서드에서 예외 발생');
			console.log(e.message);
		}
		return isSuccess;
	}

	// 로그인
	this.userLogin = function(user) {

		try {
			$.ajax({
				url : '/user/login',
				async : false,
				type : 'post',
				data : {
					userPw : user.userPw,
					userId : user.userId
				},
				dataType : '?????',
				success : function(data) { // 로그인 성공시 유저의 ID를 가져올게요

					var log = data;

				}
			});
		} catch (e) {
			console.log('userDao 객체 : userLogin 메서드에서 예외 발생');
			console.log(e.message);
		}

		return user;

	};

}