/**
 * @author Ricardo Ramírez
 */
'use strict;'

var appServices = angular.module('historicoServices', []);

appServices.factory('SecurityService', [ '$rootScope', '$http',
		function($rootScope, $http) {

			var security = {};

			security.doLogin = function(usuario, clave, callbackFunction) {
				$http({
					url : 'rest/security/doLogin',
					method : "POST",
					data : {
						username : usuario,
						password : clave
					}
				}).success(function(data) {
					callbackFunction(data);
				}).error(function(data) {
					callbackFunction(data);
				})
			};

			security.doLogout = function(callbackFunction) {
				$http({
					url : 'rest/security/doLogout',
					method : "GET",
				}).success(function(data) {
					callbackFunction(data);
				}).error(function(data) {
					callbackFunction(data);
				})
			};

			security.verifySession = function(callbackFunction) {
				$http({
					url : 'rest/security/verifySession',
					method : "GET",
				}).success(function(data) {
					callbackFunction(data);
				}).error(function(data) {
					callbackFunction(data);
				})
			};

			return security;
		} ]);
