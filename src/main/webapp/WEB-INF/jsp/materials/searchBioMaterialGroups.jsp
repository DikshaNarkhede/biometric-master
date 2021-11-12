<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
			
	<h4 class="text-info">Search Bio Material Group</h4>
	<h5 class="text-danger">${bioMaterialSearchForm.message}</h5>
	<p>&nbsp;</p>
<h4 class="text-info" id="response"></h4>


	<form:form  action="searchBioMaterialGroups"  method="post"  modelAttribute="bioMaterialSearchForm" >
	    <div class="form-group  row">
	    	<div class= "col-sm-10">
		      <form:input class="form-control"  path="groupName"   placeholder="Enter Bio-Group Name"/>
		      <form:errors  class="text-danger"  path="groupName" />
		    </div>
		    <div class ="col-sm-2">
		      <button type="submit" class="btn btn-info">Search</button>
		    </div>
		 </div> 		
	 </form:form>	
	
	
<c:choose>
  <c:when test="${!empty listOfGroup}">
  <hr/>
	<h4 class="text-info">Group's containing text : ${bioMaterialSearchForm.groupName} </h4>
	<table class="table table-hover table-striped">
	    <thead>
	      <tr>
	        <th>Group Name</th>
	        <th>&nbsp;</th>
	        <th>&nbsp;</th>
	        <th>&nbsp;</th>
	        <th>&nbsp;</th>
	      </tr>
	    </thead>
	    <tbody>
			<c:forEach var="bioGroup" items="${listOfGroup}">
				<tr class="listing" id = "deleteGrp${bioGroup.id}">
   					<td>${bioGroup.groupName}</td>
   					 <td>&nbsp;</td>
	                 <td>&nbsp;</td>
	                 <td>&nbsp;</td>
	                 <td>&nbsp;</td>
   					<td>
			     		
			     		<button type="button" class="btn btn-default clickedOpenPopup" id="clickedOpenPopup">
		      				<span class="glyphicon glyphicon-search"></span> Details
		    			</button>&nbsp;&nbsp;&nbsp;<input type="hidden" value="${bioGroup.id}" name="groupId" id="groupId"/>
		    			<%-- <a href="javascript:void(0);" onclick="getReport(&quot;${bioGroup.id}&quot;); return false;" role="button" class="btn btn-default "> --%>
			     		<a href="selectionOfMaterialOrGroup?groupId=${bioGroup.id}" role="button" class="btn btn-default ">
			    	  		<span class="glyphicon glyphicon-edit"></span> Edit
			     		</a>&nbsp;&nbsp;&nbsp;
			     		<a href="deleteGroupUsingGroupId?groupId=${bioGroup.id}&groupName=${bioMaterialSearchForm.groupName}" role="button" class="btn btn-info">
			    	  		Delete
			     		</a>
			     		<!-- <button type="button" class="btn btn-info deleteGroup" id="deleteGroup">
		      				Delete
		    			</button> -->
		     		</td>
   					
  				</tr>	
			</c:forEach>
		</tbody>
	</table>
	<div id="load_more">Load More Group</div>
	</c:when>	
	</c:choose>
	  	<!-- DETAILS POPUP START -->
	
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg" role="document" >
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Bio-Material Group Details</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <table class="table table-striped" id="dynamicMaterialName">
				</Table>
				<div >
				<p id="errorMsg"></p>
				<table class="table table-striped">
				<thead>
				<tr class="abc">
				<th><button id="btn1" type="button" class="buttonInactive">
                &#65291;&nbsp;&nbsp;&nbsp;&nbsp;</button>Materials</th>
				</tr>
				</thead>
				<tbody id="materialName">
				
				</tbody>
				</table>
				</div>
		        
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
	    </div>
	<!-- DETAILS POPUP END -->
	
	
	
	
	
	
	
	
	
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  
</body> 
