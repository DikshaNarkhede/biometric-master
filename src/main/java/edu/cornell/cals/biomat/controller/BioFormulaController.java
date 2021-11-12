package edu.cornell.cals.biomat.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.dao.BioFormulaRange;
import edu.cornell.cals.biomat.dao.BioVariable;
import edu.cornell.cals.biomat.model.formula.BioFormulaForm;
import edu.cornell.cals.biomat.model.formula.BioFormulaRangesForm;
import edu.cornell.cals.biomat.model.formula.BioFormulaSearchForm;
import edu.cornell.cals.biomat.repository.BioFormulaRangeRepository;
import edu.cornell.cals.biomat.repository.BioVariableRepository;
import edu.cornell.cals.biomat.service.BioFormulaRangeService;
import edu.cornell.cals.biomat.service.BioFormulaService;
import edu.cornell.cals.biomat.service.BioVariableService;
import edu.cornell.cals.biomat.util.ExpressionEvaluator;

@Controller
public class BioFormulaController {
	Logger logger = LoggerFactory.getLogger(BioFormulaController.class);
	
	@Autowired
	BioFormulaService bioFormulaService;
	@Autowired
	BioFormulaRangeService bioFormulaRangeService;
	@Autowired
	BioFormulaRangeRepository bioFormulaRangeRepository;
	
	@Autowired
	BioVariableService bioVariableService;
	@Autowired
	BioVariableRepository bioVariableRepository;
	
	
	@GetMapping("searchBioFormula")
	public ModelAndView displaySearchBioFormulaPage() {
		logger.info("Start displaySearchBioFormula" );
		BioFormulaSearchForm bioFormulaSearchForm = new BioFormulaSearchForm();
		ModelAndView  mv = new ModelAndView("contribute/searchBioFormula","bioFormulaSearchForm",bioFormulaSearchForm);
		return mv;
	}	
	
	@PostMapping("searchBioFormula")
	public ModelAndView searchBioFormulaPage(HttpServletRequest request, @Valid @ModelAttribute BioFormulaSearchForm bioFormulaSearchForm, BindingResult bindingResult,@AuthenticationPrincipal Principal principal) {
		logger.info("Start displaySearchBioFormula" );
		ModelAndView  mv;
		if(bindingResult.hasErrors()) {
			logger.info("Error in Form Submission.  NOT Searching for  Data. ");
		}
		else {
			List<BioFormula> bioFormula = bioFormulaService.getBioFormulaByNameOrDesc(bioFormulaSearchForm.getSearchString());
			bioFormulaSearchForm.setBioFormulaList(bioFormula);
		}
		mv = new ModelAndView("contribute/searchBioFormula","bioFormulaSearchForm",bioFormulaSearchForm);
		return mv;
	}	
	
	@GetMapping("editBioFormula")
	public ModelAndView editBioMaterialFormulaPage(@RequestParam(value="formulaId", required=false) Long formulaId) {
		logger.info("Start editBioMaterialFormulaPage {}" ,formulaId );
		BioFormula bf = bioFormulaService.getBioMaterialFormula(formulaId);
		BioFormulaForm bioFormulaForm = new BioFormulaForm();
		bioFormulaForm.setId(formulaId);
		bioFormulaForm.setName(bf.getName());
		bioFormulaForm.setFormula(bf.getFormula());
		bioFormulaForm.setFormulaDesc(bf.getFormulaDesc());
		bioFormulaForm.setCitation(bf.getCitation());
		bioFormulaForm.setDoi(bf.getDoi());
		bioFormulaForm.setVariableId(bf.getVariableId());
		bioFormulaForm.setBioVariables(bioVariableRepository.findAll());
		ModelAndView  mv = new ModelAndView("contribute/addBioFormula","bioFormulaForm",bioFormulaForm);
		return mv;
	}	

	
	@GetMapping("addBioFormula")
	public ModelAndView displayAddBioMaterialFormulaPage() {
		logger.info("Start displayAddBioMaterialFormulaPage" );
		
		BioFormulaForm bioFormulaForm = new BioFormulaForm();
		bioFormulaForm.setBioVariables(bioVariableRepository.findAll());
		ModelAndView  mv = new ModelAndView("contribute/addBioFormula","bioFormulaForm",bioFormulaForm);
		return mv;
	}	
	
