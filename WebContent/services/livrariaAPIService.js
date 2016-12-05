angular.module("livraria").factory("livrariaAPI", function ($http, config){
	var _getCategorias = function(){
		return $http.get(config.baseURL + "/CategoriaControl.do");
	};
	var _getAutores = function(){
		return $http.get(config.baseURL + "/AutorControl.do");
	};
	var _getEditoras = function(){
		return $http.get(config.baseURL + "/EditoraControl.do");
	};
	var _getLivros = function(){
		return $http.get(config.baseURL + "/LivroControl.do");
	};
	
	var _setLivro = function(livro){
		return $http.post(config.baseURL + "/LivroControl.do", livro);
	};
	return {
		getCategorias : _getCategorias,
		getAutores : _getAutores,
		getEditoras : _getEditoras,
		getLivros : _getLivros,
		setLivro: _setLivro
	};
});