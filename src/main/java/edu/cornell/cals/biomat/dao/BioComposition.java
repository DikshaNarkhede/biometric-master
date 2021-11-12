
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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bio_composition")
@JsonIgnoreProperties({"createdAt", "updatedAt","siUnit","description","symbol","addedBy","updatedBy"})
@EntityListeners(AuditingEntityListener.class)
public class BioComposition implements Serializable{
	private static final long serialVersionUID = -7643295823243097578L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String uom;
	private String tagName;
	private String nutrientDesc;
	private Integer roundedDecimal;
	private Integer sortOrder;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getNutrientDesc() {
		return nutrientDesc;
	}
	public void setNutrientDesc(String nutrientDesc) {
		this.nutrientDesc = nutrientDesc;
	}
	public Integer getRoundedDecimal() {
		return roundedDecimal;
	}
	public void setRoundedDecimal(Integer roundedDecimal) {
		this.roundedDecimal = roundedDecimal;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}


	
}

