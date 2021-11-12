<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
			
	<h4 class="text-info">Search Bio-Formula</h4>
	<p>&nbsp;</p>


	<form:form  action="./searchBioFormula"  method="post"  modelAttribute="bioFormulaSearchForm" >
	    <div class="form-group  row">
	    	<div class= "col-sm-10">
		      <form:input class="form-control"  value ="${bioFormulaSearchForm.searchString}" path="searchString"   placeholder="Enter Partial Bio-Formula Name or Description"/>
		      <form:errors  class="text-danger"  path="searchString" />
		    </div>
		    <div class ="col-sm-2">
		      <button type="submit" class="btn btn-info">Search</button>
		    </div>
		 </div> 		
	 </form:form>	
	<hr/>
	

	<h4 class="text-info">Formula's containing text : ${bioFormulaSearchForm.searchString} </h4>
	<table class="table table-hover table-striped">
	    <thead>
	      <tr>
	        <th>Name</th>
	        <th>Formula</th>
	        <th>Description</th>
	        <th>Citation</th>
	        <th>&nbsp;</th>
	      </tr>
	    </thead>
	    <tbody>
			<c:forEach var="bioFormula" items="${bioFormulaSearchForm.bioFormulaList}">
				<tr>
   					<td>${bioFormula.name}</td>
   					<td>${bioFormula.formula}</td>
   					<td>${fn:substring(bioFormula.formulaDesc, 0, 40)}</td>
   					<td>${fn:substring(bioFormula.citation, 0, 40)}</td>
   					<td>
			     		
			     		<button type="button" class="btn btn-default">
		      				<span class="glyphicon glyphicon-search" data-toggle="modal" data-target="#id_${bioFormula.id}"></span> Details
		    			</button>
		    			<a href="editBioFormula?formulaId=${bioFormula.id}" role="button" class="btn btn-default ">
			    	  		<span class="glyphicon glyphicon-edit"></span> Edit
			     		</a>
		     		</td>
   					
  				</tr>	
			</c:forEach>
		</tbody>
	</table>	
	
	
	
	
	
	  	<!-- DETAILS POPUP START -->
	<c:forEach var="bioFormula" items="${bioFormulaSearchForm.bioFormulaList}">
		<div class="modal fade" id="id_${bioFormula.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg" role="document" >
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Bio-Formula Details</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <table class="table table-striped">
		        	<TR>
					  <td>ID</td>
					  <td>${bioFormula.id}</td>
					  </TR>
					  
					  <TR>
						  <td>Name</td>
						  <td>${bioFormula.name}</td>
					  </TR>
					   <TR>
						  <td>Formula</td>
						  <td>${bioFormula.formula}</td>
					  </TR>	  
					  <TR>
						  <td>Variable (Y-Axis)</td>
						  <td>${bioFormula.bioVariable.symbol}&nbsp;-&nbsp;${bioFormula.bioVariable.name}</td>
					  </TR>	  
					  
					   <TR>
						  <td>Desc</td>
						  <td>${bioFormula.formulaDesc}</td>
					  </TR>	  
					  
					   <TR>
						  <td>Citation</td>
						  <td>${bioFormula.citation}</td>
					  </TR>	  
					   <TR>
						  <td>DOI</td>
						  <td>${bioFormula.doi}</td>
					  </TR>	  
					
					   <TR>
						  <td>Added by</td>
						  <td>${bioFormula.addedBy}</td>
					  </TR>	  

					   <TR>
						  <td>Last Updated By</td>
						  <td>${bioFormula.updatedBy}</td>
					  </TR>	  
					   <TR>
						  <td>Initially Created at</td>
						  <td>${bioFormula.createdAt}</td>
					  </TR>
					  <TR>
						  <td>Last Upadted at</td>
						  <td>${bioFormula.updatedAt}</td>
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