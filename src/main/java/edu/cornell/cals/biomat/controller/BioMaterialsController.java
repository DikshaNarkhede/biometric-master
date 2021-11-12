package edu.cornell.cals.biomat.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cornell.cals.biomat.dao.BioGrouping;
import edu.cornell.cals.biomat.dao.BioMaterial;
import edu.cornell.cals.biomat.dao.BioMaterialComposition;
import edu.cornell.cals.biomat.model.material.BioMaterialCompositionForm;
import edu.cornell.cals.biomat.model.material.BioMaterialSearchForm;
import edu.cornell.cals.biomat.model.material.BioMaterialSearchResultsForm;
import edu.cornell.cals.biomat.model.material.BioObservedPointsForm;
import edu.cornell.cals.biomat.model.material.EditBioFormulaForm;
import edu.cornell.cals.biomat.model.measurement.BioMeasurementForm;
import edu.cornell.cals.biomat.service.BioFormulaMaterialService;
import edu.cornell.cals.biomat.service.BioMatEmailService;
import edu.cornell.cals.biomat.service.BioMaterialCompositionService;
import edu.cornell.cals.biomat.service.BioMaterialGroupingService;
import edu.cornell.cals.biomat.service.BioMaterialService;

@Controller
public class BioMaterialsController {
	private static final int PAGE_SIZE 		= 10;
	private static final int PAGER_ELEMENTS = 15;
	Logger logger = LoggerFactory.getLogger(BioMaterialsController.class);
	
	
	@Autowired
	protected BioMaterialService bioMaterialService;
	@Autowired
	BioMatEmailService bioMatEmailService;
	@Autowired
	protected BioMaterialCompositionService bioMaterialCompositionService;
	//@Autowired
	//protected BioMeasurementRepository bioMeasurementRepository;
	
	@Autowired
	private BioMaterialGroupingService bioMaterialGroupingService;

	@Autowired
	protected BioFormulaMaterialService bioFormulaMaterialService;
	
	@GetMapping("bioObservedPoints")
	public ModelAndView displayBioObservedPoints() {
		logger.info("displayBioObservedPoints");
		BioObservedPointsForm bioObservedPointsForm = new BioObservedPointsForm();
		
		ModelAndView  mv = new ModelAndView("materials/bioObservedPoints","bioObservedPointsForm",bioObservedPointsForm);
		return mv;
	}	

	@PostMapping("updateFormulaMaterialAssociation")
	public ModelAndView formulaMaterialAssociation(@RequestParam(value="selectedFormulaId") Long selectedFormulaId,
			@RequestParam(value="selectedBioMaterialId", required=false) Long selectedBioMaterialId,
			@RequestParam(value="selectedBioGroupId", required=false) Long selectedBioGroupId,
			@RequestParam(value="userAction", required=false) String userAction	,
			@AuthenticationPrincipal Principal principal) {
		
		logger.info("userAction {}",userAction);
		EditBioFormulaForm editBioFormulaForm= new EditBioFormulaForm();
		BioMaterial bm  = null;
		BioGrouping bg = null;
		if(userAction.equals("addMaterialToFormula")){
			try {
				boolean b = bioFormulaMaterialService.addMaterialToBioFormula(selectedFormulaId, selectedBioMaterialId,principal.getName());
				if(b == true) {
					bm  = bioMaterialService.getBioMaterial(selectedBioMaterialId);
				}
				else {
				editBioFormulaForm.setErrorMessage("This Material is Already Associate to that Formula");
				}				
			}
			catch(Exception ex) {
				logger.error(ex.getMessage(),ex);
				editBioFormulaForm.setErrorMessage("Unable to add Material to the Formula.  Has the material already been added?");
			}
		}else if(userAction.equals("deleteMaterialFromFormula")){
			bioFormulaMaterialService.delete(""+selectedBioMaterialId, ""+selectedFormulaId);
		}
		if(userAction.equals("addGoupToFormula")) {
			try {
				boolean bgs = bioFormulaMaterialService.addGroupToBioFormula(selectedFormulaId, selectedBioGroupId, principal.getName());
				if(bgs == true) {
					bg = bioMaterialGroupingService.getGroupNameAndIdBasedOnId(selectedBioGroupId);
				}
				else {
					editBioFormulaForm.setErrorMessage("This Group is Already Associate to that Formula");
				}				
			}
			catch(Exception ex) {
				logger.error(ex.getMessage(),ex);
				editBioFormulaForm.setErrorMessage("Can not Associate Selected Group, Because data problem.");
			}
		}
		else if(userAction.equals("deleteGroupFromFormula")){
			bioFormulaMaterialService.deleteGroupBasedOnId(""+selectedBioGroupId, ""+selectedFormulaId);
		}
		editBioFormulaForm.setSelectedFormulaId(selectedFormulaId);
		List<BioMaterial> bmList = bioFormulaMaterialService.getBioMaterialByFormulaId(selectedFormulaId);
		List<BioGrouping> bgList = bioFormulaMaterialService.getBioGroupByFormulaId(selectedFormulaId);
		bmList = bmList.stream().distinct().collect(Collectors.toList());
		bgList = bgList.stream().distinct().collect(Collectors.toList());
		if(bm!=null) {
			//Remove null from the list
			bmList  =bmList.stream().filter(bioMaterial -> bioMaterial!=null).collect(Collectors.toList());
			bmList.add(bm);
		}
		if(bg != null) {
			bgList  =bgList.stream().filter(bioGroup -> bioGroup!=null).collect(Collectors.toList());
			bgList.add(bg);
		}
		while (bmList.remove(null)) {
        }
		while (bgList.remove(null)) {
        }
		if(bmList == null) {
			editBioFormulaForm.setBiomaterialSize(0);
		}else {
			editBioFormulaForm.setBiomaterialSize(1);
		}
		if(bgList == null) {
			editBioFormulaForm.setBioGroupSize(0);
		}else {
			editBioFormulaForm.setBioGroupSize(1);
		}

		editBioFormulaForm.setBioMaterials(bmList);
		editBioFormulaForm.setBioGrouping(bgList);
		ModelAndView  mv = new ModelAndView("materials/associateFormulaAndMaterial","editBioFormulaForm",editBioFormulaForm);
		return mv;
	}	
	
