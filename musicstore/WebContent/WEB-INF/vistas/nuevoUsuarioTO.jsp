<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/content/css/bootstrap.css" />' rel="stylesheet"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" >
	<form:form method="post" modelAttribute="usuario">
		<div>
			<label>Id:</label>
			<form:input path="id" class="form-control" />
			<form:errors path="id" class="text-danger" />
		</div>
		<div>
			<label>Email:</label>
			<form:input path="email" type="text" class="form-control" />
			<form:errors path="email" class="text-danger" />
		</div>
		<div>	
			<label>Password:</label>
			<form:input type="password" path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
		</div>
		<div>	
			<label>Nombre:</label>
			<form:input path="nombre" class="form-control" />
			<form:errors path="nombre" class="text-danger" />
		</div>		
		
		<button type="submit" class="btn btn-danger">Crear usuario</button>
		
		<div class="well">			
			<form:errors path="*" class="text-danger"/>			
		</div>
	</form:form>
	</div>
</body>
</html>