<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto"%>
<%@ include file="/Templates/dashboard.html" %>
<title>E-Commerce</title>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<c:if test="${!empty listProduct}">
				<c:forEach items="${listProduct}" var="product">
					<div class="col-sm-4" align="center">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">${product.nombre}</h5>
								<p class="card-text">${product.descripcion}</p>
								<h5 class="card-subtitle mb-2 text-muted">${product.precio}</h5>
								<br>
								<h6 class="card-subtitle mb-2">Available: ${product.cantidad}</h6>
								<a href='http://localhost:8080/Games4Gamers/orderProduct/${product.idProductos}'
									class="btn btn-primary">Order</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>

	</div>
</div>