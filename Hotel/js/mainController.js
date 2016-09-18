animateApp.controller('mainController', function($scope, $location, $rootScope, commonDataFactory, serviceFactory) {
	$scope.pageClass = 'page-main';
	$scope.goToPage = function(url, event) {
		$location.url(url);
		angular.element(event.currentTarget).parent().children().removeClass('active');
		angular.element(event.currentTarget).addClass('active');
	};
	$scope.bookRooms = function() {
		var login = commonDataFactory.getLoginData();
		data = {
			customerId : parseInt(login.customerId),
			roomNo : parseInt(commonDataFactory.getLatestRoomNo()),
			days : parseInt($scope.daysCount),
			date : $("#modalFromDt").val()
		};

		serviceFactory.callPostService('Rooms/bookRoom', data, getBookedRoomsSuccess);
		function getBookedRoomsSuccess(response) {
			if (!response.data.status) {
				$('.pop-up').hide();
				alert("Sorry for inconvenience,Room is booked on one of the Dates you have selected");
				angular.element("#calenderHeader").scope().getAvailableRooms(); 
			} else {
				$('.pop-up').hide();
				angular.element("#calenderHeader").scope().getAvailableRooms(); 
				alert("Thanks for choosing our Hotel, We serve our best ");
			}
		};

	};
	$scope.$on('$locationChangeStart', function(event) {
		if ((angular.element(".modal").data('bs.modal') || {}).isShown) {
			angular.element(".modal").hide();
			angular.element('.modal-backdrop.in').remove();
			angular.element('body').removeClass('modal-open');
		}
		
	});
	$scope.logout = function() {
		$rootScope.setLoginObj = {};
		$rootScope.loginFlag = false;
		$location.path('login');
		alert("User successfully logged out.");

	};
	$scope.popupClose = function() {
		angular.element('.pop-up').hide();
	};
});
