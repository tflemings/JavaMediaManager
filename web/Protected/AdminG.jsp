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
                            <h1>Genres</h1>
                            <div class="form_div">
                            <fieldset class="form_field">
                                <legend>Add</legend>
                                    <form method="post" action="../AR">
                                        <label class="form_element" for="genre_name">Genre Name</label>
                                        <input class="form_input" type="text" id="genre_name" name="genre_name" /><br />
                                        <button type="submit" value="genre" name="submit">Add</button>
                                    </form>
                            </fieldset>
                            </div>
                            <div class="form_div">
                            <fieldset class="form_field">
                                <legend>Delete</legend>
                                    <form method="post" action="../DR">
                                        <label class="form_element" for="d_genre_id">Choose Genre</label>
                                        <select class="form_input" id="d_genre_id" name="d_genre_id">
                                            <option value="0"></option>
                                        <c:forEach var="genre" items="${sessionScope.genres}">
                                            <option value="${genre.genreID}">${genre.genreDescription}</option>
                                        </c:forEach>
                                        </select><br />
                                        <button type="submit" value="genre" name="submit">Delete</button>
                                    </form>
                            </fieldset>
                            </div>
                            <div class="form_div">
                            <fieldset class="form_field">
                                <legend>Edit</legend>
                                <form method="post" action="../ER">
                                    <label class="form_element" for="e_genre_id">Current Name</label>
                                    <select class="form_input" id="e_genre_id" name="e_genre_id">
                                        <option value="0"></option>
                                    <c:forEach var="genre" items="${sessionScope.genres}">
                                        <option value="${genre.genreID}">${genre.genreDescription}</option>
                                    </c:forEach>
                                    </select><br />
                                    <label class="form_element" for="e_genre_name">New Name</label>
                                    <input class="form_input" type="text" id="e_genre_name" name="e_genre_name" /><br />
                                    <button type="submit" value="genre" name="submit">Change</button>
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