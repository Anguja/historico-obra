/**
 * @author Ricardo Ramírez
 */

var appHome = angular.module('homeController', []);

appHome.controller('HomeController', [ '$scope', 'SecurityService',
		'$location', function($scope, SecurityService, $location) {

			$scope.bookmarks = [ {
				title : "Usuarios",
				url : "#/usuario",
				icon: "icon-user"
			}, {
				title : "Reporte",
				url : "",
				icon: "icon-signal"
			} ];
			
			$scope.logout = function() {
				SecurityService.doLogout(function(response) {
					$location.url("/");
				});
			}
		} ]);
