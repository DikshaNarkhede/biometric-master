package edu.cornell.cals.biomat.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bio404Controller implements ErrorController{
    @RequestMapping("error")
    public String handleError() {
        return "error404";
    }
 
    @Override
    public String getErrorPath() {
        return "error";
    }
}

