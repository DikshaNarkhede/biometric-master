package edu.cornell.cals.biomat.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.cornell.cals.biomat.dao.BioGrouping;
import edu.cornell.cals.biomat.dao.BioMaterial;
import edu.cornell.cals.biomat.model.material.BioMaterialSearchForm;
import edu.cornell.cals.biomat.model.material.BioMaterialSearchResultsForm;
import edu.cornell.cals.biomat.service.BioMaterialGroupingService;

@Controller
public class BioMaterialsGroupingController {
	private static final int PAGE_SIZE = 10;
	private static final int PAGER_ELEMENTS = 15;
	Logger logger = LoggerFactory.getLogger(BioMaterialsGroupingController.class);

	@Autowired
	protected BioMaterialGroupingService bioMaterialGroupingService;

	@GetMapping("selectionOfMaterialOrGroup")
	public ModelAndView selectOfMaterialOrGroup(@RequestParam(value = "groupId", required = false) Long groupId) {
		ModelAndView mv = null;
		List<Long> list = null;
		if (groupId == null) {
			logger.info("Display selectionOfMaterialOrGroup");
			BioMaterialSearchForm BMSF = new BioMaterialSearchForm();
			mv = new ModelAndView("materials/selectionOfMaterialOrGroup", "bioMaterialSearchForm", BMSF);
		} else if (groupId != null) {
			List<String> groupMaterialNameList = new ArrayList<>();
			List<String> groupMaterialId = new ArrayList<>();
			BioGrouping bioGrouping = bioMaterialGroupingService.getGroupNameAndIdBasedOnId(groupId);
			System.out.println("groupId" + bioGrouping);
			String commaSeperated = bioGrouping.getMaterialsInGroup().replaceFirst("^,", "");
			if(commaSeperated != "") {
				list = Arrays.stream(commaSeperated.split(",")).map(Long::parseLong)
						.collect(Collectors.toList());
			}					
			List<BioMaterial> materialName = bioMaterialGroupingService.getMaterialNameById(list);
			System.out.println("materialName" + materialName);

			materialName.forEach(materialNameList -> {
				groupMaterialNameList.add(String.valueOf(materialNameList.getLongDesc().toUpperCase()));
				groupMaterialId.add(String.valueOf(materialNameList.getId()));
			});
			mv = new ModelAndView("materials/selectionOfMaterialOrGroup", "materialName", materialName);
			mv.addObject("groupName", bioGrouping);
			mv.addObject("groupMaterialId", groupMaterialId);
		}
		return mv;
	}

	@GetMapping("searchBioMaterialsForGrouping")
	public ModelAndView displaySearchBioMaterialForGrouping() {

		logger.info("Display searchBioMaterialsForGrouping");
		BioMaterialSearchForm BMSF = new BioMaterialSearchForm();
		ModelAndView mv = new ModelAndView("materials/searchBioMaterialForGrouping", "bioMaterialSearchForm", BMSF);
		return mv;
	}

	@GetMapping("searchBioMaterialsForGrouping1")
	public ResponseEntity<String> displaySearchResultBioMaterialForGrouping(
			@RequestParam(value = "firstIndex", required = false) String firstIndex,
			@RequestParam(value = "process", required = false) String process,
			@RequestParam(value = "form", required = false) String form,
			@Valid @ModelAttribute BioMaterialSearchForm bioMaterialSearchForm, BindingResult bindingResult)
			throws Exception {
		logger.info("Start searchBioMaterials with params {}", bioMaterialSearchForm);
		List<String> list = new ArrayList();
		List<String> idList = new ArrayList();
		ObjectMapper mapper = new ObjectMapper();
		String s = null;
		List<BioMaterial> bmList = bioMaterialGroupingService.getBioMaterialNameByNameAndProcessAndForm(firstIndex,
				process, form);
		if(bmList.isEmpty()) {
			String str = mapper.writeValueAsString("No material found");
			s = "{\"data\":\"\", \"msg\":\"\", \"error\":" + str + "}";			
		} else {
			bmList.forEach(bio -> {
				idList.add(String.valueOf(bio.getId()));
				list.add(bio.getLongDesc().toUpperCase());
			});
			String id = mapper.writeValueAsString(idList);
			String longDesc = mapper.writeValueAsString(list);
			s = "{\"msg\":" + id + ", \"data\":" + longDesc + ", \"error\":\"\"}";
		}
		logger.info("Returning dataPointLists{} {}  ", s);
		return ResponseEntity.ok(s);
	}

