package edu.cornell.cals.biomat.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import edu.cornell.cals.biomat.dao.BioVariable;
import edu.cornell.cals.biomat.model.material.BioMaterialGraphForm;
import edu.cornell.cals.biomat.service.BioFormulaMaterialService;
import edu.cornell.cals.biomat.service.BioFormulaService;
import edu.cornell.cals.biomat.service.BioMaterialService;

@Controller
public class BioMaterialGraphController {
	Logger logger = LoggerFactory.getLogger(BioMaterialGraphController.class);
		
	@Autowired
	protected BioFormulaService bioFormulaService;	
	@Autowired
	protected BioFormulaMaterialService bioFormulaMaterialService;
	@Autowired
	protected BioMaterialService bioMaterialService;

	@GetMapping("graphBioMaterial")
	public ModelAndView displayAddBioMaterialPage() {
		logger.info("GET graphBioMaterial ");
		BioMaterialGraphForm bioMaterialGraphForm =  new BioMaterialGraphForm();
		ModelAndView  mv = new ModelAndView("materials/graphBioMaterial","bioMaterialGraphForm",bioMaterialGraphForm);
		return mv;
	}	
	
	/*
	@PostMapping("graphBioMaterial")
	public ResponseEntity<String> showGraph(HttpServletRequest request, @ModelAttribute BioMaterialGraphForm bioMaterialGraphForm) throws Exception{
		logger.info("POST graphBioMaterial ");
		
		Map<String,List<Double>> resultMap = bioFormulaService.getCalculatedDataPoints(bioMaterialGraphForm.getSelectedBioFormulaId().longValue(),50,100);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String jsonVariablesArray = mapper.writeValueAsString(resultMap );
		String s="{\"msg\":\"\", \"data\":" + jsonVariablesArray +"}";
		logger.info("Returning dataPointList{} {}  ", resultMap,s);
		return ResponseEntity.ok(s);
	}	
	*/
}
