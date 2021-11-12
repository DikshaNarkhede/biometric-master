package edu.cornell.cals.biomat.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="bio_material")
@JsonIgnoreProperties({"createdAt", "updatedAt","usdaId","commonName","mfgName","usdaSurvey","refuseDesc","refusePercentage","nFactor","refusePercentage","scientificName","pFactor","choFactor","addedBy","updatedBy","citation","fFactor"})
@EntityListeners(AuditingEntityListener.class)
public class BioMaterial implements Serializable{
	@JsonProperty
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@JsonProperty
	@NotNull
	@Size(min=2, max=300)
	private String shortDesc;
	private String longDesc;
	@JsonProperty
	private String commonName;
	private String mfgName;
	private String usdaSurvey;
	private String refuseDesc;
	@javax.validation.constraints.DecimalMax(value="99.99")
	private Double refusePercentage;
	private String scientificName;
	@javax.validation.constraints.DecimalMax(value="99.99")
	private Double nFactor;
	@javax.validation.constraints.DecimalMax(value="99.99")
	private Double pFactor;
	@javax.validation.constraints.DecimalMax(value="99.99")
	private Double fFactor;
	@javax.validation.constraints.DecimalMax(value="99.99")
	private Double choFactor;
	private String addedBy;
	private String updatedBy;
	private String citation;
	
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
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getMfgName() {
		return mfgName;
	}
	public void setMfgName(String mfgName) {
		this.mfgName = mfgName;
	}
	public String getUsdaSurvey() {
		return usdaSurvey;
	}
	public void setUsdaSurvey(String usdaSurvey) {
		this.usdaSurvey = usdaSurvey;
	}
	public String getRefuseDesc() {
		return refuseDesc;
	}
	public void setRefuseDesc(String refuseDesc) {
		this.refuseDesc = refuseDesc;
	}
	public Double getRefusePercentage() {
		return refusePercentage;
	}
	public void setRefusePercentage(Double refusePercentage) {
		this.refusePercentage = refusePercentage;
	}
	public String getScientificName() {
		return scientificName;
	}
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	public Double getnFactor() {
		return nFactor;
	}
	public void setnFactor(Double nFactor) {
		this.nFactor = nFactor;
	}
	public Double getpFactor() {
		return pFactor;
	}
	public void setpFactor(Double pFactor) {
		this.pFactor = pFactor;
	}
	public Double getfFactor() {
		return fFactor;
	}
	public void setfFactor(Double fFactor) {
		this.fFactor = fFactor;
	}
	public Double getChoFactor() {
		return choFactor;
	}
	public void setChoFactor(Double choFactor) {
		this.choFactor = choFactor;
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
	public String getCitation() {
		return citation;
	}
	public void setCitation(String citation) {
		this.citation = citation;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	@Override
	public String toString() {
		return "BioMaterial [id=" + id + ", shortDesc=" + shortDesc + ", longDesc=" + longDesc
				+ ", commonName=" + commonName + ", mfgName=" + mfgName + ", usdaSurvey=" + usdaSurvey + ", refuseDesc="
				+ refuseDesc + ", refusePercentage=" + refusePercentage + ", scientificName=" + scientificName
				+ ", nFactor=" + nFactor + ", pFactor=" + pFactor + ", fFactor=" + fFactor + ", choFactor=" + choFactor
				+ ", addedBy=" + addedBy + ", updatedBy=" + updatedBy + ", citation=" + citation + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
}
