package edu.cornell.cals.biomat.model;

import java.util.List;

import edu.cornell.cals.biomat.dao.BioComposition;
import edu.cornell.cals.biomat.dao.BioVariable;

public class BioVariableAndCompostionModel {
	Long materialId;
	int variableId;
	List<BioVariable> bioVariables;
	List<BioComposition> bioComposition;

	

	public Long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
	public int getVariableId() {
		return variableId;
	}
	public void setVariableId(int variableId) {
		this.variableId = variableId;
	}
	public List<BioVariable> getBioVariables() {
		return bioVariables;
	}
	public void setBioVariables(List<BioVariable> bioVariables) {
		this.bioVariables = bioVariables;
	}
	public List<BioComposition> getBioComposition() {
		return bioComposition;
	}
	public void setBioComposition(List<BioComposition> bioComposition) {
		this.bioComposition = bioComposition;
	}
	@Override
	public String toString() {
		return "BioVariableAndCompostionModel [materialId=" + materialId + ", variableId=" + variableId
				+ ", bioVariables=" + bioVariables + ", bioComposition=" + bioComposition + "]";
	}
	
	
	
}