	@GetMapping("associateFormulaAndMaterial")
	public ModelAndView displayEditFormulaPage() {
		logger.info("displayBioMaterialNutrientsPage");
		EditBioFormulaForm editBioFormulaForm= new EditBioFormulaForm();
		ModelAndView  mv = new ModelAndView("materials/associateFormulaAndMaterial","editBioFormulaForm",editBioFormulaForm);
		return mv;
	}
	
	@GetMapping("updateFormulaMaterialAssociation")
	public ModelAndView displayUpdateFormulaMaterialAssociation() {
		logger.info("displayBioMaterialNutrientsPage");
		EditBioFormulaForm editBioFormulaForm= new EditBioFormulaForm();
		ModelAndView  mv = new ModelAndView("materials/associateFormulaAndMaterial","editBioFormulaForm",editBioFormulaForm);
		return mv;
	}
	
	@PostMapping("bioMaterialComposition")
	public ModelAndView getBioMaterialNutrients(@RequestParam(value="selectedBioMaterialId", required=true) Long materialId) {
		logger.info("getBioMaterialNutrients");
		BioMaterialCompositionForm bioMaterialCompositionForm = new BioMaterialCompositionForm();
		List<BioMaterialComposition> bioMaterialNutrientList = bioMaterialCompositionService.getComposition(materialId);
		logger.info("Fetched bioMaterialNutrientList {} {}", bioMaterialNutrientList.size()  );
		bioMaterialCompositionForm.setSelectedBioMaterialId(materialId);
		bioMaterialCompositionForm.setBioMaterialNutrientList(bioMaterialNutrientList);
		ModelAndView  mv = new ModelAndView("materials/bioMaterialComposition","bioMaterialCompositionForm",bioMaterialCompositionForm);
		return mv;
	}	

	
	@GetMapping("bioMaterialComposition")
	public ModelAndView displayBioMaterialNutrientsPage() {
		logger.info("Display bioMaterialComposition");
		BioMaterialCompositionForm bioMaterialCompositionForm = new BioMaterialCompositionForm();
		ModelAndView  mv = new ModelAndView("materials/bioMaterialComposition","bioMaterialCompositionForm",bioMaterialCompositionForm);
		return mv;
	}	

	
	
	@GetMapping("addBioMaterial")
	public ModelAndView displayAddBioMaterialPage() {
		logger.info("displayAddBioMaterialPage ");
		BioMaterial bioMaterial = new BioMaterial();
		ModelAndView  mv = new ModelAndView("materials/addBioMaterial","bioMaterial",bioMaterial);
		return mv;
	}	
	
	@PostMapping("addBioMaterial")
	public ModelAndView addBioMaterial(HttpServletRequest request, @Valid @ModelAttribute BioMaterial bioMaterial, BindingResult bindingResult,@AuthenticationPrincipal Principal principal) {
		logger.info("POST addBioMaterial:user {}  {}", bioMaterial , principal);
		ModelAndView  mv ;
		if(bindingResult.hasErrors()) {
			logger.info("Error in Form Submission.  NOT Updating Data. ");
			mv = new ModelAndView("materials/addBioMaterial","bioMaterial",bioMaterial);
			
		}
		else if(principal ==null) {
			throw new RuntimeException("User is not authorized to update a material");
		}
		else {
			bioMaterial.setAddedBy(principal.getName());
			BioMaterial bm = bioMaterialService.updateBioMaterial(bioMaterial,principal.getName());
			logger.info("bioMaterialService.updateBioMaterial {}", bm);		
			mv = new ModelAndView("materials/addBioMaterial","bioMaterial",bm);
			mv.addObject("successMessage", "Successfully Added Bio-Material");
			mv.addObject("successMessage", "Thanks for Contributing your Bio-Material.  A message is sent to the administrator for approval. You will get another email when administrator takes an action.");
			bioMatEmailService.emailBioMaterialAdded(principal);
		}
		return mv;	
	}	

	
	@GetMapping("updateBioMaterial")
	public ModelAndView displayUpdateBioMaterialPage(@RequestParam(value="materialId", required=true) Long materialId) {
		logger.info("updateBioMaterial {}", materialId );
		BioMaterial bioMaterial = bioMaterialService.getBioMaterial(materialId);
		BioMeasurementForm bioMeasurementForm = new BioMeasurementForm();
		logger.debug("Fetched BioMatrial {}", bioMaterial );
		
		ModelAndView  mv = new ModelAndView("materials/updateBioMaterial","bioMaterial",bioMaterial);
		mv.addObject("bioMeasurementForm", bioMeasurementForm);
		return mv;
	}	

