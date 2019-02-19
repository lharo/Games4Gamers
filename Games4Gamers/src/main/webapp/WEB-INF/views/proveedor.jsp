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
	<title>Pagina Proveedor</title>
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
	Add Proveedor
</h1>

<c:url var="addAction" value="/proveedor/add" ></c:url>

<form:form action="${addAction}" commandName="proveedor">
<table>
	<c:if test="${!empty proveedor.nombre}">
	<tr>
		<td>
			<form:label path="idProveedores">
				<spring:message text="idProveedores"/>
			</form:label>
		</td>
		<td>
			<form:input path="idProveedores" readonly="true" size="8"  disabled="true" />
			<form:hidden path="idProveedores" />
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
			<form:label path="direccion">
				<spring:message text="Direccion"/>
			</form:label>
		</td>
		<td>
			<form:input path="direccion" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="telefono">
				<spring:message text="Telefono"/>
			</form:label>
		</td>
		<td>
			<form:input path="telefono" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="terminos">
				<spring:message text="Terminos"/>
			</form:label>
		</td>
		<td>
			<form:input path="terminos" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty proveedor.nombre}">
				<input type="submit"
					value="<spring:message text="Editar proveedor"/>" />
			</c:if>
			<c:if test="${empty proveedor.nombre}">
				<input type="submit"
					value="<spring:message text="Añadir proveedor"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Tipo proveedor List</h3>
<c:if test="${!empty listProveedores}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Nombre</th>
		<th width="120">Direccion</th>
		<th width="120">Telefono</th>
		<th width="120">Email</th>
		<th width="120">Terminos</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listProveedores}" var="proveedor">
		<tr>
			<td>${proveedor.idProveedores}</td>
			<td>${proveedor.nombre}</td>
			<td>${proveedor.direccion}</td>
			<td>${proveedor.telefono}</td>
			<td>${proveedor.email}</td>
			<td>${proveedor.terminos}</td>
			
			<td><a href="<c:url value='/editTipoProducto/${proveedor.idProveedores}' />" >Edit</a></td>
			<td><a href="<c:url value='/removeTipoProducto/${proveedor.idProveedores}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</div>
</body>
</html>
<%@ include file="/Templates/Footer.html" %>