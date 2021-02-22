<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Ejemplo music store">
    <meta name="author" content="Ramon Mora">    

    <title>Music Store app Java</title>
    <link href='<c:url value="/content/css/bootstrap.min.css" />'  rel="stylesheet">
    <link href='<c:url value="/content/css/jumbotron.css" />' rel="stylesheet">
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Music Store </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Identificarse</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
      	<p>       
	        <div class="text-center">
	        	<img style="width: 60%" src='<c:url value="/content/img/The-Music-Store-Logo.png" />' alt="Music store logo" ></img>	        </div>	        	
	        	<div class="text-center">
	        		<div class="btn-group" >
	        		<a class="btn btn-primary btn-lg" href="#" role="button">Cat&aacute;logo &raquo;</a>
	        		<a class="btn btn-success btn-lg" href="#" role="button">Artistas &raquo;</a>
	        		<a class="btn btn-info btn-lg" href="#" role="button">Generos &raquo;</a>
	        		</div>
	        	</div>
        </p>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Lo más escuchadó</h2>
          <p>
          <c:forEach items="${albumes}" var="album">
          	<ol class="list-group">
          		<li class="list-group-item">
          			<h1>
          				<c:out value="${album.titulo}"></c:out>
          			</h1>
          			<img src="${album.portadaUrl}" style="width: 200px">
          		</li>
          		<li class="list-group-item">
          			Artista: <c:out value="${album.artista.nombre}"></c:out>
          			<img src="${album.artista.fotoUrl}" style="width: 90px">
          			<br>
          			Genero: <c:out value="${album.genero.nombre}"></c:out>
          			<div>
          				<button class="btn btn-outline-danger">
          					Comprar $<c:out value="${album.precio}"></c:out>
          				</button>
          			</div>
          		</li>
          		
          	</ol>
          </c:forEach>          
          </p>
          <p><a class="btn btn-default" href="#" role="button">Lista completa &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>Los más vendido</h2>
          <p>. </p>
          <p><a class="btn btn-default" href="#" role="button">Lista completa &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Lo salida de la semana</h2>
          <p>.</p>
          <p><a class="btn btn-default" href="#" role="button">Lista completa &raquo;</a></p>
        </div>
      </div>
      <hr>
      <footer class="well">
        <p>&copy; 2018 My company, Inc.</p>
      </footer>
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src='<c:url value="/js/jquery.js" />'></script>
    <script src='<c:url value="/js/bootstrap.js" />'></script>
    
  </body>
</html>
