<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	<h2 class="text-info">Point Input Contributions</h2>
	
	<!-- Obselete Page-->
	
	
	<!--  PAGER START -->
			
		<c:if test ="${measurementsSearchResultsForm.lastPage>0}">
			<p class="text-primary">
				Showing Page ${(measurementsSearchResultsForm.currentPage + 1)} of  ${measurementsSearchResultsForm.lastPage} 
			</p>
	
		<form:form  action="myPointInputs"  method="post"  modelAttribute="measurementsSearchResultsForm" >
			
			<button type="submit" name="pageNumber"  value = "0" class="btn btn-default  btn-xs">Start</button>
			<c:if test="${(measurementsSearchResultsForm.currentPage) ne 0}">
				<button type="submit" name="pageNumber"  value = "${measurementsSearchResultsForm.currentPage-1}" class="btn btn-default btn-xs">Prev</button>
			</c:if>
			
					
			<c:forEach var="i" begin="${measurementsSearchResultsForm.pagerStart}" end="${measurementsSearchResultsForm.pagerEnd -1}" >
				<c:choose>
		         <c:when test = "${i eq measurementsSearchResultsForm.currentPage}">
					<button type="button" name="pageNumber"  value = "${i}" class="btn btn-info btn-xs">${i+1 }</button>
		         </c:when>
		         <c:otherwise>
		            <button type="submit" name="pageNumber"  value = "${i}" class="btn btn-default btn-xs">${i+1 }</button>
		         </c:otherwise>
		      </c:choose>
			</c:forEach>
			
			<c:if test="${(measurementsSearchResultsForm.currentPage) ne (measurementsSearchResultsForm.pagerEnd -1)}">
				<button type="submit" name="pageNumber"  value = "${bioMaterialSearchResultsForm.currentPage + 1}" class="btn btn-default  btn-xs">Next</button>
			</c:if>
			
			<button type="submit" name="pageNumber"  value = "${measurementsSearchResultsForm.lastPage-1}" class="btn btn-default  btn-xs">Last Page</button>
			
		</form:form>
		</c:if>
	<!--  PAGER END -->
		
		
	
	
	
	
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Material </th>
        <th>Variable</th>
        <th>Measured Value</th>
        <th>Error Value</th>
        <th>Status</th>
        <th>&nbsp;</th>
      </tr>

    </thead>
    <tbody>
    <c:forEach var="bioMeasurement" items="${measurementsSearchResultsForm.bioMeasurements}">
      <tr>
        <td>${fn:substring(bioMeasurement.bioMaterial.shortDesc, 0, 20)}</td>
        <td>${bioMeasurement.bioVariable.name}</td>
        <td>${bioMeasurement.measuredValue}</td>
        <td>${bioMeasurement.errorValue}</td>
        <td>
        	<c:choose>
        		<c:when test="${bioMeasurement.isApproved eq 0}">
        			Pending
        		</c:when>
        		<c:otherwise>
        			Approved
        		</c:otherwise>
        		
        	</c:choose>
        	
        </td>
        
        <td>
		    <button type="button" class="btn btn-default disabled">
		      <span class="glyphicon glyphicon-search" data-toggle="modal" data-target="#id_${bioMaterial.id}"></span> Details
		    </button>
		    <c:choose>
		    	<c:when test="${bioMaterial.usdaId gt 0}">
			     <a href="" role="button" class="btn btn-default disabled">
			    	  <span class="glyphicon glyphicon-edit"></span> Edit
			     </a>
			     </c:when>
			     <c:otherwise>
				     <a href=""  role="button" class="btn btn-default disabled ">
				    	  <span class="glyphicon glyphicon-edit"></span> Edit
				     </a>
			     </c:otherwise>
			 </c:choose> 
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
	

	
<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  




</body> 