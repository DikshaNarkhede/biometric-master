<!DOCTYPE HTML>
<html lang="en">
<%@ include file="./../header.jsp"%>
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
		<div id="topbar">
			<%@ include file="./../top_bar.jsp"%></div>
		<div id="menubar">
			<%@ include file="./../menu_bar.jsp"%></div>

		<p>&nbsp;</p>
		<h2 class="text-info">Search Bio-Materials For Grouping</h2>
		<h5 class="text-success">${bioMaterialSearchResultsForm.message}</h5>
		<p>&nbsp;</p>
		<div class="row">
			<div class="form-group col-sm-3">
			<label class="text-info">Please Enter Search Name</label>
				<input class="form-control" name="bioMaterialName"
					id="bioMaterialName"
					placeholder="Enter Partial or full Bio-Material Name"
					onchange="getTextValue()" />
			</div>

			<div class="col-sm-3">
			<label class="text-info">Process</label>
				<select class="form-control" name="process" id="process"></select>
			</div>
			<div class="col-sm-3">
			<label class="text-info">Form</label>
				<select class="form-control" name="form" id="form"></select>
			</div>
			<div class="form-group">
				<div class="col-sm-3">
				<br>
					<button type="submit" id="searchMaterial" data-toggle="modal"
						data-target="#graphModal" class="btn btn-success">Search</button>
				</div>
			</div>
			<br> <br>
			<div id="footerbar">
				<p>&nbsp;</p>
				<%@ include file="./../footer_bar.jsp"%></div>
		</div>
</body>