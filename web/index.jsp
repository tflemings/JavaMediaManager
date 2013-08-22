<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Media Manager</title>
	<script src="jquery/js/jquery-1.9.1.js" type="text/javascript"></script>
	<script src="jquery/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<link rel="stylesheet" href="css/additionalStyles.css" type="text/css">
	<!--[if lte IE 7]>
		<link rel="stylesheet" href="css/ie.css" type="text/css" charset="utf-8" />	
	<![endif]-->
	<link rel="stylesheet" href="jquery/css/dark-hive/jquery-ui-1.10.1.custom.min.css" type="text/css">
</head>
<body>
	<jsp:include page="Header.jsp" />
	<div id="contents">
		<div class="body">
			<div id="sidebar">
				<h3>Quick Links</h3>
				<ul>
					<li>
						<a href="<c:url value='/Renegades' />" target="_self" class="nolinkattributes">Home</a>
					</li>
					<li>
						<a href="<c:url value='/GetchaGrooveOn' />" target="_self" class="nolinkattributes">All Items</a>
					</li>
					<li>
						<a href="<c:url value='/Hotdog' />" target="_self" class="nolinkattributes">Genres</a>
					</li>
					<li>
						<a href="<c:url value='/Boiler' />" target="_self" class="nolinkattributes">Media Types</a>
					</li>
					<li>
						<a href="<c:url value='/MyGeneration' />" target="_self" class="nolinkattributes">Purchase Info</a>
					</li>
					<li>
						<a href="<c:url value='adminhome.jsp' />" target="_self" class="nolinkattributes">Admin</a>
					</li>
					<li>
						<a href="<c:url value='contact.jsp' />" target="_self" class="nolinkattributes">Contact Us</a>
					</li>
				</ul>
			</div>
			<div id="main">
                            <p>Welcome to the Media Management System.</p>
			</div>
		</div>
	</div> <!-- /#contents -->
	<jsp:include page="Footer.jsp" />
	<script type="text/javascript">
		$(function () {
			$(function () { 
				$("ul li").removeClass('selected');
				$("#navIndex").addClass('selected'); 
			});
    	});
	</script>
</body>
</html>