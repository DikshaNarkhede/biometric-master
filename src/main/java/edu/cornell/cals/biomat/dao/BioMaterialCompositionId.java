package edu.cornell.cals.biomat.dao;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BioMaterialCompositionId implements Serializable{
	private static final long serialVersionUID = 2302910861837400324L;

	@Column(name = "material_id")
	private Long materialId;
	
	@Column(name = "composition_id")
	private Integer compositionId;
	
	public Long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
	public Integer getCompositionId() {
		return compositionId;
	}
	public void setNutrientId(Integer nutrientId) {
		this.compositionId = nutrientId;
	}
	
	 @Override
	 public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof BioMaterialCompositionId)) return false;
	        
	        BioMaterialCompositionId that = (BioMaterialCompositionId) o;
	        
	        return  Objects.equals(getMaterialId(), that.getMaterialId()) &&
	                Objects.equals(getCompositionId(), that.getCompositionId());
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(getMaterialId(), getCompositionId());
	    }
 

}
