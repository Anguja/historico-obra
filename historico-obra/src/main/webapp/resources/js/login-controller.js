var historico = angular.module('loginController', []);

historico.controller('LoginController', [
		'$scope',
		'SecurityService',
		'$location',
		function($scope, SecurityService, $location) {

			$scope.login = function() {
				SecurityService.doLogin($scope.username, $scope.clave,
						function(response) {
							if (response.success) {
								$location.url('/usuario/'+response.usuario.idUsuario);
							} else {
								$scope.error = response.message;
								$scope.dataLoading = false;
							}
						});
			};

			$scope.logout = function() {
				SecurityService.doLogout(function(response) {
					$location.url('/');
				});
			};

		} ]);
