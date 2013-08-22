<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
	<a href="index.jsp" id="logo"><img src="images/logo.jpg" /></a>
	<div id="navigation">
		<ul>
			<li id="navIndex" class="first selected">
				<a href="<c:url value='/Renegades' />" target="_self">Home</a>
			</li>
			<li id="navItems">
				<a href="<c:url value='/GetchaGrooveOn' />" target="_self">Media Items</a>
			</li>
			<li id="navG">
				<a href="<c:url value='/Hotdog' />" target="_self">Genres</a>
			</li>
			<li id="navT">
				<a href="<c:url value='/Boiler' />" target="_self">Types</a>
			</li>
			<li id="navPI">
				<a href="<c:url value='/MyGeneration' />" target="_self">Purchase Info</a>
			</li>
			<li id="navAdmin">
				<a href="<c:url value='/adminhome.jsp' />" target="_self">Admin</a>
			</li>
			<li id="navContact">
				<a href="<c:url value='contact.jsp' />" target="_self">Contact</a>
			</li>
		</ul>
	</div>
	<div id="search">
		<form method="post" action="ClockworkAngels">
			<input name="itemName" type="text" value="Search" class="txtfield" onblur="javascript:if(this.value==''){this.value=this.defaultValue;}" onfocus="javascript:if(this.value==this.defaultValue){this.value='';}" />
			<input type="submit" value="" class="button" />
		</form>
	</div>
</div> <!-- /#header -->