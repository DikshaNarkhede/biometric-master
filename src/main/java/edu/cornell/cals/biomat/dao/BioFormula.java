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
@Table(name="bio_formula")
@JsonIgnoreProperties({"createdAt", "updatedAt","addedBy","updatedBy","bioVariable","bioDependentVariable"})
@EntityListeners(AuditingEntityListener.class)
public class BioFormula implements Serializable{
	
	private static final long serialVersionUID = 3775220820478810683L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String formula;
	
	private Integer variableId;
	 
	
	private String formulaDesc;
	

	
	private String citation;
	private String doi;
	private String isApproved;

	private String addedBy;
	private String updatedBy;
	private String approvedBy;

	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "variableId", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable bioVariable;
	
	//Transiant
	public String getFormulaAndName() {
		return name + " : " + formula;
	}


	//Transiant
	public String getflatFormula() {
		return name + " : " + formula;
	}


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






	public Integer getVariableId() {
		return variableId;
	}



	public void setVariableId(Integer variableId) {
		this.variableId = variableId;
	}








	public String getFormulaDesc() {
		return formulaDesc;
	}



	public void setFormulaDesc(String formulaDesc) {
		this.formulaDesc = formulaDesc;
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



	public String getIsApproved() {
		return isApproved;
	}



	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}



	public String getAddedBy() {
		return addedBy;
	}



	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}



	public String getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	public String getApprovedBy() {
		return approvedBy;
	}



	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public BioVariable getBioVariable() {
		return bioVariable;
	}



	public void setBioVariable(BioVariable bioVariable) {
		this.bioVariable = bioVariable;
	}






	


}
