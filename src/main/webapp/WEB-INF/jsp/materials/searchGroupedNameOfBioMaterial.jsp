<!DOCTYPE HTML>
<html lang="en">
<%@ include file = "./../header.jsp" %>
<head>  
	  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	  <link rel="stylesheet" href="styles/main.css">
	  <link rel="stylesheet" href="css/jquery.inputpicker.css">
	  <link rel="stylesheet" href="css/biomaterial.group.css">
	  
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	  <script src="js/jquery.inputpicker.js"></script>
	  <script src="js/biomaterial.group.js"></script>
	  
	  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
  
  	<!-- JQUERRY ALERT.  Should download and use it in local -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
  
 </head>
<body>
<div class="container">
	<div id="topbar"> <%@ include file = "./../top_bar.jsp" %></div>
	<div id="menubar"> <%@ include file = "./../menu_bar.jsp" %></div>
	
		<div class="row">
		<div class="form-group col-sm-8">
			  <h3 class="text-info">Search Bio-Material Group To Edit Group</h3>
			  <input class="form-control" name="bioMaterialGroupName"
					id="bioMaterialGroupName"
					placeholder="Enter Partial or full Bio-Material Name"/>			  
		</div>	
		</div>		   
		<div class="row">
		<div class="form-group col-sm-7">
		<button type="submit" class="btn btn-success" id="searchGroup">Search</button></div></div>
	<div id="footerbar"> <p>&nbsp;</p> <%@ include file = "./../footer_bar.jsp" %></div>	
</div>	
</body>