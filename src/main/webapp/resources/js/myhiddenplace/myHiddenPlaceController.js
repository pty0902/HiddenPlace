$('head')
		.append(
				'<script src=\'/resources/js/myhiddenplace/myHiddenPlaceDao.js\'><\/script>');

//myHiddenPlace controller 객체
function MyHiddenPlaceController() {

	var dao = new MyHiddenPlaceDao();

	// 내알못 best 3 요청 controller 메서드
	this.requestBestMHP = function() {

		var myHiddenPlaces = dao.bestMHP();

		return myHiddenPlaces;

	};

	// 글 조회(홈페이지에서 클릭이벤트) controller 메서드
	this.requestSelectOneMHP = function(num) {

		var myHiddenPlace = dao.selectOneMHP(num);

		return myHiddenPlace;
	};

	// 글 목록 페이지요청 controller 메서드
	this.requestMHPUrl = function() {

		var requestUrl = 'myHiddenPlaceSelectAll.html';

		document.location = requestUrl;

	};

	//	내알못 추천코드 메서드
	this.requestUpCountCode = function(nickName, num) {

		var isSuccess = dao.upCountCode(nickName, num);

		return isSuccess;

	};

	//	내알못 댓글추가 메서드
	this.requestReplyInsert = function(nickName, comment, num) {

		var upCountCode = dao.replyInsert(nickName, comment, num);
		return upCountCode;

	};

	//	내알못 댓글목록 메서드
	this.requestReplySelectAll = function(num) {

		var replies = dao.replySelectAll(num);
		return replies;

	};

	//	내알못 댓글수정 메서드
	this.requestReplyUpdate = function(num, replyNum, updateComment) {

		var isSuccess = dao.replyUpdte(num, replyNum, updateComment);
		return isSuccess;
	};

	//	내알못 댓글삭제 메서드
	this.requestReplyDelete = function(num, replyNum) {
		var isSuccess = dao.replyDelete(num, replyNum);
		return isSuccess;
	};

	//내알못 글쓰기 메서드
	this.requestInsertMHP = function(content, latitude, longitude,
			mhpStoreName, mhpTitle, mhpThema, mhpTitleImg) {

		var isSuccess = dao.myHiddenPlaceInsert(content, latitude, longitude,
				mhpStoreName, mhpTitle, mhpThema, mhpTitleImg);

		var requestUrl = '/myhiddenplace/myHiddenPlaceSelectAll';

		if (isSuccess == true) {
			document.location = requestUrl;
		} else {
			return;
		}

	};

	// 내알못 리스트 controller 메서드
	this.requestHiddenPlaceSelectAll = function(num) {

		var myHiddenPlaceAll = dao.hiddenPlaceSelectAll(num);
		return myHiddenPlaceAll;

	};

	// 테마 카테고리 요청 controller 메서드
	this.requestThemeCategory = function() {

		var themeCategoryAll = dao.themeCategory();
		return themeCategoryAll;

	};

	//홈페이지 현재 로그인 유저의 내알못 즐겨찾기 목록	
	this.requestBookmarkAllMHP = function(nowLoginId) {

		var bookmarkAll = dao.bookmarkAll(nowLoginId);

		return bookmarkAll;

	}

	//즐겨찾기 등록	
	this.requestInsertBookmark = function(nowLoginId, num) {

		var isSuccess = dao.insertBookmark(nowLoginId, num);

		return isSuccess;

	}

	//즐겨찾기 해제
	this.requestDeleteBookmark = function(nowLoginId, num) {

		var isSuccess = dao.deleteBookmark(nowLoginId, num);

		return isSuccess;

	}

	//	내알못 삭제 메서드
	this.requestMyHiddenPlaceDelete = function(num) {

		var isSuccess = dao.myHiddenPlaceDelete(num);
		var requestUrl = '/myhiddenplace/myHiddenPlaceSelectAll';

		if (isSuccess == "success") {
			document.location = requestUrl;
		} else {
			return;
		}
	};

	//	내알못 추천등록 메서드
	this.requestUpCount = function(upCountCode, nickName, num) {

		var isSuccess = dao.upCount(upCountCode, nickName, num);

		return isSuccess;

	};

}