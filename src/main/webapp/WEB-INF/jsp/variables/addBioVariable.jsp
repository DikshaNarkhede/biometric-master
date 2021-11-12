<!DOCTYPE HTML>
<html lang="en">

<%@ include file = "./../header.jsp" %>

<body>

<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
		
		<p>&nbsp;</p>	
		<h2 class="text-info">Add A New Bio-Variable</h2>
		<h5 class="text-success">${bioVariableAddForm.message}</h5>
		<p>&nbsp;</p>


		<form:form  class="form-horizontal" action="./addBioVariable"  method="post"  modelAttribute="bioVariableAddForm">
			<form:hidden  value= "${bioVariableAddForm.id}" path="id"/>
			<c:choose >
				<c:when test="${empty bioVariableAddForm.id}">
				    <div class="form-group">
				    	<div class="col-sm-2" >
				    		<form:label class="text-info" path = "name">Variable Name:</form:label>
				    	</div>
					    <div class="col-sm-4"> 
					      <form:input class="form-control" path = "name"  value ="${bioVariableAddForm.name}" placeholder= "Please Name Your Variable"/>
					      <form:errors  class="text-danger"  path="name" />
					    </div>
					    <div class="col-sm-2" >
				    		<form:label class="text-info" path = "description">Description:</form:label>
				    	</div>
					    
					    <div class="col-sm-4"> 
					      <form:input class="form-control" path = "description"  value ="${bioVariableAddForm.description}" placeholder= "Describe Your  Variable"/>
					      <form:errors  class="text-danger"  path="description" />
					    </div>
					    
				   </div>
		  
				    
				   <div class="form-group">
				   		<div class="col-sm-2" >
				    		<form:label class="text-info" path = "uom">Unit of Measure:</form:label>
				    	</div>
				   
					    <div class="col-sm-4"> 
					      <form:input class="form-control" path = "uom"  value ="${bioVariableAddForm.uom}" placeholder= "Enter Unit of Measure"/>
					        <form:errors  class="text-danger"  path="uom" />
					    </div>

				   		<div class="col-sm-2" >
				    		<form:label class="text-info" path = "symbol">Symbol:</form:label>
				    	</div>
					    
					     <div class="col-sm-4"> 
					      <form:input class="form-control" path = "symbol"  value ="${bioVariableAddForm.symbol}"  placeholder= "Please Enter Unique Symbol"/>
					      <form:errors  class="text-danger"  path="symbol" />
					    </div>
					    
					    
				   </div>
				   
				   <div class="form-group">
				   	    <div class="col-sm-5"></div>
					    <div class="col-sm-2"> 
							<button type="submit" class="btn btn-info">Add Variable</button>
					    </div>
					    <div class="col-sm-5"></div>
				   </div>
			   </c:when>

				<c:otherwise>
				    <div class="form-group">
					    <div class="col-sm-3 font-weight-bold text-lg-right">Variable Name: </div>	  
					    <div class="col-sm-3 text-md-left">	${bioVariableAddForm.name}</div>
					    <div class="col-sm-3 font-weight-bold text-lg-right">Variable Desc: </div>	  
					    <div class="col-sm-3 text-md-left">	${bioVariableAddForm.description}</div>
				   </div>

				    <div class="form-group">
					    <div class="col-sm-3 font-weight-bold text-lg-right">Unit of Measure: </div>	  
					    <div class="col-sm-3 text-md-left">	${bioVariableAddForm.uom}</div>
					    <div class="col-sm-3 font-weight-bold text-lg-right">Unique Symbol: </div>	  
					    <div class="col-sm-3 text-md-left">	${bioVariableAddForm.symbol}</div>
				   </div>
				    <div class="form-group">
					    <div class="col-sm-3 font-weight-bold text-lg-right">Added By: </div>	  
					    <div class="col-sm-3 text-md-left">	${bioVariableAddForm.addedBy}</div>
				   </div>
					   
				</c:otherwise>
			</c:choose>			   
			
		
		  </form:form>	
	


	
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>  




</body> 