//앵귤러 모듈 만드는 작업 
var menuModule = angular.module("menu-app",[]); //[]디펜더시 같이 사용할 모듈들

menuModule.controller("menu-controller", function($scope){
	$scope.title = "안녕하세요";
});
