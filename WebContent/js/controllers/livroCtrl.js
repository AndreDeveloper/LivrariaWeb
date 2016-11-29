angular.module("livraria").controller("livroCtrl", function($scope){
	$scope.livro = [];
	
	$scope.salvar = function(livro){
		console.log(livro);
	};
});