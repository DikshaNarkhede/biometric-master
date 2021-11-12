package edu.cornell.cals.biomat.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cornell.cals.biomat.dao.BioComposition;
import edu.cornell.cals.biomat.dao.BioVariable;
import edu.cornell.cals.biomat.model.variable.BioVariableAddForm;
import edu.cornell.cals.biomat.model.variable.BioVariableSearchForm;
import edu.cornell.cals.biomat.model.variable.BioVariableSearchResultsForm;
import edu.cornell.cals.biomat.service.BioCompositionService;
import edu.cornell.cals.biomat.service.BioVariableService;

@Controller
public class BioVariableController {
	private static final int PAGE_SIZE 		= 10;
	private static final int PAGER_ELEMENTS = 15;
	Logger logger = LoggerFactory.getLogger(BioVariableController.class);
	
	
	@Autowired
	protected BioVariableService bioVariableService;
	
	@Autowired
	protected BioCompositionService bioCompositionService;
	
	@GetMapping("updateBioVariable")
	public ModelAndView displayUpdateBioVariablePage(@RequestParam(value="variableId", required=true) Integer variableId) {
		logger.info("updateBioVariable {} ", variableId );
		BioVariable bioVariable= bioVariableService.getBioVariable(variableId);
		logger.debug("Fetched BioVariable{}", bioVariable);
		
		ModelAndView  mv = new ModelAndView("variables/updateBioVariable","bioVariable",bioVariable);
		return mv;
	}	

	@PostMapping("updateBioVariable")
	public ModelAndView updateBioVariablePage(HttpServletRequest request, @Valid @ModelAttribute BioVariable bioVariable, BindingResult bindingResult,@AuthenticationPrincipal Principal principal) {
		logger.info("POST updateBioVariable:user {}  {}", bioVariable, principal);
		ModelAndView  mv ;
		if(bindingResult.hasErrors()) {
			logger.info("Error in Form Submission.  NOT Updating Data. ");
			mv = new ModelAndView("variables/updateBioVariable","bioVariable",bioVariable);
		}
		else if(principal ==null) {
			throw new RuntimeException("User is not Authorized to update Variables");
		}
		else {
			BioVariable bv = bioVariableService.updateBioVariable(bioVariable,principal.getName());
			logger.info("bioVariableService.updateBioVariable {}", bv);		
			mv = new ModelAndView("variables/updateBioVariable","bioVariable",bv);
			mv.addObject("message", "Successfully Updated Bio-Variable");
		}
		return mv;
	}	


	
	@GetMapping("addBioVariable")
	public ModelAndView showAddBioVariablePage() {
		logger.info("GET addBioVariable");
		BioVariableAddForm bvaf = new BioVariableAddForm();  
		ModelAndView mv = new ModelAndView("variables/addBioVariable","bioVariableAddForm",bvaf);
		return mv;
	}	

