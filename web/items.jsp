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
                            <h3>All Items</h3>
				<table class="items">
                                    <tr>
                                        <th class="items_table">Details</th>
                                        <th class="items_table">Name</th>
                                        <th class="items_table">Type</th>
                                        <th class="items_table">Genre</th>
                                        <th class="items_table">Comments</th>
                                    </tr> 
                                    <c:forEach var="item" items="${sessionScope.all_items}"> 
                                        <tr>
                                            <c:url value="/StillCounting" var="url">
                                                <c:param name="id" value="${item.itemID}"/>
                                            </c:url>
                                            <td class="items_table"><a href="${url}">Details</a></td>    
                                            <td class="items_table">${item.name}</td>
                                            <td class="items_table">${item.mediaTypeDescription}</td>
                                            <td class="items_table">${item.genreDescription}</td>
                                            <td class="items_table">${item.comments}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
				
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