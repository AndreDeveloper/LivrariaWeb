angular.module("livraria").controller("detalhesCtrl", function($scope, livrariaAPI, growl){
$scope.livroSelecionado = $routeParams.livroSelecionado;
console.log($scope.livroSelecionado);
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

});