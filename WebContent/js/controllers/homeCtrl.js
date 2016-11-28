angular.module("livraria").controller("homeCtrl", function($scope, livrariaAPI, growl){
	$scope.categorias = [];
	$scope.livros = [];
	$scope.carrinho = $routeParams.carrinho;
	$scope.erro = [{Hapened: false},{Message: ""}];
	$scope.carregandoLivros = false;
	$scope.carregandoCategorias = false;
	
	// carrega as categorias do banco de dados
	var carregarCategorias = function(){
		$scope.carregandoCategorias = true;
		livrariaAPI.getCategorias().success(function(data, status){
			$scope.categorias = data;
			console.log(data);
			$scope.erro.Hapened = false;
			$scope.erro.Message = "";
			console.log($scope.erro);
			$scope.carregandoCategorias = false;
		}).error(function(data,status){
			console.log($scope.erro);
			$scope.erro.Hapened = true;
			$scope.erro.Message = "Não foi possivel carregar a lista de categorias, erro: " + status;
			$scope.carregando = false;
		});
		
	}
	
	// carrega os livros do banco de dados
	var carregarLivros = function(){
		$scope.carregandoLivros = true;
		livrariaAPI.getLivros().success(function(data, status){
			$scope.livros = data;
			console.log(data);
			$scope.erro.Hapened = false;
			$scope.erro.Message = "";
			console.log($scope.erro);
			$scope.carregandoLivros = false;
		}).error(function(data,status){
			console.log($scope.erro);
			$scope.erro.Hapened = true;
			$scope.erro.Message = "Não foi possivel carregar a lista de livros, erro: " + status;
			$scope.carregando = false;
		});
		
	}
	
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
	
	//adiciona livro no carrinho
	$scope.adicionaNoCarrinho = function ( livro) {
		var _config = {};
		var _itemCarrinho =[];
		_itemCarrinho.livro = livro;
		_itemCarrinho.quantidade = 1;
		$scope.carrinho.push(_itemCarrinho);
		growl.success("<b>você adicionou o livro " + livro.tituloLivro + " ao carrinho</b>", _config);
		
	}
	
	
	carregarLivros();
	carregarCategorias();
});