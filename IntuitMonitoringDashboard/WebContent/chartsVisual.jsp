<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="stylesheets/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Static Data</title>
</head>
<body>

<div class="siteInfoBox ${sitePageData.userTimePeriod}">
	<div class="centered">${sitePageData.userTimePeriod}</div>
	<div class="symbol">${sitePageData.siteReachability}</div>
	<div class="number">${sitePageData.pageLoadTime }</div>
</div>

</body>
</html>