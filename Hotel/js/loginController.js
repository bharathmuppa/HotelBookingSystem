animateApp.controller('loginController', function ($scope,$rootScope,$location,serviceFactory,commonDataFactory) {
    $scope.pageClass = 'page-login';
    angular.element('.nav').children().removeClass('active');
    $scope.login=function(){
    	function loginSuccess(response){
    		if(response.data.customerId==0){
    			alert("Incorrect Credentias");
    		}else{
    			commonDataFactory.setLoginData(response.data);
    			$rootScope.setLoginObj=response.data;
    			$rootScope.setLoginObj.lastLogin=new Date();
	    		$rootScope.loginFlag = true;
	    		$location.path('home');
    		}
    	}
    	var data={};
    	data.email=$scope.email;
    	data.password=$scope.password;
    	console.log(data);
    	serviceFactory.callPostService('login/getLogin',data,loginSuccess);
    };
    $scope.goToRegister=function(){
    	$location.path('register');
    };
});