	@PostMapping("addBioFormula")
	public ModelAndView saveBioMaterialFormula(HttpServletRequest request, @Valid @ModelAttribute BioFormulaForm bioFormulaForm, BindingResult bindingResult,@AuthenticationPrincipal Principal principal) {
		logger.info("Start saveBioMaterialFormula {}", bioFormulaForm  );
		bioFormulaForm.setBioVariables(bioVariableRepository.findAll());
		if(bioFormulaForm.getName()!=null)
			bioFormulaForm.setName(bioFormulaForm.getName().toUpperCase());
		
		ModelAndView  mv;
		Map<String,String> errors = new HashMap();
		if(bindingResult.hasErrors()) {
			logger.info("Error in Form Submission.  NOT Updating Data. ");
			mv = new ModelAndView("contribute/addBioFormula","bioFormulaForm",bioFormulaForm);
			return mv;
		}
		if(bioFormulaForm.getId() == null) {
			if(!bioFormulaService.isValidFormula(bioFormulaForm.getName(),bioFormulaForm.getFormula(), errors)) {
				errors.forEach((k, v) -> bindingResult.rejectValue(k,k,v));
				mv = new ModelAndView("contribute/addBioFormula","bioFormulaForm",bioFormulaForm);
				return mv;
			}
		} else {
			if(!bioFormulaService.isValidFormulaWhileEdit(bioFormulaForm.getFormula(), errors)) {
				errors.forEach((k, v) -> bindingResult.rejectValue(k,k,v));
				mv = new ModelAndView("contribute/addBioFormula","bioFormulaForm",bioFormulaForm);
				return mv;
			}
		}
		
		BioFormula bf =bioFormulaService.updateBioMaterialFormula(bioFormulaForm, principal.getName());
		bioFormulaForm.setId(bf.getId());
		BioFormulaRangesForm bioFormulaRangesForm = new BioFormulaRangesForm();
		bioFormulaRangesForm.setBioFormula(bf);
		List<BioFormulaRange> biFormulaRanges = bioFormulaRangeService.getBioFormulaRangeByFormulaId(bf.getId());
		bioFormulaRangesForm.setRanges(biFormulaRanges);
		List<String> variables = ExpressionEvaluator.getVariableList(bf.getFormula());
		List<BioFormulaRange> bioFormulaRangeList = new ArrayList();
		for(String variable : variables) {
			BioVariable bv = bioVariableService.getBioVariableBySymbol(variable);
			if(bv!=null) {  //ignore compositions 
				BioFormulaRange bfr = new BioFormulaRange();
				bfr.setFormulaId(bf.getId());
				bfr.setVariableId(bv.getId());
				bfr.setVariableName(bv.getName());
				bfr.setVariableSymbol(bv.getSymbol());
				bioFormulaRangeList.add(bfr);
			}
		}
		bioFormulaRangesForm.setRanges(bioFormulaRangeList);
		mv = new ModelAndView("contribute/addBioFormulaRange","bioFormulaRangesForm",bioFormulaRangesForm);
		mv.addObject("successMessage", "Your Formula is saved. Please enter Ranges for the  variables defined in the formula");
		return mv;
	}	
	
	
	
	
	@PostMapping("addBioFormulaRanges")
	public ModelAndView saveBioMaterialFormulaRanges(HttpServletRequest request, @ModelAttribute BioFormulaRangesForm bioFormulaRangesForm, BindingResult bindingResult,@AuthenticationPrincipal Principal principal) {
		logger.info("Start saveBioMaterialFormulaRanges {}", bioFormulaRangesForm  );
		//Delete existing ranges
		List<BioFormulaRange> bioFormulaRanges = new ArrayList();
		for(BioFormulaRange range :bioFormulaRangesForm.getRanges()) {
			bioFormulaRanges =bioFormulaRangeRepository.getBioFormulaRangeByFormulaId(range.getFormulaId());
			break;
		}
		for(BioFormulaRange range :bioFormulaRanges) {
			bioFormulaRangeRepository.delete(range);
		}
		
		//now add new ranges
		for(BioFormulaRange range :bioFormulaRangesForm.getRanges())
			bioFormulaRangeRepository.save(range);

		ModelAndView mv = new ModelAndView("contribute/addBioFormulaRange","bioFormulaRangesForm",bioFormulaRangesForm);
		mv.addObject("successMessage", "Ranges for your fomula are saved.");
		return mv;
	}

}
