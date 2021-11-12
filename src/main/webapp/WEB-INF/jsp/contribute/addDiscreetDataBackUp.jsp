<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

 <script src="js/biomaterial.dynamic.select.list.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.min.js"></script>
 <script src="js/biomaterial.dynamic.measurement.input.js"></script>
<body>


<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
			
			<h2 class="text-info">Add Discreet Dataset</h2>
			<h5 class="text-success">${successMessage}</h5>
			
			<p>&nbsp;</p>
			
			<form:form  action="/addDiscreetData"  method="post" enctype="multipart/form-data" modelAttribute="bioDiscreetData" >
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
						<form:label  class="text-info" path="authorName" >Author Name: </form:label>
					</div>
					<div class="col-sm-10">
						<form:input class="form-control" id="authorName" path="authorName"   placeholder="Author Name"/>
						<form:errors  class="text-danger"  path="authorName" />
					</div>
				</div>	
				
				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="year" >Publish Year: </form:label>
					</div>
					<div class="col-sm-10">
						<form:input class="form-control" id="year" path="year"   placeholder="Publish Year"/>
						<form:errors  class="text-danger"  path="year" />
					</div>
				</div>	
				
				<div class="form-group row">
					<div class="col-sm-2">
						<form:label  class="text-info" path="yVariableId" >Select Y-Axis Variable: </form:label>
					</div>
					<div class="col-sm-10">
						<form:select class="form-control" id="yVariableId" path="yVariableId"/>
						<form:errors  class="text-danger"  path="yVariableId" />
					</div>
				</div>	
				
				<div class="form-group" id="materialComposition">
					<!-- Values are added by JQuerry -->
				</div>
				
				<h4 class="text-info">Upload Excel File (.xls,.xlsx) Note : First column should be the y Variable</h4>
					
					<div class="form-group row">
						<div class="col-sm-3">
							<input type="file" name="file" accept=".xls,.xlsx" /> 
						</div>
					</div>
				
					<div class="form-group row">
						<div class="col-sm-3">
							
							<input type="submit" value="Upload file" />
						</div>
					</div>
					
				
		    	</c:when>
		   		<c:otherwise>
		    			
		    	</c:otherwise>
			</c:choose>
			</form:form>
    		
    
				
    		
    		
			<form action="/addDiscreetData" method="get">
				
    		<div class="form-group row">
				<div class="col-sm-3">
						<input type="submit" value="Display file content" />
				</div>
				</div>
			
				</form>
				
				
				
				
				<c:if test="${not empty data}">
					<table class="table table-hover table-striped">
			    		<thead>
			      			<tr>
			      				<th>Y-Axis Variable</th>
			        			<th>X-Axis Variables</th>
			      			</tr>
			    		</thead>
			    		
						<c:forEach items="${data}" var="row">
							<tr>
                				<c:forEach items="${row.value}" var="cell">
                    				<td style="border:1px solid black;height:20px;width:100px;">
                      				${cell.content}
                    				</td>
                				</c:forEach>
            				</tr>
						</c:forEach>
					</table>
				</c:if>
				
		
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