<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body onload="changeColor()">

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
			
			<h2 class="text-info">Save Grouping Of Bio-Materials</h2>
			<h5 class="text-success">${successMessage}</h5>
			<p>&nbsp;</p>
	

			<form:form  class="form-horizontal"  action="addBioMaterialForGrouping"  method="post"  modelAttribute="bioMaterialSearchForm" >
			
				<div class="form-group">
			    	<form:label class="text-info col-sm-2" path = "selectedBioMaterial">Chosen Materials</form:label>
				    <div class="col-sm-10">
				          <c:forEach var="bioMaterial" items="${bioMaterialSearchResultsForm.selectedBioMaterial}">
				          <tr>
				          	<td><div class="col-sm-10">${bioMaterial.shortDesc}<button class="crossButton" id="btnDeleteid" name="btnDeletename">&times;</button><br><br><form:hidden path="id" value="${bioMaterial.id}"/><form:hidden path="selectedBioMaterial" value="${bioMaterial.id}" /></div></td>
				          </tr>			          
						  </c:forEach>
				      
				      <form:errors  class="text-danger"  path="selectedBioMaterial" />
				    </div>
			   </div>			     		
				<div class="form-group">
			    	<form:label class="text-info col-sm-2" path = "groupName" >Name Of Grouping</form:label>
				    <div class="col-sm-6">
				    		<input type="hidden" name="groupIds" value="${groupId}"/>
				      		<form:input type="text" class="form-control" path = "groupName" placeholder="Please enter bio-material grouping name" id="groupName" onkeyup="typeName()"/>			      
				      <form:errors  class="text-danger"  path="groupName" />
				    </div>			    			    			    
					<button style="font-size:x-large" type="button" class="collapsible" title="Expand The Group">&#65291;</button>
					<div class="col-sm-10">
					    <div class="content scroll" id="materialNameList"></div>	
			   		</div>
			   <p>&nbsp;</p>		   			
	           <div class="form-group row">
			  		<div class="col-sm-offset-4 col-sm-2">
						     <button type="submit" class="btn btn-info">Save Group</button>
				     </div>
			   </div>
			   </div>
		</form:form>		
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  
<script>
var coll = document.getElementsByClassName("collapsible");
var i;
for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
</script>
</body> 
