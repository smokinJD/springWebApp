<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Admin</title>
<script type="text/javascript" src="<c:url value='/res/js/jquery.min.js'/>" ></script>
<script type="text/javascript">
	jQuery(document).ready(function(){
		$(".confirm").on("click", function(){
			return confirm("Estas seguro que quieres eliminar este registro?");
		});
	});
</script>
</head>
<body>
	<c:import url="/WEB-INF/views/logout.jsp"></c:import>
	<h1>Admin.jsp</h1>

	<form:form action="${pageContext.request.contextPath}/admin/save" method="post" commandName="admin">
		<table>
			<c:if test="${admin.id ne 0}">
				<form:input path="id" type="hidden" />
				<form:input path="fechaCreacion" type="hidden" />
			</c:if>
			<tr>
				<td>Nombre</td>
				<td><form:input path="nombre" type="text" /></td>
			</tr>
			<tr>
				<td>Cargo</td>
				<td><form:input path="cargo" type="text" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Guardar"></td>
			</tr>
		</table>
	</form:form>

	<c:out value="${resultado}"></c:out>

	<c:forEach items="${admins}" var="admin">
		<p>
			<c:out value="${admin}"></c:out>
			<a href="<c:url value='/direccion/${admin.id}'/>">Direcciones</a>
			<a href="<c:url value='/admin/${admin.id}/update'/>">Actualizar</a>
			<a class="confirm" href="<c:url value='/admin/${admin.id}/delete'/>">Eliminar</a>
		</p>
	</c:forEach>
</body>
</html>