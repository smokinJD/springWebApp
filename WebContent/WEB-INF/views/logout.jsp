<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="!isAuthenticated()">
	<p>Por favor inicia sesion</p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
	<c:set var="username" value="${principal.username}"/>
	<p>usuario conectado como, 
	<c:out value="${username}"></c:out> 
	(<a href='<c:url value='/logout'/>'>Cerrar Sesion</a>)
	</p>
</sec:authorize>