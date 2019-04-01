<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<title>Home</title>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login V1</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/x-icon"
	href="http://www.iconarchive.com/download/i99377/dtafalonso/android-lollipop/Play-Games.ico">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551747971/bootstrap.min.css" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551747571/font-awesome.min.css" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551747596/animate.css" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551747615/hamburgers.min.css" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551747633/select2.min.css" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551747518/util.css" />
<link rel="stylesheet" type="text/css"
	href="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551747518/main.css" />
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img
						src="https://res.cloudinary.com/dtt1gd36w/image/upload/v1551748117/img-01.png"
						alt="IMG">
				</div>
				<c:url var="addAction" value="/logIn/enter"></c:url>
				<form:form action="${addAction}" commandName="usuario"
					class="login100-form validate-form">

					<span class="login100-form-title"> Login or Register </span>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<form:input class="input100" type="text" placeholder="Email"
							path="username" />
						<span class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<form:input class="input100" type="password"
							placeholder="Password" path="password" />
						<span class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit">Login</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1"> Forgot </span> <a class="txt2" href="#">
							Username / Password? </a>
					</div>

					<div class="text-center p-t-136">
						<a class="txt2" href="http://localhost:8080/Games4Gamers/registro"> Create your Account <i
							class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>




	<!--===============================================================================================-->
	<script
		src="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551748205/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551748399/bootstrap.min.js"></script>
	<script
		src="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551748399/popper.js"></script>
	<!--===============================================================================================-->
	<script
		src="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551747662/select2.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551748469/tilt.jquery.min.js"></script>
	<script>
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script
		src="https://res.cloudinary.com/dtt1gd36w/raw/upload/v1551747677/main.js"></script>
</body>
</html>
<%@ include file="/Templates/Footer.html" %>

