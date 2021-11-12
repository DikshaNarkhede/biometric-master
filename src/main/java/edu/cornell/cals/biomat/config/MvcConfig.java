package edu.cornell.cals.biomat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.cornell.cals.biomat.excel.ExcelPOIHelper;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("home").setViewName("home");
        registry.addViewController("login").setViewName("login");
        registry.addViewController("/").setViewName("home");
        
    }
    @Bean
    public ExcelPOIHelper excelPOIHelper() {
        return new ExcelPOIHelper();
    }
}
