<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>
 
 <script src="js/biomaterial.dynamic.select.list.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.min.js"></script>
 
 
<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	<h2 class="text-info">Bio-Material Composition</h2>
	
	
	<form:form  action="bioMaterialComposition"  method="post"  modelAttribute ="bioMaterialCompositionForm" >
	
		<div class="form-group row">
			<div class="col-sm-9">
				<form:input class="form-control" id="selectedBioMaterialId" path="selectedBioMaterialId"  placeholder="Please enter bio-material name"/>
				<form:errors  class="text-danger"  path="selectedBioMaterialId" />
			</div>
			<div class="col-sm-1">
				<button id="bio-material-nutrients" name="bio-material-nutrients" class="btn btn-info">Composition Values</button>
			</div>
		</div>
		
			<h4 class="text-info">Composition Values for Material: ${bioMaterialCompositionForm.bioMaterialCompositionList[0].bioMaterial.shortDesc } </h4>
			<table class="table table-hover table-striped">
			    <thead>
			      <tr>
			      	<th>Composition Id</th>
			        <th>Composition  Name</th>
			        <th>Symbol</th>
			        <th>UOM</th>
			        <th>Value</ths>
			        <th>Min. Value</th>
			        <th>max. Value</th>
			      </tr>
			    </thead>
			    <tbody>
					<c:forEach var="bioMaterialComposition" items="${bioMaterialCompositionForm.bioMaterialCompositionList}">
						<tr>
        					<td>${bioMaterialComposition.bioComposition.id}</td>
        					<td>${bioMaterialComposition.bioComposition.nutrientDesc}</td>
        					<td>${bioMaterialComposition.bioComposition.tagName}</td>
        					<td>${bioMaterialComposition.bioComposition.uom}</td>
        					<td>${bioMaterialComposition.nutrientValue}</td>
        					<td>${bioMaterialComposition.minValue}</td>
        					<td>${bioMaterialComposition.maxValue}</td>
        				</tr>	
					</c:forEach>
				</tbody>
			</table>	
	</form:form>
	
	
	
	
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