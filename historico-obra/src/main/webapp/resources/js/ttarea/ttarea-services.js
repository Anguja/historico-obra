/**
 * @author bdelpuerto
 */
'use strict;'

var appServices = angular.module('ttareaServices', []);

appServices.factory('TtareaService', [ '$http', function($http) {

	var ttarea = {};

	ttarea.getTtarea = function(callbackFunction) {
		$http({
			url : 'rest/tipoTareas/getTipoTarea',
			method : "GET",
		}).success(function(data) {
			callbackFunction(data);
		}).error(function(data) {
			callbackFunction(data);
		})
	};

	ttarea.crearTtarea = function(ttarea, callbackFunction) {
		$http({
			url : 'rest/tipoTareas/crearTipoTarea',
			method : "POST",
			data : {
				descripcionTipoTarea : ttarea.descripcionTipoTarea
			}
		}).success(function(data) {
			callbackFunction(data);
		}).error(function(data) {
			callbackFunction(data);
		})
	};

	return ttarea;

} ]);
