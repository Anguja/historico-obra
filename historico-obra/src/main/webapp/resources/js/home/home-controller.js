/**
 * @author Ricardo Ramírez
 */

var appHome = angular.module('homeController', []);

appHome.controller('HomeController', [ '$scope', 'SecurityService',
		'$location', function($scope, SecurityService, $location) {

			$scope.bookmarks = [ {
				title : "Usuarios",
				url : "#/usuario",
				icon : "icon-user"
			}, {
				title : "Roles",
				url : "#/home",
				icon : "icon-legal"
			}, {
				title : "Permisos",
				url : "#/home",
				icon : "icon-lock"
			}, {
				title : "Reportes",
				url : "#/home",
				icon : "icon-signal"
<<<<<<< HEAD
			}, {
				title : "Tipo Obra",
				url : "#/tobra",
				icon : "icon-signal"
			}, {
				title : "Tipo Tarea",
				url : "#/ttarea",
				icon : "icon-signal"
			} 
			];
=======
			},{
				title : "Moneda",
				url : "#/moneda",
				icon : "icon-money"
			} ];
>>>>>>> 6df0f2125fddff3f2fa3c567634fcc2b59f01d1c

			$scope.logout = function() {
				SecurityService.doLogout(function(response) {
					$location.url("/");
				});
			}
		} ]);
