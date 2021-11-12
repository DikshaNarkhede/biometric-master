<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

 <script src="js/bioDiscreetData.dynamic.select.list.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.min.js"></script>
 <script src="js/biomaterial.dynamic.measurement.input.js"></script>
<body>


<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
			
			<h2 class="text-info">Add Discreet Dataset</h2>
			<h5 class="text-success">${successMessage}</h5>
			
			<p>&nbsp;</p>
			
			<form:form  action="/addDiscreetData"  method="post" enctype="multipart/form-data" modelAttribute="bioDiscreetDataForm" >
			<form:hidden  value= "${bioDiscreetDataForm.id}" path="id"/>
			<c:choose>
				<c:when test="${empty successMessage}">
				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="materialId" >Select Material: </form:label>
					</div>
					<div class="col-sm-10">
						<form:input class="form-control" id="materialId" path="materialId" value ="${bioDiscreetDataForm.materialId}"   placeholder="Please enter bio-material name"/>
						<form:errors  class="text-danger"  path="materialId" />
					</div>
				</div>	
				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="authorName">Author Name: </form:label>
					</div>
					<div class="col-sm-10">
						<form:input class="form-control" id="authorName" path="authorName" value="${bioDiscreetDataForm.authorName}"  placeholder="Author Name"/>
						<form:errors  class="text-danger"  path="authorName" />
					</div>
				</div>	
				
				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="year" >Publish Year: </form:label>
					</div>
					<div class="col-sm-10">
						<form:input class="form-control" id="year" path="year" value="${bioDiscreetDataForm.year}"  placeholder="Publish Year"/>
						<form:errors  class="text-danger"  path="year" />
					</div>
				</div>	
				
				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="yVariableId" >Select Y-Axis Variable: </form:label>
					</div>
					<div class="col-sm-10">
						<form:select class="form-control" id="yVariableId" value="${bioDiscreetDataForm.yVariableId}" path="yVariableId"/>
						<form:errors  class="text-danger"  path="yVariableId" />
					</div>
				</div>	
				
				<div class="form-group" id="materialComposition">
					<!-- Values are added by JQuerry -->
				</div>
				
				<h4 class="text-info">Upload Excel File (.xls,.xlsx) Note : First column should be the y Variable</h4>
					
				<div class="form-group row">
					<div class="col-sm-3">
						<input type="file" value = "Choose File" name="file" id = "file" accept=".xls,.xlsx" value = "${bioDiscreetDataForm.file}"/> 
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-3">
						<input type="text" id="upload-file" name="upload-file" value="Upload File" />
		
					</div>
				</div>
					
				<div class="form-group" id="execelContent">
					<!-- Values are added by JQuerry -->
				</div>
				
				
				
				<div class="form-group row">
		  				<div class="col-sm-offset-4 col-sm-2">
		     				<button  type="submit" class="btn btn-info btn-default">Save Discreet Dataset</button>
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
    url: 'getMaterialsWithFormula',
    fields:['id','shortDesc'],
    fieldText : 'shortDesc',
    fieldValue : 'id',
    headShow: true,
    filterOpen: true,
    autoOpen: true
});


</script>

</body> 