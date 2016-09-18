// home page controller
animateApp.controller('homeController', function($scope, $rootScope, serviceFactory,commonDataFactory) {
	$scope.pageClass = 'page-home';
	$("#from").datepicker({
		"dateFormat" : "yy-mm-dd",
		minDate : 0,

	});
	/* need to use if we have multiple days
	 onClose : function(selectedDate) {
	 $("#to").datepicker("option", "minDate", selectedDate);
	 }

	 $("#to").datepicker({
	 onClose : function(selectedDate) {
	 $("#from").datepicker("option", "maxDate", selectedDate);
	 }
	 });
	 */
	var roomsDetails = null;
	$scope.getAvailableRooms = function() {
		function onSuccess(response) {
			console.log(response);
			roomsDetails = response.data.roomReults;
			//getting list of room numbers
			var availRooms = [];
			response.data.roomResults.forEach(function(value, index, key) {
				availRooms.push(+value.roomNo);
			});
			//sorting array in ascending order
			availRooms.sort(function(a, b) {
				return a - b;
			});
			//for further processing
			roomsDetails = {
				availableRooms : availRooms,
				rooms : response.data.roomResults
			};
			//getting list of rooms from DOM
			/*
			 $.each($(".roomNo").children(), function(index, element) {
			 if ($(element).data('room') === (+availRooms[index])) {
			 $(this).addClass("available");
			 } else {
			 $(this).addClass("booked");
			 }

			 });*/

			$(".roomNo").each(function(index, element) {
				if (availRooms.indexOf($(this).data('room')) > -1) {
					$(this).addClass("available");
				} else {
					$(this).addClass("booked");
				}
			});
            
            
			//iterating based on number of free rooms available

			/*
			 availRooms.forEach(function(value, index, key) {
			 $("span[data-room=" + value + "].roomNo").addClass('available');
			 });*/

		}

		var formattedDate;
		var data = {};
		if (!$("#from").val()) {
			var dt = new Date();
			formattedDate = dt.getFullYear() + "-" + (dt.getMonth() + 1) + "-" + dt.getDate();

		}
		data.date = $("#from").val() || formattedDate;
		serviceFactory.callPostService('Rooms/getRooms', data, onSuccess);
	};
	$scope.getRoomDetails = function(event) {
		var room = event.currentTarget;
		var roomId = room.getAttribute('data-room');
		commonDataFactory.setLatestRoomNo(roomId);
		var isAvailable = roomsDetails && roomsDetails.availableRooms && roomsDetails.availableRooms.indexOf(roomId);
		if (angular.element(room).hasClass('booked')) {
			alert("The room you're trying to select is already booked. Kindly select another room ");
			return;
		} else if (angular.element(room).hasClass('available')) {

			
			 if ($rootScope.loginFlag == false) {
			 alert("Please login to book room");
			 } else {
			var tab = "<tr>";
			var tabHead = Object.keys(roomsDetails.rooms[0]);
			tabHead.pop();
			tabHead.forEach(function(value, index, key) {
				tab += "<th>" + value + "</th>";
			});
			tab += "</tr><tr>";
			$(".pop-up header h3").html("Room No: " + roomId);
			roomsDetails.rooms.forEach(function(value, index, key) {
				if (value.roomNo === roomId) {
					
					tabHead.forEach(function(val, index) {
						tab += "<td>" + value[val] + "</td>";
					});
					tab += "</tr>";
					return;
				}
			});
			$(".pop-up #modalFromDt").val($("#from").val());
			$(".pop-up .modal-body #roomDetailsTbl").empty().append(tab);
			$('.pop-up').show();
			}
		} else {
			alert("An unknown error occured. Please contact system administrator");
			return;
		}
	};
});
