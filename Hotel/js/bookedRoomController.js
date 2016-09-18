animateApp.controller('bookedRoomController', function($scope, $compile, $location, $rootScope, commonDataFactory, serviceFactory) {

	if ($rootScope.loginFlag == false) {
		$location.path('login');
		return;
	}
	$rootScope.loginFlag = true;
	var login = commonDataFactory.getLoginData();
	$scope.pageClass = 'page-booked';

	$scope.getBookedRooms = function() {

		var data = {
			"customerId" : login ? login.customerId : '',
			"role" : login ? login.role : 'M'
		};
		serviceFactory.callPostService('Rooms/getBookedRooms', data, getBookedRoomsSuccess);

	};
	$scope.getBookedRooms();
	function getBookedRoomsSuccess(response) {
		console.log(response);
		$('.bookedRoomsDiv').empty();
		if (!response.data.bookedRoomsResult) {
			alert('No Data Avaialable');
			$('.bookedRoomsDiv').append("<h4>No Rooms Were Booked</h4>");
			return;
		} else {

			var tempObj = response.data.bookedRoomsResult;
			var tempString = '';
			

			if ($.isArray(tempObj)) {
				for ( i = 0; i < tempObj.length; i++) {
					var from = tempObj[i]["bookedFrom"];
					var to = tempObj[i]["bookedTo"];
					var transId = tempObj[i]["transid"];
					var price = tempObj[i]["price"];
					var roomNo = tempObj[i]["roomNo"];
					tempString = tempString + '<div class="rooms"><div id="part-1"><span>RoomNo:<b>' + roomNo + '</b></span></div><div id="part-2"><span>From:<b>' + from + '</b></span></div><div id="part-3"><span>To:<b>' + to + '</b></span></div><div id="part-4"><span>price:<b>' + price + '</b></span></div><div id="part-5" ng-click="checkOutUser(' + transId + ')">Check Out</div></div>';
				}
			} else {
				if (Object.keys(tempObj).length == 0) {
					alert("No Data Available");
					$('.bookedRoomsDiv').append("<h4>No Rooms Were Booked</h4>");
					return;
				}
				var from = tempObj["bookedFrom"];
				var to = tempObj["bookedTo"];
				var transId = tempObj["transid"];
				var price = tempObj["price"];
				var roomNo = tempObj["roomNo"];
				tempString = tempString + '<div class="rooms"><div id="part-1"><span>RoomNo:<b>' + roomNo + '</b></span></div><div id="part-2"><span>From:<b>' + from + '</b></span></div><div id="part-3"><span>To:<b>' + to + '</b></span></div><div id="part-4"><span>price:<b>' + price + '</b></span></div><div id="part-5" ng-click="checkOutUser(' + transId + ')">Check Out</div></div>';
			}
			$compile(tempString)($scope);
			angular.element('.bookedRoomsDiv').append(tempString);
			$compile(angular.element('.bookedRoomsDiv'))($scope);
		}
	};
	$scope.refreshBookedList = function() {
		$scope.getBookedRooms();
	};

	$scope.checkOutUser = function(transid) {
		var url = 'Rooms/checkout/' + transid;
		serviceFactory.callGetService(url, checkOutRoomSuccess);
		function checkOutRoomSuccess(response) {
			if (!response.data.status) {
				alert("Sorry for inconvenience, Please try after sometime");
			} else {
				$scope.getBookedRooms();
				alert("Thanks for choosing our Hotel,Hope you Like the amenities");
			}
		}

	};
});
