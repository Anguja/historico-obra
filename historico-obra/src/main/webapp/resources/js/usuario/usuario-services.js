/**
 * @author Ricardo Ramírez
 */
'use strict;'

var appServices = angular.module('usuarioServices', ['ngResource']);

appServices.factory('UsuarioService', [ '$http', function($http) {

	var usuario = {};

	usuario.getUsuarioSesion = function(callbackFunction) {
		$http({
			url : 'rest/usuarios/getUsuarioSesion',
			method : "GET",
		}).success(function(data) {
			callbackFunction(data);
		}).error(function(data) {
			callbackFunction(data);
		})
	};

	usuario.crearUsuario = function(usuario, callbackFunction) {
		$http({
			url : 'rest/usuarios/crearUsuario',
			method : "POST",
			data : {
				nombres : usuario.nombres,
				apellido : usuario.apellidos,
				cedula : usuario.cedula,
				correo : usuario.correo,
				nombreUsuario : usuario.nombreUsuario,
				password : usuario.password
			}
		}).success(function(data) {
			callbackFunction(data);
		}).error(function(data) {
			callbackFunction(data);
		})
	};

	return usuario;

} ]);

appServices.factory('UsuarioListService', [ '$resource', function($resource) {
	return $resource("rest/usuarios", {});
} ]);
