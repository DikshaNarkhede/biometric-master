package edu.cornell.cals.biomat.controller;

import java.security.Principal;

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
import org.springframework.web.servlet.ModelAndView;

import edu.cornell.cals.biomat.dao.BioObservedPoint;

import edu.cornell.cals.biomat.repository.BioObservedPointRepository;


@Controller
public class ObservedPointController {

	@Autowired
	BioObservedPointRepository bioObservedPointRepository;

	
	Logger logger = LoggerFactory.getLogger(ObservedPointController.class);
	@GetMapping("addObservedPoint")
	public ModelAndView displayAddObservedPointPage() {
		logger.info("Start" );
		BioObservedPoint BOP = new BioObservedPoint ();
		ModelAndView  mv = new ModelAndView("contribute/addObservedPoint","bioObservedPoint",BOP);
		return mv;
	}

	@PostMapping("addObservedPoint")
	public ModelAndView saveAddObservedPointPage(  @Valid @ModelAttribute BioObservedPoint BOP,BindingResult bindingResult,@AuthenticationPrincipal Principal principal) {
		logger.info("Start " );
		if(bindingResult.hasErrors()) {
			logger.info("Error in Form Submission.  NOT Updating Data. ");
			ModelAndView  mv = new ModelAndView("contribute/addObservedPoint","bioObservedPoint",BOP);
			return mv;
		}
		else if(principal ==null) {
			throw new RuntimeException("User is not authorized to update a material");
		}
		else {
			BOP.setAddedBy(principal.getName());
			bioObservedPointRepository.save(BOP);
			ModelAndView  mv = new ModelAndView("contribute/addObservedPoint","bioObservedPoint",BOP);
			mv.addObject("successMessage","Successfully Saved Observed Value");
			return mv;
		}
	}

}
