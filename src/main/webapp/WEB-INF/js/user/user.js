function User(userId,userPw,userNickName,userPhoneNum,userStartDate,userEndDate ) {

	this.userId = userId; // 아이디
	this.userPw = userPw; // 비밀번호
	this.userNickName = userNickName; // 닉네임
	this.userPhoneNum = userPhoneNum; // 전화번호
	this.userStartDate = userStartDate; // 가입일시
	this.userEndDate = userEndDate; // 탈퇴일시
	this.userLeaveIdCode = 0; // 탈퇴구분코드 1일시 탈퇴상태
	
};