package edu.cornell.cals.biomat.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bio_formula_material")
@JsonIgnoreProperties({"createdAt", "updatedAt","addedBy","updatedBy"})
@EntityListeners(AuditingEntityListener.class)
public class BioFormulaMaterial implements Serializable{
	private static final long serialVersionUID = 5464197434520479048L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long formulaId;
	private Long materialId;

	private Long groupId;
	
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
	@JoinColumn(name = "formulaId", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioFormula bioFormula;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "materialId", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioMaterial bioMaterial;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "groupId", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
	private BioGrouping bioGrouping;
	
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

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
	
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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

	
	
	

	public BioFormula getBioFormula() {
		return bioFormula;
	}

	public void setBioFormula(BioFormula bioFormula) {
		this.bioFormula = bioFormula;
	}

	public BioMaterial getBioMaterial() {
		return bioMaterial;
	}

	public void setBioMaterial(BioMaterial bioMaterial) {
		this.bioMaterial = bioMaterial;
	}

	public BioGrouping getBioGrouping() {
		return bioGrouping;
	}

	public void setBioGrouping(BioGrouping bioGrouping) {
		this.bioGrouping = bioGrouping;
	}

	@Override
	public String toString() {
		return "BioFormulaMaterial [id=" + id + ", formulaId=" + formulaId + ", materialId=" + materialId
				+ ", isApproved=" + isApproved + ", addedBy=" + addedBy + ", updatedBy=" + updatedBy + ", approvedBy="
				+ approvedBy + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", bioFormula=" + bioFormula
				+ ", bioMaterial=" + bioMaterial + "]";
	}
	
	
}
