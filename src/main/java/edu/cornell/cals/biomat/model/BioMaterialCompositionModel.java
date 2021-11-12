package edu.cornell.cals.biomat.model;

import java.io.Serializable;

public class BioMaterialCompositionModel implements Serializable{
	private static final long serialVersionUID = 7996998789667722805L;

	private Long bioMaterialId;
	private Long bioNutrientId;
	private Double nutrientValue;
	private String nutrientName;
	private String nutrientUnit;
	private String nutrientSymbol;
	private String userValue;
	public Long getBioMaterialId() {
		return bioMaterialId;
	}
	public void setBioMaterialId(Long bioMaterialId) {
		this.bioMaterialId = bioMaterialId;
	}
	public Long getBioNutrientId() {
		return bioNutrientId;
	}
	public void setBioNutrientId(Long bioNutrientId) {
		this.bioNutrientId = bioNutrientId;
	}
	public Double getNutrientValue() {
		return nutrientValue;
	}
	public void setNutrientValue(Double nutrientValue) {
		this.nutrientValue = nutrientValue;
	}
	public String getNutrientName() {
		return nutrientName;
	}
	public void setNutrientName(String nutrientName) {
		this.nutrientName = nutrientName;
	}
	public String getNutrientUnit() {
		return nutrientUnit;
	}
	public void setNutrientUnit(String nutrientUnit) {
		this.nutrientUnit = nutrientUnit;
	}
	public String getNutrientSymbol() {
		return nutrientSymbol;
	}
	public void setNutrientSymbol(String nutrientSymbol) {
		this.nutrientSymbol = nutrientSymbol;
	}
	public String getUserValue() {
		return userValue;
	}
	public void setUserValue(String userValue) {
		this.userValue = userValue;
	}
	@Override
	public String toString() {
		return "BioMaterialNutrientModel [bioMaterialId=" + bioMaterialId + ", bioNutrientId=" + bioNutrientId
				+ ", nutrientValue=" + nutrientValue + ", nutrientName=" + nutrientName + ", nutrientUnit="
				+ nutrientUnit + ", nutrientSymbol=" + nutrientSymbol + ", userValue=" + userValue + "]";
	}
	



	
	
}
