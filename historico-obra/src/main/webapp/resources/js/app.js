/**
 * @author Ricardo Ramírez
 */
'use strict';

var app = angular.module("historico-app", [ 'ngRoute', 'loginController',
		'historicoServices', 'usuarioController', 'toaster', 'usuarioServices',
		'angular-loading-bar', 'homeController' ]);

app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when("/", {
		templateUrl : "resources/templates/login.html"
	})

	$routeProvider.when("/usuario", {
		templateUrl : "resources/templates/usuario/usuario.html",
		controller : "UsuarioController"
	})

	$routeProvider.when("/home", {
		templateUrl : "resources/templates/home/home.html",
		controller : "HomeController"
	})

	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);

app.run([ '$rootScope', '$location', 'SecurityService', 'UsuarioService',
		function($rootScope, $location, SecurityService, UsuarioService) {

			$rootScope.$on('$locationChangeStart', function(event) {

				SecurityService.verifySession(function(response) {

					if (response.success) {
						UsuarioService.getUsuarioSesion(function(response) {
							$rootScope.usuarioLogin = response.nombreUsuario;
						});
					}

					if ($location.path() !== '/' && !response.success) {
						$location.url("/");
					}

				})
			})
		} ])
