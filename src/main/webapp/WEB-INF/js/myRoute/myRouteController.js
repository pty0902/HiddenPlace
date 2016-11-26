$('head').append('<script src=\'/myRouteDao.js\'><\/script>');


//myHiddenPlace controller 객체
function myRouteController() {

	var dao = new myRouteDao();	

// 즐겨찾기 controller 메서드
	this.requestBookmarkMR = function(myRoute) {
		
		var myRoutes  = dao.bookmarkMRDao(myRoute);
		
		return myRoutes;
		
	};
}