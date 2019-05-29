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
		<div class="row">
			<div class="col-sm-4" align="center">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Custom Email</h5>
						<p class="card-text">
							<img alt=""
								src="http://icons.iconarchive.com/icons/wwalczyszyn/android-style/128/Mail-icon.png">
						</p>
						<a href="http://localhost:8080/Games4Gamers/mailForm/1"
							class="btn btn-primary">Send</a>
					</div>
				</div>
			</div>
			<div class="col-sm-4" align="center">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Birthday</h5>
						<p class="card-text">
							<img alt=""
								src="http://icons.iconarchive.com/icons/google/noto-emoji-food-drink/128/32421-birthday-cake-icon.png">
						</p>
						<a href="http://localhost:8080/Games4Gamers/mailForm/2"
							class="btn btn-primary">Send</a>
					</div>
				</div>
			</div>
			<div class="col-sm-4" align="center">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Reports</h5>
						<p class="card-text">
							<img alt=""
								src="http://icons.iconarchive.com/icons/aha-soft/large-seo/128/SEO-icon.png">
						</p>
						<a href="http://localhost:8080/Games4Gamers/mailForm/generateReport"
							class="btn btn-primary">Send</a>
					</div>
				</div>
			</div>
			<div class="col-sm-4" align="center">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Offers</h5>
						<p class="card-text">
							<img alt=""
								src="http://icons.iconarchive.com/icons/carlosjj/google-jfk/128/offers-icon.png">
						</p>
						<a href="http://localhost:8080/Games4Gamers/mailForm/4"
							class="btn btn-primary">Send</a>
					</div>
				</div>
			</div>
			<div class="col-sm-4" align="center">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Send News</h5>
						<p class="card-text">
							<img alt=""
								src="http://icons.iconarchive.com/icons/paomedia/small-n-flat/128/news-icon.png">
						</p>
						<a href="http://localhost:8080/Games4Gamers/mailForm/5"
							class="btn btn-primary">Send</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
<%@ include file="/Templates/Footer.html"%>