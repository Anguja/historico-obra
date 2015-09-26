/**
 * @author Ricardo Ramírez
 */
'use strict';

var app = angular.module("historico-app", [ 'ngRoute', 'loginController',
		'historicoServices','usuarioController' ]);

app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when("/", {
		templateUrl : "resources/templates/login.html"
	})

	$routeProvider.when("/home/:idUsuario", {
		templateUrl : "resources/templates/home.html"
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
