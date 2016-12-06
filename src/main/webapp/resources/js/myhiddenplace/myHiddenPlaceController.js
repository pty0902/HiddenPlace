$('head').append('<script src=\'../../../resources/js/myhiddenplace/myHiddenPlaceDao.js\'><\/script>');

//myHiddenPlace controller 객체
function MyHiddenPlaceController() {

   var dao = new MyHiddenPlaceDao();   

// 내알못 best 4 요청 controller 메서드
   this.requestBestMHP = function() {

	  var myHiddenPlaces  = dao.bestMHP();
      
      return myHiddenPlaces;

   };
	
// 글 조회(홈페이지에서 클릭이벤트) controller 메서드
	this.requestSelectOneMHP = function(num) {
		
		var requestUrl = 'myHiddenPlaceSelectOne.html?num=' + num;
		
		document.location = requestUrl;
		
	};
	
// 글 목록 페이지요청 controller 메서드
	this.requestMHPUrl = function() {
		
		var requestUrl = 'myHiddenPlaceSelectAll.html';
		
		document.location = requestUrl;
		
	};
}