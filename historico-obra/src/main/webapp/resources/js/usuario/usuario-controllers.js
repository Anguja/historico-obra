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
		 'SecurityService',
		 'UsuarioService',
		 '$location',
		 function($scope, SecurityService, UsuarioService,
				 $location) {

			 $scope.tabs = [ {
				 title : "Buscar Usuario",
				 url : "resources/templates/usuario/listaUsuarios.html"
			 } 
			 ,{
				 title : "Crear Usuario",
				 url : "resources/templates/usuario/crearUsuario.html"
			 }
			 ];

			 $scope.currentTab = 'resources/templates/usuario/listaUsuarios.html';

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
		'CrearUsuarioController',
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

		 } ]);

appUsuario.controller('ListarUsuarioController', [ '$scope', 'UsuarioListService',
                                                   'toaster', function($scope, UsuarioListService, toaster) {

	/*
	 * A partir de aquí se utiliza la directiva st-pipe
	 * a fin de poder soportar paginación del lado del
	 * servidor
	 */
	$scope.displayed = [];

	/*
	 * Método utilizado para reemplazar el método pipe()
	 * proveído por smart-table, a fin que se pueda
	 * realizar el filtro y paginación correspondiente
	 * del lado del servidor.
	 */
	$scope.callServer = function callServer(tableState,
			ctrl) {

		$scope.isLoading = true;
		/*
		 * La variable start sería el index para que se
		 * pueda realizar el offset en la base de datos,
		 * el cual ya es calculado por smart-table
		 */
		var start = tableState.pagination.start;

		/*
		 * La variable number es la cantidad de
		 * elementos que se muestra en una página del
		 * table
		 */
		var pageSize = tableState.pagination.number;

		/*
		 * Se obtiene el valor de la variable
		 * predicateObject, que contiene el valor del
		 * elemento input, a fin de poder realizar el
		 * filtro del lado del servidor.
		 */
		var filter = "";

		if (tableState.search.predicateObject) {
			filter = tableState.search.predicateObject;
		} else {
			filter = "";
		}

		/*
		 * La viariable ctrl.tableState().sort contiene
		 * los valores para el orderBy
		 */

		var sortField = "";
		var sortAsc = "";

		if (ctrl.tableState().sort) {
			sortField = ctrl.tableState().sort.predicate;
			sortAsc = ctrl.tableState().sort.reverse;
		} else {
			sortField = "";
			sortAsc = "";
		}

		UsuarioListService
		.get(
				{
					filter : filter,
					pageSize : pageSize,
					start : start,
					sortField : sortField,
					sortAsc : sortAsc
				},
				function(response) {
					$scope.displayed = response.lista;
					tableState.pagination.numberOfPages = response.totalNumberOfPages;
					$scope.isLoading = false;
//					$scope.tableStateCopy = tableState;
//					$scope.ctrlCopy = ctrl;
				});
	}

} ]);