<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
		
		<p>&nbsp;</p>	
		<h5 class="text-info">Update Bio-Variable - ${bioVariable.id} - ${bioVariable.name} - Last Updated By: ${bioVariable.updatedBy} - Last Updated at: ${bioVariable.updatedAt}</h2>
		<h5 class="text-success">${message}</h2>
		<p>&nbsp;</p>


		<form:form  class="form-horizontal" action="./updateBioVariable"  method="post"  modelAttribute="bioVariable">
			<form:hidden  value= "${bioVariable.id}" path="id"/>
			
		    <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "Name">Name</form:label>
			    <div class="col-sm-10"> 
			      <form:input class="form-control" path = "name"  value ="${bioVariable.name}" />
			      <form:errors  class="text-danger"  path="name" />
			    </div>
		   </div>
  
		    <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "description">Desc</form:label>
			    <div class="col-sm-10"> 
			      <form:input class="form-control" path = "description"  value ="${bioVariable.description}" />
			    </div>
		   </div>
		    
		   <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "uom">UOM</form:label>
			    <div class="col-sm-10"> 
			      <form:input class="form-control" path = "uom"  value ="${bioVariable.uom}" />
			    </div>
		   </div>
		   
		   <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "symbol">Symbol</form:label>
			    <div class="col-sm-10"> 
			      <form:input class="form-control" path = "symbol"  value ="${bioVariable.symbol}" />
			    </div>
		   </div>
		   
		   
			<button type="submit" class="btn btn-info">Update</button>
		
		  </form:form>	
	


	
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  




</body> 