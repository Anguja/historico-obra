/**
 * @author Ricardo Ramírez
 */
'use strict';

var app = angular.module("historico-app",
		[ 'ngRoute', 'loginController', 'historicoServices',
				'usuarioController', 'toaster', 'usuarioServices' ]);

app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when("/", {
		templateUrl : "resources/templates/login.html"
	})

	$routeProvider.when("/usuario/:idUsuario", {
		templateUrl : "resources/templates/usuario/usuario.html",
		controller : "UsuarioController"
	})

	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);

app.run([ '$rootScope', '$location', 'SecurityService',
		function($rootScope, $location, SecurityService) {

			$rootScope.$on('$locationChangeStart', function(event) {
				SecurityService.verifySession(function(response) {
					if ($location.path() !== '/' && !response.success) {
						$location.url("/");
					}
				})
			})
		} ])
