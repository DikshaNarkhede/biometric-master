<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>
 <script src="js/biomaterial.dynamic.measurement.input.js"></script>

<body>

	<div class="container">
		<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
		<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
		
				
				<h2 class="text-info">Add Your Bio-Material Formula</h2>
				<h5 class="text-success">${successMessage}</h5>
				<p>&nbsp;</p>
				
					
	
					<form:form  class="form-horizontal" action="addBioFormula"  method="post"  modelAttribute="bioFormulaForm">
					<form:hidden class="form-control" path = "id"  value ="${bioFormulaForm.id}" />
					<div class="row">
						<div class="form-group col-sm-5">
					    	<form:label class="text-info"  path = "name">Name Your Formula: </form:label>
						    <div > 
					      		<form:input class="form-control" path = "name"  value ="${bioFormulaForm.name}" />
					      		<form:errors  class="text-danger"  path="name" />
						    </div>
						    <h6 class="text-info">(Use Single Word. Example: K_WATER, VISCOSITY_PEANUT_OIL)</h6>
				   		</div>
				   		<div class="form-group col-sm-1"></div>
						<div class="form-group col-sm-6">
					    	<form:label class="text-info" path = "bioVariables">Select Variable (Y-Axis):</form:label>
						    	<div> 
								  <form:select class="form-control" id="variableId" path="variableId">
										<c:forEach items="${bioFormulaForm.bioVariables}" var="bioVariable">
											<c:choose>
												<c:when test ="${bioFormulaForm.variableId eq bioVariable.id }">
													<option value = "${ bioVariable.id}" SELECTED> ${bioVariable.symbol}  &nbsp;:&nbsp;  ${bioVariable.name}</option>
												</c:when>
												<c:otherwise>
													<option value = "${ bioVariable.id}"> ${bioVariable.symbol}  &nbsp;:&nbsp;  ${bioVariable.name}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>	  
								  </form:select>
								</div>
				   			</div>
				   		</div>
				   		
						<div class="row">
							<div class="form-group col-sm-12">
						    	<form:label class="text-info" path = "formula">Enter Your Formula:</form:label>
							    <div> 
						      		<form:textarea rows = "5" class="form-control" path = "formula"  value ="${bioFormulaForm.formula}" />
						      		<form:errors  class="text-danger"  path="formula" />
							    </div>
							 </div>
						</div>
						
						<div class = "row">	 
							  <div class="form-group col-sm-12"> 
							    <h6 class="text-info"><b>Rules for Entering Formula's</b>
							    	<UL>
								    	<LI>
								    		<small><b>Allowed Operators</b>
								    			Addition: 2 + 2&nbsp;&nbsp;&nbsp;Subtraction: 2 - 2&nbsp;&nbsp;&nbsp;Multiplication: 2 * 2&nbsp;&nbsp;&nbsp;Division: 2 / 2&nbsp;&nbsp;&nbsp;Exponentation: 2 ^ 2&nbsp;&nbsp;&nbsp;Unary Minus,Plus (Sign Operators): +2 - (-2)&nbsp;&nbsp;&nbsp;Modulo: 2 % 2			    	
								    		</small>
								    	<LI><small><b>Allowed Functions</b>
									    		abs: absolute value&nbsp;&nbsp;&nbsp;acos: arc cosine&nbsp;&nbsp;&nbsp;&nbsp;asin: arc sine&nbsp;&nbsp;&nbsp;&nbsp;atan: arc tangent&nbsp;&nbsp;&nbsp;&nbsp;cbrt: cubic root&nbsp;&nbsp;&nbsp;&nbsp;ceil: nearest upper integer&nbsp;&nbsp;&nbsp;&nbsp;cos: cosine&nbsp;&nbsp;&nbsp;&nbsp;cosh: hyperbolic cosine&nbsp;&nbsp;&nbsp;&nbsp;exp: euler's number raised to the power (e^x)&nbsp;&nbsp;&nbsp;&nbsp;floor: nearest lower integer&nbsp;&nbsp;&nbsp;&nbsp;log: logarithmus naturalis (base e)&nbsp;&nbsp;&nbsp;&nbsp;log10: logarithm (base 10)&nbsp;&nbsp;&nbsp;&nbsp;log2: logarithm (base 2)&nbsp;&nbsp;&nbsp;&nbsp;sin: sine&nbsp;&nbsp;&nbsp;&nbsp;sinh: hyperbolic sine&nbsp;&nbsp;&nbsp;&nbsp;sqrt: square root&nbsp;&nbsp;&nbsp;&nbsp;tan: tangent&nbsp;&nbsp;&nbsp;&nbsp;tanh: hyperbolic tangent&nbsp;&nbsp;&nbsp;&nbsp;signum: signum function			    				    	
								    		</small>
								    	<LI><small><b>Any Defined Formula.  Use Name of the formula</b></small>
							    	</UL>
						    	</h6>
					   		</div>
						</div>
	
				   		
	
	
						<div class="form-group col-sm-4">
					    	<form:label class="text-info" path = "formulaDesc">Formula Desc:</form:label>
						    <div> 
					      		<form:textarea   class="form-control" path = "formulaDesc"  value ="${bioFormulaForm.formulaDesc}" />
					      		<form:errors  class="text-danger"  path="formulaDesc" />
						    </div>
				   		</div>
	
				   		<div class="form-group col-sm-1"></div>
				   		<div class="form-group col-sm-3">
		    				<form:label class="text-info" path = "citation">Citation</form:label>
			    			<div > 
						    	<form:textarea class="form-control" path = "citation"  value ="${bioFormulaForm.citation}" />
						    	<form:errors  class="text-danger"  path="citation" />
						    </div>
			   			</div>
				   		<div class="form-group col-sm-1"></div>
				   		<div class="form-group col-sm-3">
		    				<form:label class="text-info" path = "doi">DOI</form:label>
			    			<div> 
						    	<form:textarea class="form-control" path = "doi"  value ="${bioFormulaForm.doi}" />
						    	<form:errors  class="text-danger"  path="doi" />
						    </div>
			   			</div>
			   			<div class="form-group col-sm-5"></div>
			   			<div class="form-group col-sm-2"><button type="submit" class="btn btn-info">Save Formula</button></div>
			   			<div class="form-group col-sm-5"></div>
							
						</div>
			</div>		
			</form:form>
		  
 		<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>

</body> 