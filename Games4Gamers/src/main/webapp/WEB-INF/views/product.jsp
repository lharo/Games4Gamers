<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto"%>
<%@ include file="/Templates/dashboard.html" %>

<title>Pagina Producto</title>

<div class="content">
   <div class="container-fluid">


	<h1>
		Add a Product
	</h1>
	<c:url var="addAction" value="/product/add" ></c:url>	
	
	<form:form action="${addAction}" commandName="product">
	<table>
		<c:if test="${!empty product.nombre}">
		<tr>
			<td>
				<form:label path="idProductos">
					<spring:message text="idProductos"/>
				</form:label>
			</td>
			<td>
				<form:input path="idProductos" readonly="true" size="8"  disabled="true" />
				<form:hidden path="idProductos" />
			</td> 
		</tr>
		</c:if>
		<tr>
			<td>
				<form:label path="nombre">
					<spring:message text="Name"/>
				</form:label>
			</td>
			<td>
				<form:input path="nombre" />
			</td> 
		</tr>
		<tr>
			<td>
				<form:label path="descripcion">
					<spring:message text="Description"/>
				</form:label>
			</td>
			<td>
				<form:input path="descripcion" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="precio">
					<spring:message text="Price"/>
				</form:label>
			</td>
			<td>
				<form:input path="precio" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="cantidad">
					<spring:message text="Quanity"/>
				</form:label>
			</td>
			<td>
				<form:input path="cantidad" />
			</td>
		</tr>
		<tr>
			<td>
	
				<form:label path="idTipoProducto">
					<spring:message text="Tipo Producto"/>
				</form:label>
			</td>
			<td>
				<form:select path="idTipoProducto">	
					<c:forEach items="${listTypeProducts}" var="typeProducts">
							<form:option value="${typeProducts.idTipoProducto}">${typeProducts.nombre}</form:option>
					</c:forEach>		
				</form:select>
			</td>	
		</tr>
			<tr>
			<td>
	
				<form:label path="idProveedor">
					<spring:message text="Proveedor"/>
				</form:label>
			</td>
			<td>
				<form:select path="idProveedor">	
					<c:forEach items="${listProveedores}" var="proveedor">
							<form:option value="${proveedor.idProveedores}">${proveedor.nombre}</form:option>
					</c:forEach>		
				</form:select>
			</td>	
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${!empty product.nombre}">
					<input type="submit"
						value="<spring:message text="Edit Producto"/>" />
				</c:if>
				<c:if test="${empty product.nombre}">
					<input type="submit"
						value="<spring:message text="Add Producto"/>" />
				</c:if>
			</td>
		</tr>
	</table>	
	</form:form>
	<br>
	<h3>Product List</h3>
	<c:if test="${!empty listProduct}">
		<table class="tg">
		<tr>
			<th width="80">ID</th>
			<th width="120">Name</th>
			<th width="120">Description</th>
			<th width="120">Price</th>
			<th width="120">Quantity</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${listProduct}" var="product">
			<tr>
				<td>${product.idProductos}</td>
				<td>${product.nombre}</td>
				<td>${product.descripcion}</td>
				<td>${product.precio}</td>
				<td>${product.cantidad}</td>
				<td><a href="<c:url value='/edit/${product.idProductos}' />" >Edit</a></td>
				<td><a href="<c:url value='/remove/${product.idProductos}' />" >Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
</div>
</body>
</html>
<%@ include file="/Templates/Footer.html" %>
