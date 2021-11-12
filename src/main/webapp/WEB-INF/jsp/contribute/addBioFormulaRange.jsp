<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>
 <script src="js/biomaterial.dynamic.measurement.input.js"></script>

<body>

	<div class="container">
		<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
		<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
		
				<c:choose>
				<c:when test="${not empty bioFormulaRangesForm.ranges  }">	
					<h2 class="text-info">Add Ranges to Variables in the  Formula </h2>
					<h5 class="text-success">${successMessage}</h5>
					<p>&nbsp;</p>
					
					<form:form  class="form-horizontal" action="addBioFormulaRanges"  method="post"  modelAttribute="bioFormulaRangesForm">
					
						<c:forEach var="range" items="${bioFormulaRangesForm.ranges}" varStatus="loop">
						<div class="row">
							<form:hidden path = "ranges[${loop.index}].variableId" value ="${range.variableId}"/>
							<form:hidden path = "ranges[${loop.index}].formulaId" value ="${range.formulaId}"/>
							<div class="form-group col-sm-3">&nbsp;</div>
							<div class="form-group col-sm-1">
						    	<form:label class="text-info"  path = "ranges[${loop.index}].variableSymbol">${range.variableSymbol}</form:label>
						    </div>
							<div class="form-group col-sm-2">
						    	<form:input class="form-control"  path = "ranges[${loop.index}].minRange" value = "${range.minRange}" placeholder="Minimum Range"/>
						    </div>
						    <div class="form-group col-sm-1">&nbsp;</div>
							<div class="form-group col-sm-2">
						    	<form:input class="form-control"  path = "ranges[${loop.index}].maxRange" value = "${range.maxRange}" placeholder="Maxumun Range"/> 
						    </div>
						    
						    <div class="form-group col-sm-3">&nbsp;</div>
						</div>	
						</c:forEach>
						
						
				<div class="form-group  row">
					<div class= "col-sm-5">&nbsp;</div>
		    		<div class= "col-sm-2"><button type="submit" class="btn btn-info">Add Ranges</button></div>
		    		<div class= "col-sm-5">&nbsp;</div>
				 </div> 		
						
						
						
				</form:form>
				</c:when>
				<c:otherwise>
					<h2 class="text-info">Formula is successfully saved. </h2>
				</c:otherwise>
				</c:choose>
				
		  
				
				
 		<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>

</body> 