	@PostMapping("updateBioMaterial")
	public ModelAndView updateBioMaterialPage(HttpServletRequest request, @Valid @ModelAttribute BioMaterial bioMaterial, BindingResult bindingResult,@AuthenticationPrincipal Principal principal) {
		logger.info("POST updateBioMaterial:user {}  {}", bioMaterial , principal);
		ModelAndView  mv ;
		if(bindingResult.hasErrors()) {
			logger.info("Error in Form Submission.  NOT Updating Data. ");
			mv = new ModelAndView("materials/updateBioMaterial","bioMaterial",bioMaterial);
			
		}
		else if(principal ==null) {
			throw new RuntimeException("User is not authorized to update a material");
		}
		else {
			BioMaterial bm = bioMaterialService.updateBioMaterial(bioMaterial,principal.getName());
			logger.info("bioMaterialService.updateBioMaterial {}", bm);		
			mv = new ModelAndView("materials/updateBioMaterial","bioMaterial",bm);
			mv.addObject("successMessage", "Successfully Updated Bio-Material");
		}
		return mv;
	}	

	
	@GetMapping("searchBioMaterials")
	public ModelAndView displaySearchBioMaterialsPage(@ModelAttribute BioMaterialSearchForm bioMaterialSearchForm) {
	        
		logger.info("Start searchBioMaterials {}" , bioMaterialSearchForm);
		BioMaterialSearchForm BMSF = new BioMaterialSearchForm();
		BMSF.setUsdaOnly("a");
		logger.debug("Start searchBioMaterials {}" , bioMaterialSearchForm);
		ModelAndView  mv = new ModelAndView("materials/searchBioMaterials","bioMaterialSearchForm",BMSF);
		return mv;
	}
	
	@PostMapping("searchBioMaterials")
	public ModelAndView paginatedBioMaterialsResultsPage(HttpServletRequest request, @ModelAttribute @Valid BioMaterialSearchForm bioMaterialSearchForm,BindingResult bindingResult,  @RequestParam(value="pageNumber", required=false, defaultValue = "0") Integer pageNumber) {
		logger.info("Start searchBioMaterials with params {}",bioMaterialSearchForm);;
		ModelAndView  mv =null;
		

		List<BioMaterial> bmList = new ArrayList<BioMaterial>();
		Map<String,Object> map = bioMaterialService.getBioMaterial(gotoPage(pageNumber), bioMaterialSearchForm.getBioMaterialName());
		Page<BioMaterial> boiMaterialPage = (Page<BioMaterial>)map.get("bioMaterialPage"); 		
		for(BioMaterial bm : boiMaterialPage){
			bmList.add(bm);
		}
		int totalBioMaterialPages= 	((int)map.get("count")) / PAGE_SIZE;
		if(((int)map.get("count")) % PAGE_SIZE > 0) totalBioMaterialPages++;
			
		BioMaterialSearchResultsForm BMSRF = new BioMaterialSearchResultsForm();
		
		if(totalBioMaterialPages <=  PAGER_ELEMENTS ) {
			BMSRF.setPagerStart(0);
			BMSRF.setPagerEnd(totalBioMaterialPages);
			
		}
		else {
			
			if(pageNumber <= 5) {
				BMSRF.setPagerStart(0);
				BMSRF.setPagerEnd(9);
			}
			else {
				
				BMSRF.setPagerStart(pageNumber-4);
				if(totalBioMaterialPages<(pageNumber+5))
					BMSRF.setPagerEnd(totalBioMaterialPages);
				else
					BMSRF.setPagerEnd(pageNumber+5);
			}
		}
		
		BMSRF.setBioMaterials(bmList);
		BMSRF.setLastPage(totalBioMaterialPages);
		BMSRF.setCurrentPage(pageNumber);
		BMSRF.setBioMaterialSearchForm(bioMaterialSearchForm);
		logger.info("Total Pages for this Search {}" , totalBioMaterialPages);
		logger.info("SearchData {} ",BMSRF);
		
		mv = new ModelAndView("materials/searchBioMaterialsResults","bioMaterialSearchResultsForm",BMSRF);
		return mv;
	}
	
	private PageRequest gotoPage(int pageNumber){
		PageRequest requestedPage = new PageRequest(pageNumber,PAGE_SIZE,Sort.Direction.ASC,"shortDesc");
		return requestedPage;
	}
	
	
}
