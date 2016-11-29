angular.module("livraria").controller("livrariaCtrl", function($scope, livrariaAPI, growl){
	$scope.carrinho = [];
	$routeParams = [];
	if($routeParams.carrinho != undefined){
		$scope.carrinho = $routeParams.carrinho;
	}
	$routeParams = {carrinho: $scope.carrinho};
});