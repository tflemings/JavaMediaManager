<%-- 
    Document   : itemDetails
    Created on : Mar 19, 2013, 11:55:40 PM
    Author     : Tony
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin Home</title>
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
	<jsp:include page="../Header.jsp" />
	
	<div id="contents">
		<div class="background">
			<div id="solutions">
                            <c:choose>
                                <c:when test="!${sessionScope.user.authlevel eq 1}">
                                    <jsp:forward page="../adminhome.jsp" />
                                </c:when>
                                <c:otherwise>
                                    <h1>Admin Functions</h1>
                                    
                                    <ul>
                                        <li><a href="Protected/AdminG.jsp">Genres</a></li>
                                        <li><a href="Protected/AdminMI.jsp">Media Items</a></li>
                                        <li><a href="Protected/AdminMT.jsp">Media Types</a></li>
                                        <li><a href="Protected/AdminPI.jsp">Purchase Info</a></li>
                                        <li><a href="Protected/AdminPIMI.jsp">Purchase Info Media Item</a></li>
                                    </ul>
                                </c:otherwise>
                            </c:choose>
                            
                                    
                            
                            
				
				<%-- Put your code here --%>
				
				
			</div>
		</div>
	</div> <!-- /#contents -->
	
	<jsp:include page="../Footer.jsp" />

	<script type="text/javascript">
		$(function () {
			$(function () { 
				$("ul li").removeClass('selected');
				$("#navAdmin").addClass('selected'); 
			});
    	});
	</script>
</body>
</html>