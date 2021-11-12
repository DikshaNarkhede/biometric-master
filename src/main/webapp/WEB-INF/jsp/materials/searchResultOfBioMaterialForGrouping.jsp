<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	<h2 class="text-info">Search Results For Grouping Of Bio-Materials</h2>
	<h5 class="text-success">${bioMaterialSearchResultsForm.message}</h5>
	
	<h5 class="text-primary">
		Bio-Materials containing text: <b>${bioMaterialSearchResultsForm.bioMaterialSearchForm.bioMaterialName }</b>
	</h5>
	
		<form:form  action="saveBioMaterialsForGrouping"  method="post"  modelAttribute="bioMaterialSearchForm" >
			<form:hidden  value= "${bioMaterialSearchResultsForm.bioMaterialSearchForm.bioMaterialName}" path="bioMaterialName"/>
			<form:hidden  value= "${bioMaterialSearchResultsForm.bioMaterialSearchForm.process}" path="process"/>
			<form:hidden  value= "${bioMaterialSearchResultsForm.bioMaterialSearchForm.form}" path="form"/>
			<table class="table table-hover">
    		<thead>
      		<tr>
        		<th>Short Desc</th>
        		<th><input type="checkbox" onClick="selectTop50(this)" /> Select Top 50 Bio-Material</th>
        		<th>&nbsp;</th>
      		</tr>
    		</thead>
	    	<tbody>
			    <c:forEach var="bioMaterial" items="${bioMaterialSearchResultsForm.bioMaterials}">
			      <tr class="listing">
			        <td>${bioMaterial.longDesc}</td>
			        <td>
					    <form:checkbox id="${bioMaterial.id}" path="selectedBioMaterial" value="${bioMaterial.id}" class="btn btn-default"/>					      
			        </td>
			      </tr>
			    </c:forEach>
	    	</tbody>
   
  			</table>
			<input type="hidden" name="groupName" value="${groupName}"/>
			<input type="hidden" name="id" value="${groupId}"/>     
			<div id="load_more" style="align:left">
                           Load More
           </div>   
			<button type="submit" class="btn btn-info">Save Grouping</button>				
	 				
		</form:form>
	
<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  
</body> 