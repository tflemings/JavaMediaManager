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
	<title>Items</title>
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
		<div class="background">
			<div id="solutions">
                            <h3>Item Details</h3>
                            <c:forEach var="item" items="${anItem}">
                                <fieldset class="item_field">
                                    <legend class="item_legend">${item.name}</legend>
                                    
                                        <label class="item_details_label">Media Type:</label>
                                        <label class="item_details_value">${item.mediaTypeDescription}</label><br />
                                        
                                        <label class="item_details_label">Genre Type:</label>
                                        <label class="item_details_value">${item.genreDescription}</label><br />
                                        
                                        <label class="item_details_label">Year:</label>
                                        <label class="item_details_value">${item.year}</label><br />
                                        
                                        <label class="item_details_label">Purchase Date:</label>
                                        <label class="item_details_value">${item.purchaseDate}</label><br />
                                        
                                        <label class="item_details_label">Current Value:</label>
                                        <label class="item_details_value">${item.currentValue}</label><br />
                                        
                                        <label class="item_details_label">Purchase Price:</label>
                                        <label class="item_details_value">${item.purchasePrice}</label><br />
                                        
                                        <label class="item_details_label">Comments:</label>
                                        <label class="item_details_value">${item.comments}</label><br />
                                        
                                        <label class="item_details_label">Purchase Location:</label>
                                        <label class="item_details_value">${item.purchaseLocation}</label><br />
                                    
                                </fieldset>
                            </c:forEach>
                            
				
				<%-- Put your code here --%>
				
				
			</div>
		</div>
	</div> <!-- /#contents -->
	
	<jsp:include page="Footer.jsp" />

	<script type="text/javascript">
		$(function () {
			$(function () { 
				$("ul li").removeClass('selected');
				$("#navItems").addClass('selected'); 
			});
    	});
	</script>
</body>
</html>