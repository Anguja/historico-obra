/**
 * @author Ricardo Ramírez
 */
'use strict';

var app = angular.module("historico-app", [ 'ngRoute', 'loginController',
<<<<<<< HEAD
		'usuarioController', 'tobraController', 'ttareaController', 
		'toaster', 'usuarioServices', 'tobraServices', 'ttareaServices', 'historicoServices', 
		'angular-loading-bar', 'homeController' ]);
=======
		'historicoServices', 'usuarioController', 'toaster', 'usuarioServices',
		'angular-loading-bar', 'homeController', 'monedaController',
		'monedaServices', 'smart-table', 'ngDialog']);
>>>>>>> 6df0f2125fddff3f2fa3c567634fcc2b59f01d1c

app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when("/", {
		templateUrl : "resources/templates/login.html"
	})

	$routeProvider.when("/usuario", {
		templateUrl : "resources/templates/usuario/usuario.html",
		controller : "UsuarioController"
	})
	
	$routeProvider.when("/tobra", {
		templateUrl : "resources/templates/tobra/tobra.html",
		controller : "TobraController"
	})
	
	$routeProvider.when("/ttarea", {
		templateUrl : "resources/templates/ttarea/ttarea.html",
		controller : "TtareaController"
	})

	$routeProvider.when("/home", {
		templateUrl : "resources/templates/home/home.html",
		controller : "HomeController"
	})
<<<<<<< HEAD
=======

	$routeProvider.when("/moneda", {
		templateUrl : "resources/templates/moneda/moneda.html",
		controller : "MonedaController"
	})
>>>>>>> 6df0f2125fddff3f2fa3c567634fcc2b59f01d1c
	
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
