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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bio_observed_point")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class BioObservedPoint implements Serializable{

	private static final long serialVersionUID = 5987829938980111480L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Long materialId;
	@NotNull
	private int xVariableId;
	@NotNull
	private int yVariableId;
	@NotNull
	private Double xObservedValue;
	@NotNull
	private Double yObservedValue;
	@NotNull
	private Double errorValue;
	@NotEmpty
	private String citation;
	@NotEmpty
	private String doi;
	
	private String isApproved;
	
	
	
	
	private String addedBy;
	private String updatedBy;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "materialId", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioMaterial bioMaterial;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "xVariableId", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable xBioVariable;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "yVariableId", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable yBioVariable;

	
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public int getxVariableId() {
		return xVariableId;
	}

	public void setxVariableId(int xVariableId) {
		this.xVariableId = xVariableId;
	}

	public int getyVariableId() {
		return yVariableId;
	}

	public void setyVariableId(int yVariableId) {
		this.yVariableId = yVariableId;
	}

	public Double getxObservedValue() {
		return xObservedValue;
	}

	public void setxObservedValue(Double xObservedValue) {
		this.xObservedValue = xObservedValue;
	}

	public Double getyObservedValue() {
		return yObservedValue;
	}

	public void setyObservedValue(Double yObservedValue) {
		this.yObservedValue = yObservedValue;
	}

	public Double getErrorValue() {
		return errorValue;
	}

	public void setErrorValue(Double errorValue) {
		this.errorValue = errorValue;
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

	public BioMaterial getBioMaterial() {
		return bioMaterial;
	}

	public void setBioMaterial(BioMaterial bioMaterial) {
		this.bioMaterial = bioMaterial;
	}

	public BioVariable getxBioVariable() {
		return xBioVariable;
	}

	public void setxBioVariable(BioVariable xBioVariable) {
		this.xBioVariable = xBioVariable;
	}

	public BioVariable getyBioVariable() {
		return yBioVariable;
	}

	public void setyBioVariable(BioVariable yBioVariable) {
		this.yBioVariable = yBioVariable;
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

	@Override
	public String toString() {
		return "BioObservedPoint [id=" + id + ", materialId=" + materialId + ", xVariableId=" + xVariableId
				+ ", yVariableId=" + yVariableId + ", xObservedValue=" + xObservedValue + ", yObservedValue="
				+ yObservedValue + ", errorValue=" + errorValue + ", citation=" + citation + ", doi=" + doi
				+ ", isApproved=" + isApproved + ", addedBy=" + addedBy + ", updatedBy=" + updatedBy + ", bioMaterial="
				+ bioMaterial + ", xBioVariable=" + xBioVariable + ", yBioVariable=" + yBioVariable + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}


    
    
    
    
    
}
