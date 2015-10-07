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
			} ];

			$scope.logout = function() {
				SecurityService.doLogout(function(response) {
					$location.url("/");
				});
			}
		} ]);
