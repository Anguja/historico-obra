/**
 * @author ricardo
 */

'use strict;'

var appUsuario = angular.module('usuarioController', [ 'toaster' ]);

appUsuario
.controller(
		'UsuarioController',
		[
		 '$scope',
		 '$routeParams',
		 'SecurityService',
		 'UsuarioService',
		 '$location',
		 function($scope, $routeParams, SecurityService,
				 UsuarioService, $location) {

			 $scope.usuarioLogin = {};

			 UsuarioService
			 .getUsuario(
					 $routeParams.idUsuario,
					 function(response) {
						 $scope.usuarioLogin = response.nombreUsuario;
					 })

					 $scope.tabs = [
					                {
					                	title : "Crear Usuario",
					                	url : "resources/templates/usuario/crearUsuario.html"
					                },
					                {
					                	title : "Buscar Usuario",
					                	url : "resources/templates/usuario/buscarUsuario.html"
					                } ];

			 $scope.currentTab = 'resources/templates/usuario/crearUsuario.html';

			 $scope.onClickTab = function(tab) {
				 $scope.currentTab = tab.url;
			 }

			 $scope.isActiveTab = function(tabUrl) {
				 return tabUrl == $scope.currentTab;
			 }

			 $scope.logout = function() {
				 SecurityService.doLogout(function(response) {
					 $location.url("/");
				 });
			 }

		 } ]);

appUsuario
.controller(
		'crearUsuarioController',
		[
		 '$scope',
		 'UsuarioService',
		 'toaster',
		 function($scope, UsuarioService, toaster) {

			 $scope.usuario = {};

			 $scope.equalsPass = function() {
				 return $scope.usuario.password == $scope.usuario.passwordConfirmation;
			 }

			 $scope.crearUsuario = function(usuario) {
				 UsuarioService
				 .crearUsuario(
						 usuario,
						 function(response) {
							 if (response.success) {
								 toaster
								 .pop({
									 type : 'success',
									 title : 'Operación correcta.',
									 body : response.message,
									 timeout : 3000,
									 showCloseButton : true
								 });
								 $scope.usuario = {};
							 } else {
								 toaster
								 .pop({
									 type : 'error',
									 title : 'Error al realizar la operación.',
									 body : response.message,
									 timeout : 3000,
									 showCloseButton : true
								 });
							 }
						 });
			 };

		 } ])