	@GetMapping("saveMaterialInGroup")
	public ResponseEntity<String> saveGroupOfMaterial(
			@RequestParam(value = "selectedMaterialAndGroupMaterialsArray", required = false) List<Integer> selectedMaterialAndGroupMaterialsArray,
			@RequestParam(value = "selectedMaterialSize", required = false) Integer selectedMaterialSize,
			@RequestParam(value = "groupName", required = false) String groupName, @RequestParam(value = "status", required = false) Integer status, HttpServletRequest request,
			@AuthenticationPrincipal Principal principal) throws Exception {
		String s = null;
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> response = new HashMap<>();
		StringBuilder strbul = new StringBuilder();
		String userName = principal.getName();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String updatedDate = dtf.format(now);
		List<Integer> listWithoutDuplicateMaterial = selectedMaterialAndGroupMaterialsArray.stream().distinct()
				.collect(Collectors.toList());
		while (listWithoutDuplicateMaterial.remove(null)) {
		}
		for (Integer bioMaterial : listWithoutDuplicateMaterial) {
			strbul.append(bioMaterial);
			strbul.append(",");
		}
		String strr = strbul.toString();
		String exsistingGroupName = bioMaterialGroupingService.getGroupDistinctName(groupName);
		BioGrouping bioGrouping = bioMaterialGroupingService.getMaterialIsExistOrNot(groupName);
		if (groupName == "") {
			String str = mapper.writeValueAsString("Group Name is Required.");
			String s1 = "{\"data\":\"\", \"msg\":" + str + "}";
			return ResponseEntity.ok(s1);
		} else if (status == 1 && exsistingGroupName != null && bioGrouping.getMaterialsInGroup() != "") {
			String str = mapper.writeValueAsString("The Grouping Name is already taken. Please use another name.");
			String s1 = "{\"data\":\"\", \"already\":" + str + "}";
			return ResponseEntity.ok(s1);
		} else if (status == 0 && exsistingGroupName != null && bioGrouping.getMaterialsInGroup() != "") {
			String nullMaterial = "";
			boolean updateMaterialNull = bioMaterialGroupingService.deleteBioGroupingMaterialUsingGroupName(groupName, nullMaterial);
			if(updateMaterialNull == true) {
				boolean bgId = bioMaterialGroupingService.editGroupUsingGroupId(groupName, strr, userName, updatedDate);
				if (bgId == true) {
					response.put("success", "Group is Successfully Add");
				} else {
					response.put("success", "Error in Group Submission");
				}
				String str = mapper.writeValueAsString(response.get("success"));
				s = "{\"msg\":\"\", \"data\":" + str + "}";
				return ResponseEntity.ok(s);
			}
		} else if (status == 1 && exsistingGroupName != null && bioGrouping.getMaterialsInGroup() == "") {
			boolean bgId = bioMaterialGroupingService.editGroupUsingGroupId(groupName, strr, userName, updatedDate);
			if (bgId == true) {
				response.put("success", "Group is Successfully Add");
			} else {
				response.put("success", "Error in Group Submission");
			}
			String str = mapper.writeValueAsString(response.get("success"));
			s = "{\"msg\":\"\", \"data\":" + str + "}";
			return ResponseEntity.ok(s);
		} else {
			logger.info("selectedMaterialSize {}", selectedMaterialSize);
			if (selectedMaterialSize > 50) {
				String select50Material = mapper.writeValueAsString(
						"Error in Grouping Of Bio-Material. Please select Minimun 1 or Maximum 50 material.");
				String s1 = "{\"data\":\"\", \"select50\":" + select50Material + "}";
				return ResponseEntity.ok(s1);
			} else {
				BioGrouping bg = new BioGrouping();
				bg.setGroupName(groupName.toLowerCase());
				bg.setMaterialsInGroup(strr);
				bg.setAddedBy(principal.getName());
				BioGrouping bgId = bioMaterialGroupingService.updateBioMaterialGrouping(bg);
				if (bgId.getId() != 0) {
					response.put("success", "Group is Successfully Add");
				} else {
					response.put("success", "Error in Group Submission");
				}
			}

			String str = mapper.writeValueAsString(response.get("success"));
			s = "{\"msg\":\"\", \"data\":" + str + "}";
		}
		return ResponseEntity.ok(s);
	}

