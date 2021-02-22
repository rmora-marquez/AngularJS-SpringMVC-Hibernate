<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<c:url var="bootstrap" value="/content/css/bootstrap.css"></c:url>
	<link href="${bootstrap}" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style>
@import url(http://fonts.googleapis.com/css?family=Roboto:400);
body {
  background-color:#fff;
  -webkit-font-smoothing: antialiased;
  font: normal 14px Roboto,arial,sans-serif;
}

.container {
    padding: 25px;
    position: fixed;
}

.form-login {
    background-color: #EDEDED;
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 20px;
    padding-right: 20px;
    border-radius: 15px;
    border-color:#d2d2d2;
    border-width: 5px;
    box-shadow:0 1px 0 #cfcfcf;
}

h4 { 
 border:0 solid #fff; 
 border-bottom-width:1px;
 padding-bottom:10px;
 text-align: center;
}

.form-control {
    border-radius: 10px;
}

.wrapper {
    text-align: center;
}
	
	
	</style>
</head>
<body>
	<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
        <form action="login" method="post">
            <div class="form-login">
            <h4>Bienvenido, favor de identificarse.</h4>
            <input name="username" type="text" id="userName" class="form-control input-sm chat-input" placeholder="username" />
            </br>
            <input name="password" type="text" id="userPassword" class="form-control input-sm chat-input" placeholder="password" />
            </br>
            <div class="wrapper">
            <span class="group-btn">     
                <button class="btn btn-primary btn-md">Identificarse <i class="fa fa-sign-in"></i></button>
            </span>
            </div>
            </div>
        </form>
        </div>
    </div>
</div>
	<c:url var="jquery" value="/content/js/jquery.js"></c:url>
	<script type="text/javascript" src="${jquery}"></script>
	<c:url var="bootstrapjs" value="/content/js/bootstrap.js"></c:url>
	<script type="text/javascript" src="${bootstrapjs}"></script>
</body>
</html>