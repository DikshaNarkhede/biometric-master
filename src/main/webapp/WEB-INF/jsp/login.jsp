<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "menu_bar.jsp" %></div>
	<!-- 
		<c:choose>
			<c:when test ="${empty pageContext.request.remoteUser}">
				<h5 class="text-danger">Invalid Credentials.  Please try again</h2>
			</c:when>
			<c:otherwise>
				<h5 class="text-success">Successfully logged in  ${pageContext.request.remoteUser}</h2>		
			</c:otherwise>
		</c:choose>
-->

        <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
        <form:form  action="./login"  method="post" class="form-horizontal"  >

	        <div class="form-group">
    			<label class="control-label col-sm-2" for="email">User Name:</label>
			    <div class="col-sm-4">
      				<input class="form-control"  name="username"   placeholder="Please Enter User Name"/>
    			</div>
  			</div>

	        <div class="form-group">
    			<label class="control-label col-sm-2" for="email">Password:</label>
			    <div class="col-sm-4">
      				<input type = "password" class="form-control"  name="password"   placeholder="Please Enter Password"/>
    			</div>
  			</div>
  			
  			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
     					<button type="submit" class="btn btn-info btn-default">Sign In</button>
   				</div>
    		</div>
  			
        </form:form>
	
	
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "footer_bar.jsp" %></div>	
</div>  




</body> 