	@GetMapping("saveBioMaterialsForGrouping")
	public ModelAndView saveBioMaterialsForGrouping() {

		logger.info("Display saveBioMaterialsForGrouping");
		BioMaterialSearchForm BMSF = new BioMaterialSearchForm();
		ModelAndView mv = new ModelAndView("materials/searchResultOfBioMaterialForGrouping", "bioMaterialSearchForm",
				BMSF);
		return mv;
	}

	@GetMapping("addBioMaterialForGrouping")
	public ModelAndView addBioMaterialForGrouping() {

		logger.info("Display addBioMaterialForGrouping");
		BioMaterialSearchForm BMSF = new BioMaterialSearchForm();
		ModelAndView mv = new ModelAndView("materials/saveResultOfGroupingOfBioMaterial", "bioMaterialSearchForm",
				BMSF);
		return mv;
	}

	@GetMapping("searchBioMaterialInGroupedMaterial")
	public ModelAndView searchMaterailGroup() {

		logger.info("Display searchBioMaterialInGroupedMaterial");
		BioMaterialSearchForm BMSF = new BioMaterialSearchForm();
		ModelAndView mv = new ModelAndView("materials/searchGroupedNameOfBioMaterial", "bioMaterialSearchForm", BMSF);
		return mv;
	}

	@PostMapping("searchBioMaterialInGroupedMaterial")
	public ModelAndView groupResult(HttpServletRequest request,
			@ModelAttribute @Valid BioMaterialSearchForm bioMaterialSearchForm, BindingResult bindingResult) {
		logger.info("Start searchBio Material Group with params {}", bioMaterialSearchForm);
		List<BioMaterial> bioMaterialName = bioMaterialGroupingService
				.getBioMaterialNameByName(bioMaterialSearchForm.getBioMaterialName());
		BioMaterialSearchResultsForm BMSRF = new BioMaterialSearchResultsForm();
		ModelAndView mv = null;
		if (bioMaterialSearchForm.getBioMaterialName().isEmpty()) {
			logger.info("Error in Form Submission.  NOT Searching for  Data. ");
			bindingResult.rejectValue("groupName", "error.groupName", "must not be empty");
			mv = new ModelAndView("materials/searchGroupedNameOfBioMaterial");
		} else if (bioMaterialName.size() == 0) {
			BMSRF.setMessage("No Biomaterial Found with Name [" + bioMaterialSearchForm.getBioMaterialName() + "]");
			mv = new ModelAndView("materials/searchGroupedNameOfBioMaterial", "bioMaterialSearchResultsForm", BMSRF);
		} else {
			List<BioGrouping> bioGroup = bioMaterialGroupingService
					.searchBioGroupNameByBioMaterial(bioMaterialSearchForm.getBioMaterialName());
			BMSRF.setBioGrouping(bioGroup);
			BMSRF.setBioMaterialSearchForm(bioMaterialSearchForm);
			mv = new ModelAndView("materials/searchResultOfGroupedMaterial", "bioMaterialSearchResultsForm", BMSRF);
		}
		return mv;
	}

	@GetMapping("addMaterialInExstingGroup")
	public ModelAndView addMaterialInExstingGroup() {
		logger.info("Start addMaterialInExstingGroup {}");
		BioMaterialSearchForm BMSF = new BioMaterialSearchForm();
		ModelAndView mv = new ModelAndView("materials/searchBioMaterialForGrouping", "bioMaterialSearchForm", BMSF);
		return mv;
	}

