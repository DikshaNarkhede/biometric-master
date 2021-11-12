package edu.cornell.cals.biomat.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bio_discreet_data")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class BioDiscreetData implements Serializable{

	private static final long serialVersionUID = 4L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Long materialId;
	
	@NotNull
	private int yVariableId;
	@NotNull
	private int aVariableId;
	private int bVariableId;
	private int cVariableId;
	private int dVariableId;
	private int eVariableId;
	private int fVariableId;
	private int gVariableId;
	private int hVariableId;
	private int iVariableId;
	private int jVariableId;
	
	
	@NotNull
	private Double yValue;
	@NotNull
	private Double aValue;
	private Double bValue;
	private Double cValue;
	private Double dValue;
	private Double eValue;
	private Double fValue;
	private Double gValue;
	private Double hValue;
	private Double iValue;
	private Double jValue;
	
	
	private String author_name;
	private String year;

	
	private String addedBy;
	private String updatedBy;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "materialId", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioMaterial bioMaterial;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "yVariableId", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable yBioVariable;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "aVariableId", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable aBioVariable;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bVariableId", nullable = true, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable bBioVariable = null;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cVariableId", nullable = true, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable cBioVariable = null;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "dVariableId", nullable = true, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable dBioVariable = null;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "eVariableId", nullable = true, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable eBioVariable = null;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fVariableId", nullable = true, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable fBioVariable = null;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gVariableId", nullable = true, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable gBioVariable = null;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "hVariableId", nullable = true, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable hBioVariable = null;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "iVariableId", nullable = true, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable iBioVariable = null;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "jVariableId", nullable = true, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable jBioVariable = null;


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
	
	
	public String getAuthorName() {
		return author_name;
	}

	public void setAuthorName(String author_name) {
		this.author_name = author_name;
	}
	
	
	
	

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public int getyVariableId() {
		return yVariableId;
	}

	public void setyVariableId(int yVariableId) {
		this.yVariableId = yVariableId;
	}

	public int getaVariableId() {
		return aVariableId;
	}

	public void setaVariableId(int aVariableId) {
		this.aVariableId = aVariableId;
	}

	public int getbVariableId() {
		return bVariableId;
	}

	public void setbVariableId(int bVariableId) {
		this.bVariableId = bVariableId;
	}

	public int getcVariableId() {
		return cVariableId;
	}

	public void setcVariableId(int cVariableId) {
		this.cVariableId = cVariableId;
	}

	public int getdVariableId() {
		return dVariableId;
	}

	public void setdVariableId(int dVariableId) {
		this.dVariableId = dVariableId;
	}

	public int geteVariableId() {
		return eVariableId;
	}

	public void seteVariableId(int eVariableId) {
		this.eVariableId = eVariableId;
	}

	public int getfVariableId() {
		return fVariableId;
	}

	public void setfVariableId(int fVariableId) {
		this.fVariableId = fVariableId;
	}

	public int getgVariableId() {
		return gVariableId;
	}

	public void setgVariableId(int gVariableId) {
		this.gVariableId = gVariableId;
	}

	public int gethVariableId() {
		return hVariableId;
	}

	public void sethVariableId(int hVariableId) {
		this.hVariableId = hVariableId;
	}

	public int getiVariableId() {
		return iVariableId;
	}

	public void setiVariableId(int iVariableId) {
		this.iVariableId = iVariableId;
	}

	public int getjVariableId() {
		return jVariableId;
	}

	public void setjVariableId(int jVariableId) {
		this.jVariableId = jVariableId;
	}

	public Double getyValue() {
		return yValue;
	}

	public void setyValue(Double yValue) {
		this.yValue = yValue;
	}

	public Double getaValue() {
		return aValue;
	}

	public void setaValue(Double aValue) {
		this.aValue = aValue;
	}

	public Double getbValue() {
		return bValue;
	}

	public void setbValue(Double bValue) {
		this.bValue = bValue;
	}

	public Double getcValue() {
		return cValue;
	}

	public void setcValue(Double cValue) {
		this.cValue = cValue;
	}

	public Double getdValue() {
		return dValue;
	}

	public void setdValue(Double dValue) {
		this.dValue = dValue;
	}

	public Double geteValue() {
		return eValue;
	}

	public void seteValue(Double eValue) {
		this.eValue = eValue;
	}

	public Double getfValue() {
		return fValue;
	}

	public void setfValue(Double fValue) {
		this.fValue = fValue;
	}

	public Double getgValue() {
		return gValue;
	}

	public void setgValue(Double gValue) {
		this.gValue = gValue;
	}

	public Double gethValue() {
		return hValue;
	}

	public void sethValue(Double hValue) {
		this.hValue = hValue;
	}

	public Double getiValue() {
		return iValue;
	}

	public void setiValue(Double iValue) {
		this.iValue = iValue;
	}

	public Double getjValue() {
		return jValue;
	}

	public void setjValue(Double jValue) {
		this.jValue = jValue;
	}

	public BioVariable getyBioVariable() {
		return yBioVariable;
	}

	public void setyBioVariable(BioVariable yBioVariable) {
		this.yBioVariable = yBioVariable;
	}

	public BioVariable getaBioVariable() {
		return aBioVariable;
	}

	public void setaBioVariable(BioVariable aBioVariable) {
		this.aBioVariable = aBioVariable;
	}

	public BioVariable getbBioVariable() {
		return bBioVariable;
	}

	public void setbBioVariable(BioVariable bBioVariable) {
		this.bBioVariable = bBioVariable;
	}

	public BioVariable getcBioVariable() {
		return cBioVariable;
	}

	public void setcBioVariable(BioVariable cBioVariable) {
		this.cBioVariable = cBioVariable;
	}

	public BioVariable getdBioVariable() {
		return dBioVariable;
	}

	public void setdBioVariable(BioVariable dBioVariable) {
		this.dBioVariable = dBioVariable;
	}

	public BioVariable geteBioVariable() {
		return eBioVariable;
	}

	public void seteBioVariable(BioVariable eBioVariable) {
		this.eBioVariable = eBioVariable;
	}

	public BioVariable getfBioVariable() {
		return fBioVariable;
	}

	public void setfBioVariable(BioVariable fBioVariable) {
		this.fBioVariable = fBioVariable;
	}

	public BioVariable getgBioVariable() {
		return gBioVariable;
	}

	public void setgBioVariable(BioVariable gBioVariable) {
		this.gBioVariable = gBioVariable;
	}

	public BioVariable gethBioVariable() {
		return hBioVariable;
	}

	public void sethBioVariable(BioVariable hBioVariable) {
		this.hBioVariable = hBioVariable;
	}

	public BioVariable getiBioVariable() {
		return iBioVariable;
	}

	public void setiBioVariable(BioVariable iBioVariable) {
		this.iBioVariable = iBioVariable;
	}

	public BioVariable getjBioVariable() {
		return jBioVariable;
	}

	public void setjBioVariable(BioVariable jBioVariable) {
		this.jBioVariable = jBioVariable;
	}

	
	
	@Override
	public String toString() {
		return "BioDiscreetData [id=" + id + ", materialId=" + materialId + ", yVariableId=" + yVariableId
				+ ", aVariableId=" + aVariableId + ", bVariableId=" + bVariableId + ", cVariableId=" + cVariableId
				+ ", dVariableId=" + dVariableId + ", eVariableId=" + eVariableId + ", fVariableId=" + fVariableId
				+ ", gVariableId=" + gVariableId + ", hVariableId=" + hVariableId + ", iVariableId=" + iVariableId
				+ ", jVariableId=" + jVariableId + ", yValue=" + yValue + ", aValue=" + aValue + ", bValue=" + bValue
				+ ", cValue=" + cValue + ", dValue=" + dValue + ", eValue=" + eValue + ", fValue=" + fValue
				+ ", gValue=" + gValue + ", hValue=" + hValue + ", iValue=" + iValue + ", jValue=" + jValue
				+ ", author_name=" + author_name + ", year=" + year + ", addedBy=" + addedBy + ", updatedBy="
				+ updatedBy + ", bioMaterial=" + bioMaterial + ", yBioVariable=" + yBioVariable + ", aBioVariable="
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
