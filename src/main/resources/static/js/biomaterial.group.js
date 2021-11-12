$(document).ready(function() {
	$('.materialGroupList').on('change', function() {
		$('.materialGroupList').not(this).prop('checked', false);
	});
});

	function showMaterialSearchBar() {
		if($('.searchMaterialBar').is(":checked")){
			if($('#searchBarOfMaterial').css('display','none')){
				$('#searchBarOfMaterial').css('display','block')
			}
			if($('#searchBarOfGroup').css('display','block')){
				$('#searchBarOfGroup').css('display','none')
			}
			$("#displayGroupName").hide();
			$("#showExpandedMaterial").hide();	
			$("#showTr1").show();
			$("#showTr2").show();
			$("#noGroupError").empty();	
			$('#bioMaterialName').val("");
			$("option[class='val']").remove();
		} else {
			if($('#searchBarOfMaterial').css('display','block')){
				$('#searchBarOfMaterial').css('display','none')
			}
		}
	}

function showGroupSearchBar() {
		if($('.groupList').is(":checked")){
			if($('#searchBarOfGroup').css('display','none')){
				$('#searchBarOfGroup').css('display','block')
			}
			if($('#searchBarOfMaterial').css('display','block')){
				$('#searchBarOfMaterial').css('display','none')
			}
			$("#showDiv1").hide();
			$("#showExpandedMaterial").hide();
			$("#showTr2").show();
			$("#groupTr").show();
			$("#noMaterialError").empty();
			$('#bioMaterialGroupName').val("");
		} else {
			if($('#searchBarOfGroup').css('display','block')){
				$('#searchBarOfGroup').css('display','none')
			}
		}
	}

function changeColor() {
	var name = document.getElementById('groupName').value;
	if (name != null) {
		groupName.style.color = '#9ACD32';
	}
}
function typeName() {
	groupName.style.color = '#000000';
}

$(document).ready(function() {
	var coll = document.getElementsByClassName("collapsible");
	var i;
	for (i = 0; i < coll.length; i++) {
		coll[i].addEventListener("click", function() {
			var groupName = $("#groupName").val();
			$.ajax({
				type: 'GET',
				url: 'expandForExsistingBioMaterial/groupName/' + groupName,
				success: function(data) {
					data = JSON.parse(data);
					var html = '';
					data.forEach(function(materiallist) {
						html += '<li>' + materiallist.shortDesc + '</li><br>';
					});
					html = '<ul class= "removebullet">' + html + '</ul>';
					document.querySelector('#materialNameList').innerHTML = html;
				}
			});
		});
	}
});

var expandSelectedGroupName = "";
var removeSelectedGroupName = "";
var removeSelectedMaterialName = "";
var selectedGroupNameArray = [];
let selectedMaterialAndGroupMaterialsArray = [];
var selectedMaterialNameArray = [];
let selectedMaterialIdArray = [];
let selectedMaterialSize = "";
let exsistingGroupMaterialsArray = [];
let materialsNameList = "";
let exsistingMaterialsNameList = [];
let btnDeleteid = [];
function searchGroup(){
	jQuery('#displayGroup').empty();
	jQuery('#materialNameList').empty();
	var bioMaterialGroupName = $("#bioMaterialGroupName").val();
	$(".error").remove();
	if (bioMaterialGroupName.length < 1) {
		$('#bioMaterialGroupName').after('<span class="error">Please Enter Bio-Material Name</span>');
	} else {
		$.get("searchResultOfBioMaterialInGroupedMaterial?bioMaterialGroupName=" + bioMaterialGroupName, function(response) {
			console.log(response);
			var jsonValue = JSON.parse(response);
			if (jsonValue['data']) {
				var groupNameList = "";
				for (var i = 0; i < jsonValue.data.length; i++) {
					groupNameList += '<tr class="searchGroup"><td>' + jsonValue.data[i] + '<input type="hidden" name="groupMaterialId" id="groupMaterialId" value=' + jsonValue.materialId[i] + '></td><td style="width:50%"></td><td><input type="checkbox" class="groupNameCheckbox" id="groupNameCheckbox' + jsonValue.id[i] + '" name="groupNameCheckbox"/><input type="hidden" name="groupId" id="groupId" value="' + jsonValue.id[i] + '"></td></tr><br>';
					$('#displayGroup').html(groupNameList);
				}
				$("#noGroupError").empty();
				$('#groupTr').show();
			} 
			if (jsonValue['error']) {
				$("#noGroupError").html(jsonValue['error']);
				$('#noGroupError').css("color", "red");
				$('#groupTr').hide();
			}
		})
		$("#displayGroupName").show();
	}
}