	@PostMapping("addMaterialInExstingGroup")
	public ModelAndView addMaterialInExstingGroup(HttpServletRequest request,
			@ModelAttribute @Valid BioMaterialSearchForm bioMaterialSearchForm, BindingResult bindingResult) {
		logger.info("Start addMaterialInExstingGroup with params {}", bioMaterialSearchForm);
		ModelAndView mv = null;
		if (bioMaterialSearchForm.getGroupName() == null) {
			List<BioGrouping> bioGroup = bioMaterialGroupingService
					.searchBioGroupNameByBioMaterial(bioMaterialSearchForm.getBioMaterialName());
			BioMaterialSearchResultsForm BMSRF = new BioMaterialSearchResultsForm();
			BMSRF.setBioGrouping(bioGroup);
			BMSRF.setBioMaterialSearchForm(bioMaterialSearchForm);
			BMSRF.setMessage("Error In Selecting Grouped Of Bio-Material. Please Select Grouped Name");
			mv = new ModelAndView("materials/searchResultOfGroupedMaterial", "bioMaterialSearchResultsForm", BMSRF);
		} else {
			HttpSession session = request.getSession();
			bioMaterialSearchForm.setBioMaterialName(null);
			mv = new ModelAndView("materials/searchBioMaterialForGrouping", "bioMaterialSearchForm",
					bioMaterialSearchForm);
			session.setAttribute("preExstingGroupId", bioMaterialSearchForm.getGroupName());
		}
		return mv;
	}

	@GetMapping("expandForExsistingBioMaterial")
	public ResponseEntity<String> expandForExsistingBioMaterial(@RequestParam("groupName") String groupName)
			throws Exception {
		logger.info("Start searchBioMaterials with params {}", groupName);
		BioGrouping bg = bioMaterialGroupingService.getMaterialIsExistOrNot(groupName);
		String commaSeperated = bg.getMaterialsInGroup().replaceFirst("^,", "");
		List<Long> list = Arrays.stream(commaSeperated.split(",")).map(Long::parseLong).collect(Collectors.toList());
		List<BioMaterial> materialName = bioMaterialGroupingService.getMaterialNameById(list);
		ObjectMapper mapper = new ObjectMapper();
		String groupedMaterialList = mapper.writeValueAsString(materialName);
		return ResponseEntity.ok(groupedMaterialList);
	}

	@GetMapping("getSecondIndexBasedOnFirstIndex")
	public ResponseEntity<String> searchBioMaterialNameUsingFirstIndex(@RequestParam("firstIndex") String firstIndex,
			HttpServletRequest request, @Valid @ModelAttribute BioMaterialSearchForm bioMaterialSearchForm,
			BindingResult bindingResult) throws Exception {
		Map<List<String>, List<String>> map = bioMaterialGroupingService.getBioMaterialBasedOnProcess(firstIndex);
		Map<String, Object> maps = new HashMap<>();
		map.forEach((process, form) -> {
			maps.put("process", process);
			maps.put("form", form);
		});
		ObjectMapper mapper = new ObjectMapper();
		String process = mapper.writeValueAsString(maps.get("process"));
		String form = mapper.writeValueAsString(maps.get("form"));
		String s = "{\"msg\":" + process + ", \"data\":" + form + "}";
		return ResponseEntity.ok(s);
	}

	@GetMapping("searchResultOfBioMaterialInGroupedMaterial")
	public ResponseEntity<String> searchResultOfBioMaterialInGroupedMaterial(
			@RequestParam("bioMaterialGroupName") String bioMaterialGroupName) throws Exception {
		logger.info("Start searchBio Material Group with params {}", bioMaterialGroupName);
		List<String> groupNameList = new ArrayList<>();
		List<String> groupNameMaterialId = new ArrayList<>();
		List<String> groupNameId = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		String groupedName = null;
		List<BioGrouping> listOfGroup = bioMaterialGroupingService.getAllBioGroupingBasedOnTheSearch(bioMaterialGroupName);
		if(listOfGroup.isEmpty()) {
			String str = mapper.writeValueAsString("No Group Found with Name [" + bioMaterialGroupName + "]");
			groupedName = "{\"materialId\":\"\", \"data\":\"\" , \"id\":\"\", \"error\":" + str + "}";
		} else {
			listOfGroup.forEach(groupName -> {
				groupNameMaterialId.add(String.valueOf(groupName.getMaterialsInGroup()));
				groupNameList.add(groupName.getGroupName());
				groupNameId.add(String.valueOf(groupName.getId()));
			});
			String materialId = mapper.writeValueAsString(groupNameMaterialId);
			String groupName = mapper.writeValueAsString(groupNameList);
			groupedName = "{\"materialId\":" + materialId + ", \"data\":" + groupName + " , \"id\":" + groupNameId
					+ "}";
		}
		logger.info("Returning dataPointLists{} {}  ", groupedName);
		return ResponseEntity.ok(groupedName);
	}

