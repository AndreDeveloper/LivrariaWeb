angular.module("livraria").factory("livrariaAPI", function ($http, config){
	var _getCategorias = function(){
		return $http.get(config.baseURL + "/CategoriaControl.do");
	};
	var _getLivros = function(){
		return $http.get(config.baseURL + "/LivroControl.do");
	};
	return {
		getCategorias : _getCategorias,
		getLivros : _getLivros
	};
});