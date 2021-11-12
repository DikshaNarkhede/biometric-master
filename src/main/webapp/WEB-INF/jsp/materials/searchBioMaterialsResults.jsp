<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	<h2 class="text-info">Search Results for Bio-Materials</h2>
	
	<h5 class="text-primary">
		Bio-Materials containing text: <b>${bioMaterialSearchResultsForm.bioMaterialSearchForm.bioMaterialName }</b>
	</h5>
		
	<h5 class="text-primary">
		Database Search: 
	</h5>
	
	<c:if test ="${bioMaterialSearchResultsForm.lastPage>0}">
		<p class="text-primary">
			Showing Page ${(bioMaterialSearchResultsForm.currentPage + 1)} of  ${bioMaterialSearchResultsForm.lastPage} 
		</p>
	
		<!--  PAGER START -->
		<form:form  action="searchBioMaterials"  method="post"  modelAttribute="bioMaterialSearchForm" >
			<form:hidden  value= "${bioMaterialSearchResultsForm.bioMaterialSearchForm.bioMaterialName }" path="bioMaterialName"/>
			
			
			<button type="submit" name="pageNumber"  value = "0" class="btn btn-default  btn-xs">Start</button>
			<c:if test="${(bioMaterialSearchResultsForm.currentPage) ne 0}">
				<button type="submit" name="pageNumber"  value = "${bioMaterialSearchResultsForm.currentPage-1}" class="btn btn-default btn-xs">Prev</button>
			</c:if>
			
					
			<c:forEach var="i" begin="${bioMaterialSearchResultsForm.pagerStart}" end="${bioMaterialSearchResultsForm.pagerEnd -1}" >
				<c:choose>
		         <c:when test = "${i eq bioMaterialSearchResultsForm.currentPage}">
					<button type="button" name="pageNumber"  value = "${i}" class="btn btn-info btn-xs">${i+1 }</button>
		         </c:when>
		         <c:otherwise>
		            <button type="submit" name="pageNumber"  value = "${i}" class="btn btn-default btn-xs">${i+1 }</button>
		         </c:otherwise>
		      </c:choose>
			</c:forEach>
			
			<c:if test="${(bioMaterialSearchResultsForm.currentPage) ne (bioMaterialSearchResultsForm.pagerEnd -1)}">
				<button type="submit" name="pageNumber"  value = "${bioMaterialSearchResultsForm.currentPage + 1}" class="btn btn-default  btn-xs">Next</button>
			</c:if>
			
			<button type="submit" name="pageNumber"  value = "${bioMaterialSearchResultsForm.lastPage-1}" class="btn btn-default  btn-xs">Last Page</button>
			
		</form:form>
		<!--  PAGER END -->
		
	</c:if>



	
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Short Desc</th>
        <th>Citation</th>
        <th>&nbsp;</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="bioMaterial" items="${bioMaterialSearchResultsForm.bioMaterials}">
      <tr>
        <td>${bioMaterial.shortDesc}</td>
        <td>${fn:substring(bioMaterial.citation, 0, 20)}</td>
        <td>
		    <button type="button" class="btn btn-default">
		      <span class="glyphicon glyphicon-search" data-toggle="modal" data-target="#id_${bioMaterial.id}"></span> Details
		    </button>
		  <!--   
		   	<a href="graphBioMaterial?materialId=${bioMaterial.id}" role="button" class="btn btn-default ">
		    	  <span class="glyphicon glyphicon-stats"></span> Graph
		     </a>
		    -->
		    
		     <a href="updateBioMaterial?materialId=${bioMaterial.id}" role="button" class="btn btn-default ">
		    	  <span class="glyphicon glyphicon-edit"></span> Edit
		     </a>
		    
		    
		    
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
	
	<!-- DETAILS POPUP START -->
	<c:forEach var="bioMaterial" items="${bioMaterialSearchResultsForm.bioMaterials}">
		<div class="modal fade" id="id_${bioMaterial.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg" role="document" >
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Bio-Material Details</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <table class="table table-striped">
		        	<TR>
					  <td>ID</td>
					  <td>${bioMaterial.id}</td>
					  </TR>
					  
					
					  <TR>
						  <td>Short Desc</td>
						  <td>${bioMaterial.shortDesc}</td>
					  </TR>
					   <TR>
						  <td>Long Desc</td>
						  <td>${bioMaterial.longDesc}</td>
					  </TR>	  
					  
					   <TR>
						  <td>Common Name</td>
						  <td>${bioMaterial.commonName}</td>
					  </TR>	  
					  	  
					   <TR>
						  <td>Mfg Name</td>
						  <td>${bioMaterial.mfgName}</td>
					  </TR>	  
					   <TR>
						  <td>usdaSurvey</td>
						  <td>${bioMaterial.usdaSurvey}</td>
					  </TR>	  
					
					   <TR>
						  <td>Refuse Desc</td>
						  <td>${bioMaterial.refuseDesc}</td>
					  </TR>	  

					   <TR>
						  <td>Refuse Percentage</td>
						  <td>${bioMaterial.refusePercentage}</td>
					  </TR>	  
					   <TR>
						  <td>Scientific Name</td>
						  <td>${bioMaterial.scientificName}</td>
					  </TR>	  
					   <TR>
						  <td>Factors</td>
						  <td>nFactor: ${bioMaterial.nFactor}&nbsp;&nbsp;pFactor: ${bioMaterial.pFactor}&nbsp;&nbsp;fFactor: ${bioMaterial.fFactor}&nbsp;&nbsp;choFactor: ${bioMaterial.choFactor}</td>
					  </TR>	  
					   <TR>
						  <td>Citation</td>
						  <td><textArea readOnly rows ="5"  cols="100">${bioMaterial.citation}</textArea></td>
					  </TR>	  
				</Table>
				
		        
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
	    </div>
	</c:forEach>
	
	<!-- DETAILS POPUP END -->
	
	





	
<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  




</body> 