$(document).ready(function() {
$('#displayGroup').on('change', '.searchGroup', function() {
	if ($(this).closest('tr').find('.groupNameCheckbox').is(':checked')) {
		var selectedGroupName = $(this).closest("tr").find('td').text();
		var groupMaterialId = $(this).closest("tr").find('#groupMaterialId').val();
		var groupId = $(this).closest("tr").find('#groupId').val();
		selectedGroupNameArray.push(selectedGroupName);
		var count = getOccurrence(selectedGroupNameArray, selectedGroupName);
		if (count == 1) {
			selectedMaterialAndGroupMaterialsArray.push(groupMaterialId);
			$('#showSelectedMaterial').append('<tr class="showGroupInColor materialList"><td><button type="button" style="font-size:x-large" class="expandButton buttonInactive unstyled-button" id= "expandButton" value="yes">&#65291;</button><input type="hidden" name="groupNameId" id="groupNameId" value=' + groupId + '></td><td style="width: 100%; margin-right:20px">' + selectedGroupName + '<input type="hidden" name="selectedBioMaterial" id="groupMaterialId" value="' + groupMaterialId + '"></td><div><td><button class="crossButtonGroup" id="btnDeleteid" name="btnDeletename" >&times;</button><input type="hidden" name="groupNameId" id="groupNameId" value=' + groupId + '></td></div></tr><tr class="bioMaterialNameListt bioMaterialNameList'+groupId+'"><td><div style="display:none;" class="content scroll" id="materialNameList'+groupId+'"></td></tr><br>');
			$("#showDiv2").show();
			$("#showDiv3").show();
		} else {
			$("#showDiv2").show();
			$("#showDiv3").show();
		}
	} else {
		$("#showDiv2").show();
		$("#showDiv3").show();
	}
});
});
function searchMaterial(){
	$("#showDiv1").hide();
	jQuery('#displayMaterial').empty();
	var firstIndex = $("#bioMaterialName").val();
	var process = $("#process option:selected").text();
	if(process == 'No Selection'){
		process = "";
	}
	var form = $("#form option:selected").text();
	if(form == 'No Selection'){
		form = "";
	}
	$(".error").remove();
	if (firstIndex.length < 1) {
		$('#bioMaterialName').after('<span class="error">This field is required</span>');
	}
	else {
		process = process.trim();
		form = form.trim();
		$.get("searchBioMaterialsForGrouping1?firstIndex=" + firstIndex + "&process=" + encodeURIComponent(process) + "&form=" + encodeURIComponent(form), function(response) {
			console.log(response);
			var jsonValue = JSON.parse(response);
			if (jsonValue['data']) {
				var materialList = "";
				for (var i = 0; i < jsonValue.data.length; i++) {
					materialList += '<tr class="getMaterial"><td>'
						+ jsonValue.data[i]
						+ '<input type="hidden" name="selectedBioMaterial" id="matId" value=' + jsonValue.msg[i] + '></td><td><input id="checkValue' + jsonValue.msg[i] + '" type="checkbox" class="checkboxbutton" name="selectedBioMaterial"/><br></td></tr>';
					$("#displayMaterial").html(materialList);
				}
				$("#noMaterialError").empty();
				$('#showTr1').show();
			}
			if (jsonValue['error']) {
				$("#noMaterialError").html(jsonValue['error']);
				$('#noMaterialError').css("color", "red");
				$('#showTr1').hide();
			}
		})
		$('#showDiv1').show();
	}

}