	@GetMapping("searchBioMaterialGroups")
	public ModelAndView searchBioMaterialGroup() {
		logger.info("search bio material group");
		BioMaterialSearchForm searchGroup = new BioMaterialSearchForm();
		ModelAndView mv = new ModelAndView("materials/searchBioMaterialGroups", "bioMaterialSearchForm", searchGroup);
		return mv;
	}

	@PostMapping("searchBioMaterialGroups")
	public ModelAndView getBioGroupBasedOnTheSearch(HttpServletRequest request,
			@ModelAttribute @Valid BioMaterialSearchForm bioMaterialSearchForm, BindingResult bindingResult) {
		ModelAndView mv = null;
		logger.info("get bio material group");		
			List<BioGrouping> listOfGroup = bioMaterialGroupingService
					.getAllBioGroupingBasedOnTheSearch(bioMaterialSearchForm.getGroupName());
			if(listOfGroup.isEmpty()) {
				BioMaterialSearchForm searchGroup = new BioMaterialSearchForm();
				mv = new ModelAndView("materials/searchBioMaterialGroups", "bioMaterialSearchForm", searchGroup);
				searchGroup.setMessage("No Group Found with Name [" + bioMaterialSearchForm.getGroupName() + "]");
			} else {
				mv = new ModelAndView("materials/searchBioMaterialGroups", "listOfGroup", listOfGroup);
			}						
		return mv;
	}

	@GetMapping("editBioGroup")
	public ResponseEntity<String> editBioGroupPage(@RequestParam(value = "groupId", required = false) Long groupId)
			throws Exception {
		logger.info("Start editBioMaterialFormulaPage {}", groupId);
		List<String> groupMaterialNameList = new ArrayList<>();
		List<String> groupMaterialId = new ArrayList<>();
		BioGrouping bioGrouping = bioMaterialGroupingService.getGroupNameAndIdBasedOnId(groupId);
		System.out.println("groupId" + bioGrouping);
		String commaSeperated = bioGrouping.getMaterialsInGroup().replaceFirst("^,", "");
		List<Long> list = Arrays.stream(commaSeperated.split(",")).map(Long::parseLong).collect(Collectors.toList());
		List<BioMaterial> materialName = bioMaterialGroupingService.getMaterialNameById(list);
		System.out.println("materialName" + materialName);

		materialName.forEach(materialNameList -> {
			groupMaterialNameList.add(String.valueOf(materialNameList.getLongDesc()));
			groupMaterialId.add(String.valueOf(materialNameList.getId()));
		});
		ObjectMapper mapper = new ObjectMapper();
		String groupMaterialName = mapper.writeValueAsString(groupMaterialNameList);
		String bioGroupMaterialId = mapper.writeValueAsString(groupMaterialId);
		String existingGrouped = "{\"groupMaterialName\":" + groupMaterialName + ", \"bioGroupMaterialId\":"
				+ bioGroupMaterialId + "}";
		logger.info("Returning dataPointLists{} {}  ", existingGrouped);
		return ResponseEntity.ok(existingGrouped);
	}

	@GetMapping("getBioGroupingUsingId")
	public ResponseEntity<String> getBioGroupOnTheId(@RequestParam(value = "groupId", required = false) Long groupId)
			throws Exception {
		BioGrouping bgs = null;
		List<Long> list = null;
		List<BioGrouping> listOf = new ArrayList<>();
		BioGrouping bg = bioMaterialGroupingService.getGroupNameAndIdBasedOnId(groupId);
		if(bg.getMaterialsInGroup() != "") {
			list = Arrays.stream(bg.getMaterialsInGroup().split(",")).map(Long::parseLong)
					.collect(Collectors.toList());
		}	
		List<BioMaterial> materialName = bioMaterialGroupingService.getMaterialNameById(list);
		List<BioGrouping> bgList = Arrays.asList(bg);
		for (BioGrouping group : bgList) {
			bgs = new BioGrouping();
			bgs.setId(group.getId());
			bgs.setGroupName(group.getGroupName());
			bgs.setAddedBy(group.getAddedBy());
			bgs.setUpdatedBy(group.getUpdatedBy());
			bgs.setCreatedAt(group.getCreatedAt());
			bgs.setUpdatedAt(group.getUpdatedAt());
		}
		listOf.add(bgs);
		ObjectMapper mapper = new ObjectMapper();
		String materialNames = mapper.writeValueAsString(materialName);
		String groupDetails = mapper.writeValueAsString(listOf);
		String listMaterialName = "{\"msg\":" + groupDetails + ",\"data\":" + materialNames + "}";
		logger.info("Returning groupDetails {}  ", listMaterialName);
		return ResponseEntity.ok(listMaterialName);
	}

