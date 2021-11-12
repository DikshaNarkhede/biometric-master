package edu.cornell.cals.biomat.model.measurement;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BioMeasurementForm implements  Serializable{
	private static final long serialVersionUID = -4466876916099902333L;
	
	@NotNull
	private Long materialId;

	private String materialName;
	
	@NotNull
	private Integer variableId;
	@NotNull
	@NotEmpty
	private String citation;
	@NotNull
	@NotEmpty
	private String doi;

	private List<MeasurementPair> measurementPairs;

	public Long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
	public Integer getVariableId() {
		return variableId;
	}
	public void setVariableId(Integer variableId) {
		this.variableId = variableId;
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
	public List<MeasurementPair> getMeasurementPairs() {
		return measurementPairs;
	}
	public void setMeasurementPairs(List<MeasurementPair> measurementPairs) {
		this.measurementPairs = measurementPairs;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	@Override
	public String toString() {
		return "BioMeasurementForm [materialId=" + materialId + ", materialName=" + materialName + ", variableId="
				+ variableId + ", citation=" + citation + ", doi=" + doi + ", measurementPairs=" + measurementPairs
				+ "]";
	}
	
	
	
}
