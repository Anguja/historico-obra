/**
 * @author bdelpuerto
 */

'use strict;'

var appObra = angular.module('tobraController', [ 'toaster' ]);

appObra
.controller(
		'TobraController',
		[
		 '$scope',
		 'SecurityService',
		 'TobraService',
		 '$location',
		 function($scope, SecurityService, TobraService,
				 $location) {

			 $scope.tabs = [
			                {
			                	title : "Buscar Tipo Obra",
			                	url : "resources/templates/tobra/listaTobra.html"
			                },
			                {
			                	title : "Crear Tipo Obra",
			                	url : "resources/templates/tobra/crearTobra.html"
			                } ];

			 $scope.currentTab = 'resources/templates/tobra/crearTobra.html';

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

appObra
.controller(
		'crearTobraController',
		[
		 '$scope',
		 'TobraService',
		 'toaster',
		 function($scope, TobraService, toaster) {

			 $scope.tobra = {};

			 $scope.crearTobra = function(tobra) {
				 TobraService
				 .crearTobra(tobra, function(response) {
					 if (response.success) {
						 toaster
						 .pop({
							 type : 'success',
							 title : 'Operación correcta.',
							 body : response.message,
							 timeout : 3000,
							 showCloseButton : true
						 });
						 $scope.tobra = {};
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