<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/content/css/bootstrap.css" />' rel="stylesheet"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" >
		<div>
			<a href='<c:url value="/nuevo" />' class="btn btn-success btn-block" >Nuevo usuario</a>	
		</div>
		<table class="table">
			<thead><tr>
				<th>Id</th><th>Email</th><th>Password</th>
				<th>Nombre</th><th>Acciones</th>
			</tr></thead>
			<c:forEach items="${usuarios}" var="u">
				<tr><td><c:out value="${u.id}" /></td>
					<td><c:out value="${u.email}" /></td>
					<td><c:out value="${u.password}" /></td>
					<td><c:out value="${u.nombre}" /></td>					
					<td>
						<a href='<c:url value="/actualizar" >
							<c:param name="id" value="${u.id}" />
						</c:url>' class="btn btn-warning" >Editar</a>
						<a href='<c:url value="/borrar" >
							<c:param name="id" value="${u.id}" />
						</c:url>' class="btn btn-danger" >Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>