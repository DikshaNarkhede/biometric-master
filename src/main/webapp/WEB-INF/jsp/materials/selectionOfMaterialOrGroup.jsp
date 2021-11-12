<!DOCTYPE HTML>
<html lang="en">

<%@ include file="./../header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<body>
	<div class="container">
		<div id="topbar">
			<%@ include file="./../top_bar.jsp"%></div>
		<div id="menubar">
			<%@ include file="./../menu_bar.jsp"%></div>
		<div id="container" style="width: 100%;">
			<h5 class="text-success" id="SuccessResponse"></h5>
			<h5 class="text-success" id="noMaterialError"></h5>
			<h5 class="text-success" id="noGroupError"></h5>
			<h5 class="text-danger" id="select50"></h5>
			<div>
			<div id="left" style="float: left; width: 10%;">
				<input type="checkbox" name="material" class="searchMaterialBar materialGroupList"
					id="material" onchange="showMaterialSearchBar()"><span>Material</span><br> <br> 
					<input type="checkbox" class="materialGroupList groupList" name="material"
					id="group" onchange="showGroupSearchBar()"><span>Group</span>
					</div>
			<div id="searchBarOfMaterial" style="float: right; width: 90%; height: 70%; vertical-align: top; display: none">
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
					<button type="submit" id="searchMaterial" onclick="searchMaterial()" data-toggle="modal"
						data-target="#graphModal" class="btn btn-success">Search</button>
				</div>
			</div></div>
		</div>
		<br> <br>
		<div id="searchBarOfGroup" style="float: right; width: 90%; height: 70%; vertical-align: top; display: none">
		<div class="row">
				<div class="form-group col-sm-8">
					  <h2 class="text-info">Search Bio-Material Group To Edit Group</h2>
					  <p>&nbsp;</p>
					  <input class="form-control" name="bioMaterialGroupName"
							id="bioMaterialGroupName"
							placeholder="Enter Partial or full Bio-Material Name"/>			  
				</div>	
				</div>		   
				<div class="row">
				<div class="form-group col-sm-7">
				<button type="submit" class="btn btn-success" id="searchGroup" onclick="searchGroup()">Search</button></div></div>
		</div>
							</div>
		
<br><br>
		<div id="displayGroupName"
			style="float: right; width: 90%; height: 70%; display: none">

			<table class="table table-hover">
				<thead>
					<tr id= "groupTr" class="colorFullTh">
						<th>Group Name</th>
						<th style="width:50%"></th>
						<th>Select</th>
					</tr>
				</thead>
				<tbody id="displayGroup">
				</tbody>
			</table>
		</div>
		<div id="showDiv1"
			style="float: right; width: 90%; height: 70%; display: none;">
			<br> <br>
			<table class="table table-hover">
				<thead>
					<tr id="showTr1">
						<th class="colorFullTh">Material in Database</th>
						<th class="colorFullTh">Select</th>
					</tr>
				</thead>
				<tbody id="displayMaterial">
				</tbody>
			</table>

		</div>
		<c:choose>
			<c:when test="${not empty materialName}">
				<div id="showDiv2" style="float: right; width: 90%; height: 70%;">
					<table class="table" id="delete">
						<thead>
							<tr>
								<th class="colorFullTh">Materials Chosen</th>
								<th class="colorFullTh"></th>
								<th class="colorFullTh"></th>
							</tr>
						</thead>
						<tbody id="showSelectedMaterial">
							<c:forEach var="material" items="${materialName}">
								<tr class="materialList" >
									<td style="width: 100%; margin-right:20px">${fn:toUpperCase(material.longDesc)}<input
										type="hidden" name="materialid" id="materialList"
										value="${groupMaterialId}"><input
										type="hidden" name="materialDelete" id="materialDeleteId" class="materialDeleteId"
										value="${material.id}"></td>
									<td></td>
									<td class="del"><button class="crossButton" id="btnDeleteid"
											name="btnDeletename" value="${material.id}">&times;</button>
											</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<div id="showDiv2"
					style="float: right; width: 90%; height: 70%; display: none;">
					<table class="table">
						<thead>
							<tr id="showTr2">
								<th class="colorFullTh">Materials Chosen</th>
								<th class="colorFullTh"></th>
								<th class="colorFullTh"></th>
							</tr>
						</thead>
						<tbody id="showSelectedMaterial">
						</tbody>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${not empty groupName.groupName}">
				<div id="showDiv3"
					style="float: right; width: 90%; height: 70%;">
					<div class="row">
						<div class="form-group col-sm-8">
							<h5 class="text-info">Enter Group Name</h5>
									<input class="form-control" name="bioGroupName"
										id="bioGroupName"
										placeholder="Enter Partial or full Bio-Material Name"
										value="${groupName.groupName}" disabled />
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-7">
							<button type="submit" class="btn btn-success" id="saveGroup">Save
								Group</button>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div id="showDiv3"
					style="float: right; width: 90%; height: 70%; display: none;">
					<div class="row">
						<div class="form-group col-sm-8">
							<h5 class="text-info">Enter Group Name</h5>
							<input class="form-control" name="bioGroupName" id="bioGroupName"
								placeholder="Enter Partial or full Bio-Material Name" /> <span
								id="errorMsg"></span>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-7">
							<button type="submit" class="btn btn-success" id="saveGroup">Save
								Group</button>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	</div>
	<br>
	<br>
	<div id="footerbar">
		<p>&nbsp;</p>
		<%@ include file="./../footer_bar.jsp"%></div>

</body>