<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ include file="/Templates/dashboard.html"%>

<title>${product.nombre}</title>

<div class="content">
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-8">
				<h1>${product.nombre}</h1>
				<hr>
				<h2 ><p>Description: ${product.descripcion}</p></h2>
				<blockquote cite="">Price:  ${product.precio}</blockquote>
				<h3>Available: ${product.cantidad}</h3>
				<input name="item" type="text" pattern="\d*" />
				</div>
		</div>
		<a
			href='http://localhost:8080/Games4Gamers/store'
			class="btn btn-primary">Back</a>
		<a 
			href='http://localhost:8080/Games4Gamers/orderProductBought/${product.idProductos}/1'
			
			class="btn btn-primary">Buy</a>

	</div>
</div>