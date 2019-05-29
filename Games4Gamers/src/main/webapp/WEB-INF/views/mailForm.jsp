<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto"%>
<%@ include file="/Templates/dashboard.html"%>

<title>Manual CRM</title>

<div class="content">
	<div class="container-fluid">
			<c:choose>
				<c:when test="${id == 1}">
					<h1>
						Send Email
					</h1>
					<br>
					<c:url var="addAction" value="/mailForm/sendMail"></c:url>
						<form:form action="${addAction}" commandName="mail">
							<table style="border-collapse:separate; border-spacing:1em">
								<tr>
									<td><form:label path="subject">
											<spring:message text="Subject" />
										</form:label></td>
									<td><form:input path="subject" /></td>
								</tr>
								<tr>
									<td><form:label path="receivers">
											<spring:message text="Receiver" />
										</form:label></td>
									<td><form:input path="receivers" /></td>
								</tr>
								<tr>
									<td><form:label path="msg">
											<spring:message text="Message" />
										</form:label></td>
									<td><form:textarea rows="15" cols="65" path="msg" /></td>
								</tr>
								<tr>
									<td><input type="submit" value="<spring:message text="Send"/>" />
								</tr>
							</table>
						</form:form>					
				</c:when>
				<c:when test="${id == 2}">
					<h1>Birthday</h1>
										<h1>
						Send Email
					</h1>
					<br>
					<c:url var="addAction" value="/mailForm/sendBirthdayMail"></c:url>
						<form:form action="${addAction}" commandName="mail">
							<table style="border-collapse:separate; border-spacing:1em">
								<tr>
									<td><form:label path="receivers">
											<spring:message text="Receiver" />
										</form:label></td>
									<td><form:input path="receivers" /></td>
								</tr>
								<tr>
									<td><input type="submit" value="<spring:message text="Send"/>" />
								</tr>
								
							</table>
						</form:form>					
				</c:when>
				<c:when test="${id == 3}">
					<h1>Reports</h1>
				</c:when>
				<c:when test="${id == 4}">
					<h1>Offers</h1>
						<c:url var="addAction" value="/mailForm/sendMassiveSpam"></c:url>
						<form:form action="${addAction}" commandName="mail">
							<table style="border-collapse:separate; border-spacing:1em">
								<tr>
									<td><input type="submit" value="<spring:message text="Spam Every User With a Discount to Our Best Selling Product"/>" />
								</tr>
							</table>
						</form:form>
				</c:when>
				<c:when test="${id == 5}">
					<h1>Send News</h1>
				</c:when>
				<c:otherwise>
				    Error
				 </c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</body>
</html>
<%@ include file="/Templates/Footer.html"%>