$(document).ready(function () {
    var next = 0;
    $("#add-more").click(function(e){
        e.preventDefault();
        var selectedVariableOrFactor = $("#inputpicker-2").val();
        var selectedVariableOrFactorId = $("#variableId").val();
        if(selectedVariableOrFactorId==null || selectedVariableOrFactorId ==""){
        	alert("Please select a Variable/Factor to enter measurements.")
        	return;
        } 
        var addto = "#field" + next;
        
        
        var newIn  = "<div class=\"col-sm-2\">&nbsp;</div><div class=\"col-sm-4 text-primary\">\r\n" + 
		"&nbsp;&nbsp;" +selectedVariableOrFactor + "&nbsp;" + selectedVariableOrFactorId+  "&nbsp;&nbsp;"+
		"<input id=\"measurementPairs["+next+"].id\" name=\"measurementPairs["+next+"].id\" type=\"hidden\" value=\""+selectedVariableOrFactorId+"\" />\r\n" +
		"<input id=\"measurementPairs["+next+"].name\" name=\"measurementPairs["+next+"].name\" type=\"hidden\" value=\""+selectedVariableOrFactor+"\" />\r\n" +
		"							&nbsp;\r\n" + 
		"						</div>\r\n" + 
		"						<div class=\"col-sm-2\">\r\n" + 
		"							<input id=\"measurementPairs["+next+"].measurementValue\" name=\"measurementPairs["+next+"].measurementValue\" placeholder=\"Measurement Value\" class=\"form-control\" type=\"text\" />\r\n" + 
		"						</div>\r\n" + 
		"						<div class=\"col-sm-2\">\r\n" + 
		"							<input id=\"measurementPairs["+next+"].errorValue\" name=\"measurementPairs["+next+"].errorValue\" placeholder=\"Error Value\" class=\"form-control\" type=\"text\" />\r\n" + 
		"						</div>\r\n" + 
		"						<div class=\"col-sm-2\">\r\n" + 
		"							&nbsp;\r\n" + 
		"						</div>\r\n" + 
		"					</div>\r\n" + 
		"";
        
        next++;
        
        newIn+="<p><div class=\"form-group row\" id=\"field"+next+"\"></div>"; 
        
		 

        
        var newInput = $(newIn);
        $(addto).after(newInput);
        
        $("#field" + next).attr('data-source',$(addto).attr('data-source'));
        $("#count").val(next);  

    });

});