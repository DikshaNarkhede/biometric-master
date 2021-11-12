<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
			
			<h2 class="text-info">Find Bio-Variables</h2>
			<p>&nbsp;</p>
	

			<form:form  action="./searchBioVariables"  method="post"  modelAttribute="bioVariableSearchForm" >
			
			    <div class="form-group">
			      <form:label class="text-info" path = "name">Bio-Variable Name</form:label>
			      <form:input class="form-control"  value ="${bioVariableSearchForm.name}" path="name"   placeholder="Enter Partial or full Bio-Variable Name"/>
			      <form:errors  class="text-danger"  path="name" />
			    </div>
				<button type="submit" class="btn btn-info">Search</button>
			
			  </form:form>	
			
	


	
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  




</body> 