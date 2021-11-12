package edu.cornell.cals.biomat.model.formula;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import edu.cornell.cals.biomat.dao.BioFormula;

public class BioFormulaSearchForm implements Serializable {
	private static final long serialVersionUID = 7074378111390497433L;
	
	@NotNull
	@NotEmpty
	private String searchString;
	
	List<BioFormula> bioFormulaList;
	
	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public List<BioFormula> getBioFormulaList() {
		return bioFormulaList;
	}

	public void setBioFormulaList(List<BioFormula> bioFormulaList) {
		this.bioFormulaList = bioFormulaList;
	}

	
	
}
