/**
 * @author bdelpuerto
 */

'use strict;'

var appTtarea = angular.module('ttareaController', [ 'toaster' ]);

appTtarea
.controller(
		'TtareaController',
		[
		 '$scope',
		 'SecurityService',
		 'TtareaService',
		 '$location',
		 function($scope, SecurityService, TtareaService,
				 $location) {

			 $scope.tabs = [
			                {
			                	title : "Crear Tipo Tarea",
			                	url : "resources/templates/ttarea/crearTtarea.html"
			                },
			                {
			                	title : "Buscar Tipo Tarea",
			                	url : "resources/templates/ttarea/buscarTtarea.html"
			                } ];

			 $scope.currentTab = 'resources/templates/ttarea/crearTtarea.html';

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

appTtarea
.controller(
		'crearTtareaController',
		[
		 '$scope',
		 'TtareaService',
		 'toaster',
		 function($scope, TtareaService, toaster) {

			 $scope.ttarea = {};

			 $scope.crearTtarea = function(ttarea) {
				 TtareaService
				 .crearTtarea(ttarea, function(response) {
							 if (response.success) {
								 toaster
								 .pop({
									 type : 'success',
									 title : 'Operación correcta.',
									 body : response.message,
									 timeout : 3000,
									 showCloseButton : true
								 });
								 $scope.ttarea = {};
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