$(document).ready(function() {
$('#displayMaterial')
	.on('change', '.getMaterial', function() {
		if ($(this).closest('tr').find('.checkboxbutton').is(':checked')) {
			var id = $(this).closest("tr").find('td').text();
			var getId = $(this).closest("tr").find('#matId').val();
			selectedMaterialNameArray.push(id);
			var count = getOccurrence(selectedMaterialNameArray, id);
			if (count == 1) {
				selectedMaterialIdArray.push(getId);
				selectedMaterialSize = selectedMaterialIdArray.length;
				selectedMaterialAndGroupMaterialsArray.push(getId);
				var storeData = '<tr class="materialList"><td style="width: 100%; margin-right:20px">'
					+ id
					+ '<input type="hidden" name="selectedBioMaterial" id="matId" value="' + getId + '"></td><td></td><div><td><button class="crossButton" id="btnDeleteid" name="btnDeletename">&times;</button></div></td></tr>';

				$('#showSelectedMaterial').append(storeData);
				$("#showDiv2").show();
				$("#showDiv3").show();
			} else {
				$("#showDiv2").show();
				$("#showDiv3").show();
			}
		}
		else {
			$("#showDiv2").show();
			$("#showDiv3").show();
		}
	});
});

$(document).ready(function() {
$("#showSelectedMaterial").on('click', '.crossButtonGroup', function() {
	var groupNameId = $(this).closest("tr").find('#groupNameId').val();
	var groupMaterialId = $(this).closest("tr").find('#groupMaterialId').val();
	removeSelectedGroupName = $(this).closest("tr").find('td').text();
	removeSelectedGroupName = removeSelectedGroupName.substr(1);
	removeSelectedGroupName = removeSelectedGroupName.substr(0, removeSelectedGroupName.length - 1);
	$("#groupNameCheckbox" + groupNameId).removeAttr('checked');
	$(this).closest('tr').remove();
	$('.bioMaterialNameList'+groupNameId+'').remove();
	selectedGroupNameArray = arrayRemove(selectedGroupNameArray, removeSelectedGroupName);
	selectedMaterialAndGroupMaterialsArray = arrayRemove(selectedMaterialAndGroupMaterialsArray, groupMaterialId);
});
});

$(document).ready(function() {
$("#showSelectedMaterial").on('click', '.crossButton', function() {
	if(selectedMaterialAndGroupMaterialsArray != ""){
	var materialId = $(this).closest("tr").find('#matId').val();
	removeSelectedMaterialName = $(this).closest("tr").find('td').text();
	removeSelectedMaterialName = removeSelectedMaterialName.substr(0, removeSelectedMaterialName.length - 1);
	$("#checkValue" + materialId).removeAttr('checked');
	$(this).closest('tr').remove();
	selectedMaterialSize = selectedMaterialSize - 1;
	selectedMaterialNameArray = arrayRemove(selectedMaterialNameArray, removeSelectedMaterialName);
	selectedMaterialAndGroupMaterialsArray = arrayRemove(selectedMaterialAndGroupMaterialsArray, materialId);
	}else {
			$(this).closest('tr').remove();

	}
});
});

