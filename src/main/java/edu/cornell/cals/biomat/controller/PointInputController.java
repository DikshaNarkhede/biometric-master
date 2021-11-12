package edu.cornell.cals.biomat.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cornell.cals.biomat.model.measurement.BioMeasurementForm;
import edu.cornell.cals.biomat.model.measurement.MeasurementPair;
import edu.cornell.cals.biomat.service.BioMatEmailService;

@Controller
public class PointInputController {
	Logger logger = LoggerFactory.getLogger(PointInputController.class);
	private static final int PAGE_SIZE 		= 10;
	private static final int PAGER_ELEMENTS = 15;

	
	//@Autowired
	//BioMeasurementService bioMeasurementService;
	
	@Autowired
	BioMatEmailService bioMatEmailService;
	
	@GetMapping("addPointInput")
	public ModelAndView displayAddPointInputPage() {
		logger.info("Start" );
		BioMeasurementForm BMF = new BioMeasurementForm();
		MeasurementPair mp = new MeasurementPair();
		List<MeasurementPair> measurementPairs = new ArrayList<MeasurementPair>();
		measurementPairs.add(mp);
		BMF.setMeasurementPairs(measurementPairs);
		ModelAndView  mv = new ModelAndView("contribute/addPointInput","bioMeasurementForm",BMF);
		return mv;
	}
	/*
	@PostMapping("addPointInput")
	public ModelAndView addBioMeasurement(HttpServletRequest request, @RequestParam("inputpicker-1") String materialName, @Valid @ModelAttribute BioMeasurementForm bioMeasurementForm,BindingResult bindingResult,@AuthenticationPrincipal Principal principal) {
		logger.info("Start {} {}" ,materialName, bioMeasurementForm);
		ModelAndView  mv =  new ModelAndView("contribute/addPointInput","bioMeasurementForm",bioMeasurementForm);
		if(bindingResult.hasErrors()) {
			logger.info("Error in Form Submission.  NOT Updating Data. ");
		}
		else if(principal ==null) {
			throw new RuntimeException("User is not authorized to update a material");
		}
		else {
			// Filter invalid pair. 
			// 1. Error and Measured Values both 0.  2. both null 3. id == null
			bioMeasurementForm.setMaterialName(materialName);
			List<MeasurementPair> filteredMeasurementPairs = bioMeasurementForm.getMeasurementPairs()
			.stream()
			.filter(pair-> !(pair.getMeasurementValue() == null && pair.getErrorValue()==null) || (pair.getMeasurementValue()==0.0 && pair.getErrorValue()==0.0) || (pair.getId()==null ))
			.collect(Collectors.toList());
			logger.info("filteredMeasurementPairs {}" , filteredMeasurementPairs);
			List<BioMeasurement> bmList = bioMeasurementService.addBioMaterial(bioMeasurementForm.getMaterialId(),bioMeasurementForm.getCitation(), bioMeasurementForm.getDoi(), filteredMeasurementPairs, principal.getName());
			logger.info("Updated BioMeasurements {}", bmList);
			bioMatEmailService.emailBioMaterialAdded(principal);
			mv.addObject("successMessage", "Thanks for the Input Point Data.  A message is sent to the administrator for approval. You will get another email when administrator takes an action. ");
		}
		
		return mv;
	}
*/
	//@PostMapping("/myPointInputs")
	/*
	@RequestMapping(value = "myPointInputs", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView displayMyPointInputPage(@AuthenticationPrincipal Principal principal,@RequestParam(value="pageNumber", required=false, defaultValue = "0") Integer pageNumber) {
		logger.info("Start" );
		
		List<BioMeasurement> bioMeasurements = new ArrayList<BioMeasurement>();
		Map<String,Object> map = bioMeasurementService.getBioMeasurementsByContributor(gotoPage(pageNumber), principal.getName());
		Page<BioMeasurement> bioMeasurementPage = (Page<BioMeasurement>)map.get("bioMeasurementPage");

		for(BioMeasurement bm : bioMeasurementPage){
			bioMeasurements.add(bm);
		}
		
		int totalBioMeasurementPages= 	((int)map.get("count")) / PAGE_SIZE;
		if(((int)map.get("count")) % PAGE_SIZE > 0) totalBioMeasurementPages++;
		
		MeasurementsSearchResultsForm measurementsSearchResultsForm = new MeasurementsSearchResultsForm();
		
		if(totalBioMeasurementPages <=  PAGER_ELEMENTS ) {
			measurementsSearchResultsForm.setPagerStart(0);
			measurementsSearchResultsForm.setPagerEnd(totalBioMeasurementPages);
		}else {
			if(pageNumber <= 5) {
				measurementsSearchResultsForm.setPagerStart(0);
				measurementsSearchResultsForm.setPagerEnd(9);
			}
			else {
				
				measurementsSearchResultsForm.setPagerStart(pageNumber-4);
				if(totalBioMeasurementPages<(pageNumber+5))
					measurementsSearchResultsForm.setPagerEnd(totalBioMeasurementPages);
				else
					measurementsSearchResultsForm.setPagerEnd(pageNumber+5);
			}
		}
		
		measurementsSearchResultsForm.setBioMeasurements(bioMeasurements);
		measurementsSearchResultsForm.setLastPage(totalBioMeasurementPages);
		measurementsSearchResultsForm.setCurrentPage(pageNumber);
		//measurementsSearchResultsForm.setBioMeasurementSearchForm(measurementsSearchResultsForm);
		logger.info("Total Pages for this Search {}" , totalBioMeasurementPages);
		logger.info("SearchData {} ",measurementsSearchResultsForm);
		
		ModelAndView  mv = new ModelAndView("contribute/myPointInputs","measurementsSearchResultsForm",measurementsSearchResultsForm);
		return mv;
	}
*/
	/*
	 * 
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

	 */
	
	
	private PageRequest gotoPage(int pageNumber){
		PageRequest requestedPage = new PageRequest(pageNumber,PAGE_SIZE,Sort.Direction.ASC,"materialId");
		return requestedPage;
	}

}
