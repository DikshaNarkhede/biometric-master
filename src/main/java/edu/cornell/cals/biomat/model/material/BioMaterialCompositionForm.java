package edu.cornell.cals.biomat.model.material;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.cornell.cals.biomat.dao.BioMaterialComposition;

public class BioMaterialCompositionForm implements Serializable{
	private static final long serialVersionUID = -5114043930431101518L;
	@NotNull
	@Size(min=2, max=300)
	private String materialName;
	private Long selectedBioMaterialId;
	
	private List<BioMaterialComposition> bioMaterialCompositionList;
	
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public Long getSelectedBioMaterialId() {
		return selectedBioMaterialId;
	}
	public void setSelectedBioMaterialId(Long selectedBioMaterialId) {
		this.selectedBioMaterialId = selectedBioMaterialId;
	}
	public List<BioMaterialComposition> getBioMaterialCompositionList() {
		return bioMaterialCompositionList;
	}
	public void setBioMaterialNutrientList(List<BioMaterialComposition> bioMaterialCompositionList) {
		this.bioMaterialCompositionList = bioMaterialCompositionList;
	}
	
}