	@PostMapping("addBioVariable")
	public ModelAndView addBioVariablePage(HttpServletRequest request, @Valid @ModelAttribute BioVariableAddForm bioVariableAddForm, BindingResult bindingResult,@AuthenticationPrincipal Principal principal) {
		logger.info("POST addBioVariable");
		if(bindingResult.hasErrors()) {
			logger.info("Error in Form Submission.  NOT Updating Data. ");
			return new ModelAndView("variables/addBioVariable","bioVariableAddForm",bioVariableAddForm);
			
		}else if(principal ==null) {
			throw new RuntimeException("User is not Authorized to update Variables");
		}
		else { 
			BioVariable bv = bioVariableService.getBioVariableBySymbol(bioVariableAddForm.getSymbol());
			if(bv!=null && bv.getId()!=null) {
				logger.info("Error in Form Submission. Duplicate Symbol. NOT Updating Data. ");
				bioVariableAddForm.setMessage("Error in Adding bioVariable. Symbol is already used for another Variable ");
				bindingResult.rejectValue("symbol","error.symbol", "This Symbol is already taken");
				return new ModelAndView("variables/addBioVariable","bioVariableAddForm",bioVariableAddForm);
			}
			
			BioComposition bc = bioCompositionService.getBioCompositionByTagName(bioVariableAddForm.getSymbol());
			
			if(bc!=null && bc.getId()!=null) {
				logger.info("Error in Form Submission. This Symbol is used in a Composition . NOT Updating Data. ");
				bioVariableAddForm.setMessage("Error in Adding bioVariable. Symbol is already used for another Composition");
				bindingResult.rejectValue("symbol","error.symbol", "This Symbol is used in a Material composition");
				return new ModelAndView("variables/addBioVariable","bioVariableAddForm",bioVariableAddForm);
			}
			
		}
		
		
		
		try {
			BioVariable bioVariable = new BioVariable();
			bioVariable.setName(bioVariableAddForm.getName());
			bioVariable.setDescription(bioVariableAddForm.getDescription());
			bioVariable.setSymbol(bioVariableAddForm.getSymbol());
			bioVariable.setUom(bioVariableAddForm.getUom());
			bioVariable.setAddedBy(principal.getName());
			bioVariable = bioVariableService.updateBioVariable(bioVariable,principal.getName());
			bioVariableAddForm.setId(bioVariable.getId());
			bioVariableAddForm.setAddedBy(principal.getName());
			bioVariableAddForm.setMessage("Successfully Added New BioVariable");
			logger.info("bioVariableService.updateBioVariable {}", bioVariable);		
			return  new ModelAndView("variables/addBioVariable","bioVariableAddForm",bioVariableAddForm);
			
			
		}
		catch(Exception ex) {
			logger.error("Error in adding variable: ",ex );
			bioVariableAddForm.setMessage("Error in Adding bioVariable. Is symbol for your variable unique?");
			return new ModelAndView("variables/addBioVariable","bioVariableAddForm",bioVariableAddForm);
		}
			
	}
	
	
	@GetMapping("searchBioVariables")
	public ModelAndView displaySearchBioVariablesPage(@ModelAttribute BioVariableSearchForm bioVariableSearchForm) {
	        
		logger.info("Start searchBioVariable {}" , bioVariableSearchForm);
		BioVariableSearchForm form = new BioVariableSearchForm();
		
		logger.debug("Start searchBioVariable {}" , form);
		ModelAndView  mv = new ModelAndView("variables/searchBioVariables","bioVariableSearchForm",form);
		return mv;
	}

	
	@PostMapping("searchBioVariables")
	public ModelAndView bioVariableResultsPage(HttpServletRequest request, @ModelAttribute @Valid BioVariableSearchForm bioVariableSearchForm,BindingResult bindingResult,  @RequestParam(value="pageNumber", required=false, defaultValue = "0") Integer pageNumber) {
		logger.info("Start searchBioVariables with params {}",bioVariableSearchForm);;
		ModelAndView  mv =null;
		

		List<BioVariable> bvList = new ArrayList<BioVariable>();
		Map<String,Object> map = bioVariableService.getBioVariable(gotoPage(pageNumber), bioVariableSearchForm.getName());
		Page<BioVariable> boiVariablePage = (Page<BioVariable>)map.get("bioVariablePage"); 		
		for(BioVariable bv : boiVariablePage){
			bvList.add(bv);
		}
		int totalVariablePages= 	((int)map.get("count")) / PAGE_SIZE;
		if(((int)map.get("count")) % PAGE_SIZE > 0) totalVariablePages++;
			
		BioVariableSearchResultsForm BVSRF = new BioVariableSearchResultsForm();
		
		if(totalVariablePages <=  PAGER_ELEMENTS ) {
			BVSRF .setPagerStart(0);
			BVSRF .setPagerEnd(totalVariablePages);
			
		}
		else {
			
			if(pageNumber <= 5) {
				BVSRF .setPagerStart(0);
				BVSRF .setPagerEnd(9);
			}
			else {
				
				BVSRF .setPagerStart(pageNumber-4);
				if(totalVariablePages<(pageNumber+5))
					BVSRF .setPagerEnd(totalVariablePages);
				else
					BVSRF .setPagerEnd(pageNumber+5);
			}
		}
		
		BVSRF .setBioVariables(bvList);
		BVSRF .setLastPage(totalVariablePages);
		BVSRF .setCurrentPage(pageNumber);
		BVSRF .setBioVariableSearchForm(bioVariableSearchForm);
		logger.info("Total Pages for this Search {}" , totalVariablePages);
		logger.info("SearchData {} ",BVSRF);
		
		mv = new ModelAndView("variables/searchBioVariableResults","bioVariableSearchResultsForm",BVSRF);
		return mv;
	}

	private PageRequest gotoPage(int pageNumber){
		PageRequest requestedPage = new PageRequest(pageNumber,PAGE_SIZE,Sort.Direction.ASC,"name");
		return requestedPage;
	}

}
