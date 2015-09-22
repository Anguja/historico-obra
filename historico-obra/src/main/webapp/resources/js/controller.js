var historicoAPP=angular.module("historicoAPP",[]);

   historicoAPP.controller('MonedaController'), function($scope){
	$scope.moneda={
			descripcionMoneda:"",
			cotizacion:undefined
	};
	
	$scope.crearMoneda = function(){
		$http.post("rest/moneda/crearMoneda", $scope.moneda)
		.success(function(data){
			$scope.moneda = {};
			console.log(data);
		})
		.error(function(data) {
            console.log('Error:' + data);
        });
	}
}();