/**
 * @author ricardo
 */

'use strict;'

var appUsuario = angular.module('usuarioController', []);

appUsuario.controller('UsuarioController', [ '$scope', 'UsuarioServices','$routeParams',
		function($scope, UsuarioServices,$routeParams) {

			$scope.usuario = {};
			
			UsuarioServices.getUsuario($routeParams.idUsuario, function(response) {
				$scope.usuario = response;
			})

		} ]);