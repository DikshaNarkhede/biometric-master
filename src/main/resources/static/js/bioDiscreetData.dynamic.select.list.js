$(document).ready(function () {
	$("#yVariableId" ).on( "focus", function() {
		var materialId = $("#materialId").val();
		$("#yVariableId").empty();
	    jQuery('#materialComposition').empty();
	    jQuery('#execelContent').empty();
	    jQuery('#storeIntoDB').empty();
	    
		if(materialId != '' ){
			console.log( "Got MaterialID " +  materialId + " Now fetching variables for the material");
			$.get( "getVariablesForBiMaterial?materialId="+materialId, function( response ) {
				
				$('#yVariableId').empty()
					var jsonValue = JSON.parse(response);
					var variableOptionsString="";
					for( var i=0;i<jsonValue.data.length;i++){
						variableOptionsString += "<OPTION value = "+jsonValue.data[i].id+">"+jsonValue.data[i].name+"</OPTION>";
						var o = new Option( jsonValue.data[i].name,jsonValue.data[i].id);
						$(o).html(jsonValue.data[i].name);
						$("#yVariableId").append(o);	
					}
					console.log( variableOptionsString );
			})
		}else {
			console.log( "Must select a material before selecting a variable.");
			$("#materialId").focus();
			$.alert({
			    title: 'Alert!',
			    content: 'Must select a material before selecting a variable.!',
			});
		}
	});
	
	
	$("#yVariableId" ).on( "change", function() {
	    var materialId = $("#materialId").val();
	    var variableId = $("#yVariableId").val();
	    console.log( "yVariableId was selected, materialId:variabledId " +  materialId + ":" + variableId );

	    jQuery('#materialComposition').empty();
	    jQuery('#execelContent').empty();
	    jQuery('#storeIntoDB').empty();
	    
	    var variable;
	    $.get( "getVariablesName?variableId="+variableId, function( response ) {
	    	console.log("see the content of response" + response)
	    	var jsonValue1 = JSON.parse(response);
	    	variable = jsonValue1.data;
	    })
	    
	    $.get("getVariablesInFormula?materialId="+materialId + "&variableId=" +variableId, function( response ) {
				var jsonValue = JSON.parse(response);
				console.log( jsonValue);
				if(jsonValue.data.bioVariables.length==0 && jsonValue.data.bioComposition.length == 0){
					$.alert({
						title: 'Alert!',
						content: 'No related dependent variables!',
					});
					return;
				}
				
				
				
				var inptString = 
				
				"<h4 class='text-info'>  The format of the Excel file should be: </h4>\n" +
				
				"<div class='form-group row'>\n" + 
				
				"<div class= 'col-sm-1'>&nbsp;</div>\n"+
				"<div class='col-sm-1 text-info'><b>"+variable.name+"</b></div>  \n";
				
				var length = jsonValue.data.bioVariables.length;
				if (length > 10) length = 10;
				for( var i=0;i<length;i++){
					inptString+=
						"<div class='col-sm-1 text-info'><b>"+jsonValue.data.bioVariables[i].name+"</b></div>\n";
				}
				
				/*
				 
				
				for( var i=0;i<jsonValue.data.bioComposition.length;i++){
					inptString+=
						"<div class='col-sm-1 text-info'><b>"+jsonValue.data.bioComposition[i].tagName+"</b></div>\n";
				}
				*/
				inptString += "\n" + "</div>";
				inptString += "<div class='form-group row'>\n" + 
				"<div class= 'col-sm-1'>&nbsp;</div>\n"+
				" <div class='col-sm-1 text-info'><b>"+variable.uom+"</b></div>  \n";
				for( var i=0;i<length;i++){
					inptString+=
						"<div class='col-sm-1 text-info'><b>"+jsonValue.data.bioVariables[i].uom+"</b></div>\n";
				}
				/*
				for( var i=0;i<jsonValue.data.bioComposition.length;i++){
					inptString+=
						"<div class='col-sm-1 text-info'><b>"+jsonValue.data.bioComposition[i].uom+"</b></div>\n";
				}
				*/
				inptString += "\n" + "</div>";
				
				jQuery('#materialComposition').append(inptString);
				
				
				
		})
	    
	});
	
	
	$("#delete-button").on("click",function() {
		$.alert({
			title: 'Success!',
			content: 'Successfully deleted the record!',
		});
		t
	})
	$("#upload-file" ).on( "click", function() {
		var materialId = $("#materialId").val();
		var authorName = $("#authorName").val();
		var year = $("#year").val();
	    var variableId = $("#yVariableId").val();
	    var file = $("#file").val()
	    jQuery('#execelContent').empty();

	    if(materialId == '' ){
			console.log( "Must select a material before uploading the Excel File.");
			$("#materialId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, enter the author Name and Experiment Year, select the Variable before uploading the Excel File!',
			});
			return;
	    }
	    if(authorName == '' || authorName == null){
			console.log( "Must enter the author Name before uploading the Excel File.");
			$("#authorName").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, enter the author Name and Experiment Year, select the Variable before uploading the Excel File!',
			});
			return;
	    }

	    if(year.length !== 4){
	    	console.log( "Length of year is invalid.");
	    	$("#year").focus();
	    	$.alert({
				title: 'Alert!',
				content: 'Length of Year must be 4!',
			});
	    	return;
	    }
	    if(year == '' || year == null){
			console.log( "Must enter the Experiment Year before uploading the Excel File.");
			$("#year").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, enter the author Name and Experiment Year, select the Variable before uploading the Excel File!',
			});
			return;
	    }
	    if(variableId == '' || variableId == null){
			console.log( "Must select a Variable before uploading the Excel File.");
			$("#yVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material, enter the author Name and Experiment Year, select the Variable before uploading the Excel File!',
			});
			return;
	    }
	    var fileLocation = file.replace(/^.*(\\|\/|\:)/, '');
	    
		if(fileLocation != '' ){
			jQuery('#execelContent').empty();
			$.get("getExcelContent?file="+fileLocation, function( response ) {
				var jsonValue = JSON.parse(response);
				console.log(jsonValue);
				if(jsonValue.data.length == 0){
					$.alert({
						title: 'Alert!',
						content: 'Not a valid file or File missing! Please upload an excel file.!',
					});
					return;
				}
				var inptString = "<table class='table table-hover table-striped'>\n" +
				"<thead>\n"+
				"<tr>\n"+
				"<th>Y-Axis Variable</th>\n"+
				"<th>X-Axis Variables</th>\n"+
				"</tr>\n"+
				"</thead>\n"+
				"";
				
				for( var i=0;i<Object.keys(jsonValue.data).length;i++){
					inptString+="<tr>\n" + 
					"";
					for(var j = 0; j < jsonValue.data[i].length; j++) {
						
						if(jsonValue.data[i][j].content != ""){	
								inptString += "<td style='border:1px solid black;height:20px;width:100px;'>\n"+
                  				jsonValue.data[i][j].content+
                				"</td>\n";
						}
					}
					
					inptString+="</tr>\n" + 
					"";
				}
				inptString += "\n" + "</table>";
				jQuery('#execelContent').append(inptString);
		})
		} else {
			$.alert({
				title: 'Alert!',
				content: 'Not a valid file or File missing! Please upload an excel file.!',
			});
			return;
		}
	});
	
	$("#aVariableId" ).on( "focus", function() {
	    var materialId = $("#materialId").val();
	    var variableId = $("#yVariableId").val();
	    console.log( "aVariableId got focus selected materialId:variabledId " +  materialId + ":" + variableId );

	    $("#aVariableId").empty();
	    
	    if(materialId == '' ){
			console.log( "Must select a material before selecting a variable.");
			$("#materialId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a material and variable before selecting a dependent variable.!',
			});
			return;
	    }
	    
	    if(variableId == '' || variableId == null){
			console.log( "Must select a Variable efore selecting a Dependent Variable.");
			$("#yVariableId").focus();
			$.alert({
				title: 'Alert!',
				content: 'Must select a Variable before selecting a Dependent Variable.!',
			});
			return;
	    }
	    
	    
		
		$.get("getVariablesInFormula?materialId="+materialId + "&variableId=" +variableId, function( response ) {
			$('#aVariableId').empty()
			
				var jsonValue = JSON.parse(response);
				console.log( jsonValue);
				var variableOptionsString="";
				for( var i=0;i<jsonValue.data.bioVariables.length;i++){
					variableOptionsString += "<OPTION value = "+jsonValue.data.bioVariables[i].id+">"+jsonValue.data.bioVariables[i].name+"</OPTION>";
					var o = new Option( jsonValue.data.bioVariables[i].name,jsonValue.data.bioVariables[i].id);
					$(o).html(jsonValue.data.bioVariables[i].name);
					$("#aVariableId").append(o);	
				}
				for( var i=0;i<jsonValue.data.bioComposition.length;i++){
					variableOptionsString += "<OPTION value = "+jsonValue.data.bioComposition[i].id+">"+jsonValue.data.bioComposition[i].tagName+"</OPTION>";
					var o = new Option(jsonValue.data.bioComposition[i].tagName,jsonValue.data.bioComposition[i].id);
					$(o).html(jsonValue.data.bioComposition[i].tagName);
					$("#aVariableId").append(o);	
				}

				console.log( variableOptionsString );
		})
	    
	    
	});
	
});