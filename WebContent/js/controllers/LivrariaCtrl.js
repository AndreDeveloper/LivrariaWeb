angular.module("livraria").controller("livrariaCtrl", function($scope, livrariaAPI, growl){
	$scope.carrinho = [];
	$routeParams = {carrinho: $scope.carrinho};
});