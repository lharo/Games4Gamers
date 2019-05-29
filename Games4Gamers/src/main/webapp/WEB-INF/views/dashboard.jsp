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
		// CanvasJS column chart to show revenue from Jan 2015 - Dec 2015
		var revenueColumnChart = new CanvasJS.Chart("revenue-column-chart", {
			animationEnabled: true,
			backgroundColor: "transparent",
			theme: "theme2",
			axisX: {
				labelFontSize: 14,
				valueFormatString: "MMM YYYY"
			},
			axisY: {
				labelFontSize: 14,
				prefix: "$"
			},
			toolTip: {
				borderThickness: 0,
				cornerRadius: 0
			},
			data: [
				{
					type: "column",
					yValueFormatString: "$###,###.##",
					dataPoints: [
						{ x: new Date("1 Jan 2019"), y: 800 },
						{ x: new Date("1 Feb 2019"), y: 1550 },
						{ x: new Date("1 Mar 2019"), y: 6200 },
						{ x: new Date("1 Apr 2019"), y: 6900 },
						{ x: new Date("1 May 2018"), y: 1030 },
						{ x: new Date("1 Jun 2018"), y: 7160 },
						{ x: new Date("1 Jul 2018"), y: 8000 },
						{ x: new Date("1 Aug 2018"), y: 850 },
						{ x: new Date("1 Sep 2018"), y: 4150 },
						{ x: new Date("1 Oct 2018"), y: 1700 },
						{ x: new Date("1 Nov 2018"), y: 8400 },
						{ x: new Date("1 Dec 2018"), y: 48600 }
					]
				}
			]
		});
		
		revenueColumnChart.render();

	}
</script>
<body>
	<div class="content">
		<div class="container-fluid">

			<div id="chartContainer" style="height: 370px; width: 100%;"></div>
			<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

				<div class="card shadow">
					<h4 class="card-header">Revenue <span class="tag tag-success" id="revenue-tag">$95,340</span></h4>
					<div id="revenue-column-chart"></div>
				</div>
			</div>
		</div>

</body>


