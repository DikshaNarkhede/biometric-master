package edu.cornell.cals.biomat.model.material;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.cornell.cals.biomat.dao.BioGrouping;
import edu.cornell.cals.biomat.dao.BioMaterial;

public class EditBioFormulaForm implements Serializable{
	private static final long serialVersionUID = 2947162447360595216L;
	@NotNull
	@Size(min=2, max=300)
	private String formulaName;
	private Long selectedFormulaId;
	private List<BioMaterial> bioMaterials;
	
	private List<BioGrouping> bioGrouping;
	private String userAction;
	
	private int selectedMaterialId;
	private int selectedBioMaterialId;
	private int selectedBioGroupId;
	
	private int selectedGroupId;
	
	private String errorMessage;
	
	private int biomaterialSize;
	private int bioGroupSize;

	public List<BioMaterial> getBioMaterials() {
		return bioMaterials;
	}
	public void setBioMaterials(List<BioMaterial> bioMaterials) {
		this.bioMaterials = bioMaterials;
	}
	
	public List<BioGrouping> getBioGrouping() {
		return bioGrouping;
	}
	public void setBioGrouping(List<BioGrouping> bioGrouping) {
		this.bioGrouping = bioGrouping;
	}
	
	public String getFormulaName() {
		return formulaName;
	}
	public void setFormulaName(String formulaName) {
		this.formulaName = formulaName;
	}
	public Long getSelectedFormulaId() {
		return selectedFormulaId;
	}
	public void setSelectedFormulaId(Long selectedFormulaId) {
		this.selectedFormulaId = selectedFormulaId;
	}
	
	public int getSelectedMaterialId() {
		return selectedMaterialId;
	}
	public void setSelectedMaterialId(int selectedMaterialId) {
		this.selectedMaterialId = selectedMaterialId;
	}
	public String getUserAction() {
		return userAction;
	}
	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}
	public int getSelectedBioMaterialId() {
		return selectedBioMaterialId;
	}
	public void setSelectedBioMaterialId(int selectedBioMaterialId) {
		this.selectedBioMaterialId = selectedBioMaterialId;
	}
	public int getSelectedBioGroupId() {
		return selectedBioGroupId;
	}
	public void setSelectedBioGroupId(int selectedBioGroupId) {
		this.selectedBioGroupId = selectedBioGroupId;
	}
	public int getSelectedGroupId() {
		return selectedGroupId;
	}
	public void setSelectedGroupId(int selectedGroupId) {
		this.selectedGroupId = selectedGroupId;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getBiomaterialSize() {
		return biomaterialSize;
	}
	public void setBiomaterialSize(int biomaterialSize) {
		this.biomaterialSize = biomaterialSize;
	}
	public int getBioGroupSize() {
		return bioGroupSize;
	}
	public void setBioGroupSize(int bioGroupSize) {
		this.bioGroupSize = bioGroupSize;
	}
	
	@Override
	public String toString() {
		return "EditBioFormulaForm [formulaName=" + formulaName + ", selectedFormulaId=" + selectedFormulaId
				+ ", bioMaterials=" + bioMaterials + ", bioGrouping=" + bioGrouping + ", userAction=" + userAction
				+ ", selectedMaterialId=" + selectedMaterialId + ", selectedBioMaterialId=" + selectedBioMaterialId
				+ ", selectedBioGroupId=" + selectedBioGroupId + ", selectedGroupId=" + selectedGroupId
				+ ", errorMessage=" + errorMessage + ", biomaterialSize=" + biomaterialSize + ", bioGroupSize="
				+ bioGroupSize + "]";
	}

}
  
