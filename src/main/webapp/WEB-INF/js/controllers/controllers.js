$('head').append('<script src=\'../../js/hiddenPlace/myHiddenPlaceController.js\'><\/script>');
$('head').append('<script src=\'../../js/myRoute/myRouteController.js\'><\/script>');
$('head').append('<script src=\'../../js/user/userController.js\'><\/script>');

//controller 객체(static)
var Controllers = function() {   

};

Controllers.myHiddenPlaceController = new myHiddenPlaceController();
Controllers.myRouteController = new myRouteController();
Controllers.userController = new userController();

Controllers.getMyHiddenPlaceController = function() {
   return Controllers.myHiddenPlaceController;
};

Controllers.getMyRouteController = function() {
	return Controllers.myRouteController;
};

Controllers.getUserController = function() {
	return Controllers.userController;
};