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
}