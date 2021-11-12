package edu.cornell.cals.biomat.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="formula")


public class Formula implements Serializable{
	
	private static final long serialVersionUID = 3775220820478810683L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer formulaID;
	private Integer formulaVariable;
	private String formulaText;
	private String name;
	private String description;
	private String citations;
	private String doi;
	

	private Integer DependentVariableLowRange;
	private Integer DependentVariableHighRange;
	
	private String validMaterials;
	private Double error;
	private Double rSq;
	private Integer DependentVariable;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFormulaID() {
		return formulaID;
	}
	public void setFormulaID(Integer formulaID) {
		this.formulaID = formulaID;
	}
	public Integer getFormulaVariable() {
		return formulaVariable;
	}
	public void setFormulaVariable(Integer formulaVariable) {
		this.formulaVariable = formulaVariable;
	}
	public String getFormulaText() {
		return formulaText;
	}
	public void setFormulaText(String formulaText) {
		this.formulaText = formulaText;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCitations() {
		return citations;
	}
	public void setCitations(String citations) {
		this.citations = citations;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public Integer getDependentVariableLowRange() {
		return DependentVariableLowRange;
	}
	public void setDependentVariableLowRange(Integer dependentVariableLowRange) {
		DependentVariableLowRange = dependentVariableLowRange;
	}
	public Integer getDependentVariableHighRange() {
		return DependentVariableHighRange;
	}
	public void setDependentVariableHighRange(Integer dependentVariableHighRange) {
		DependentVariableHighRange = dependentVariableHighRange;
	}
	public String getValidMaterials() {
		return validMaterials;
	}
	public void setValidMaterials(String validMaterials) {
		this.validMaterials = validMaterials;
	}
	public Double getError() {
		return error;
	}
	public void setError(Double error) {
		this.error = error;
	}
	public Double getrSq() {
		return rSq;
	}
	public void setrSq(Double rSq) {
		this.rSq = rSq;
	}
	public Integer getDependentVariable() {
		return DependentVariable;
	}
	public void setDependentVariable(Integer dependentVariable) {
		DependentVariable = dependentVariable;
	}
	
	
	
}
