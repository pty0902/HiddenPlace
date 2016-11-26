$('head').append('<script src=\'../hiddenPlace/myHiddenPlacecController.js\'><\/script>');
$('head').append('<script src=\'../myRoute/myRouteController.js\'><\/script>');
$('head').append('<script src=\'../user/userController.js\'><\/script>');
//controller 객체(static)
var Controllers = function() {	

};
Controllers.userController = new UserController();
Controllers.myHiddenPlaceController = new MyHiddenPlaceController();
Controllers.myRouteController = new myRouteController();

Controllers.getMyHiddenPlaceController = function() {

	return Controllers.myHiddenPlaceController;
	
};

Controllers.getMyRouteController = function() {

	return Controllers.myRouteController;

};




















Controllers.getUserController = function() {
	
	return Controllers.userController;
	
}