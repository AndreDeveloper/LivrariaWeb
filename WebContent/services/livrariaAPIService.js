angular.module("livraria").factory("livrariaAPI", function ($http, config){
	var _getCategorias = function(){
		return $http.get(config.baseURL + "/CategoriaControl.do");
	};
	var _getLivros = function(){
		return $http.get(config.baseURL + "/LivroControl.do");
	};
	
	var _setLivro = function(livro){
		return $http.post(config.baseURL + "/LivroControl.do", livro);
	};
	return {
		getCategorias : _getCategorias,
		getLivros : _getLivros,
		setLivro: _setLivro
	};
});