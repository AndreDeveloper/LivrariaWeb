angular.module('livraria').config(['growlProvider',"$routeProvider", function (growlProvider,$routeProvider,$http) {
	//Configuração do tempo que a mensagem ficará na tela
	growlProvider.globalTimeToLive(5000);
	
	$routeProvider
	.when('/', {
		  templateUrl : 'pages/home.html',
		  controller  : 'homeCtrl'
		})
		.when('/carrinho', {
		  templateUrl : 'pages/carrinho.html',
		  controller  : 'carrinhoCtrl'
		})
		.when('/autor', {
		  templateUrl : 'pages/autor.html',
		  //controller  : 'LivrariaCtrl.js'
		})
		.when('/livro', {
			templateUrl : 'pages/livro.html',
			controller  : 'livroCtrl'
		})
		.when('/detalhes', {
			templateUrl : 'pages/detalhes.html',
			controller  : 'detalhesCtrl'
		})
		.otherwise({redirectTo: '/'});
}]);





