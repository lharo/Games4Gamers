<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto"%>
<%@ include file="/Templates/Navbar.html" %>

<html>
<head>
	<title>Pagina Tipo Producto</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<div style="margin-left: 55px; margin-top: 20px;">
<h1>
	Add a Tipo Producto
</h1>

<c:url var="addAction" value="/tipoProducto/add" ></c:url>

<form:form action="${addAction}" commandName="typeProducts">
<table>
	<c:if test="${!empty typeProducts.nombre}">
	<tr>
		<td>
			<form:label path="idTipoProducto">
				<spring:message text="idTipoProducto"/>
			</form:label>
		</td>
		<td>
			<form:input path="idTipoProducto" readonly="true" size="8"  disabled="true" />
			<form:hidden path="idTipoProducto" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="nombre">
				<spring:message text="Nombre"/>
			</form:label>
		</td>
		<td>
			<form:input path="nombre" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="descripcion">
				<spring:message text="Descripcion"/>
			</form:label>
		</td>
		<td>
			<form:input path="descripcion" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty typeProducts.nombre}">
				<input type="submit"
					value="<spring:message text="Editar Tipo Producto"/>" />
			</c:if>
			<c:if test="${empty typeProducts.nombre}">
				<input type="submit"
					value="<spring:message text="Añadir Tipo Producto"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Tipo Producto List</h3>
<c:if test="${!empty listTypeProducts}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Nombre</th>
		<th width="120">Descripcion</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listTypeProducts}" var="tipoProducto">
		<tr>
			<td>${tipoProducto.idTipoProducto}</td>
			<td>${tipoProducto.nombre}</td>
			<td>${tipoProducto.descripcion}</td>
			<td><a href="<c:url value='/editTipoProducto/${tipoProducto.idTipoProducto}' />" >Edit</a></td>
			<td><a href="<c:url value='/removeTipoProducto/${tipoProducto.idTipoProducto}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</div>
</body>
</html>
<%@ include file="/Templates/Footer.html" %>