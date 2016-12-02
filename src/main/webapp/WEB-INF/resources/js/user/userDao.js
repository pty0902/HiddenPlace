//user dao 객체
function UserDao() {
	// 회원가입 메서드
	this.userInsertDao = function(user) {

		try {

			$.ajax({
				url : '/', // 홈페이지 불러올 주소
				async : false, // false: 동기, true: 비동기
				type : 'post', // 요청방식 get or post
				data : {
					userId : user.uesrId,
					userPw : user.userPw,
					userNickName : user.userNickName,
					userPhoneNum : user.userPhoneNum
				},
				dataType : 'xml', // 서버에서 보내오는 데이터 타입
				success : function(data) { // 서버에서 보내오는 데이터

					var messageValue = $(data).find('message').text(); // 여기 나중에 수정
					isSuccess = eval('(' + messageValue + ')');

				}
			});
		} catch (e) {
			console.log('userDao 객체 : userInsertDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};
	// 회원가입 닉네임 중복확인
	this.nickNameCheckDao = function(nickName) {

		try {
			
			$.ajax({
				url : '/', // 닉네임 중복 체크할 곳
				async : false,  // false: 동기, true: 비동기
				type : 'post',
				data : {
					nickName : nickName
				},
				dataType : 'xml', // 서버에서 보내오는 데이터 타입
				success : function(data) { // 서버에서 보내오는 데이터
	
					var messageValue = $(data).find('message').text(); // 여기 나중에 수정
					isSuccess = eval('(' + messageValue + ')');
	
				}
			});
		} catch (e) {
			console.log('userDao 객체 : nickNameCheckDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;
	}
	S
	// 로그인 메서드
	this.userLoginDao = function(user) {

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
			console.log('userDao 객체 : userLoginDao 메서드에서 예외 발생');
			console.log(e.message);
		}

		return isSuccess;

	};

}