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
	<script src="../jquery/js/jquery-1.9.1.js" type="text/javascript"></script>
	<script src="../jquery/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
	<link rel="stylesheet" href="../css/style.css" type="text/css">
	<link rel="stylesheet" href="../css/additionalStyles.css" type="text/css">
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
                            <h1>Edit Purchase Info Media Item</h1>
                            <div class="form_div">
                            <fieldset class="form_field">
                                <legend>Edit Item</legend>
                                    <form method="post" action="../EPI">
                                        <label class="form_element" for="price">Purchase Price</label>
                                        <input class="form_input" id="price" name="price" /><br />
                                        <label class="form_element" for="date">Purchase Date</label>
                                        <input class="form_input" id="date" name="date" />
                                        <label class="form_element" for="location">Purchase Location</label>
                                        <select class="form_input" id="location" name="location">
                                            <c:forEach var="location" items="${sessionScope.locations}">
                                                <c:choose>
                                                    <c:when test="${requestScope.purchase_info.locationID}==${location.locationID}">
                                                        <option value="${item.itemID}" selected="selected">${item.name}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${item.itemID}">${item.name}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select><br />
                                        <label class="form_element" for="location">Location</label>
                                        <select class="form_input" id="location" name="location">
                                            <option value="0"></option>
                                            <c:forEach var="location" items="${sessionScope.locations}">
                                                <option value="${location.locationID}">${location.purchaseLocation}</option>
                                            </c:forEach>
                                        </select><br />
                                        <label class="form_element" for="price">Purchase Price</label>
                                        <input class="form_input" type="text" id="price" name="price" /><br />
                                        <label class="form_element" for="date">Date (YYYY-MM-DD)</label>
                                        <input class="form_input" type="text" id="date" name="date" /><br />
                                        <button type="submit" name="submit" value="purchaseinfomediaitem">Add</button>
                                    </form>
                            </fieldset>
                            </div>
                            
                                    
                            
                            
				
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

