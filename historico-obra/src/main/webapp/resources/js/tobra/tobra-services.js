/**
 * @author bdelpuerto
 */
'use strict;'

var appServices = angular.module('tobraServices', []);

appServices.factory('TobraService', [ '$http', function($http) {

	var tobra = {};

	tobra.getTobra = function(callbackFunction) {
		$http({
			url : 'rest/tipoObras/getTipoObra',
			method : "GET",
		}).success(function(data) {
			callbackFunction(data);
		}).error(function(data) {
			callbackFunction(data);
		})
	};

	tobra.crearTobra = function(tobra, callbackFunction) {
		$http({
			url : 'rest/tipoObras/crearTipoObra',
			method : "POST",
			data : {
				descripcionTipoObra : tobra.descripcionTipoObra
			}
		}).success(function(data) {
			callbackFunction(data);
		}).error(function(data) {
			callbackFunction(data);
		})
	};

	return tobra;

} ]);
