angular.module("livraria").controller("carrinhoCtrl", function($scope, livrariaAPI, growl){
	$scope.carrinho = [];
	$scope.carrinho = $routeParams.carrinho;

	//função que tranforma um array de bytes em base 64
	$scope._arrayBufferToBase64 = function ( buffer ) {
		  var binary = '';
		  var bytes = new Uint8Array( buffer );
		  var len = bytes.byteLength;
		  for (var i = 0; i < len; i++) {
		    binary += String.fromCharCode( bytes[ i ] );
		  }
		  return window.btoa( binary );
		}
	
	$scope.addQuantidade = function (carrinho){
		carrinho.quantidade = carrinho.quantidade + 1; 
		$scope.carrinho.total = $scope.calculaTotal($scope.carrinho);
	}
	$scope.subQuantidade = function (carrinho){
		if(carrinho.quantidade > 1){
			carrinho.quantidade = carrinho.quantidade - 1; 
		}
		$scope.carrinho.total = $scope.calculaTotal($scope.carrinho);
	}
	$scope.calculaTotal = function (carrinho){
		var _total = 0;
		for (let index = 0; index < carrinho.length; ++index) {
			_total += carrinho[index].livro.precoVenda * carrinho[index].quantidade;
		    };
		return _total; 
	}
	$scope.removerItem = function (item){
		$scope.carrinho = $scope.carrinho.filter(function(livro) { 
			$routeParams = {carrinho: $scope.carrinho};
		    return livro !== item;
		});
	}
});