$('head').append('<script src=\'../../js/myRoute/myRouteDao.js\'><\/script>');

//myHiddenPlace controller 객체
function MyRouteController() {

	var dao = new myRouteDao();	

// 즐겨찾기 controller 메서드
	this.requestBookmarkMR = function() {
		
		var myRoutes  = dao.bookmarkMRDao();
		
		return myRoutes;
		
	};
	
}