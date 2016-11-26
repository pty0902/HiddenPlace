$('head').append('<script src=\'../../js/hiddenPlace/myHiddenPlaceController.js\'><\/script>');

////controller 객체
//function Controllers() {   
//
//   var myHiddenPlaceController = new MyHiddenPlaceController();
//   var myRouteController = new myRouteController();
//
//   this.getMyHiddenPlaceController = function() {
//
//      return myHiddenPlaceController;
//      
//   };
//
//   this.getMyRouteController = function() {
//
//      return myRouteController;
//
//   };
//   
//};

//controller 객체(static)
var Controllers = function() {   

};

Controllers.myHiddenPlaceController = new myHiddenPlaceController();

Controllers.getMyHiddenPlaceController = function() {

   return Controllers.myHiddenPlaceController;
   
};
