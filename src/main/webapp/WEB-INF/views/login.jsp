<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
	<body>
		<h1>Login:</h1>
<%-- 		<div class="success">${message}</div> --%>
<%-- 		<c:if test="${'fail' eq param.auth}"> --%>
<!-- 			<div class="errors">  -->
<!-- 				Invalid username or password! -->
<!-- 			</div> -->
<%-- 		</c:if><br> --%>
        <c:url var="loginUrl" value="/login" />
		<sf:form method="POST" action="${loginUrl}" commandName="user">
			<sf:label path="username" cssErrorClass="error">Username</sf:label>:
			<sf:input path="username" cssErrorClass="error" id="username"/> <br><br>
			<sf:label path="password" cssErrorClass="error">Password</sf:label>:
			<sf:password path="password" cssErrorClass="error" id="password"/> <br><br>
			<input id="loginButton" type="submit" value="Login"/>
		</sf:form><br><br>
<%-- 		<h2><a href="<c:url value="/signup" />" > Sign up</a></h2> --%>
	
	</body>
</html>