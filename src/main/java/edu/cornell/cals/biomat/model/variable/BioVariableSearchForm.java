package edu.cornell.cals.biomat.model.variable;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BioVariableSearchForm implements Serializable{
	private static final long serialVersionUID = -327007650141157344L;
	@NotNull
	@Size(min=1, max=300)
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String bioVariableName) {
		this.name = bioVariableName;
	}
	@Override
	public String toString() {
		return "BioVariableSearchForm [bioVariableName=" + name + "]";
	}
	
	

}
