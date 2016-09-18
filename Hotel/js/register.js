animateApp.controller('registerController', function($scope, $rootScope, $location, serviceFactory, commonDataFactory) {
	$scope.pageClass = 'page-register';
    angular.element('.nav').children().removeClass('active');
	$scope.backupCountries = {
		"id" : "field10",
		"items" : [{
			"id" : "0",
			"StateGroupID" : "0",
			"name" : "United State"
		}, {
			"id" : "1",
			"StateGroupID" : "1",
			"name" : "Canada"
		}, {
			"id" : "2",
			"StateGroupID" : "2",
			"name" : "India"
		}]
	};

	$scope.backupStates = {
		"id" : "field20",
		"StateGroups" : [{
			"items" : [{
				"id" : "1",
				"name" : "Alabama"
			}, {
				"id" : "2",
				"name" : "Alaska"
			}, {
				"id" : "3",
				"name" : "Arizona"
			}, {
				"id" : "4",
				"name" : "California"
			}]
		}, {
			"items" : [{
				"id" : "201",
				"name" : "Alberta"
			}, {
				"id" : "202",
				"name" : "British Columbia"
			}, {
				"id" : "203",
				"name" : "Manitoba"
			}, {
				"id" : "204",
				"name" : "Ontario"
			}]
		}, {
			"items" : [{
				"id" : "500",
				"name" : "Andhra Pradesh"
			}, {
				"id" : "502",
				"name" : "Tamil Nadu"
			}, {
				"id" : "503",
				"name" : "Orissa"
			}, {
				"id" : "504",
				"name" : "Kerala"
			}]
		}]
	};

	$scope.Countries = $scope.backupCountries;
	$scope.selectedCountry = 0;
	$scope.getStates = function() {
		console.log($scope.selectedCountry);
		return $scope.backupStates.StateGroups[$scope.selectedCountry].items;
	};
	$scope.register = function() {

		if ($scope.password && $scope.passwordCheck) {
			if ($scope.password != $scope.passwordCheck) {
				alert("password mismatch");
				return;
			}
		}
		var data = {
			"MobileNo" : $scope.phoneNumber,
			"city" : $scope.city,
			"state" : $scope.selectedState,
			"country" : $scope.selectedCountry,
			"password" : $scope.password,
			"email" : $scope.email,
			"lastName" : $scope.lastName,
			"firstName" : $scope.firstName

		};
		console.log(data);
		serviceFactory.callPostService('login/registerUser', data, registerSuccess);
		function registerSuccess(response) {
			if (response.data.customerId==0) {
				alert("email already existed,Please try with new email");
			} else {
				commonDataFactory.setLoginData(response.data);
				$rootScope.setLoginObj = response.data;
				$rootScope.setLoginObj.lastLogin = new Date();
				$rootScope.loginFlag = true;
				$location.path('home');
			}
		}

	};
	//$scope.currentStates = $scope.backupStates.StateGroups[0];

	/*$scope.$watch('currentStates', function(value, oldValue){
	 //alert(value);
	 //alert(JSON.stringify(value));
	 //$scope.currentStates = (value == "10") ?  States.StateGroups[0] : States.StateGroups[1];
	 });*/

});
