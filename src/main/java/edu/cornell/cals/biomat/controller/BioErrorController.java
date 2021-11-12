package edu.cornell.cals.biomat.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BioErrorController{
 
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception ex)  throws Exception {
		
		if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null) {
			throw ex;
		}
		else {
			ModelAndView  mv = new ModelAndView();
	        mv.addObject("exception", ex);
	        mv.addObject("url", request.getRequestURL());
	        mv.setViewName("error500");
		    return mv;
		}
	}
    
}
