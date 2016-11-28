<<<<<<< HEAD
$('head').append('<script src=\'../hiddenPlace/myHiddenPlacecController.js\'><\/script>');
$('head').append('<script src=\'../myRoute/myRouteController.js\'><\/script>');
$('head').append('<script src=\'../user/userController.js\'><\/script>');
=======
$('head').append('<script src=\'../../js/hiddenPlace/myHiddenPlaceController.js\'><\/script>');
$('head').append('<script src=\'../../js/myRoute/myRouteController.js\'><\/script>');
$('head').append('<script src=\'../../js/user/userController.js\'><\/script>');

>>>>>>> refs/remotes/dongjin1204/master
//controller 객체(static)
var Controllers = function() {   

};
<<<<<<< HEAD
Controllers.userController = new UserController();
Controllers.myHiddenPlaceController = new MyHiddenPlaceController();
=======

Controllers.myHiddenPlaceController = new myHiddenPlaceController();
>>>>>>> refs/remotes/dongjin1204/master
Controllers.myRouteController = new myRouteController();
Controllers.userController = new userController();

Controllers.getMyHiddenPlaceController = function() {
   return Controllers.myHiddenPlaceController;
};

Controllers.getMyRouteController = function() {
	return Controllers.myRouteController;
};

<<<<<<< HEAD
};




















Controllers.getUserController = function() {
	
	return Controllers.userController;
	
}
=======
Controllers.getUserController = function() {
	return Controllers.userController;
};
>>>>>>> refs/remotes/dongjin1204/master
