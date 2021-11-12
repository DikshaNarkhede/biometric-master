<head>
	  <title>BioMaterials Database</title>
	  
	  <meta charset="utf-8">
	  
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  
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
 
 
 <c:choose>
	 <c:when test ="${not empty pageContext.request.remoteUser}">
	 	<c:set var = "userRole" scope = "session" value = "${pageContext.request.userPrincipal.principal.bioUser.userRole}"/>
	 </c:when>
	 <c:otherwise>
	 	<c:set var = "userRole" scope = "session" value = "Guest"/>
	 </c:otherwise> 
 </c:choose>
  