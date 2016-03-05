/**
 * @author Lucio Rodriguez
 */
'use strict;'

var appServices = angular.module('monedaServices', []);

appServices.factory('MonedaService', [ '$http', function($http) {

	var moneda = {};

//	moneda.getUsuarioSesion = function(callbackFunction) {
//		$http({
//			url : 'rest/usuarios/getUsuarioSesion',
//			method : "GET",
//		}).success(function(data) {
//			callbackFunction(data);
//		}).error(function(data) {
//			callbackFunction(data);
//		})
//	};

	moneda.crearMoneda = function(moneda, callbackFunction) {
		$http({
			url : 'rest/moneda/crearMoneda',
			method : "POST",
			data : {
				cotizacion : moneda.cotizacion,
				descripcionMoneda : moneda.descripcionMoneda
			}
		}).success(function(data) {
			callbackFunction(data);
		}).error(function(data) {
			callbackFunction(data);
		})
	};

	moneda.listarMonedas = function(callbackFunction){
		$http({
			url : 'rest/moneda/listarMonedas',
			method : "GET"
		}).success(function(data) {
			callbackFunction(data);
		}).error(function(data) {
			callbackFunction(data);
		})
	};
	
	moneda.actualizarMoneda = function(moneda, callbackFunction) {
		$http({
			url : 'rest/moneda/actualizarMoneda',
			method : "POST",
			data : {
				idMoneda: moneda.idMoneda,
				cotizacion : moneda.cotizacion,
				descripcionMoneda : moneda.descripcionMoneda
			}
		}).success(function(data) {
			callbackFunction(data);
		}).error(function(data) {
			callbackFunction(data);
		})
	};

	moneda.eliminarMoneda = function(moneda, callbackFunction) {
		$http({
			url : 'rest/moneda/eliminarMoneda',
			method : "POST",
			data : {
				idMoneda: moneda.idMoneda
			}
		}).success(function(data) {
			callbackFunction(data);
		}).error(function(data) {
			callbackFunction(data);
		})
	};
	
	
	return moneda;

} ]);
