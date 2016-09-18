animateApp.factory('commonDataFactory', function () {
    var obj={};
    var loginObj;
    var roomNo;
    obj.setLoginData=function(data){
    	loginObj=data;
    };
    obj.getLoginData=function(){
    	return loginObj;
    };
    obj.setLatestRoomNo=function(data){
    	roomNo=data;
    };
    obj.getLatestRoomNo=function(){
    	return roomNo;
    };
    return obj;
    
});