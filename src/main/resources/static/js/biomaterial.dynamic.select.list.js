$(document).ready(function () {
	console.log("page ready");

//	BioMaterial1
	$("#selectedBioMaterialId1").inputpicker({
		url: 'getMaterials',
		fields:['id','shortDesc'],
		fieldText : 'shortDesc',
		fieldValue : 'id',
		headShow: true,
		filterOpen: true,
		autoOpen: true,
		width: '100%',
		headShow: true,
	});

	$("#selectedBioVariableId1" ).on( "focus", function() {
		console.log( "selectedBioVariableId got focus. now fetching selected Material" );

		$("#selectedBioVariableId1").empty();
		$("#selectedDependentBioVariableId1").empty();
		$("#selectedBioFormulaId1").empty();
		jQuery('#materialComposition1').empty();

		var materialId1 = $("#selectedBioMaterialId1").val();

		if(materialId1 != '' ){
			console.log( "Got MaterialID " +  materialId1 + " Now fetching variables for the material");
			$.get("getVariablesForBiMaterial?materialId=" + materialId1, function(response) {
				$('#selectedBioVariableId1').empty()
				var jsonValue = JSON.parse(response);
				var variableOptionsString="";
				for(var i = 0; i < jsonValue.data.length; i++){
					variableOptionsString += "<OPTION value = "+jsonValue.data[i].id+">"+jsonValue.data[i].name+"</OPTION>";
					var o = new Option(jsonValue.data[i].name, jsonValue.data[i].id);
					$(o).html(jsonValue.data[i].name);
					$("#selectedBioVariableId1").append(o);	
				}
				console.log( variableOptionsString );
			})
		}
		else{
			console.log( "Must select a material before selecting a variable.");
			$("#selectedBioMaterialId1").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material before selecting a variable.!',
			});
		}
	});




	$("#selectedBioFormulaId1" ).on( "focus", function() {
		var materialId = $("#selectedBioMaterialId1").val();
		var variableId = $("#selectedBioVariableId1").val();
		var dependentVariableId = $("#selectedDependentBioVariableId").val();
		jQuery('#materialComposition1').empty();
		console.log( "selectedBioFormulaId1   got focus selectedBioDependentVariableId selected materialId:variabledId:dependentVariableId " +  materialId + ":" + variableId  + ":"+ dependentVariableId);
		$("#selectedBioFormulaId1").empty();

		if(materialId == '' ){
			console.log( "Must select a material before selecting a variable.");
			$("#selectedBioMaterialId1").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}

		if(variableId == '' || variableId == null){
			console.log( "Must select a Variable before selecting a Dependent Variable.");
			$("#selectedBioVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}

		if(dependentVariableId == '' || dependentVariableId == null){
			console.log( "Must select a material, variable  and dependent Variable before selecting a Formula.");
			$("#selectedDependentBioVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}



		$.get("getBioFormula?materialId="+materialId + "&variableId=" +variableId+ "&dependentVariableId=" +dependentVariableId, function( response ) {
			$('#selectedBioFormulaId1').empty()
			var jsonValue = JSON.parse(response);
			var optionsString="";
			for( var i=0;i<jsonValue.data.length;i++){
				optionsString += "<OPTION value = "+jsonValue.data[i].id+">"+jsonValue.data[i].formulaAndName+"</OPTION>";
				var o = new Option( jsonValue.data[i].formulaAndName,jsonValue.data[i].id);
				$(o).html(jsonValue.data[i].formulaAndName);
				$("#selectedBioFormulaId1").append(o);	
			}
			console.log( optionsString );
		})


	});

//	BioMaterial2
	$('#selectedBioMaterialId2').inputpicker({
		url: 'getMaterials',
		fields:['id','shortDesc'],
		fieldText : 'shortDesc',
		fieldValue : 'id',
		headShow: true,
		filterOpen: true,
		autoOpen: true,
		width: '100%',
		headShow: true,
	});

	$("#selectedBioVariableId2" ).on( "focus", function() {
		console.log( "selectedBioVariableId2 got focus. now fetching selected Material" );

		$("#selectedBioVariableId2").empty();
		$("#selectedDependentBioVariableId2").empty();
		$("#selectedBioFormulaId2").empty();
		jQuery('#materialComposition2').empty();

		var materialId2 = $("#selectedBioMaterialId2").val();

		if(materialId2 != '' ){
			console.log( "Got MaterialID " +  materialId2 + " Now fetching variables for the material");
			$.get("getVariablesForBiMaterial?materialId=" + materialId2, function(response) {
				$('#selectedBioVariableId2').empty()
				var jsonValue = JSON.parse(response);
				var variableOptionsString="";
				for(var i = 0; i < jsonValue.data.length; i++){
					variableOptionsString += "<OPTION value = "+jsonValue.data[i].id+">"+jsonValue.data[i].name+"</OPTION>";
					var o = new Option(jsonValue.data[i].name, jsonValue.data[i].id);
					$(o).html(jsonValue.data[i].name);
					$("#selectedBioVariableId2").append(o);	
				}
				console.log( variableOptionsString );
			})
		}
		else{
			console.log( "Must select a material before selecting a variable.");
			$("#selectedBioMaterialId2").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material before selecting a variable.!',
			});
		}
	});




	$("#selectedBioFormulaId2" ).on( "focus", function() {
		var materialId = $("#selectedBioMaterialId2").val();
		var variableId = $("#selectedBioVariableId2").val();
		var dependentVariableId = $("#selectedDependentBioVariableId").val();
		jQuery('#materialComposition').empty();
		console.log( "selectedBioFormulaId2   got focus selectedBioDependentVariableId selected materialId:variabledId:dependentVariableId " +  materialId + ":" + variableId  + ":"+ dependentVariableId);
		$("#selectedBioFormulaId2").empty();

		if(materialId == '' ){
			console.log( "Must select a material before selecting a variable.");
			$("#selectedBioMaterialId2").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}

		if(variableId == '' || variableId == null){
			console.log( "Must select a Variable before selecting a Dependent Variable.");
			$("#selectedBioVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}

		if(dependentVariableId == '' || dependentVariableId == null){
			console.log( "Must select a material, variable  and dependent Variable before selecting a Formula.");
			$("#selectedDependentBioVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}



		$.get("getBioFormula?materialId="+materialId + "&variableId=" +variableId+ "&dependentVariableId=" +dependentVariableId, function( response ) {
			$('#selectedBioFormulaId2').empty()
			var jsonValue = JSON.parse(response);
			var optionsString="";
			for( var i=0;i<jsonValue.data.length;i++){
				optionsString += "<OPTION value = "+jsonValue.data[i].id+">"+jsonValue.data[i].formulaAndName+"</OPTION>";
				var o = new Option( jsonValue.data[i].formulaAndName,jsonValue.data[i].id);
				$(o).html(jsonValue.data[i].formulaAndName);
				$("#selectedBioFormulaId2").append(o);	
			}
			console.log( optionsString );
		})


	});

//	BioMaterial3
	$('#selectedBioMaterialId3').inputpicker({
		url: 'getMaterials',
		fields:['id','shortDesc'],
		fieldText : 'shortDesc',
		fieldValue : 'id',
		headShow: true,
		filterOpen: true,
		autoOpen: true,
		width: '100%',
		headShow: true,
	});

	$("#selectedBioVariableId3" ).on( "focus", function() {
		console.log( "selectedBioVariableId3 got focus. now fetching selected Material" );

		$("#selectedBioVariableId3").empty();
		$("#selectedDependentBioVariableId3").empty();
		$("#selectedBioFormulaId3").empty();
		jQuery('#materialComposition3').empty();

		var materialId3 = $("#selectedBioMaterialId3").val();

		if(materialId3 != '' ){
			console.log( "Got MaterialID " +  materialId3 + " Now fetching variables for the material");
			$.get("getVariablesForBiMaterial?materialId=" + materialId3, function(response) {
				$('#selectedBioVariableId3').empty()
				var jsonValue = JSON.parse(response);
				var variableOptionsString="";
				for(var i = 0; i < jsonValue.data.length; i++){
					variableOptionsString += "<OPTION value = "+jsonValue.data[i].id+">"+jsonValue.data[i].name+"</OPTION>";
					var o = new Option(jsonValue.data[i].name, jsonValue.data[i].id);
					$(o).html(jsonValue.data[i].name);
					$("#selectedBioVariableId3").append(o);	
				}
				console.log( variableOptionsString );
			})
		}
		else{
			console.log( "Must select a material before selecting a variable.");
			$("#selectedBioMaterialId3").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material before selecting a variable.!',
			});
		}
	});




	$("#selectedBioFormulaId3" ).on( "focus", function() {
		var materialId = $("#selectedBioMaterialId3").val();
		var variableId = $("#selectedBioVariableId3").val();
		var dependentVariableId = $("#selectedDependentBioVariableId").val();
		jQuery('#materialComposition').empty();
		console.log( "selectedBioFormulaId3   got focus selectedBioDependentVariableId selected materialId:variabledId:dependentVariableId " +  materialId + ":" + variableId  + ":"+ dependentVariableId);
		$("#selectedBioFormulaId3").empty();

		if(materialId == '' ){
			console.log( "Must select a material before selecting a variable.");
			$("#selectedBioMaterialId3").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}

		if(variableId == '' || variableId == null){
			console.log( "Must select a Variable before selecting a Dependent Variable.");
			$("#selectedBioVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}

		if(dependentVariableId == '' || dependentVariableId == null){
			console.log( "Must select a material, variable  and dependent Variable before selecting a Formula.");
			$("#selectedDependentBioVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}



		$.get("getBioFormula?materialId="+materialId + "&variableId=" +variableId+ "&dependentVariableId=" +dependentVariableId, function( response ) {
			$('#selectedBioFormulaId3').empty()
			var jsonValue = JSON.parse(response);
			var optionsString="";
			for( var i=0;i<jsonValue.data.length;i++){
				optionsString += "<OPTION value = "+jsonValue.data[i].id+">"+jsonValue.data[i].formulaAndName+"</OPTION>";
				var o = new Option( jsonValue.data[i].formulaAndName,jsonValue.data[i].id);
				$(o).html(jsonValue.data[i].formulaAndName);
				$("#selectedBioFormulaId3").append(o);	
			}
			console.log( optionsString );
		})


	});

//	BioMaterial4
	$('#selectedBioMaterialId4').inputpicker({
		url: 'getMaterials',
		fields:['id','shortDesc'],
		fieldText : 'shortDesc',
		fieldValue : 'id',
		headShow: true,
		filterOpen: true,
		autoOpen: true,
		width: '100%',
		headShow: true,
	});

	$("#selectedBioVariableId4" ).on( "focus", function() {
		console.log( "selectedBioVariableId4 got focus. now fetching selected Material" );

		$("#selectedBioVariableId4").empty();
		$("#selectedDependentBioVariableId4").empty();
		$("#selectedBioFormulaId4").empty();
		jQuery('#materialComposition4').empty();

		var materialId4 = $("#selectedBioMaterialId4").val();

		if(materialId4 != '' ){
			console.log( "Got MaterialID " +  materialId4 + " Now fetching variables for the material");
			$.get("getVariablesForBiMaterial?materialId=" + materialId4, function(response) {
				$('#selectedBioVariableId4').empty()
				var jsonValue = JSON.parse(response);
				var variableOptionsString="";
				for(var i = 0; i < jsonValue.data.length; i++){
					variableOptionsString += "<OPTION value = "+jsonValue.data[i].id+">"+jsonValue.data[i].name+"</OPTION>";
					var o = new Option(jsonValue.data[i].name, jsonValue.data[i].id);
					$(o).html(jsonValue.data[i].name);
					$("#selectedBioVariableId4").append(o);	
				}
				console.log( variableOptionsString );
			})
		}
		else{
			console.log( "Must select a material before selecting a variable.");
			$("#selectedBioMaterialId4").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material before selecting a variable.!',
			});
		}
	});




	$("#selectedBioFormulaId4" ).on( "focus", function() {
		var materialId = $("#selectedBioMaterialId4").val();
		var variableId = $("#selectedBioVariableId4").val();
		var dependentVariableId = $("#selectedDependentBioVariableId").val();
		jQuery('#materialComposition').empty();
		console.log( "selectedBioFormulaId4   got focus selectedBioDependentVariableId selected materialId:variabledId:dependentVariableId " +  materialId + ":" + variableId  + ":"+ dependentVariableId);
		$("#selectedBioFormulaId4").empty();

		if(materialId == '' ){
			console.log( "Must select a material before selecting a variable.");
			$("#selectedBioMaterialId4").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}

		if(variableId == '' || variableId == null){
			console.log( "Must select a Variable before selecting a Dependent Variable.");
			$("#selectedBioVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}

		if(dependentVariableId == '' || dependentVariableId == null){
			console.log( "Must select a material, variable  and dependent Variable before selecting a Formula.");
			$("#selectedDependentBioVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}



		$.get("getBioFormula?materialId="+materialId + "&variableId=" +variableId+ "&dependentVariableId=" +dependentVariableId, function( response ) {
			$('#selectedBioFormulaId4').empty()
			var jsonValue = JSON.parse(response);
			var optionsString="";
			for( var i=0;i<jsonValue.data.length;i++){
				optionsString += "<OPTION value = "+jsonValue.data[i].id+">"+jsonValue.data[i].formulaAndName+"</OPTION>";
				var o = new Option( jsonValue.data[i].formulaAndName,jsonValue.data[i].id);
				$(o).html(jsonValue.data[i].formulaAndName);
				$("#selectedBioFormulaId4").append(o);	
			}
			console.log( optionsString );
		})


	});

//	BioMaterial5
	$('#selectedBioMaterialId5').inputpicker({
		url: 'getMaterials',
		fields:['id','shortDesc'],
		fieldText : 'shortDesc',
		fieldValue : 'id',
		headShow: true,
		filterOpen: true,
		autoOpen: true,
		width: '100%',
		headShow: true,
	});

	$("#selectedBioVariableId5" ).on( "focus", function() {
		console.log( "selectedBioVariableId5 got focus. now fetching selected Material" );

		$("#selectedBioVariableId5").empty();
		$("#selectedDependentBioVariableId5").empty();
		$("#selectedBioFormulaId5").empty();
		jQuery('#materialComposition5').empty();

		var materialId5 = $("#selectedBioMaterialId5").val();

		if(materialId5 != '' ){
			console.log( "Got MaterialID " +  materialId5 + " Now fetching variables for the material");
			$.get("getVariablesForBiMaterial?materialId=" + materialId5, function(response) {
				$('#selectedBioVariableId5').empty()
				var jsonValue = JSON.parse(response);
				var variableOptionsString="";
				for(var i = 0; i < jsonValue.data.length; i++){
					variableOptionsString += "<OPTION value = "+jsonValue.data[i].id+">"+jsonValue.data[i].name+"</OPTION>";
					var o = new Option(jsonValue.data[i].name, jsonValue.data[i].id);
					$(o).html(jsonValue.data[i].name);
					$("#selectedBioVariableId5").append(o);	
				}
				console.log( variableOptionsString );
			})
		}
		else{
			console.log( "Must select a material before selecting a variable.");
			$("#selectedBioMaterialId5").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material before selecting a variable.!',
			});
		}
	});




	$("#selectedBioFormulaId5" ).on( "focus", function() {
		var materialId = $("#selectedBioMaterialId5").val();
		var variableId = $("#selectedBioVariableId5").val();
		var dependentVariableId = $("#selectedDependentBioVariableId").val();
		jQuery('#materialComposition').empty();
		console.log( "selectedBioFormulaId5   got focus selectedBioDependentVariableId selected materialId:variabledId:dependentVariableId " +  materialId + ":" + variableId  + ":"+ dependentVariableId);
		$("#selectedBioFormulaId5").empty();

		if(materialId == '' ){
			console.log( "Must select a material before selecting a variable.");
			$("#selectedBioMaterialId5").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}

		if(variableId == '' || variableId == null){
			console.log( "Must select a Variable before selecting a Dependent Variable.");
			$("#selectedBioVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}

		if(dependentVariableId == '' || dependentVariableId == null){
			console.log( "Must select a material, variable  and dependent Variable before selecting a Formula.");
			$("#selectedDependentBioVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, variable  and dependent Variable before selecting a Formula.!',
			});
			return;
		}



		$.get("getBioFormula?materialId="+materialId + "&variableId=" +variableId+ "&dependentVariableId=" +dependentVariableId, function( response ) {
			$('#selectedBioFormulaId5').empty()
			var jsonValue = JSON.parse(response);
			var optionsString="";
			for( var i=0;i<jsonValue.data.length;i++){
				optionsString += "<OPTION value = "+jsonValue.data[i].id+">"+jsonValue.data[i].formulaAndName+"</OPTION>";
				var o = new Option( jsonValue.data[i].formulaAndName,jsonValue.data[i].id);
				$(o).html(jsonValue.data[i].formulaAndName);
				$("#selectedBioFormulaId5").append(o);	
			}
			console.log( optionsString );
		})


	});

	//Dependent Variable
	$("#selectedDependentBioVariableId" ).on( "focus", function() {
		var materialId = $("#selectedBioMaterialId1").val();
		var variableId = $("#selectedBioVariableId1").val();
		console.log( "selectedBioDependentVariableId got focus selected materialId:variabledId " +  materialId + ":" + variableId );

		$("#selectedDependentBioVariableId").empty();
		$("#selectedBioFormulaId1").empty();
		jQuery('#materialComposition1').empty();

		if(materialId == '' ){
			console.log( "Must select a material before selecting a variable.");
			$("#selectedBioMaterialId1").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material and variable before selecting a dependent variable.!',
			});
			return;
		}

		if(variableId == '' || variableId == null){
			console.log( "Must select a Variable efore selecting a Dependent Variable.");
			$("#selectedBioVariableId1").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a Variable before selecting a Dependent Variable.!',
			});
			return;
		}



		$.get("getVariablesInFormula?materialId="+materialId + "&variableId=" +variableId, function( response ) {
			$('#selectedDependentBioVariableId').empty()

			var jsonValue = JSON.parse(response);
			console.log( jsonValue);
			var variableOptionsString="";
			for( var i=0;i<jsonValue.data.bioVariables.length;i++){
				variableOptionsString += "<OPTION value = "+jsonValue.data.bioVariables[i].id+">"+jsonValue.data.bioVariables[i].name+"</OPTION>";
				var o = new Option( jsonValue.data.bioVariables[i].name,jsonValue.data.bioVariables[i].id);
				$(o).html(jsonValue.data.bioVariables[i].name);
				$("#selectedDependentBioVariableId").append(o);	
			}
			for( var i=0;i<jsonValue.data.bioComposition.length;i++){
				variableOptionsString += "<OPTION value = "+jsonValue.data.bioComposition[i].id+">"+jsonValue.data.bioComposition[i].tagName+"</OPTION>";
				var o = new Option( jsonValue.data.bioComposition[i].tagName,jsonValue.data.bioComposition[i].id);
				$(o).html(jsonValue.data.bioComposition[i].tagName);
				$("#selectedDependentBioVariableId").append(o);	
			}

			console.log( variableOptionsString );
		})    
	});

	/* Material Composition START**/

	$("#materialCompositionCollapse1" ).on( "show.bs.collapse", function() {
		var materialId = $("#selectedBioMaterialId1").val();
		var formulaId = $("#selectedBioFormulaId1").val();
		var dependentVariableId = $("#selectedDependentBioVariableId").val();
		jQuery('#materialComposition1').empty();
		$.get("getBioMaterialCompositionForFormula?materialId="+materialId +"&formulaId="+formulaId +"&dependentVariableId="+dependentVariableId, function( response ) {

			var jsonValue = JSON.parse(response);

			if(jsonValue.data.length==0){
				$.alert({
					title: 'Alert!',
					content: 'No user input is needed. Please proceed to Chart Formula.!',
				});
				return;
			}

			var inptString= "		<div class='row' >\n" + 
			"			<div class='col-sm-1'>&nbsp;</div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Material Composition </b></div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Unit</b></div>\n" + 
			"			<div class='col-sm-2 text-info'><b>USDA Value</b> </div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Change Value(Optional)</b></div>\n" + 
			"		</div>\n" + 
			"";
			for( var i=0;i<jsonValue.data.length;i++){
				//inptString+=jsonValue.data[i].nutrientName + "&nbsp;&nbsp;" +jsonValue.data[i].nutrientValue
				inptString+="<div class='form-group row'>\n" + 
				"			<input  type='hidden'   value = '" + jsonValue.data[i].bioMaterialId	+"' 	id='bioMaterialCompositionModelList1["+i+"].bioMaterialId' name='bioMaterialNutrientModelList1["+i+"].bioMaterialId'/>\n" + 
				"			<input type='hidden'  value = '" + jsonValue.data[i].bioNutrientId 	+"' 	id='bioMaterialCompositionModelList1["+i+"].bioNutrientId' name='bioMaterialCompositionModelList1["+i+"].bioNutrientId'/>			\n" + 
				"			<input  type='hidden'  value = '" + jsonValue.data[i].nutrientName	+"' 	id='bioMaterialCompositionModelList1["+i+"].nutrientName' name='bioMaterialCompositionModelList1["+i+"].nutrientName'/>			\n" + 
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientUnit	+"' 	id='bioMaterialCompositionModelList1["+i+"].nutrientUnit' name='bioMaterialCompositionModelList1["+i+"].nutrientUnit'/>			\n" + 
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientValue	+"' 	id='bioMaterialCompositionModelList1["+i+"].nutrientValue' name='bioMaterialCompositionModelList1["+i+"].nutrientValue'/>			\n" +
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientSymbol	+"' 	id='bioMaterialCompositionModelList1["+i+"].nutrientSymbol' name='bioMaterialCompositionModelList1["+i+"].nutrientSymbol'/>			\n" + 
				"\n" + 
				"			<div class='col-sm-1'>&nbsp;</div>\n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientName+"</div>  \n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientUnit+"</div>\n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientValue+"</div>\n" + 
				"			<div class='col-sm-2'>\n" + 
				"				<input class='form-control' id='bioMaterialCompositionModelList1["+i+"].userValue' name='bioMaterialCompositionModelList1["+i+"].userValue' value ="+jsonValue.data[i].nutrientValue+"  />\n" + 
				"			</div>\n" + 
				"			\n" + 
				"		</div>";

			}
			//input = jQuery(inptString);
			jQuery('#materialComposition1').append(inptString);
			console.log( inptString );
		})
		return;
	});
	
	$("#materialCompositionCollapse2" ).on( "show.bs.collapse", function() {
		var materialId = $("#selectedBioMaterialId2").val();
		var formulaId = $("#selectedBioFormulaId2").val();
		var dependentVariableId = $("#selectedDependentBioVariableId").val();
		jQuery('#materialComposition2').empty();
		$.get("getBioMaterialCompositionForFormula?materialId="+materialId +"&formulaId="+formulaId +"&dependentVariableId="+dependentVariableId, function( response ) {

			var jsonValue = JSON.parse(response);

			if(jsonValue.data.length==0){
				$.alert({
					title: 'Alert!',
					content: 'No user input is needed. Please proceed to Chart Formula.!',
				});
				return;
			}

			var inptString= "		<div class='row' >\n" + 
			"			<div class='col-sm-1'>&nbsp;</div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Material Composition </b></div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Unit</b></div>\n" + 
			"			<div class='col-sm-2 text-info'><b>USDA Value</b> </div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Change Value(Optional)</b></div>\n" + 
			"		</div>\n" + 
			"";
			for( var i=0;i<jsonValue.data.length;i++){
				//inptString+=jsonValue.data[i].nutrientName + "&nbsp;&nbsp;" +jsonValue.data[i].nutrientValue
				inptString+="<div class='form-group row'>\n" + 
				"			<input  type='hidden'   value = '" + jsonValue.data[i].bioMaterialId	+"' 	id='bioMaterialCompositionModelList2["+i+"].bioMaterialId' name='bioMaterialNutrientModelList2["+i+"].bioMaterialId'/>\n" + 
				"			<input type='hidden'  value = '" + jsonValue.data[i].bioNutrientId 	+"' 	id='bioMaterialCompositionModelList2["+i+"].bioNutrientId' name='bioMaterialCompositionModelList2["+i+"].bioNutrientId'/>			\n" + 
				"			<input  type='hidden'  value = '" + jsonValue.data[i].nutrientName	+"' 	id='bioMaterialCompositionModelList2["+i+"].nutrientName' name='bioMaterialCompositionModelList2["+i+"].nutrientName'/>			\n" + 
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientUnit	+"' 	id='bioMaterialCompositionModelList2["+i+"].nutrientUnit' name='bioMaterialCompositionModelList2["+i+"].nutrientUnit'/>			\n" + 
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientValue	+"' 	id='bioMaterialCompositionModelList2["+i+"].nutrientValue' name='bioMaterialCompositionModelList2["+i+"].nutrientValue'/>			\n" +
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientSymbol	+"' 	id='bioMaterialCompositionModelList2["+i+"].nutrientSymbol' name='bioMaterialCompositionModelList2["+i+"].nutrientSymbol'/>			\n" + 
				"\n" + 
				"			<div class='col-sm-1'>&nbsp;</div>\n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientName+"</div>  \n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientUnit+"</div>\n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientValue+"</div>\n" + 
				"			<div class='col-sm-2'>\n" + 
				"				<input class='form-control' id='bioMaterialCompositionModelList2["+i+"].userValue' name='bioMaterialCompositionModelList2["+i+"].userValue' value ="+jsonValue.data[i].nutrientValue+"  />\n" + 
				"			</div>\n" + 
				"			\n" + 
				"		</div>";

			}
			//input = jQuery(inptString);
			jQuery('#materialComposition2').append(inptString);
			console.log( inptString );
		})
		return;
	});
	
	$("#materialCompositionCollapse3" ).on( "show.bs.collapse", function() {
		var materialId = $("#selectedBioMaterialId3").val();
		var formulaId = $("#selectedBioFormulaId3").val();
		var dependentVariableId = $("#selectedDependentBioVariableId").val();
		jQuery('#materialComposition3').empty();
		$.get("getBioMaterialCompositionForFormula?materialId="+materialId +"&formulaId="+formulaId +"&dependentVariableId="+dependentVariableId, function( response ) {

			var jsonValue = JSON.parse(response);

			if(jsonValue.data.length==0){
				$.alert({
					title: 'Alert!',
					content: 'No user input is needed. Please proceed to Chart Formula.!',
				});
				return;
			}

			var inptString= "		<div class='row' >\n" + 
			"			<div class='col-sm-1'>&nbsp;</div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Material Composition </b></div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Unit</b></div>\n" + 
			"			<div class='col-sm-2 text-info'><b>USDA Value</b> </div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Change Value(Optional)</b></div>\n" + 
			"		</div>\n" + 
			"";
			for( var i=0;i<jsonValue.data.length;i++){
				//inptString+=jsonValue.data[i].nutrientName + "&nbsp;&nbsp;" +jsonValue.data[i].nutrientValue
				inptString+="<div class='form-group row'>\n" + 
				"			<input  type='hidden'   value = '" + jsonValue.data[i].bioMaterialId	+"' 	id='bioMaterialCompositionModelList3["+i+"].bioMaterialId' name='bioMaterialNutrientModelList3["+i+"].bioMaterialId'/>\n" + 
				"			<input type='hidden'  value = '" + jsonValue.data[i].bioNutrientId 	+"' 	id='bioMaterialCompositionModelList3["+i+"].bioNutrientId' name='bioMaterialCompositionModelList3["+i+"].bioNutrientId'/>			\n" + 
				"			<input  type='hidden'  value = '" + jsonValue.data[i].nutrientName	+"' 	id='bioMaterialCompositionModelList3["+i+"].nutrientName' name='bioMaterialCompositionModelList3["+i+"].nutrientName'/>			\n" + 
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientUnit	+"' 	id='bioMaterialCompositionModelList3["+i+"].nutrientUnit' name='bioMaterialCompositionModelList3["+i+"].nutrientUnit'/>			\n" + 
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientValue	+"' 	id='bioMaterialCompositionModelList3["+i+"].nutrientValue' name='bioMaterialCompositionModelList3["+i+"].nutrientValue'/>			\n" +
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientSymbol	+"' 	id='bioMaterialCompositionModelList3["+i+"].nutrientSymbol' name='bioMaterialCompositionModelList3["+i+"].nutrientSymbol'/>			\n" + 
				"\n" + 
				"			<div class='col-sm-1'>&nbsp;</div>\n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientName+"</div>  \n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientUnit+"</div>\n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientValue+"</div>\n" + 
				"			<div class='col-sm-2'>\n" + 
				"				<input class='form-control' id='bioMaterialCompositionModelList3["+i+"].userValue' name='bioMaterialCompositionModelList3["+i+"].userValue' value ="+jsonValue.data[i].nutrientValue+"  />\n" + 
				"			</div>\n" + 
				"			\n" + 
				"		</div>";

			}
			//input = jQuery(inptString);
			jQuery('#materialComposition3').append(inptString);
			console.log( inptString );
		})
		return;
	});
	
	$("#materialCompositionCollapse4" ).on( "show.bs.collapse", function() {
		var materialId = $("#selectedBioMaterialId4").val();
		var formulaId = $("#selectedBioFormulaId4").val();
		var dependentVariableId = $("#selectedDependentBioVariableId").val();
		jQuery('#materialComposition4').empty();
		$.get("getBioMaterialCompositionForFormula?materialId="+materialId +"&formulaId="+formulaId +"&dependentVariableId="+dependentVariableId, function( response ) {

			var jsonValue = JSON.parse(response);

			if(jsonValue.data.length==0){
				$.alert({
					title: 'Alert!',
					content: 'No user input is needed. Please proceed to Chart Formula.!',
				});
				return;
			}

			var inptString= "		<div class='row' >\n" + 
			"			<div class='col-sm-1'>&nbsp;</div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Material Composition </b></div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Unit</b></div>\n" + 
			"			<div class='col-sm-2 text-info'><b>USDA Value</b> </div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Change Value(Optional)</b></div>\n" + 
			"		</div>\n" + 
			"";
			for( var i=0;i<jsonValue.data.length;i++){
				//inptString+=jsonValue.data[i].nutrientName + "&nbsp;&nbsp;" +jsonValue.data[i].nutrientValue
				inptString+="<div class='form-group row'>\n" + 
				"			<input  type='hidden'   value = '" + jsonValue.data[i].bioMaterialId	+"' 	id='bioMaterialCompositionModelList4["+i+"].bioMaterialId' name='bioMaterialNutrientModelList4["+i+"].bioMaterialId'/>\n" + 
				"			<input type='hidden'  value = '" + jsonValue.data[i].bioNutrientId 	+"' 	id='bioMaterialCompositionModelList4["+i+"].bioNutrientId' name='bioMaterialCompositionModelList4["+i+"].bioNutrientId'/>			\n" + 
				"			<input  type='hidden'  value = '" + jsonValue.data[i].nutrientName	+"' 	id='bioMaterialCompositionModelList4["+i+"].nutrientName' name='bioMaterialCompositionModelList4["+i+"].nutrientName'/>			\n" + 
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientUnit	+"' 	id='bioMaterialCompositionModelList4["+i+"].nutrientUnit' name='bioMaterialCompositionModelList4["+i+"].nutrientUnit'/>			\n" + 
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientValue	+"' 	id='bioMaterialCompositionModelList4["+i+"].nutrientValue' name='bioMaterialCompositionModelList4["+i+"].nutrientValue'/>			\n" +
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientSymbol	+"' 	id='bioMaterialCompositionModelList4["+i+"].nutrientSymbol' name='bioMaterialCompositionModelList4["+i+"].nutrientSymbol'/>			\n" + 
				"\n" + 
				"			<div class='col-sm-1'>&nbsp;</div>\n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientName+"</div>  \n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientUnit+"</div>\n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientValue+"</div>\n" + 
				"			<div class='col-sm-2'>\n" + 
				"				<input class='form-control' id='bioMaterialCompositionModelList4["+i+"].userValue' name='bioMaterialCompositionModelList4["+i+"].userValue' value ="+jsonValue.data[i].nutrientValue+"  />\n" + 
				"			</div>\n" + 
				"			\n" + 
				"		</div>";

			}
			//input = jQuery(inptString);
			jQuery('#materialComposition4').append(inptString);
			console.log( inptString );
		})
		return;
	});
	
	$("#materialCompositionCollapse5" ).on( "show.bs.collapse", function() {
		var materialId = $("#selectedBioMaterialId5").val();
		var formulaId = $("#selectedBioFormulaId5").val();
		var dependentVariableId = $("#selectedDependentBioVariableId").val();
		jQuery('#materialComposition5').empty();
		$.get("getBioMaterialCompositionForFormula?materialId="+materialId +"&formulaId="+formulaId +"&dependentVariableId="+dependentVariableId, function( response ) {

			var jsonValue = JSON.parse(response);

			if(jsonValue.data.length==0){
				$.alert({
					title: 'Alert!',
					content: 'No user input is needed. Please proceed to Chart Formula.!',
				});
				return;
			}

			var inptString= "		<div class='row' >\n" + 
			"			<div class='col-sm-1'>&nbsp;</div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Material Composition </b></div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Unit</b></div>\n" + 
			"			<div class='col-sm-2 text-info'><b>USDA Value</b> </div>\n" + 
			"			<div class='col-sm-2 text-info'><b>Change Value(Optional)</b></div>\n" + 
			"		</div>\n" + 
			"";
			for( var i=0;i<jsonValue.data.length;i++){
				//inptString+=jsonValue.data[i].nutrientName + "&nbsp;&nbsp;" +jsonValue.data[i].nutrientValue
				inptString+="<div class='form-group row'>\n" + 
				"			<input  type='hidden'   value = '" + jsonValue.data[i].bioMaterialId	+"' 	id='bioMaterialCompositionModelList5["+i+"].bioMaterialId' name='bioMaterialNutrientModelList5["+i+"].bioMaterialId'/>\n" + 
				"			<input type='hidden'  value = '" + jsonValue.data[i].bioNutrientId 	+"' 	id='bioMaterialCompositionModelList5["+i+"].bioNutrientId' name='bioMaterialCompositionModelList5["+i+"].bioNutrientId'/>			\n" + 
				"			<input  type='hidden'  value = '" + jsonValue.data[i].nutrientName	+"' 	id='bioMaterialCompositionModelList5["+i+"].nutrientName' name='bioMaterialCompositionModelList5["+i+"].nutrientName'/>			\n" + 
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientUnit	+"' 	id='bioMaterialCompositionModelList5["+i+"].nutrientUnit' name='bioMaterialCompositionModelList5["+i+"].nutrientUnit'/>			\n" + 
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientValue	+"' 	id='bioMaterialCompositionModelList5["+i+"].nutrientValue' name='bioMaterialCompositionModelList5["+i+"].nutrientValue'/>			\n" +
				"			<input  type='hidden' value = '" + jsonValue.data[i].nutrientSymbol	+"' 	id='bioMaterialCompositionModelList5["+i+"].nutrientSymbol' name='bioMaterialCompositionModelList5["+i+"].nutrientSymbol'/>			\n" + 
				"\n" + 
				"			<div class='col-sm-1'>&nbsp;</div>\n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientName+"</div>  \n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientUnit+"</div>\n" + 
				"			<div class='col-sm-2 text-info'>"+jsonValue.data[i].nutrientValue+"</div>\n" + 
				"			<div class='col-sm-2'>\n" + 
				"				<input class='form-control' id='bioMaterialCompositionModelList5["+i+"].userValue' name='bioMaterialCompositionModelList5["+i+"].userValue' value ="+jsonValue.data[i].nutrientValue+"  />\n" + 
				"			</div>\n" + 
				"			\n" + 
				"		</div>";

			}
			//input = jQuery(inptString);
			jQuery('#materialComposition5').append(inptString);
			console.log( inptString );
		})
		return;
	});

	$("#graph-bio-material" ).on( "click", function() {
		jQuery('#chart').empty();
		var formData = $("#graphForm").serialize();

		console.log( formData );
		$.post("getCalculatedDataPoints", formData,function( response ){
			console.log(response);
			var jsonValue = JSON.parse(response);
			console.log(jsonValue);
			const dataPointsList = [
				{
					dataPointsX: jsonValue.data.dataPointsX1,
					dataPointsY: jsonValue.data.dataPointsY1
				},{
					dataPointsX: jsonValue.data.dataPointsX2,
					dataPointsY: jsonValue.data.dataPointsY2
				},{
					dataPointsX: jsonValue.data.dataPointsX3,
					dataPointsY: jsonValue.data.dataPointsY3
				},{
					dataPointsX: jsonValue.data.dataPointsX4,
					dataPointsY: jsonValue.data.dataPointsY4
				},{
					dataPointsX: jsonValue.data.dataPointsX5,
					dataPointsY: jsonValue.data.dataPointsY5
				}
			]
			console.log(dataPointsList);
			var data = [];
			for (var i = 0; i < 5; i++) {
				var xAxisArray = dataPointsList[i].dataPointsX;
				var yAxisArray = dataPointsList[i].dataPointsY;
				if (xAxisArray == undefined) continue;

				var dataSet = [];
				for(var j = 0; j < xAxisArray.length; j++) {
					dataSet.push(
							{
								x: xAxisArray[j],
								y: yAxisArray[j]
							}
					);
				}
				data.push(dataSet);
			}
			console.log(data);

			// set the dimensions and margins of the graph
			var margin = {top: 10, right: 30, bottom: 30, left: 60},
			width = 600 - margin.left - margin.right,
			height = 520 - margin.top - margin.bottom;

			// append the svg object to the body of the page
			var svg = d3.select("#chart")
				.append("svg")
				.attr("width", width + margin.left + margin.right)
				.attr("height", height + margin.top + margin.bottom)
				.style("overflow", "overlay")
				.append("g")
				.attr("transform","translate(" + margin.left + "," + margin.top + ")");
			
			var color = d3.scaleOrdinal(d3.schemeCategory10);

			var materialNames = []
			for (var i = 1; i < 6; i++) {
				if ($("#inputpicker-"+i).val() != "") {
					materialNames.push($("#inputpicker-"+i).val());
				}
			}
			console.log(materialNames);

			var variableNames = []
			for (var i = 1; i < 6; i++) {
				if ($("#selectedBioVariableId"+i).val() != null) {
					var curVariableId = $("#selectedBioVariableId"+i).val();
					for (var j = 0; j < $("#selectedBioVariableId"+i)[0].length; j++) {
						if ($("#selectedBioVariableId"+i)[0][j].value == curVariableId) {
							variableNames.push($("#selectedBioVariableId"+i)[0][j].text);
						}
					}
				}
			}
			console.log(variableNames);
			
			var legends = []
			for (var i = 0; i < materialNames.length; i++) {
				legends.push(materialNames[i] + ', ' + variableNames[i])
			}

			console.log(legends);

			// add legends
			var lineLegend = svg.selectAll(".lineLegend").data(legends)
				.enter().append("g")
				.attr("class","lineLegend")
				.attr("transform", function (d,i) {
						return "translate(" + width + "," + (i*20)+")";
					});

			lineLegend.append("text").text(function (d) {return d;})
				.attr("transform", "translate(40,9)"); //align texts with boxes

			lineLegend.append("rect")
				.attr("fill", function (d, i) {return color(i); })
				.attr("width", 10).attr("height", 10)
				.attr("transform", "translate(25,0)"); //align texts with boxes

			
			// add x-axis
			var xAxisLabel = ""
			for (var i = 0; i < $("#selectedDependentBioVariableId")[0].length; i++) {
				if ($("#selectedDependentBioVariableId")[0][i].value == $("#selectedDependentBioVariableId").val()) {
					xAxisLabel = $("#selectedDependentBioVariableId")[0][i].text;
					break;
				}
			}
			const xScale = d3.scaleLinear()
				.domain(d3.extent(data[0], function(d) { return d.x; }))
				.rangeRound([0, width]);
			
			const xaxis = d3.axisBottom().scale(xScale);

			svg.append("g")
				.attr("class", "axis")
				.attr("transform", "translate(0," + height + ")")
				.call(xaxis);
			
			svg.append("text")             
				.attr("transform",
						"translate(" + (width/2) + " ," + 
									(height + 50) + ")")
				.style("text-anchor", "middle")
				.text(xAxisLabel);

			var variables = [...new Set(variableNames)]

			var dataForVar = []
			variables.forEach(_ => { dataForVar.push([]); })
			
			for (var i = 0; i < data.length; i++) {
				dataForVar[variables.indexOf(variableNames[i])] = dataForVar[variables.indexOf(variableNames[i])].concat(data[i])
			}
			console.log(dataForVar)
			var yScales = []
			dataForVar.forEach(v => {
				yScales.push(d3.scaleLinear()
					.domain(d3.extent(v, function(d) { return d.y; }))
					.rangeRound([height, 0])
				);
			})

			// add y-axises, one axis for one variable, allow 4 axis
			yScales.forEach((yScale, idx) => {
				var onLeft = idx % 2 == 0;
				var yaxis = onLeft ? d3.axisLeft(yScale) : d3.axisRight(yScale);
				var yAxisLabel = variableNames[idx]
				if (idx < 2) {
					svg.append("g")
						.attr("class", "axis")
						.call(yaxis);
					
					svg.append("text")
						.attr("transform", onLeft ? "rotate(-90)" : "rotate(+90)")
						.attr("y", onLeft ? - 100 : + 60)
						.attr("x", onLeft ? 0 - (height / 2) : height / 2)
						.attr("dy", "1em")
						.style("text-anchor", "middle")
						.text(yAxisLabel);  
				} else if (idx < 4) {
					svg.append("g")
						.attr("class", "axis")
						.attr("transform", "translate( " + width + ", 0 )")
						.call(yaxis);

					svg.append("text")
						.attr("transform", onLeft ? "rotate(-90)" : "rotate(+90)")
						.attr("y", onLeft ? width - 100 : width + 60)
						.attr("x", onLeft ? 0 - (height / 2) : height / 2)
						.attr("dy", "1em")
						.style("text-anchor", "middle")
						.text(yAxisLabel);  
				}
			})

			// add lines
			for (var i = 0; i < data.length; i++) {
				var curYScale = yScales[variables.indexOf(variableNames[i])];
				svg.append("path")
					.data([data[i]])
					.attr("class", "line")
					.attr("fill", "none")
					.style("stroke", color(i))
					.attr("stroke-width", 1.5)
					.attr("d",
						d3.line()
							.x(function(d) { return xScale(d.x) })
							.y(function(d) { return curYScale(d.y) })
							.curve(d3.curveBasis)
						)
			}
		});

	});
});