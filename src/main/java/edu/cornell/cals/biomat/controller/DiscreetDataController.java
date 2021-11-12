package edu.cornell.cals.biomat.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.cornell.cals.biomat.dao.BioDiscreetData;
import edu.cornell.cals.biomat.dao.BioVariable;
import edu.cornell.cals.biomat.excel.ExcelPOIHelper;
import edu.cornell.cals.biomat.excel.MyCell;
import edu.cornell.cals.biomat.model.BioVariableAndCompostionModel;
import edu.cornell.cals.biomat.model.discreet.BioDiscreetDataForm;
import edu.cornell.cals.biomat.model.discreet.ShowBioDiscreetDataForm;
import edu.cornell.cals.biomat.repository.BioDiscreetDataRepository;
import edu.cornell.cals.biomat.service.BioDiscreetDataService;
import edu.cornell.cals.biomat.service.BioFormulaMaterialService;
import edu.cornell.cals.biomat.service.BioMaterialService;
import edu.cornell.cals.biomat.service.BioVariableService;

@Controller
public class DiscreetDataController {
	@Autowired
	protected BioDiscreetDataService bioDiscreetDataService;
	@Autowired
	protected BioVariableService bioVariableService;
	@Autowired
	protected BioMaterialService bioMaterialService;
	@Autowired
	protected BioDiscreetDataRepository bioDiscreetDataRepository;
	
	@Autowired
	protected BioFormulaMaterialService bioFormulaMaterialService;
	@Resource(name = "excelPOIHelper")
    private ExcelPOIHelper excelPOIHelper;
	
	Logger logger = LoggerFactory.getLogger(DiscreetDataController.class);

	@GetMapping("showDiscreetData")
	public ModelAndView showDiscreetDataPage(@ModelAttribute ShowBioDiscreetDataForm showBioDiscreetDataForm) {
		logger.info("Start");
		showBioDiscreetDataForm.setBioDiscreetDatas(bioDiscreetDataService.getAllBioDiscreetData());
		logger.info("Start showBioDiscreetData in get{}" , showBioDiscreetDataForm);
		ModelAndView  mv = new ModelAndView("contribute/showDiscreetData","showBioDiscreetDataForm",showBioDiscreetDataForm);
		return mv;
	}
	
	@GetMapping("deleteDiscreetData")
	public ModelAndView deleteBioDiscreetDataPage(@ModelAttribute ShowBioDiscreetDataForm showBioDiscreetDataForm) {
		logger.info("Start");
		showBioDiscreetDataForm.setBioDiscreetDatas(bioDiscreetDataService.getAllBioDiscreetData());
		logger.info("Start showBioDiscreetData in get{}" , showBioDiscreetDataForm);
		ModelAndView  mv = new ModelAndView("contribute/showDiscreetData","showBioDiscreetDataForm",showBioDiscreetDataForm);
		return mv;
		
	}
	
	@PostMapping("deleteDiscreetData")
	private ModelAndView deleteStudent(HttpServletRequest request, @RequestParam Long id, @Valid @ModelAttribute ShowBioDiscreetDataForm showBioDiscreetDataForm, BindingResult bindingResult,@AuthenticationPrincipal Principal principal) {
		logger.info("Start");
		logger.info("DiscreetData_Id : "+id);
		ModelAndView  mv ;
		if(bindingResult.hasErrors()) {
			logger.info("Error in Form Submission.  NOT deleting Data. ");
			mv = new ModelAndView("contribute/showDiscreetData","showBioDiscreetDataForm",showBioDiscreetDataForm);
		}else if(principal ==null) {
			throw new RuntimeException("User is not Authorized to delete DiscreetData");
		}else {
			BioDiscreetData bioDiscreetData= bioDiscreetDataService.getBioDiscreetData(id);
		    bioDiscreetDataRepository.delete(bioDiscreetData);
			showBioDiscreetDataForm.setBioDiscreetDatas(bioDiscreetDataService.getAllBioDiscreetData());
			logger.info("new showBioDiscreetData after deleting{}" , showBioDiscreetDataForm);
		}
		mv = new ModelAndView("contribute/showDiscreetData","showBioDiscreetDataForm",showBioDiscreetDataForm);
		mv.addObject("successMessage", "Successfully deleted Bio-DiscreetData");
		
		return mv;
	    
	}
	
	@GetMapping("addDiscreetData")
	public ModelAndView displayAddDiscreetDataPage() {
		logger.info("Start" );
		BioDiscreetDataForm BDD = new BioDiscreetDataForm ();
		ModelAndView  mv = new ModelAndView("contribute/addDiscreetData","bioDiscreetDataForm",BDD);	
		return mv;
	}
	
