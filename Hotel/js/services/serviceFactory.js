animateApp.factory('serviceFactory', function($http) {
	var obj = {};
	var serviceUrl = "http://localhost:8080/login/rest/";
	obj.callPostService = function(url, data, success) {
		$http({
			method : 'POST',
			url : serviceUrl+url,
			data : data,
			headers : {
				'Content-Type' : 'application/json'
			},
		}).then(function successCallback(response) {
			success(response);
		}, function errorCallback(response) {
			alert("Unable to connect to server, Please try after some time");
		});
	};
	obj.callGetService = function(url, success) {
		$http({
			method : 'GET',
			url : serviceUrl+url,

			headers : {
				'Content-Type' : 'application/json'
			},
		}).then(function successCallback(response) {
			success(response);
		}, function errorCallback(response) {
			alert("Unable to connect to server, Please try after some time");
		});
	};
	return obj;
});
