$('head').append('<script src=\'../hiddenPlace/myHiddenPlacecController.js\'><\/script>');
$('head').append('<script src=\'../myRoute/myRouteController.js\'><\/script>');

//controller 객체(static)
var Controllers = function() {	

};

Controllers.myHiddenPlaceController = new MyHiddenPlaceController();
Controllers.myRouteController = new myRouteController();

Controllers.getMyHiddenPlaceController = function() {

	return Controllers.myHiddenPlaceController;
	
};

Controllers.getMyRouteController = function() {

	return Controllers.myRouteController;

};