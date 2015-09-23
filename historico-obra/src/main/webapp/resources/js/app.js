/**
 * @author Ricardo Ramírez
 */
'use strict';
var app = angular
		.module("historico-app", [ 'ngRoute', 'loginController','historicoServices' ]);

app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when("/", {
		templateUrl : "resources/templates/login.html"
	})

	$routeProvider.when("/home", {
		templateUrl : "resources/templates/home.html"
	})

	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);

app.run([ '$rootScope', '$location', function($rootScope, $location) {

	$rootScope.$on('$locationChangeStart', function(event) {

	})
} ])
