package edu.cornell.cals.biomat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cornell.cals.biomat.dao.BioUser;
import edu.cornell.cals.biomat.model.signup.BioUserForm;
import edu.cornell.cals.biomat.model.variable.BioVariableSearchForm;
import edu.cornell.cals.biomat.service.BioUserService;

@Controller
public class SignupController {
	Logger logger = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	BioUserService bioUserService;
	
	@GetMapping("signUp")
	public ModelAndView displaySignupPage() {
		logger.info("displaySignupPage");
		BioUserForm bioUserForm = new BioUserForm();
		ModelAndView  mv = new ModelAndView("signUp","bioUserForm",bioUserForm);
		return mv;
	}	

	@PostMapping("signUp")
	public ModelAndView signUpUser(HttpServletRequest request, @Valid @ModelAttribute BioUserForm bioUserForm,BindingResult bindingResult) {
		logger.info("POST SignUp {}" , bioUserForm);
		ModelAndView  mv ;
		
		if(bindingResult.hasErrors()) {
			logger.info("Error in Form Submission.  NOT Updating Data. ");
			mv = new ModelAndView("signUp","bioUserForm",bioUserForm);
		}
		else {
				BioUser existingUser = bioUserService.getBioUser(bioUserForm.getEmail());
				if(existingUser!=null && existingUser.getEmail().length()>1){
					logger.info("User with emailAddress {} already exists. NOT updating data.", bioUserForm.getEmail());
					mv = new ModelAndView("signUp","bioUserForm",bioUserForm);
					mv.addObject("message", "An user already signed with that email address. Please choose another email or contact administrator");
				}
				else if(!bioUserForm.getPassword1().equals(bioUserForm.getPassword2())) {
					mv = new ModelAndView("signUp","bioUserForm",bioUserForm);
					mv.addObject("message", "Passwords do not match. Please try again.");
					
				}
				else {
					BioUser bu = new BioUser();
					bu.setUserName(bioUserForm.getEmail());
					bu.setFirstName(bioUserForm.getFirstName());
					bu.setLastName(bioUserForm.getLastName());
					bu.setEmail(bioUserForm.getEmail());
					bu.setPassword(bioUserForm.getPassword1());
					bu.setUserName(bioUserForm.getEmail());
					bu.setAddedBy(bioUserForm.getEmail());
					bu.setActive("1");
					bu.setUserRole("CONTRIBUTOR");
					
					bu = bioUserService.addBioUser(bu);
					logger.info("Added User{}", bu);		
					mv = new ModelAndView("signUp","bioUserForm",bioUserForm);
					mv.addObject("message", "You have been successfully signed up as a contributer. Please Login to contribute ");
				}
		}
		return mv;
	}	
	
}
