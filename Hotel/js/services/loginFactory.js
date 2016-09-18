animateApp.factory('loginFactory', function ($http) {
    var obj={};
    obj.callLogin=function(url,data,success,failure){
    	$http({
    		"url":url,
    		"data":data,
    		"headers":{
    			
    		},
    		"content-type":"application/json"
    	});
    };
    return obj;
});