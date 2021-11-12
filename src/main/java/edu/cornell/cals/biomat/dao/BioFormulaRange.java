package edu.cornell.cals.biomat.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="bio_formula_range")
public class BioFormulaRange {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long formulaId;
	private Integer variableId;
	@Transient
	private String variableName;
	@Transient
	private String variableSymbol;
	
	@Override
	public String toString() {
		return "BioFormulaRange [id=" + id + ", formulaId=" + formulaId + ", variableId=" + variableId
				+ ", variableName=" + variableName + ", variableSymbol=" + variableSymbol + ", minRange=" + minRange
				+ ", maxRange=" + maxRange + "]";
	}
	public String getVariableSymbol() {
		return variableSymbol;
	}
	public void setVariableSymbol(String variableSymbol) {
		this.variableSymbol = variableSymbol;
	}
	private Double minRange;
	private Double maxRange;
	
	
	
	public String getVariableName() {
		return variableName;
	}
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFormulaId() {
		return formulaId;
	}
	public void setFormulaId(Long formulaId) {
		this.formulaId = formulaId;
	}
	public Integer getVariableId() {
		return variableId;
	}
	public void setVariableId(Integer variableId) {
		this.variableId = variableId;
	}
	public Double getMinRange() {
		return minRange;
	}
	public void setMinRange(Double minRange) {
		this.minRange = minRange;
	}
	public Double getMaxRange() {
		return maxRange;
	}
	public void setMaxRange(Double maxRange) {
		this.maxRange = maxRange;
	}
	
	
	

}
