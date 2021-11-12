<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	<h2 class="text-info">Search Results Of Grouped</h2>
	<h5 class="text-success">${bioMaterialSearchResultsForm.message}</h5>
	
	<form:form action="addMaterialInExstingGroup"  method="post"  modelAttribute="bioMaterialSearchForm">
	<form:hidden  value= "${bioMaterialSearchResultsForm.bioMaterialSearchForm.bioMaterialName}" path="bioMaterialName"/>				
	
		<table class="table table-hover">
		    <thead>
		      	<tr>
		        <th>Group Name</th>
		        <th>Select Bio Group</th>
		      </tr>
		    </thead>
		    <tbody>
		    <c:forEach var="group" items="${bioMaterialSearchResultsForm.bioGrouping}">
		      <tr class="listing">
		        <td>${group.groupName}</td>
		        <td>
				    <form:checkbox id="${group.id}" path="groupName" value="${group.id}" class="btn btn-default materialGroupList"/>		       
		        </td>
		      </tr>
		      </c:forEach>
		    </tbody>		   
		  </table>
		  <div id="load_more" style="align:left">
                           Load More
          </div>
  	<button type="submit" class="btn btn-info">Add Material</button>
  </form:form>
  <div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>
	
</body>
 