<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
</head>
<body>

	<h1>Index.Jsp</h1>
	
	<p>Mensaje de pagina admin: <c:out value="${mensaje}"/></p>
	<p>Mensaje de sesion: <c:out value="${sessionScope.Bienvenida}"/></p>
	
	<a href="<c:url value='/about'/>">Acerca de</a> <br>
	<a href="<c:url value='/admin'/>">Admin</a>
</body>
</html>