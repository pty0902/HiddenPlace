//user dao 객체
function UserDao() {
	// 회원가입 메서드
	this.userInsert = function(newUser) {

		alert("dao까지 왔음");
		try {
			$.ajax({
				url : '/views/user/userInsertView', // 홈페이지 불러올 주소
				async : false, // false: 동기, true: 비동기
				type : 'post', // 요청방식 get or post
				data : {
					userId : newUser.uesrId,
					userPw : newUser.userPw,
					userNickname : newUser.userNickname,
					userPhoneNum : newUser.userPhoneNum
				},
				dataType : 'xml', // 서버에서 보내오는 데이터 타입
				success : function(data) { // 서버에서 보내오는 데이터

					isSucces: $(this).find('isSuccess').text() // 회원가입 성공 여부

					// var messageValue = $(data).find('message').text(); // 여기 나중에 수정
					// isSuccess = eval('(' + messageValue + ')');

				}
			});
		} catch (e) {
			console.log('userDao 객체 : userInsert 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};

	// 회원가입 닉네임 중복확인
	this.userNicknameCheck = function(nickname) {

		alert("dao까지 왔음");
		try {

			$.ajax({
				url : '/user/userInsertView', // 닉네임 중복 체크할 곳
				async : false, // false: 동기, true: 비동기
				type : 'post',
				data : {
					nickname : nickname
				},
				dataType : 'xml', // 서버에서 보내오는 데이터 타입
				success : function(data) { // 서버에서 보내오는 데이터

					isSucces: $(this).find('isSuccess').text() // 사용가능한 닉네임 : true

				}
			});
		} catch (e) {
			console.log('userDao 객체 : nickNameCheck 메서드에서 예외 발생');
			console.log(e.message);
		}
		return isSuccess;
	};

	// 이메일로 인증코드 발송
	this.emailSend = function(email, certificationNum) {

		alert("dao까지 왔음");
		try {
			$.ajax({
				url : '/', // ㅁㅍ
				type : 'POST',
				data : {
					email : email,
					certificationNum : certificationNum
				// 메일로 보낼 인증번호
				},
				success : function(data) {
					$("#email_alert").hide();

					if (data == 'emailCheckOK') {
						alert("이메일이 전송되었습니다.")
						isSuccess = true;
					} else if (data == 'emailCheckFail') {
						alert("중복된 이메일 입니다. 다른 이메일을 입력하여주십시오.")
					}
				}
			});
		} catch (e) {
			console.log('userDao 객체 : emailSend 메서드에서 예외 발생');
			console.log(e.message);
		}
		return isSuccess;

	};

	// 이메일로 인증코드 확인
	this.emailCheck = function(userInputNum, certificationNum) {

		try {
			$.ajax({
				url : '/seoulmate/member/regist/emailcheck',
				data : {
					userInputNum : userInputNum,
					certificationNum : certificationNum
				},
				type : 'POST',
				success : function(data) {

					if (data == 'emailCheckSuccess') {
						alert("이메일 인증에 성공하였습니다.");
						/* emailInput(); */
						$('#email_join').attr("readonly", "readonly");
						$('#email_confirm').attr("readonly", "readonly");

						// $('#emailSend').attr("disabled", true);
						// $('#emailCheckSuccess').attr("disabled", true);
						$('#emailSend').attr("class", "btn disabled");
						$('#emailCheckSuccess').attr("class", "btn disabled");

						isEmailCheck = true;

					} else if (data == 'emailCheckFail') {
						alert("이메일 인증에 실패하였습니다. 인증번호를 확인하여주십시오.");
					}
				}
			});
		} catch (e) {
			console.log('userDao 객체 : userLogin 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isEmailCheck;
	};

	// 로그인 메서드
	this.userLogin = function(user) {

		try {

			$.ajax({
				url : '/', // 홈페이지 불러올 주소
				async : false, // false: 동기, true: 비동기
				type : 'post', // 요청방식 get or post
				data : {
					userId : user.uesrId,
					userPw : user.userPw
				},
				dataType : 'xml', // 서버에서 보내오는 데이터 타입
				success : function(data) { // 서버에서 보내오는 데이터

					var messageValue = $(data).find('message').text(); // 여기 나중에 수정
					isSuccess = eval('(' + messageValue + ')');

				}
			});
		} catch (e) {
			console.log('userDao 객체 : userLogin 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};

}