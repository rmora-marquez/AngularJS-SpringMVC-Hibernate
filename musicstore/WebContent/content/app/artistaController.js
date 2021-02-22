app.controller('ArtistaController', ['$scope', '$http', function($scope, $http) {
    $scope.artistas = [{ "prueba": "dato" }];
    var URL = '/musicstore/api/artista/';
    $scope.artista = { id: null, nombre: "", fotoUrl: "", sitioUrl: "" };

    $scope.guardar = function() {
        if ($scope.artista.id === null) {
            crear();
        } else {
            actualizar();
        }
    }
    $scope.editar = function(id) {
        $http.get(URL + id)
            .then(function(resp) {
                $scope.artista = resp.data;
            }, function(resp) {
                alert("Error en conexion");
            });
    }
    $scope.borrar = function(id) {
        $http({
            url: URL + id,
            method: 'DELETE'
        }).then(function(resp) {
            alert("Borrado correctamente");
            cargarTodo();
        }, function(resp) {
            alert("error en borrado");
        });
    }

    function cargarTodo() {
        $http.get(URL)
            .then(function(resp, status, headers, config) {
                $scope.artistas = resp.data;
            }, function(resp, status, headers, config) {
                alert("Error en conexion");
            })
    }

    function crear() {
        $http({
            url: URL,
            method: "POST",
            data: $scope.artista
        }).then(function(resp) {
            alert("Guardado correctamente");
            $scope.artista = { id: null, nombre: "", fotoUrl: "", sitioUrl: "" };
            cargarTodo();
        }, function(resp) {
            alert("error en guardado");
        });
    }

    function actualizar() {
        $http({
            url: URL + $scope.artista.id,
            method: "PUT",
            data: $scope.artista
        }).then(function(resp) {
            alert("Guardado correctamente");
            $scope.artista = { id: null, nombre: "", fotoUrl: "", sitioUrl: "" };
            cargarTodo();
        }, function(resp) {
            alert("error en guardado");
        });
    }
    cargarTodo();
}]);