<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
			
			<h2 class="text-info">Find Bio-Materials</h2>
			<p>&nbsp;</p>
	

			<form:form  action="searchBioMaterials"  method="post"  modelAttribute="bioMaterialSearchForm" >
			
			    <div class="form-group">
			      <form:label class="text-info" path = "bioMaterialName">Bio-Material Name</form:label>
			      <form:input class="form-control"  value ="${bioMaterialSearchForm.bioMaterialName}" path="bioMaterialName"   placeholder="Enter Partial or full Bio-Material Name"/>
			      <form:errors  class="text-danger"  path="bioMaterialName" />
			    </div>
			    <!-- 
			    <div class="form-group">
			       <form:radiobutton class="text-info" path = "usdaOnly" value = "u"/>
			       <form:label class="text-info" path = "usdaOnly">USDA Data Only</form:label>
			    </div>
			    <div class="form-group">
                  <form:radiobutton class="text-info" path = "usdaOnly" value = "a"/>
                  <form:label class="text-info" path = "usdaOnly">All (Includes Contributed Data)</form:label>
      			</div>
      			-->
				<button type="submit" class="btn btn-info">Search</button>
			 
			  </form:form>	
			
	


	
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  




</body> 