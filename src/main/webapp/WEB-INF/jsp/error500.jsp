<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "menu_bar.jsp" %></div>

	<p>&nbsp;</p>
	<h2 class="text-danger">An error occurred in processing the request.</h2>
	<p>&nbsp;</p>
	<h3 class="text-danger">URL:</h3>  
	<h4 class="text-info">${url}</h4>

	<h3 class="text-danger">Exception:</h3>  
	<h4 class="text-info">${exception.message}</h4>

	<p>&nbsp;</p><p>&nbsp;</p>
	<h3 class="text-danger">Error Details:</h3>
	<h5 class="text-info">
	   <c:forEach items="${exception.stackTrace}" var="ste">    
	   			${ste} 
	    </c:forEach>
	</h5>
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "footer_bar.jsp" %></div>	
</div>  




</body> 