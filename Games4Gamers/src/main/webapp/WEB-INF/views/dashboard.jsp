<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%@ include file="/Templates/dashboard.html"%>
<title>Assessment</title>

<script type="text/javascript">
	window.onload = function() {

		var chart = new CanvasJS.Chart("chartContainer", {
			theme : "light2",
			animationEnabled : true,
			exportFileName : "Lifetime Sales",
			exportEnabled : true,
			title : {
				text : "Top Selling Products"
			},
			data : [ {
				type : "pie",
				showInLegend : true,
				legendText : "{label}",
				toolTipContent : "{label}: <strong>{y}</strong>",
				indexLabel : "{label} {y}",
				dataPoints : ${mapProduct}
	} ]
		});

		chart.render();

	}
</script>
<body>
	<div class="content">
		<div class="container-fluid">

			<div id="chartContainer" style="height: 370px; width: 100%;"></div>
			<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
		</div>
	</div>
</body>

<%@ include file="/Templates/Footer.html" %>

