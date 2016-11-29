$('head').append('<script src=\'/userDao.js\'><\/script>');


// user controller 객체
function UserController() {

	var dao = new UserDao();

	// 회원가입 controller 메서드
	this.requestUserInsert = function(newUser) {

		var isSuccess = dao.userInsertDao(newUser);

		return isSuccess;

	};
	
	// 닉네임 중복확인 controller 메서드
	this.requestNicknameCheck = function(nickname) {
		
		var isSuccess = dao.nicknameCheckDao(nickname);
		
		return isSucces;
	
	}
	
	// 로그인 controller 메서드
	this.requestLogin = function(id, pw) {
		
		var isSuccess = dao.userLoginDao(id, pw);
		
		return isSuccess;
		
	}
	

}