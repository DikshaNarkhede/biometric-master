<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>
 <script src="js/biomaterial.dynamic.measurement.input.js"></script>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
			
			<h2 class="text-info">Add Observed Values</h2>
			<h5 class="text-success">${successMessage}</h5>
			
			<p>&nbsp;</p>
			
			<form:form  action="addObservedPoint"  method="post"  modelAttribute="bioObservedPoint" >
			<c:choose>
				<c:when test="${empty successMessage}">
				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="materialId" >Select Material: </form:label>
					</div>
					<div class="col-sm-10">
						<form:input class="form-control" id="materialId" path="materialId"   placeholder="Please enter bio-material name"/>
						<form:errors  class="text-danger"  path="materialId" />
					</div>
				</div>	

				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="yVariableId" >Select Y-Axis Variable: </form:label>
					</div>
					<div class="col-sm-10">
						<form:input class="form-control" id="yVariableId" path="yVariableId"   placeholder="Please enter y-axis Variable"/>
						<form:errors  class="text-danger"  path="yVariableId" />
					</div>
				</div>	


				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="xVariableId" >Select X-Axis Variable: </form:label>
					</div>
					<div class="col-sm-10">
						<form:input class="form-control" id="xVariableId" path="xVariableId"   placeholder="Please enter x-axis Variable"/>
						<form:errors  class="text-danger"  path="xVariableId" />
					</div>
				</div>	

				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="xVariableId" >Observed Value: </form:label>
					</div>
					
					<div class="col-sm-3">
						<form:input class="form-control" id="xObservedValue" path="xObservedValue"   placeholder="X Observed Value"/>
						<form:errors  class="text-danger"  path="xObservedValue" />
					</div>
					
					<div class="col-sm-3">
						<form:input class="form-control" id="yObservedValue" path="yObservedValue"   placeholder="Y Observed Value"/>
						<form:errors  class="text-danger"  path="yObservedValue" />
					</div>
					
					<div class="col-sm-3">
						<form:input class="form-control" id="errorValue" path="errorValue"   placeholder="Error Value"/>
						<form:errors  class="text-danger"  path="errorValue" />
					</div>
				</div>	
				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="citation" >Citation: </form:label>
					</div>
					<div class="col-sm-10">
						<form:input class="form-control" id="citation" path="citation"   placeholder="Citation"/>
						<form:errors  class="text-danger"  path="citation" />
					</div>
				</div>	
				
				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="doi" >DOI: </form:label>
					</div>
					<div class="col-sm-10">
						<form:input class="form-control" id="doi" path="doi"   placeholder="DOI"/>
						<form:errors  class="text-danger"  path="doi" />
					</div>
				</div>	
				
				
				
				   <p>&nbsp;</p>
			        <div class="form-group row">
		  				<div class="col-sm-offset-4 col-sm-2">
		     				<button  type="submit" class="btn btn-info btn-default">Save Observed Point</button>
		   				</div>
		    		</div>
		    		</c:when>
		    		<c:otherwise>
		    			
		    		</c:otherwise>
		    		</c:choose>
		</form:form>
	
	<p>&nbsp;</p>
	
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  
 
<script>
$('#materialId').inputpicker({
    url: 'getMaterials',
    fields:['id','shortDesc'],
    fieldText : 'shortDesc',
    fieldValue : 'id',
    headShow: true,
    filterOpen: true,
    autoOpen: true
});


$('#yVariableId').inputpicker({
    url: 'getVariables',
    fields:['id','name'],
    fieldText : 'name',
    fieldValue : 'id',
    headShow: true,
    filterOpen: true,
    autoOpen: true
});

$('#xVariableId').inputpicker({
    url: 'getVariables',
    fields:['id','name'],
    fieldText : 'name',
    fieldValue : 'id',
    headShow: true,
    filterOpen: true,
    autoOpen: true
});


</script>

</body> 