$(document).ready(function() {
	$("#showSelectedMaterial").on('click', '.expandButton', function() {
		var groupNameId = $(this).closest("tr").find('#groupNameId').val();
		if ($(this).val() == "yes") {
			$('.bioMaterialNameList'+groupNameId+'').show();
			var html = '';
			expandSelectedGroupName = $(this).closest("tr").find('td').text();
			expandSelectedGroupName = expandSelectedGroupName.substr(1);
			expandSelectedGroupName = expandSelectedGroupName.substr(0, expandSelectedGroupName.length - 1);
			$.get("expandForExsistingBioMaterial?groupName=" + expandSelectedGroupName, function(response) {
				var data = JSON.parse(response);
				console.log(data);
				data.forEach(function(materiallist) {
					html += '<li>' + materiallist.longDesc.toUpperCase() + '</li><br>';
				});
				html = '<ul class= "removebullet">' + html + '</ul>';
				$('#materialNameList'+groupNameId+'').html(html);
				$('#materialNameList'+groupNameId+'').show();
				$("#showSelectedMaterial").show();
				$("#showDiv2").show();
				$("#showDiv3").show();
			});
			$(this).val("no");
		} else {
			$('#materialNameList'+groupNameId+'').hide();
			$('.bioMaterialNameList'+groupNameId+'').hide();
			$(this).val("yes");
		}
	});
	});

