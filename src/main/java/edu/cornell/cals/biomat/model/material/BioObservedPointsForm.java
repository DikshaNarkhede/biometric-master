package edu.cornell.cals.biomat.model.material;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BioObservedPointsForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@NotNull
	@Size(min=2, max=300)
	private String materialName;
	private Long selectedBioMaterialId;
	/*
	private List<BioMeasurement> bioMeasurementList;

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

	public List<BioMeasurement> getBioMeasurementList() {
		return bioMeasurementList;
	}

	public void setBioMeasurementList(List<BioMeasurement> bioMeasurementList) {
		this.bioMeasurementList = bioMeasurementList;
	}
*/
}
