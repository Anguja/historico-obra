/**
 * @author Lucio Rodriguez
 */

'use strict;'

var appMoneda = angular.module('monedaController', [ 'toaster' ]);

appMoneda
.controller(
		'MonedaController',
		[
		 '$scope',
		 'SecurityService',
		 'MonedaService',
		 '$location',
		 function($scope, SecurityService, MonedaService,
				 $location) {

			 $scope.tabs = [
			                {
			                	title : "Crear Moneda",
			                	url : "resources/templates/moneda/crearMoneda.html"
			                },
			                
			                {
			                	title : "Listar Moneda",
			                	url : "resources/templates/moneda/listarMonedas.html"
			                }];
			 
			 
			 $scope.currentTab = 'resources/templates/moneda/crearMoneda.html';

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

appMoneda
.controller(
		'crearMonedaController',
		[
		 '$scope',
		 'MonedaService',
		 'toaster',
		 function($scope, MonedaService, toaster) {

			 $scope.moneda = {};

			 $scope.crearMoneda = function(moneda) {
				 MonedaService
				 .crearMoneda(
						 moneda,
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
								 $scope.moneda = {};
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

		 } ]);

appMoneda
.controller(
		'listarMonedaController',
		[
		 '$scope',
		 'MonedaService',
		 'ngDialog',
		 'toaster',
		 function($scope, MonedaService, ngDialog, toaster) {
			 $scope.array = [];
			 $scope.moneda = {};
				 MonedaService.listarMonedas(function(response){
					 $scope.array = response;
				 }),
				 				 
                $scope.abrirEditarPopUp = function (moneda) {
					 $scope.moneda = moneda;
 		                ngDialog.open({
 		                	scope: $scope,
		                    template: 'myModalContent.html',
		                    className: 'ngdialog-theme-default'
		                });
		            },
		        $scope.abrirEliminarMoneda = function (moneda) {
					 $scope.moneda = moneda;
		                ngDialog.open({
		                	scope: $scope,
		                    template: 'confirmModalContent.html',
		                    className: 'ngdialog-theme-default'
		                });
		            },
		        $scope.actualizarMoneda = function(moneda) {
						 MonedaService
						 .actualizarMoneda(
								 moneda,
								 function(response) {
									 ngDialog.close();
									 if (response.success) {										
										 toaster
										 .pop({
											 type : 'success',
											 title : 'Operación correcta.',
											 body : response.message,
											 timeout : 3000,
											 showCloseButton : true
										 });
										 $scope.moneda = {};
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
					 },
				        $scope.eliminarMoneda = function(moneda) {
						 console.log("Moneda ID " + moneda.idMoneda);
						 MonedaService
						 .eliminarMoneda(
								 moneda,
								 function(response) {
									 ngDialog.close();
									 if (response.success) {										
										 toaster
										 .pop({
											 type : 'success',
											 title : 'Operación correcta.',
											 body : response.message,
											 timeout : 3000,
											 showCloseButton : true
										 });
										 $scope.moneda = {};
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
		 }
		 ]);
