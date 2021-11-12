<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>
 
 <script src="js/biomaterial.dynamic.select.list.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.min.js"></script>
 
 
<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
	<h3 class="bg-info text-info">Select Material and Formula to Graph</h3>
	
	<form:form id ="graphForm" action="graphBioMaterial"  method="post"  modelAttribute="bioMaterialGraphForm" target="_newtab" >
		<div class="form-group row">
			<div class="col-sm-1">
				<form:label  class="text-info" id="selectedBioMaterialIdLabel" path="selectedBioMaterialId" >Material: </form:label>
			</div>
			<div class="col-sm-11">
				<form:input class="form-control" id="selectedBioMaterialId" path="selectedBioMaterialId"   placeholder="Please enter bio-material name"/>
				<form:errors  class="text-danger"  path="selectedBioMaterialId" />
			</div>
		</div>	
	
		<div class="form-group row">
			<div class="col-sm-1">
				<form:label  class="text-info" path="selectedBioVariableId" >Y-Axis: </form:label>
			</div>
			<div class="col-sm-5">
				<form:select class="form-control" id="selectedBioVariableId" path="selectedBioVariableId" >
				</form:select>
				<form:errors  class="text-danger"  path="selectedBioVariableId" />
			</div>
			<div class="col-sm-1">
				<form:label  class="text-info" path="selectedDependentBioVariableId" >X-Axis: </form:label>
			</div>
			<div class="col-sm-5">
				<form:select class="form-control" id="selectedDependentBioVariableId" path="selectedDependentBioVariableId" >
				</form:select>
				<form:errors  class="text-danger"  path="selectedDependentBioVariableId" />
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-1">
				<form:label  class="text-info" path="selectedBioFormulaId" >Formula: </form:label>
			</div>
			<div class="col-sm-11">
				<form:select class="form-control" id="selectedBioFormulaId" path="selectedBioFormulaId" >
				</form:select>
				<form:errors  class="text-danger"  path="selectedBioFormulaId" />
			</div>
		</div>
		
		
		
		<br/>
		<div class="form-group row" id="materialComposition">
			<!-- Values are added by JQuerry -->
		</div>

	</form:form>
	 
		
	<div class="col-sm-3"></div>
		<div class="col-sm-3">
			<button id="add-material-composition" name="add-material-composition" class="btn btn-info">Add Material Composition</button>
		</div>
		<div class="col-sm-3">
			<button id="graph-bio-material" name="graph-bio-material" class="btn btn-info">Graph Bio-Material Formula</button>
		</div>
	 <div class="col-sm-3"></div>
		

	 
	 
	<div class="col-sm-12">
		<canvas id="popChart" width="1100" height="300"></canvas>
	</div>

	
	
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  
 
	<script>
	$('#selectedBioMaterialId').inputpicker({
	    url: 'getMaterials',
	    fields:['id','shortDesc'],
	    fieldText : 'shortDesc',
	    fieldValue : 'id',
	    headShow: true,
	    filterOpen: true,
	    autoOpen: true
	});
	</script>
</body>