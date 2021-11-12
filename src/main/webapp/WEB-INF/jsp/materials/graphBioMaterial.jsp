<!DOCTYPE HTML>
<html lang="en">

<%@ include file="./../header.jsp"%>

<script src="js/biomaterial.dynamic.select.list.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.min.js"></script>
<script src="https://d3js.org/d3.v4.js"></script>

<body>

	<div class="container">
		<div id="topbar">
			<%@ include file="./../top_bar.jsp"%></div>
		<div id="menubar">
			<%@ include file="./../menu_bar.jsp"%></div>

		<h2 class="text-info">Select Material and Formula to Graph</h2>
		<hr>
		<form id="graphForm" action="graphBioMaterial"  method="post"  modelAttribute="bioMaterialGraphForm">
			<table class="table table-striped table-bordered"
				id="BioMaterialTable" style="text-align: center;">
				<thead>
					<tr>
						<th scope="col" style="width: 15%; text-align: center;"></th>
						<th scope="col" style="width: 17%; text-align: center;">
							Material 1</th>
						<th scope="col" style="width: 17%; text-align: center;">
							Material 2</th>
						<th scope="col" style="width: 17%; text-align: center;">
							Material 3</th>
						<th scope="col" style="width: 17%; text-align: center;">
							Material 4</th>
						<th scope="col" style="width: 17%; text-align: center;">
							Material 5</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row" style="text-align: center;">Material</th>
						<td><input class="form-control" id="selectedBioMaterialId1"
							name="selectedBioMaterialId1"
							placeholder="Please enter bio-material name" /></td>
						<td><input class="form-control" id="selectedBioMaterialId2"
							name="selectedBioMaterialId2"
							placeholder="Please enter bio-material name" /></td>
						<td><input class="form-control" id="selectedBioMaterialId3"
							name="selectedBioMaterialId3"
							placeholder="Please enter bio-material name" /></td>
						<td><input class="form-control" id="selectedBioMaterialId4"
							name="selectedBioMaterialId4"
							placeholder="Please enter bio-material name" /></td>
						<td><input class="form-control" id="selectedBioMaterialId5"
							name="selectedBioMaterialId5"
							placeholder="Please enter bio-material name" /></td>
					</tr>
					<tr>
						<th scope="row" style="text-align: center;">Y-Axis</th>
						<td><select class="form-control" id="selectedBioVariableId1"
							name="selectedBioVariableId1"></select></td>
						<td><select class="form-control" id="selectedBioVariableId2"
							name="selectedBioVariableId2"></select></td>
						<td><select class="form-control" id="selectedBioVariableId3"
							name="selectedBioVariableId3"></select></td>
						<td><select class="form-control" id="selectedBioVariableId4"
							name="selectedBioVariableId4"></select></td>
						<td><select class="form-control" id="selectedBioVariableId5"
							name="selectedBioVariableId5"></select></td>

					</tr>
					<tr>
						<th scope="row" style="text-align: center;">X-Axis</th>
						<td colspan="5"><select class="form-control"
							id="selectedDependentBioVariableId"
							name="selectedDependentBioVariableId">
						</select></td>
					</tr>
					<tr>
						<th scope="row" style="text-align: center;">X-Axis start
							value</th>
						<td colspan="5"><input class="form-control" id="minRange"
							name="minRange" value="${minRange}"/></td>
					</tr>
					<tr>
						<th scope="row" style="text-align: center;">X-Axis end value</th>
						<td colspan="5"><input class="form-control" id="maxRange"
							name="maxRange" value="${maxRange}"/></td>
					</tr>
					<tr>
						<th scope="row" style="text-align: center;">Formula</th>
						<td><select class="form-control" id="selectedBioFormulaId1"
							name="selectedBioFormulaId1"></select></td>
						<td><select class="form-control" id="selectedBioFormulaId2"
							name="selectedBioFormulaId2"></select></td>
						<td><select class="form-control" id="selectedBioFormulaId3"
							name="selectedBioFormulaId3"></select></td>
						<td><select class="form-control" id="selectedBioFormulaId4"
							name="selectedBioFormulaId4"></select></td>
						<td><select class="form-control" id="selectedBioFormulaId5"
							name="selectedBioFormulaId5"></select></td>

					</tr>
				</tbody>
			</table>

			<div style="padding: 10px 0px; text-align: center;">
				<a class="btn btn-primary" data-toggle="collapse"
					href="#materialCompositionCollapse1" role="button"
					aria-expanded="false" aria-controls="materialCompositionCollapse1">
					Material Composition 1 </a>
				<div class="collapse" id="materialCompositionCollapse1">
					<div class="form-group row" id="materialComposition1" name="materialComposition"
						style="border: 1px solid #ddd; margin: 10px 0px; padding: 10px 0px 0px 0px;">
						<!-- Values are added by JQuerry -->
					</div>
				</div>
			</div>

			<div style="padding: 10px 0px; text-align: center;">
				<a class="btn btn-primary" data-toggle="collapse"
					href="#materialCompositionCollapse2" role="button"
					aria-expanded="false" aria-controls="materialCompositionCollapse2">
					Material Composition 2 </a>
				<div class="collapse" id="materialCompositionCollapse2">
					<div class="form-group row" id="materialComposition2" name="materialComposition2"
						style="border: 1px solid #ddd; margin: 10px 0px; padding: 10px 0px 0px 0px;">
						<!-- Values are added by JQuerry -->
					</div>
				</div>
			</div>

			<div style="padding: 10px 0px; text-align: center;">
				<a class="btn btn-primary" data-toggle="collapse"
					href="#materialCompositionCollapse3" role="button"
					aria-expanded="false" aria-controls="materialCompositionCollapse3">
					Material Composition 3 </a>
				<div class="collapse" id="materialCompositionCollapse3">
					<div class="form-group row" id="materialComposition3" name="materialComposition3"
						style="border: 1px solid #ddd; margin: 10px 0px; padding: 10px 0px 0px 0px;">
						<!-- Values are added by JQuerry -->
					</div>
				</div>
			</div>

			<div style="padding: 10px 0px; text-align: center;">
				<a class="btn btn-primary" data-toggle="collapse"
					href="#materialCompositionCollapse4" role="button"
					aria-expanded="false" aria-controls="materialCompositionCollapse4">
					Material Composition 4 </a>
				<div class="collapse" id="materialCompositionCollapse4">
					<div class="form-group row" id="materialComposition4" name="materialComposition4"
						style="border: 1px solid #ddd; margin: 10px 0px; padding: 10px 0px 0px 0px;">
						<!-- Values are added by JQuerry -->
					</div>
				</div>
			</div>

			<div style="padding: 10px 0px; text-align: center;">
				<a class="btn btn-primary" data-toggle="collapse"
					href="#materialCompositionCollapse5" role="button"
					aria-expanded="false" aria-controls="materialCompositionCollapse5">
					Material Composition 5 </a>
				<div class="collapse" id="materialCompositionCollapse5">
					<div class="form-group row" id="materialComposition5" name="materialComposition5"
						style="border: 1px solid #ddd; margin: 10px 0px; padding: 10px 0px 0px 0px;">
						<!-- Values are added by JQuerry -->
					</div>
				</div>
			</div>
		</form>
		<div style="text-align: center;">
			<button id="graph-bio-material" name="graph-bio-material"
				class="btn btn-primary" data-toggle="modal"
				data-target="#graphModal">Chart Bio-Material Formula</button>
		</div>
		<div style="text-align: center; margin: 10px 0px; padding: 10px 0px 0px 0px;">
			<div id="chart" name="chart"></div>
		</div>
		<div id="footerbar">
			<p>&nbsp;</p>
			<%@ include file="./../footer_bar.jsp"%></div>
	</div>
</body>