$(document).ready(function() {
$("#saveGroup").on("click", function() {
	var status = 1;
	materialsNameList = $("#materialList").val();		
	if(materialsNameList == undefined){
	if (selectedMaterialAndGroupMaterialsArray != "") {
		exsistingGroupMaterialsArray.push(selectedMaterialAndGroupMaterialsArray);
		if(btnDeleteid != "") {
			status = 0;
		}
		var bioGroupName = $("#bioGroupName").val();
		$.get("saveMaterialInGroup?selectedMaterialAndGroupMaterialsArray=" + exsistingGroupMaterialsArray + "&selectedMaterialSize=" + selectedMaterialSize + "&groupName=" + bioGroupName + "&status=" + status, function(response) {
			var jsonData = JSON.parse(response);
			if (jsonData['data']) {
				$("#SuccessResponse").html(jsonData['data']);
				jQuery('#showSelectedMaterial').empty();
				$("#bioGroupName").val('');
				$("#displayGroupName").hide();
				$("#right").hide();
				$("#showDiv1").hide();
				$("#showDiv2").hide();
				$("#showDiv3").hide();
				$("#showExpandedMaterial").hide();
				$('#errorMsg').empty();
				$('#select50').empty();
				$("#material").removeAttr('checked');
				$("#group").removeAttr('checked');
				selectedMaterialIdArray = [];
				selectedMaterialAndGroupMaterialsArray = [];
				exsistingGroupMaterialsArray = [];
				selectedMaterialSize = 0;
				if($('#searchBarOfGroup').css('display','block')){
					$('#searchBarOfGroup').css('display','none')
				}
				if($('#searchBarOfMaterial').css('display','block')){
					$('#searchBarOfMaterial').css('display','none')
				}
			}

			if (jsonData['msg']) {
				$("#errorMsg").html(jsonData['msg']);
				$('#errorMsg').css("color", "red");
				$("#SuccessResponse").empty();
			}
			if (jsonData['already']) {
				$("#errorMsg").html(jsonData['already']);
				$('#errorMsg').css("color", "red");
				$("#SuccessResponse").empty();
			}
			if (jsonData['select50']) {
				$("#select50").html(jsonData['select50']);
				$('#select50').css("color", "red");
				$("#SuccessResponse").empty();
			}
		});
	} else if(btnDeleteid != "" && selectedMaterialAndGroupMaterialsArray == ""){
			$.alert({
					title: 'Alert!',
					content: 'Please Add Material OR Group.!',
				});
		} 
	} else if(materialsNameList != "" && btnDeleteid == "" && selectedMaterialAndGroupMaterialsArray == "") {
		$.alert({
				title: 'Alert!',
				content: 'Please Add Material OR Group.!',
			});
	} else {
		materialsNameList = materialsNameList.replace(/\s*,\s*/g, ",");
			materialsNameList = materialsNameList.replace(/[\[\]']+/g,'');
			exsistingGroupMaterialsArray.push(materialsNameList);
			$("#materialList").val("");
		if(btnDeleteid != ""){	
			exsistingGroupMaterialsArray.pop(materialsNameList);
			exsistingGroupMaterialsArray.push(exsistingMaterialsNameList[exsistingMaterialsNameList.length - 1]);
			$("#materialList").val("");			
		}	
		if(selectedMaterialAndGroupMaterialsArray != ""){
			exsistingGroupMaterialsArray.push(selectedMaterialAndGroupMaterialsArray);
		}
		console.log(exsistingGroupMaterialsArray);
		var bioGroupName = $("#bioGroupName").val();
		if(exsistingGroupMaterialsArray != "") {
			$.get("saveEditMaterialInGroup?exsistingGroupMaterialsArray=" + exsistingGroupMaterialsArray + "&selectedMaterialSize=" + selectedMaterialSize + "&groupName=" + bioGroupName, function(response, error) {			
				var jsonData = JSON.parse(response);
				if (jsonData['data']) {
					$("#SuccessResponse").html(jsonData['data']);
					jQuery('#showSelectedMaterial').empty();
					$("#bioGroupName").val('');
					$("#displayGroupName").hide();
					$("#right").hide();
					$("#showDiv1").hide();
					$("#showDiv2").hide();
					$("#showDiv3").hide();
					$("#showExpandedMaterial").hide();
					$('#errorMsg').empty();
					$('#select50').empty();
					$("#material").removeAttr('checked');
					$("#group").removeAttr('checked');
					selectedMaterialIdArray = [];
					selectedMaterialAndGroupMaterialsArray = [];
					exsistingGroupMaterialsArray = [];
					selectedMaterialSize = 0;
					if($('#searchBarOfGroup').css('display','block')){
						$('#searchBarOfGroup').css('display','none')
					}
					if($('#searchBarOfMaterial').css('display','block')){
						$('#searchBarOfMaterial').css('display','none')
					}
				}
	
				if (jsonData['msg']) {
					$("#errorMsg").html(jsonData['msg']);
					$('#errorMsg').css("color", "red");
					$("#SuccessResponse").empty();
				}
				if (jsonData['already']) {
					$("#errorMsg").html(jsonData['already']);
					$('#errorMsg').css("color", "red");
					$("#SuccessResponse").empty();
				}
				if (jsonData['select50']) {
					$("#select50").html(jsonData['select50']);
					$('#select50').css("color", "red");
					$("#SuccessResponse").empty();
				}
			});
		} 
	}
});
});

$(document).ready(function() {	
$(".clickedOpenPopup").on("click",function(){
	var groupId = $(this).closest("td").find("#groupId").val();
	if(groupId != null){
	$.get("getBioGroupingUsingId?groupId=" + groupId, function(response) {
        var groupDetails = "";	
        var groupMaterial = "";
        var errorMsg = "";
		var materialName = JSON.parse(response);
		console.log(JSON.stringify(materialName));
		for(var i = 0; i<materialName.msg.length; i++){
			groupDetails += "<TR><TD>ID</TD><TD>"+materialName.msg[i].id+"</TD></TR><TR><TD>GroupName</TD><TD>"+materialName.msg[i].groupName+"</TD></TR>"+
			                "<TR><TD>Added By</TD><TD>"+materialName.msg[i].addedBy+"</TD></TR><TR><TD>Updated By</TD><TD>"+materialName.msg[i].updatedBy+"</TD></TR>"+
			                "<TR><TD>Created At</TD><TD>"+materialName.msg[i].createdAt+"</TD></TR><TR><TD>Updated At</TD><TD>"+materialName.msg[i].updatedAt+"</TD></TR>";
		}
		if(materialName.data.length !=0){
		for(var j = 0; j<materialName.data.length; j++){
			groupMaterial +="<TR class='header'><TD>"+materialName.data[j].shortDesc+"</TD></TR>";
		}
		$("#dynamicMaterialName").html(groupDetails);
		$("#materialName").html(groupMaterial);
		$("#errorMsg").empty();
		$(".abc").show();
		$(".header").hide();
		$("#myModal").modal('show');
		}
		else{
			errorMsg +="No Material in Group Containing.";
			$("#errorMsg").html(errorMsg);
			$('#errorMsg').css("color", "red");
			$("#dynamicMaterialName").html(groupDetails);
		    $("#materialName").html(groupMaterial)

			$(".abc").show();
		$(".header").hide();
		$("#myModal").modal('show');
		}
		
		
		});
		}
		else{
			$("#clickedOpenPopup").focus();
			$.alert({
				title: 'Alert!',
				content: 'No Group .!',
			});
		}
});
});


$(function () {
        $(".header").hide();
$("#btn1").click(function () {
            $('.buttonInactive').not(this).removeClass('buttonInactive');
            $(this).toggleClass('buttonActive');
            if ($(this).hasClass("buttonActive")) {
                $(".header").show();
            }
            else {
                $(".header").hide();
            }
        });
});

$(document).ready(function(){
    var size_item = $('.listing').length;
    var v=3;
    $('.listing').hide();
    $('.listing:lt('+v+')').show();
    $('#load_more').click(function () {
        v= (v+5 <= size_item) ? v+5 : size_item;
        $('.listing:lt('+v+')').show();
        if($(".listing:visible").length >= size_item ){ $("#load_more").hide(); }
    });
});

$(document).ready(function() {
	if($('.materialList').css('display','none')){
		$('.materialList').css('display','block')
	}
});

$(document).ready(function() {
	$("#showSelectedMaterial").on('click', '.crossButton', function() {
		if(materialsNameList == ""){
			materialsNameList = ($("#materialList").val());
		}	
	materialsNameList = materialsNameList.replace(/\s*,\s*/g, ",");
	materialsNameList = materialsNameList.replace(/[\[\]']+/g,'');
	var deleteExpandMaterial = $(this).closest("tr").find('#materialDeleteId').val();
	materialsNameList = materialsNameList.replace(deleteExpandMaterial, "");
	if(exsistingMaterialsNameList != "" && btnDeleteid == ""){
		exsistingMaterialsNameList.pop(materialsNameList);
	}
	exsistingMaterialsNameList.push(materialsNameList);
		btnDeleteid.push(deleteExpandMaterial);
		});
});
function getTextValue() {
	var firstIndex = $("#bioMaterialName").val();
	if (firstIndex != '') {
		console.log("Got First Index Of Material " + firstIndex + " Now fetching material");
		$.get("getSecondIndexBasedOnFirstIndex?firstIndex=" + firstIndex, function(response) {
			$('#selectedBioVariableId1').empty()
			var jsonValue = JSON.parse(response);
			console.log(jsonValue)
			var form = "";
			var process = "";
			if (jsonValue.msg.length == 0) {
				$("#process").find('option').remove();
				process += "<OPTION class='val' value = ''>No Selection</OPTION>";
				$("#process").html(process);
			}
			else {
				process += "<OPTION class='val' value = ''>No Selection</OPTION>";
				for (var i = 0; i < jsonValue.msg.length; i++) {
					process += "<OPTION class='val' value = " + jsonValue.msg[i] + ">" + jsonValue.msg[i] + "</OPTION>";
					$("#process").html(process);
				}
			}
			if (jsonValue.data.length == 0) {
				$("#form").find('option').remove();
				form += "<OPTION class='val' value = ''>No Selection</OPTION>";
				$("#form").html(form);
			}
			else {
				form += "<OPTION class='val' value = ''>No Selection</OPTION>";
				for (var i = 0; i < jsonValue.data.length; i++) {
					form += "<OPTION class='val' value = " + jsonValue.data[i] + ">" + jsonValue.data[i] + "</OPTION>";
					$("#form").html(form);
				}
			}
		})
	}
}

function arrayRemove(arr, value) {
	return arr.filter(function(ele) {
		return ele != value;
	});
}

function getOccurrence(array, value) {
	var count = 0;
	array.forEach((v) => (v === value && count++));
	return count;
}
