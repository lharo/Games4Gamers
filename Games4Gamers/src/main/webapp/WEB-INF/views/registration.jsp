<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ include file="/Templates/dashboard.html" %>

<title>Registration Form</title>

<div class="content">
   <div class="container-fluid">

	<h1>
		Registration Form
	</h1>
	<c:url var="addAction" value="/user/add" ></c:url>	
	
	<form:form action="${addAction}" commandName="user">
	<table>
		<c:if test="${!empty user.correoElectronico}">
		<tr>
			<td>
				<form:label path="idUsuario">
					<spring:message text="idUsuario"/>
				</form:label>
			</td>
			<td>
				<form:input path="idUsuario" readonly="true" size="8"  disabled="true" />
				<form:hidden path="idUsuario" />
			</td> 
		</tr>
		</c:if>
		<tr>
			<td>
				<form:label path="primerNombre">
					<spring:message text="First Name"/>
				</form:label>
			</td>
			<td>
				<form:input path="primerNombre" />
			</td> 
		</tr>
		<tr>
			<td>
				<form:label path="segundoNombre">
					<spring:message text="Middle Name"/>
				</form:label>
			</td>
			<td>
				<form:input path="segundoNombre" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="apellidoPaterno">
					<spring:message text="Lastname"/>
				</form:label>
			</td>
			<td>
				<form:input path="apellidoPaterno" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="apellidoMaterno">
					<spring:message text="Mother Lastname"/>
				</form:label>
			</td>
			<td>
				<form:input path="apellidoMaterno" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="nombreUsuario">
					<spring:message text="Username"/>
				</form:label>
			</td>
			<td>
				<form:input path="nombreUsuario" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="contrasenia">
					<spring:message text="Password"/>
				</form:label>
			</td>
			<td>
				<form:password path="contrasenia"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="correoElectronico">
					<spring:message text="Email"/>
				</form:label>
			</td>
			<td>
				<form:input path="correoElectronico" />
			</td>
		</tr>
				<tr>
			<td colspan="2">
				<input type="submit"
					value="<spring:message text="Add User"/>" />
			</td>
		</tr>
		
	</table>	
	</form:form>	
</div>
</body>
</html>
<%@ include file="/Templates/Footer.html" %>