	@GetMapping("saveEditMaterialInGroup")
	public ResponseEntity<String> saveEditGroupOfMaterial(
			@RequestParam(value = "exsistingGroupMaterialsArray", required = false) List<Integer> exsistingGroupMaterialsArray,
			@RequestParam(value = "selectedMaterialSize", required = false) Integer selectedMaterialSize,
			@RequestParam(value = "groupName", required = false) String groupName, HttpServletRequest request,
			@AuthenticationPrincipal Principal principal) throws Exception {
		String s = null;
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> response = new HashMap<>();
		StringBuilder strbul = new StringBuilder();
		String userName = principal.getName();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String updatedDate = dtf.format(now);
		List<Integer> listWithoutDuplicateMaterial = exsistingGroupMaterialsArray.stream().distinct()
				.collect(Collectors.toList());
		while (listWithoutDuplicateMaterial.remove(null)) {
		}
		for (Integer bioMaterial : listWithoutDuplicateMaterial) {
			strbul.append(bioMaterial);
			strbul.append(",");
		}
		String strr = strbul.toString();
		logger.info("selectedMaterialSize {}", selectedMaterialSize);
		if (selectedMaterialSize != null) {
			if (selectedMaterialSize > 50) {
				String select50Material = mapper.writeValueAsString(
						"Error in Grouping Of Bio-Material. Please select Minimun 1 or Maximum 50 material.");
				String s1 = "{\"data\":\"\", \"select50\":" + select50Material + "}";
				return ResponseEntity.ok(s1);
			} else {
				boolean bgId = bioMaterialGroupingService.editGroupUsingGroupId(groupName, strr, userName, updatedDate);
				if (bgId == true) {
					response.put("success", "Group is Successfully Add");
				} else {
					response.put("success", "Error in Group Submission");
				}
			}
		} else {
			boolean bgId = bioMaterialGroupingService.editGroupUsingGroupId(groupName, strr, userName, updatedDate);
			if (bgId == true) {
				response.put("success", "Group is Successfully Add");
			} else {
				response.put("success", "Error in Group Submission");
			}
		}
		String str = mapper.writeValueAsString(response.get("success"));
		s = "{\"msg\":\"\", \"data\":" + str + "}";
		return ResponseEntity.ok(s);
	}
	
	@GetMapping("deleteGroupUsingGroupId")
	public ModelAndView deleteGroupUsingId(@RequestParam(value = "groupId", required = false) Long groupId, @RequestParam(value = "groupName", required = false) String groupName,  @ModelAttribute BioMaterialSearchForm bioMaterialSearchForm, BindingResult result) {
		logger.info("deleteGroupUsingId {}", groupId);
		ModelAndView mv = null;
		boolean flagResult = bioMaterialGroupingService.removeGroupUsingId(groupId);
		if(flagResult == true) {
			logger.info("group is deleted {}", groupId);
			List<BioGrouping> listOfGroup = bioMaterialGroupingService
					.getAllBioGroupingBasedOnTheSearch(groupName);
			mv = new ModelAndView("materials/searchBioMaterialGroups", "listOfGroup", listOfGroup);
			return mv;
		}
		else {
			logger.warn("group is not deleted {}", groupId);
			List<BioGrouping> listOfGroup = bioMaterialGroupingService
					.getAllBioGroupingBasedOnTheSearch(groupName);
			mv = new ModelAndView("materials/searchBioMaterialGroups", "listOfGroup", listOfGroup);
			return mv;
		}
	}
}
