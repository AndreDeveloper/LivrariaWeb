angular.module("livraria").controller("livroCtrl", function($scope, $http, config, livrariaAPI, growl){
	$scope.categorias  = [];
	$scope.autores  = [];
	$scope.editoras  = [];
	
	$(".formato").select2({
		placeholder: "escolha o formato",
		tags: true
	});
	var carregarCategorias = function(){
		livrariaAPI.getCategorias().success(function(data, status){
			$scope.categorias = data;
			$(".categoria").select2({
				placeholder: "selecione a categoria",
				data: $scope.categorias,
				tags: true
			});
			console.log(data);
		}).error(function(data,status){
		});		
	}
	var carregarAutores = function(){
		livrariaAPI.getAutores().success(function(data, status){
			$scope.autores = data;
			$(".autor").select2({
				placeholder: "selecione o autor",
				data: $scope.autores,
				tags: true
			});
		}).error(function(data,status){
		});		
	}
	var carregarEditoras = function(){
		livrariaAPI.getEditoras().success(function(data, status){
			$scope.editoras = data;
			console.log("editoras")
			console.log(data)
			$(".editora").select2({
				placeholder: "selecione a editora",
				data: $scope.editoras,
				tags: true
			});
		}).error(function(data,status){
		});		
	}
	
	$scope.salvar = function(_livro){
		console.log(_livro)
		livrariaAPI.setLivro(_livro).success(function(data, status){
			console.log("deu certo")
			growl.success("<b>Livro adicionado com sucesso</b>");
			delete _livro;
		}).error(function(data,status){
			console.log('deu ruim' + status)
			growl.error("erro ao adicionar livro</b>" + status);
		});
	};
	
	carregarCategorias();
	carregarAutores();
	carregarEditoras();

	console.log("chamou aqui")
});