<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
		
		<p>&nbsp;</p>	
		<h3 class="bg-info text-info">Contribute Your Bio-Material ... </h3>
		<h5 class="text-success">${successMessage}</h5>
		<p>&nbsp;</p>

		
		<form:form  class="form-horizontal" action="addBioMaterial"  method="post"  modelAttribute="bioMaterial">
			<form:hidden  value= "${bioMaterial.id}" path="id" />
			<%-- <form:hidden  value= "${bioMaterial.usdaId}" path="usdaId" /> --%>
		    <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "shortDesc">Short Desc</form:label>
			    <div class="col-sm-10">
			      <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
			      		<form:input class="form-control" path = "shortDesc"  value ="${bioMaterial.shortDesc}" disabled ="true"/>
			      	</c:when>
			      	<c:otherwise>
			      		<form:input class="form-control" path = "shortDesc"  value ="${bioMaterial.shortDesc}" />
			      	</c:otherwise>
			      </c:choose>
			      
			      <form:errors  class="text-danger"  path="shortDesc" />
			    </div>
		   </div>
  
		    <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "longDesc">Long Desc</form:label>
			    <div class="col-sm-10"> 
			      
			      
			      <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
			      		<form:input class="form-control" path = "longDesc"  value ="${bioMaterial.longDesc}" disabled ="true"/>
			      	</c:when>
			      	<c:otherwise>
			      		<form:input class="form-control" path = "longDesc"  value ="${bioMaterial.longDesc}" />
			      	</c:otherwise>
			      </c:choose>
			      
			      
			    </div>
		   </div>
		    
		   <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "commonName">Common Name</form:label>
			    <div class="col-sm-10"> 

			      <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
					      <form:input class="form-control" path = "commonName"  value ="${bioMaterial.commonName}" disabled ="true"/>
			      	</c:when>
			      	<c:otherwise>
					      <form:input class="form-control" path = "commonName"  value ="${bioMaterial.commonName}" />
			      	</c:otherwise>
			      </c:choose>

			      
			    </div>
		   </div>
		   
		   <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "mfgName">Mfg Name</form:label>
			    <div class="col-sm-10">
			    
			    
			      <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
					     <form:input class="form-control" path = "mfgName"  value ="${bioMaterial.mfgName}" disabled ="true"/>
			      	</c:when>
			      	<c:otherwise>
					      <form:input class="form-control" path = "mfgName"  value ="${bioMaterial.mfgName}" />
			      	</c:otherwise>
			      </c:choose>
			    
			     
			      
			    </div>
		   </div>
		   
		   <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "refuseDesc">Refuse Desc</form:label>
			    <div class="col-sm-10"> 
			      
			      
			      <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
					     <form:input class="form-control" path = "refuseDesc"  value ="${bioMaterial.refuseDesc}"  disabled ="true"/>
			      	</c:when>
			      	<c:otherwise>
					      <form:input class="form-control" path = "refuseDesc"  value ="${bioMaterial.refuseDesc}" />
			      	</c:otherwise>
			      </c:choose>
			      
			      
			    </div>
		   </div>
		   
		   <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "refusePercentage">Refuse %</form:label>
			    <div class="col-sm-10">
			    
			      <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
					     <form:input class="form-control" onkeypress="return isNumericKey(event)"  path = "refusePercentage"  value ="${bioMaterial.refusePercentage}"  disabled ="true"/>
			      	</c:when>
			      	<c:otherwise>
					      <form:input class="form-control" onkeypress="return isNumericKey(event)"  path = "refusePercentage"  value ="${bioMaterial.refusePercentage}" />
			      	</c:otherwise>
			      </c:choose>
			      
			      <form:errors  class="text-danger"  path="refusePercentage" />
			    </div>
		   </div>
		   

		   <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "scientificName">Scientific Name</form:label>
			    <div class="col-sm-10"> 
			      
			      
			       <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
					     <form:input class="form-control" path = "scientificName"  value ="${bioMaterial.scientificName}"  disabled ="true"/>
			      	</c:when>
			      	<c:otherwise>
					      <form:input class="form-control" path = "scientificName"  value ="${bioMaterial.scientificName}" />
			      	</c:otherwise>
			      </c:choose>
			      
			      
			    </div>
		   </div>
		   
		   <div class="form-group">
		    	<form:label class="text-info col-sm-2" path = "citation">Citation</form:label>
			    <div class="col-sm-10"> 
			      
			      
			       <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
					     <form:textarea class="form-control" path = "citation"  value ="${bioMaterial.citation}"  disabled ="true"/>
			      	</c:when>
			      	<c:otherwise>
					     <form:textarea class="form-control" path = "citation"  value ="${bioMaterial.citation}" />
			      	</c:otherwise>
			      </c:choose>
			      
			      
			    </div>
		   </div>
		   <div class="form-group">
		   		<form:label class="text-info col-sm-3" path = "pFactor">&nbsp;</form:label>
		    	<form:label class="text-info col-sm-1" path = "nFactor">nFactor</form:label>
			    <div class="col-sm-1">
			     
			      
			    
			    
			       <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
					     <form:input class="form-control" path = "nFactor"  value ="${bioMaterial.nFactor}"  disabled ="true"/>
			      	</c:when>
			      	<c:otherwise>
					     <form:input class="form-control" path = "nFactor"  value ="${bioMaterial.nFactor}" />
			      	</c:otherwise>
			      </c:choose>
			      
			      
			      <form:errors  class="text-danger"  path="nFactor" />
			    </div>
		    	<form:label class="text-info col-sm-1" path = "pFactor">pFactor</form:label>
			    <div class="col-sm-1"> 

			      
			      
			       <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
					     <form:input class="form-control" path = "pFactor"  value ="${bioMaterial.pFactor}" disabled ="true"/>
			      	</c:when>
			      	<c:otherwise>
					     <form:input class="form-control" path = "pFactor"  value ="${bioMaterial.pFactor}" />
			      	</c:otherwise>
			      </c:choose>
			      
			      
			      <form:errors  class="text-danger"  path="pFactor" />
			    </div>
		    	
		    	
		    	<form:label class="text-info col-sm-1" path = "pFactor">choFactor</form:label>
		    	<div class="col-sm-1"> 
			      
			       <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
					     <form:input class="form-control" path = "choFactor"  value ="${bioMaterial.choFactor}"  disabled ="true"/>
			      	</c:when>
			      	<c:otherwise>
					     <form:input class="form-control" path = "choFactor"  value ="${bioMaterial.choFactor}" />
			      	</c:otherwise>
			      </c:choose>
			      
			      
			      
			      
			      
			      <form:errors  class="text-danger"  path="choFactor" />
			    </div>
		    	<form:label class="text-info col-sm-3" path = "pFactor">&nbsp;</form:label>
			    
		   </div>
		   <div class="form-group row">
		  		<div class="col-sm-offset-4 col-sm-2">
			       <c:choose>
			      	<c:when test="${bioMaterial.id ge 0}"> 
					     <button type="submit" class="btn btn-info" disabled ="true">Add Bio-Material</button>  
			      	</c:when>
			      	<c:otherwise>
					     <button type="submit" class="btn btn-info">Add Bio-Material</button>
			      	</c:otherwise>
			     </c:choose>
			     </div>
			</div>
		
		  </form:form>	
	


	
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  




</body> 