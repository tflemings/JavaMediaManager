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
                            <h1>Media Types</h1>
                            <div class="form_div">
                            <fieldset class="form_field">
                                <legend>Add</legend>
                                <form method="post" action="../AR">
                                    <label class="form_element" for="media_type_name">Media Type Name</label>
                                    <input class="form_input" type="text" id="media_type_name" name="media_type_name" /><br />
                                    <button type="submit" value="mediatype" name="submit">Add</button>
                                </form>
                            </fieldset>
                            </div>
                            <div class="form_div">
                            <fieldset class="form_field">
                                <legend>Delete</legend>
                                <form method="post" action="../DR">
                                    <label class="form_element" for="d_media_id">Choose</label>
                                    <select class="form_input" id="d_media_id" name="d_media_id">
                                        <option value="0"></option>
                                    <c:forEach var="media_type" items="${sessionScope.media_types}">
                                        <option value="${media_type.mediaID}">${media_type.mediaTypeDescription}</option>
                                    </c:forEach>
                                    </select><br />
                                    <button type="submit" value="mediatype" name="submit">Delete</button>
                                </form>
                            </fieldset>
                            </div>
                            <div class="form_div">
                            <fieldset class="form_field">
                                <legend>Edit</legend>
                                <form method="post" action="../ER">
                                    <label class="form_element" for="e_media_id">Current Name</label>
                                    <select class="form_input" id="e_media_id" name="e_media_id">
                                        <option value="0"></option>
                                    <c:forEach var="media_type" items="${sessionScope.media_types}">
                                        <option value="${media_type.mediaID}">${media_type.mediaTypeDescription}</option>
                                    </c:forEach>
                                    </select><br />
                                    <label class="form_element" for="e_media_type_name">New Name</label>
                                    <input class="form_input" type="text" id="e_media_type_name" name="e_media_type_name" /><br />
                                    <button type="submit" value="mediatype" name="submit">Change</button>
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