	@PostMapping("addDiscreetData")
	public ModelAndView saveAddDiscreetDataPage(HttpServletRequest request,  @Valid @ModelAttribute BioDiscreetDataForm bioDiscreetDataForm,BindingResult bindingResult,@AuthenticationPrincipal Principal principal) throws IOException {
		logger.info("Start " );
		
		if(bindingResult.hasErrors()) {
			logger.info("Error in Form Submission.  NOT Updating Data. ");
			ModelAndView  mv = new ModelAndView("contribute/addDiscreetData","bioDiscreetDataForm", bioDiscreetDataForm);
			return mv;
		}
		else if(principal ==null) {
			throw new RuntimeException("User is not authorized to add discreet dataset");
		}
		else {
			MultipartFile file = bioDiscreetDataForm.getFile();
			InputStream in = file.getInputStream();
		    File currDir = new File(".");
		    String path = currDir.getAbsolutePath();
		    String fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
		    
		    FileOutputStream f = new FileOutputStream(fileLocation);
		    int ch = 0;
		    while ((ch = in.read()) != -1) {
		        f.write(ch);
		    }
		    f.flush();
		    f.close();
		    
		    
		    Map<Integer, List<MyCell>> data = null;
		    
		    if (fileLocation != null && (fileLocation.endsWith(".xlsx") || fileLocation.endsWith(".xls"))  ) {
		    	 data = excelPOIHelper.readExcel(fileLocation);
			} 
		    bioDiscreetDataForm.setData(data);
		    
		    
			for(int i = 2; i < data.size();i ++) {
				List<MyCell> row = data.get(i);
				BioDiscreetData BDD = generateNewBDD(bioDiscreetDataForm);
				BDD.setyValue(Double.parseDouble(row.get(0).getContent()));
				
				int length = row.size();
				
				if(length >= 2) {
					BDD.setaValue(Double.parseDouble(row.get(1).getContent()));
				}
				if(length >= 3) {
					BDD.setbValue(Double.parseDouble(row.get(2).getContent()));
				}
				if(length >= 4) {
					BDD.setcValue(Double.parseDouble(row.get(3).getContent()));
				}
				if(length >= 5) {
					BDD.setdValue(Double.parseDouble(row.get(4).getContent()));
				}
				if(length >= 6) {
					BDD.seteValue(Double.parseDouble(row.get(5).getContent()));
				}
				if(length >= 7) {
					BDD.setfValue(Double.parseDouble(row.get(6).getContent()));
				}
				if(length >= 8) {
					BDD.setgValue(Double.parseDouble(row.get(7).getContent()));
				}
				if(length >= 9) {
					BDD.sethValue(Double.parseDouble(row.get(8).getContent()));
				}
				if(length >= 10) {
					BDD.setiValue(Double.parseDouble(row.get(9).getContent()));
				}
				if(length >= 11) {
					BDD.setjValue(Double.parseDouble(row.get(10).getContent()));
				}
				BDD.setAddedBy(principal.getName());
				bioDiscreetDataRepository.save(BDD);
			}
		    
			ModelAndView  mv = new ModelAndView("contribute/addDiscreetData","bioDiscreetDataForm",bioDiscreetDataForm);
			
			mv.addObject("successMessage", "DataSet has been uploaded successfully!");
			
			return mv;
		}
	}
	
	
	BioDiscreetData generateNewBDD (BioDiscreetDataForm bioDiscreetDataForm) {
		BioDiscreetData BDD = new BioDiscreetData();
		
		BDD.setBioMaterial(bioMaterialService.getBioMaterialByUsdaId(bioDiscreetDataForm.getMaterialId()));
		BDD.setAuthorName(bioDiscreetDataForm.getAuthorName());
		BDD.setYear(bioDiscreetDataForm.getYear());
		BDD.setMaterialId(bioDiscreetDataForm.getMaterialId());
		BDD.setyVariableId(bioDiscreetDataForm.getyVariableId());
		
		BioVariableAndCompostionModel bioVariableAndCompostionModel= bioFormulaMaterialService.getVariablesInFormula(bioDiscreetDataForm.getMaterialId(), bioDiscreetDataForm.getyVariableId());
		BDD.setyBioVariable(bioVariableService.getBioVariable(bioDiscreetDataForm.getyVariableId()));
		
		List<BioVariable> bbv = bioVariableAndCompostionModel.getBioVariables();
		
		if(bbv.size() >= 1) {
			BDD.setaBioVariable(bbv.get(0));
			BDD.setaVariableId(bbv.get(0).getId());
		}
		if(bbv.size() >= 2) {
			BDD.setbBioVariable(bbv.get(1));
			BDD.setbVariableId(bbv.get(1).getId());
		}
		if(bbv.size() >= 3) {
			BDD.setcBioVariable(bbv.get(2));
			BDD.setcVariableId(bbv.get(2).getId());
		}
		if(bbv.size() >= 4) {
			BDD.setdBioVariable(bbv.get(3));
			BDD.setdVariableId(bbv.get(3).getId());
		}
		if(bbv.size() >= 5) {
			BDD.seteBioVariable(bbv.get(4));
			BDD.seteVariableId(bbv.get(4).getId());
		}
		if(bbv.size() >= 6) {
			BDD.setfBioVariable(bbv.get(5));
			BDD.setfVariableId(bbv.get(5).getId());
		}
		if(bbv.size() >= 7) {
			BDD.setgBioVariable(bbv.get(6));
			BDD.setgVariableId(bbv.get(6).getId());
		}
		if(bbv.size() >= 8) {
			BDD.sethBioVariable(bbv.get(7));
			BDD.sethVariableId(bbv.get(7).getId());
		}
		if(bbv.size() >= 9) {
			BDD.setiBioVariable(bbv.get(8));
			BDD.setiVariableId(bbv.get(8).getId());
		}
		if(bbv.size() >= 10) {
			BDD.setjBioVariable(bbv.get(9));
			BDD.setjVariableId(bbv.get(9).getId());
		}
		
		return BDD;
		
		
	}

}
