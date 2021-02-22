/** * */
var app = angular.module("app", []);

app.controller('PruebaController', ['$scope', function($scope) {
    $scope.mensaje = "Hola mundo";

    $scope.cambiarMensaje = function() {
        $scope.mensaje = "Adios mundo cruel";
    }
}]);