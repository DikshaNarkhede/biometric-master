<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>
<script src="js/bioDiscreetData.dynamic.select.list.js"></script>l
<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	<h2 class="text-info">Show DiscreetData</h2>
	
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Material</th>
        <th>Author Name</th>
        <th>Year</th>
        <th>Variable</th>
        <th>Dependent Variable 1</th>
        <th>Dependent Variable 2</th>
        <th>Dependent Variable 3</th>
        <th>Dependent Variable 4</th>
        <th>Dependent Variable 5</th>
        <th>Dependent Variable 6</th>
        <th>Dependent Variable 7</th>
        
        <th>Dependent Variable 8</th>
        <th>Dependent Variable 9</th>
        <th>Dependent Variable 10</th>
        <th>Value</th>
        <th>Dependent Value 1</th>
        <th>Dependent Value 2</th>
        <th>Dependent Value 3</th>
        <th>Dependent Value 4</th>
        <th>Dependent Value 5</th>
        <th>Dependent Value 6</th>
        <th>Dependent Value 7</th>
        
        <th>Dependent Value 8</th>
        <th>Dependent Value 9</th>
        <th>Dependent Value 10</th>
        
        <th>&nbsp;</th>
      </tr>
    </thead>
     
    <tbody>
   
    <c:forEach var="bioDiscreetData" items="${showBioDiscreetDataForm.bioDiscreetDatas}">
      <tr>
        <td>${bioDiscreetData.bioMaterial.shortDesc}</td>
        
        <td>${bioDiscreetData.authorName}</td>
        <td>${bioDiscreetData.year}</td>
        
        
        <c:if test="${(bioDiscreetData.yVariableId) ne 0}">
        	<td>${bioDiscreetData.yBioVariable.name}</td>
		</c:if>
		
		<c:choose>
    		<c:when test="${(bioDiscreetData.aVariableId) ne 0}">
        		<td>${bioDiscreetData.aBioVariable.name}</td>
    		</c:when>    
    	<c:otherwise>
        		<td></td>
    	</c:otherwise>
		</c:choose>
		<c:choose>
    		<c:when test="${(bioDiscreetData.bVariableId) ne 0}">
        		<td>${bioDiscreetData.bBioVariable.name}</td>
    		</c:when>    
    	<c:otherwise>
        		<td></td>
    	</c:otherwise>
		</c:choose>
		
		<c:choose>
    		<c:when test="${(bioDiscreetData.cVariableId) ne 0}">
        		<td>${bioDiscreetData.cBioVariable.name}</td>
    		</c:when>    
    	<c:otherwise>
        		<td></td>
    	</c:otherwise>
		</c:choose>
		
		<c:choose>
    		<c:when test="${(bioDiscreetData.dVariableId) ne 0}">
        		<td>${bioDiscreetData.dBioVariable.name}</td>
    		</c:when>    
    	<c:otherwise>
        		<td></td>
    	</c:otherwise>
		</c:choose>
		
		<c:choose>
    		<c:when test="${(bioDiscreetData.eVariableId) ne 0}">
        		<td>${bioDiscreetData.eBioVariable.name}</td>
    		</c:when>    
    	<c:otherwise>
        		<td></td>
    	</c:otherwise>
		</c:choose>
		
		<c:choose>
    		<c:when test="${(bioDiscreetData.fVariableId) ne 0}">
        		<td>${bioDiscreetData.fBioVariable.name}</td>
    		</c:when>    
    	<c:otherwise>
        		<td></td>
    	</c:otherwise>
		</c:choose>
		
		<c:choose>
    		<c:when test="${(bioDiscreetData.gVariableId) ne 0}">
        		<td>${bioDiscreetData.gBioVariable.name}</td>
    		</c:when>    
    	<c:otherwise>
        		<td></td>
    	</c:otherwise>
		</c:choose>
		
		<c:choose>
    		<c:when test="${(bioDiscreetData.hVariableId) ne 0}">
        		<td>${bioDiscreetData.hBioVariable.name}</td>
    		</c:when>    
    	<c:otherwise>
        		<td></td>
    	</c:otherwise>
		</c:choose>
		
		<c:choose>
    		<c:when test="${(bioDiscreetData.iVariableId) ne 0}">
        		<td>${bioDiscreetData.iBioVariable.name}</td>
    		</c:when>    
    	<c:otherwise>
        		<td></td>
    	</c:otherwise>
		</c:choose>
		
		<c:choose>
    		<c:when test="${(bioDiscreetData.jVariableId) ne 0}">
        		<td>${bioDiscreetData.jBioVariable.name}</td>
    		</c:when>    
    	<c:otherwise>
        		<td></td>
    	</c:otherwise>
		</c:choose>
        <td>${bioDiscreetData.yValue}</td>
        <td>${bioDiscreetData.aValue}</td>
        <td>${bioDiscreetData.bValue}</td>
        <td>${bioDiscreetData.cValue}</td>
        <td>${bioDiscreetData.dValue}</td>
        <td>${bioDiscreetData.eValue}</td>
        <td>${bioDiscreetData.fValue}</td>
        <td>${bioDiscreetData.gValue}</td>
        <td>${bioDiscreetData.hValue}</td>
        <td>${bioDiscreetData.iValue}</td>
        <td>${bioDiscreetData.jValue}</td>
        <td >
            <form action="deleteDiscreetData" method="post">
                  <input type="hidden" name="id" value="${bioDiscreetData.id}" />
                  <input type="submit" value="Delete" id = "delete-button" class="btn btn-info" />
              </form>
        </td>
      </tr>
      </c:forEach>
    </tbody>
     
  </table>
  
  
	
<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  

</body> 