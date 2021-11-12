package edu.cornell.cals.biomat.dao;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="bio_material_composition")
public class BioMaterialComposition implements Serializable{
	private static final long serialVersionUID = 1987782750999640931L;
	
	@EmbeddedId
	private BioMaterialCompositionId id;
	
	
	private Double nutrientValue;
	private String dataPoints;
	private String stdError;
	private String srcCd;
	private String derivationCd;
	private String nbdNumber;
	private String numberOfStudies;
	private String minValue;
	private String maxValue;
	private String df;
	private String lowEb;
	private String statCmt;
	private String addModDate;
	private String cc;
	
	@ManyToOne
    @JoinColumns(@JoinColumn(name = "composition_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false))
    private BioComposition bioComposition;
	
	

	@OneToOne
    @JoinColumns(@JoinColumn(name = "material_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false))
    private BioMaterial bioMaterial;

	public BioMaterial getBioMaterial() {
		return bioMaterial;
	}
	public void setBioMaterial(BioMaterial bioMaterial) {
		this.bioMaterial = bioMaterial;
	}
	public BioMaterialCompositionId getId() {
		return id;
	}
	public void setId(BioMaterialCompositionId id) {
		this.id = id;
	}
	public Double getNutrientValue() {
		return nutrientValue;
	}
	public void setNutrientValue(Double nutrientValue) {
		this.nutrientValue = nutrientValue;
	}
	public String getDataPoints() {
		return dataPoints;
	}
	public void setDataPoints(String dataPoints) {
		this.dataPoints = dataPoints;
	}
	public String getStdError() {
		return stdError;
	}
	public void setStdError(String stdError) {
		this.stdError = stdError;
	}
	public String getSrcCd() {
		return srcCd;
	}
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
	}
	public String getDerivationCd() {
		return derivationCd;
	}
	public void setDerivationCd(String derivationCd) {
		this.derivationCd = derivationCd;
	}
	public String getNbdNumber() {
		return nbdNumber;
	}
	public void setNbdNumber(String nbdNumber) {
		this.nbdNumber = nbdNumber;
	}
	public String getNumberOfStudies() {
		return numberOfStudies;
	}
	public void setNumberOfStudies(String numberOfStudies) {
		this.numberOfStudies = numberOfStudies;
	}
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	public String getDf() {
		return df;
	}
	public void setDf(String df) {
		this.df = df;
	}
	public String getLowEb() {
		return lowEb;
	}
	public void setLowEb(String lowEb) {
		this.lowEb = lowEb;
	}
	public String getStatCmt() {
		return statCmt;
	}
	public void setStatCmt(String statCmt) {
		this.statCmt = statCmt;
	}
	public String getAddModDate() {
		return addModDate;
	}
	public void setAddModDate(String addModDate) {
		this.addModDate = addModDate;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public BioComposition getBioComposition() {
		return bioComposition;
	}
	public void setBioComposition(BioComposition bioComposition) {
		this.bioComposition = bioComposition;
	}
	
	
}
