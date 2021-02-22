<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html ng-app="app">

        <head>
            <meta charset="utf-8">
            <title>Ejemplos AngularJs</title>
            <c:url value="/content/css/bootstrap.css" var="bootstrap" />
            <link href="${bootstrap}" rel="stylesheet">
        </head>

        <body>
            <div class="container">
                <div class="row" ng-controller="PruebaController">
                    <div class="col-12">
                        <h1>{{mensaje}}</h1>
                        <button ng-click="cambiarMensaje()" class="btn btn-primary">Cambiar</button>
                        <input class="form-control" ng-model="mensaje">
                    </div>
                </div>
                <!--end row -->
                <div class="row" ng-controller="ArtistaController">
                    <div class="col-5">
                        <form id="formulario" ng-submit="guardar()" action="#" class="card border-primary">
                            <legend class="card-title bg-primary text-white">Artistas</legend>
                            <fieldset class="card-body text-primary">
                                <div class="form-group">
                                    <label>Nombre:</label>
                                    <input ng-model="artista.nombre" type="text" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Foto:</label>
                                    <input ng-model="artista.fotoUrl" type="text" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Sitio:</label>
                                    <input ng-model="artista.sitioUrl" type="text" class="form-control">
                                </div>

                            </fieldset>
                            <div class="card-footer bg-light">
                                <button type="submit" class="btn btn-outline-primary">Guardar</button>
                                <button type="reset" class="btn btn-outline-warning">Reset</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-7">
                        <div class="card border-primary">
                            <table id="tabla" class="table table-bordered table-striped">
                                <thead class="bg-primary text-white">
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Foto</th>
                                        <th>Sitio</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr ng-repeat="a in artistas">
                                        <td>{{a.nombre}}</td>
                                        <td><img ng-src="{{a.fotoUrl}}" style="width: 80px;height: 80px;"></td>
                                        <td><a ng-href="{{a.sitioUrl}}" class="btn btn-success">Sitio de fans</a> </td>
                                        <td>
                                            <button ng-click="editar(a.id)" class="btn btn-primary" href="#">Editar</button>
                                            <button ng-click="borrar(a.id)" class="btn btn-danger">Borrar</button>
                                        </td>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!--end row -->
            </div>
            <c:url value="/content/js/angular.js" var="angularjs"></c:url>
            <script type="text/javascript" src="${angularjs}"></script>
            <c:url value="/content/app/app.js" var="appjs" />
            <script type="text/javascript" src="${appjs}"></script>
            <c:url value="/content/app/artistaController.js" var="artistaController"></c:url>
            <script type="text/javascript" src="${artistaController}"></script>
        </body>

        </html>