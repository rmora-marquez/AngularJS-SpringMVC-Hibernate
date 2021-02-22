<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
    <head>
        <meta charset="utf-8" >
        <title>Ejemplos jquery</title>
        <c:url value="/content/css/bootstrap.css" var="bootstrap" />
        <link href="${bootstrap}" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Titulo</h1>
                    <h2 id="subtitulo">Subtitulo</h2>                    
                </div>
            </div><!--end row -->
            <div class="row">
                <div class="col-6">
                    <h3>Favoritos</h3>
                    <ol id="favoritos" class="list-group">
                        <li class="list-group-item">Rock</li>
                        <li class="list-group-item">Pop</li>
                        <li class="list-group-item">Jazz</li>
                    </ol>                    
                </div>
                <div class="col-6">
                    <h3>Odiados</h3>
                    <ol id="odiados" class="list-group">                        
                    </ol>                    
                </div>
            </div><!--end row --> 
            <div class="row">
                <div class="col-5">                    
                    <form id="formulario" action="#" class="card border-primary" >
                        <legend class="card-title bg-primary text-white">Artistas</legend>
                        <fieldset class="card-body text-primary">                            
                            <div class="form-group">
                                <label>Nombre:</label>
                                <input id="input-nombre" type="text" class="form-control" >
                            </div>
                            <div class="form-group">
                                <label>Foto:</label>
                                <input id="input-foto" type="text" class="form-control" >
                            </div>
                            <div class="form-group">
                                <label>Sitio:</label>
                                <input id="input-sitio" type="text" class="form-control" >
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
                            <tbody></tbody>
                        </table>
                    </div>                    
                </div>
            </div><!--end row -->           
        </div>
        <c:url var="jqueryjs" value="/content/js/jquery.js"></c:url>
        <script type="text/javascript" src="${jqueryjs}" ></script>
        <c:url var="bootstrapjs"  value="/content/js/bootstrap.js"/>        
        <script type="text/javascript" src="${bootstrapjs}" ></script>
        <c:url var="jqueryscript" value="/content/js/jquery-script.js"></c:url>
        <script type="text/javascript" src="${jqueryscript}"></script>
    </body>
</html>