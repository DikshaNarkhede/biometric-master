package edu.cornell.cals.biomat.model.formula;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import edu.cornell.cals.biomat.dao.BioVariable;

public class BioFormulaForm implements  Serializable{
	private static final long serialVersionUID = -3674920855102623820L;
	
	private Long id;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String formula;

	@NotNull
	@NotEmpty
	private String citation;
	@NotNull
	@NotEmpty
	private String doi;

	@NotNull
	@NotEmpty
	private String formulaDesc;
	
	private Integer variableId;
	
	List<BioVariable> bioVariables;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public String getCitation() {
		return citation;
	}
	public void setCitation(String citation) {
		this.citation = citation;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public Integer getVariableId() {
		return variableId;
	}
	public void setVariableId(Integer variableId) {
		this.variableId = variableId;
	}
	public List<BioVariable> getBioVariables() {
		return bioVariables;
	}
	public void setBioVariables(List<BioVariable> bioVariables) {
		this.bioVariables = bioVariables;
	}
	public String getFormulaDesc() {
		return formulaDesc;
	}
	public void setFormulaDesc(String formulaDesc) {
		this.formulaDesc = formulaDesc;
	}
	
	

	
	

}
