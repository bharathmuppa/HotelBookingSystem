// app.js

// define our application and pull in ngRoute and ngAnimate
var animateApp = angular.module('animateApp', ['ngRoute', 'ngAnimate']);

// ROUTING ===============================================
// set our routing for this application
// each route will pull in a different controller
animateApp.config(function($routeProvider) {

	$routeProvider.when('/home', {
		templateUrl : 'templates/home.html',
		controller : 'homeController'
	}).when('/about', {
		templateUrl : 'templates/page-about.html',
		controller : 'aboutController'
	}).when('/contact', {
		templateUrl : 'templates/page-contact.html',
		controller : 'contactController'
	}).when('/login', {
		templateUrl : 'templates/login.html',
		controller : 'loginController'
	}).when('/bookedRooms', {
		templateUrl : 'templates/bookedRooms.html',
		controller : 'bookedRoomController'
	}).when('/register', {
		templateUrl : 'templates/register.html',
		controller : 'registerController'
	}).otherwise({
		redirectTo : '/login'
	});

});
animateApp.run(function($rootScope) {
	$rootScope.loginFlag = false;
});

// CONTROLLERS ============================================

// about page controller
animateApp.controller('aboutController', function($scope,$rootScope, serviceFactory,commonDataFactory) {
	$scope.pageClass = 'page-about';
});

// contact page controller
animateApp.controller('contactController', function($scope,$location,$rootScope, serviceFactory,commonDataFactory) {
	$scope.pageClass = 'page-contact';
    $scope.sendMessage=function(){
    	
    	var data={
    		"name":$scope.name||'',
    		"number":$scope.number||'',
    		"message":$scope.message||''
    	};
    	
    	serviceFactory.callPostService('login/sendMessage',data,messageSuccess);
        function messageSuccess(response){
        	if(response.data.status=='false' || response.data.status==false){
        		alert("Cannot send message right now, Please try after some time");
        	}
        	else{
        		
        		$scope.name="";
        		$scope.number="";
        		$scope.message="";
        		alert("Message sent successfully");
        	}
        }
    };
});
