angular.module("livraria").controller("livroCtrl", function($scope, $http, config, livrariaAPI, growl){
		$(".categoria").select2({
			placeholder: "Categoria",
			allowClear: true,  
		})
		$(".autor").select2({
			placeholder: "Autor",
			allowClear: true,  
		})
		$(".editora").select2({
			placeholder: "Editora",
			allowClear: true,  
		})
	$scope.salvar = function(_livro){
		livrariaAPI.setLivro(_livro).success(function(data, status){
			growl.success("<b>Livro adicionado com sucesso</b>");
		}).error(function(data,status){
			growl.error("erro ao adicionar livro</b>" + status);
		});
	};
});