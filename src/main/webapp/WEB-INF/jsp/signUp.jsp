<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "menu_bar.jsp" %></div>

		<p>&nbsp;</p>	
		<h2 class="text-info">Signup to contribute</h2>
		<h5 class="text-success">${message}</h5>
		<p>&nbsp;</p>
        
        
        <form:form  action="./signUp"  method="post" class="form-horizontal"  modelAttribute="bioUserForm" >
        
			<h4 class="bg-info text-info">Your Information</h4>
	        <div class="form-group">
    			<label class="control-label col-sm-2" for="firstName">First Name:</label>
			    <div class="col-sm-4">
      				<input class="form-control"  name="firstName"  value="${bioUserForm.firstName}" placeholder="Please Enter First Name"/>
      				<form:errors  class="text-danger"  path="firstName" />
    			</div>
  			</div>

	        <div class="form-group">
    			<label class="control-label col-sm-2" for="lastName">Last Name:</label>
			    <div class="col-sm-4">
      				<input class="form-control"  name="lastName"   placeholder="Please Enter Last Name" value="${bioUserForm.lastName}"/>
      				<form:errors  class="text-danger"  path="lastName" />
    			</div>
  			</div>

			<h4 class="bg-info text-info">Username and Password</h4>
	        <div class="form-group">
    			<label class="control-label col-sm-2" for="email">Email @ UserName:</label>
			    <div class="col-sm-4">
      				<input class="form-control"  name="email"   placeholder="Please Enter Email" value="${bioUserForm.email}"/>
      				<form:errors  class="text-danger"  path="email" />
    			</div>
  			</div>
  			

	        <div class="form-group">
    			<label class="control-label col-sm-2" for="password1">Password:</label>
			    <div class="col-sm-4">
      				<input type = "password" class="form-control"  name="password1"   placeholder="Please Enter Password"/>
      				<form:errors  class="text-danger"  path="password1" />
    			</div>
  			</div>
  			
	        <div class="form-group">
    			<label class="control-label col-sm-2" for="password2">Confirm Password:</label>
			    <div class="col-sm-4">
      				<input type = "password" class="form-control"  name="password2"   placeholder="Please Confirm Password"/>
      				<form:errors  class="text-danger"  path="password2" />
    			</div>
  			</div>
  			
  			
  			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
     					<button type="submit" class="btn btn-info btn-default">Sign Up</button>
   				</div>
    		</div>
  			
        </form:form>
	


	
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "footer_bar.jsp" %></div>	
</div>  




</body> 