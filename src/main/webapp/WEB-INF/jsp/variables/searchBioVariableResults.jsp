<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	<h2 class="text-info">Search Results for Bio-Variable</h2>
	
	<h5 class="text-primary">
		Bio-Variables containing text: <b>${bioVariableSearchResultsForm.bioVariableSearchForm.name}</b>
	</h5>
		
	
	<c:if test ="${bioVariableSearchResultsForm.lastPage>0}">
		<p class="text-primary">
			Showing Page ${(bioVariableSearchResultsForm.currentPage + 1)} of  ${bioVariableSearchResultsForm.lastPage} 
		</p>
	
		<!--  PAGER START -->
		<form:form  action="./searchBioVariables"  method="post"  modelAttribute="bioVariableSearchForm" >
			<form:hidden  value= "${bioVariableSearchResultsForm.bioVariableSearchForm.name }" path="name"/>
			
			<button type="submit" name="pageNumber"  value = "0" class="btn btn-default  btn-xs">Start</button>
			<c:if test="${(bioVariableSearchResultsForm.currentPage) ne 0}">
				<button type="submit" name="pageNumber"  value = "${bioVariableSearchResultsForm.currentPage-1}" class="btn btn-default btn-xs">Prev</button>
			</c:if>
			
					
			<c:forEach var="i" begin="${bioVariableSearchResultsForm.pagerStart}" end="${bioVariableSearchResultsForm.pagerEnd -1}" >
				<c:choose>
		         <c:when test = "${i eq bioVariableSearchResultsForm.currentPage}">
					<button type="button" name="pageNumber"  value = "${i}" class="btn btn-info btn-xs">${i+1 }</button>
		         </c:when>
		         <c:otherwise>
		            <button type="submit" name="pageNumber"  value = "${i}" class="btn btn-default btn-xs">${i+1 }</button>
		         </c:otherwise>
		      </c:choose>
			</c:forEach>
			
			<c:if test="${(bioVariableSearchResultsForm.currentPage) ne (bioVariableSearchResultsForm.pagerEnd -1)}">
				<button type="submit" name="pageNumber"  value = "${bioVariableSearchResultsForm.currentPage + 1}" class="btn btn-default  btn-xs">Next</button>
			</c:if>
			
			<button type="submit" name="pageNumber"  value = "${bioVariableSearchResultsForm.lastPage-1}" class="btn btn-default  btn-xs">Last Page</button>
			
		</form:form>
		<!--  PAGER END -->
		
	</c:if>



	
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Name</th>
        <th>Desc</th>
        <th>Symbol</th>
        <th>UOM</th>
        <th>&nbsp;</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="bioVariable" items="${bioVariableSearchResultsForm.bioVariables}">
      <tr>
        <td>${bioVariable.name}</td>
        <td>${fn:substring(bioVariable.description, 0, 20)}</td>
        <td>${bioVariable.symbol}</td>
        <td>${bioVariable.uom}</td>
        <td>
		    <button type="button" class="btn btn-default">
		      <span class="glyphicon glyphicon-search" data-toggle="modal" data-target="#id_${bioVariable.id}"></span> Details
		    </button>
		    <a href="updateBioVariable?variableId=${bioVariable.id}" role="button" class="btn btn-default ">
				<span class="glyphicon glyphicon-edit"></span> Edit
			</a>
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  
  
  	<!-- DETAILS POPUP START -->
	<c:forEach var="bioVariable" items="${bioVariableSearchResultsForm.bioVariables}">
		<div class="modal fade" id="id_${bioVariable.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg" role="document" >
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Bio-Variable Details</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <table class="table table-striped">
		        	<TR>
					  <td>ID</td>
					  <td>${bioVariable.id}</td>
					  </TR>
					  
					  <TR>
						  <td>Name</td>
						  <td>${bioVariable.name}</td>
					  </TR>
					   <TR>
						  <td>Desc</td>
						  <td>${bioVariable.description}</td>
					  </TR>	  
					  
					   <TR>
						  <td>SI Unit</td>
						  <td>${bioVariable.symbol}</td>
					  </TR>	  
					  
					   <TR>
						  <td>UOM</td>
						  <td>${bioVariable.uom}</td>
					  </TR>	  
					
					   <TR>
						  <td>Added by</td>
						  <td>${bioVariable.addedBy}</td>
					  </TR>	  

					   <TR>
						  <td>Last Updated By</td>
						  <td>${bioVariable.updatedBy}</td>
					  </TR>	  
					   <TR>
						  <td>Initially Created at</td>
						  <td>${bioVariable.createdAt}</td>
					  </TR>
					  <TR>
						  <td>Last Upadted at</td>
						  <td>${bioVariable.updatedAt}</td>
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