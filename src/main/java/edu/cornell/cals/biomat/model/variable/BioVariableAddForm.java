package edu.cornell.cals.biomat.model.variable;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BioVariableAddForm  implements Serializable{
	private static final long serialVersionUID = -5865084796173252199L;

	private Integer id;

	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String description;
	@NotNull
	@NotEmpty
	private String symbol;
	@NotNull
	@NotEmpty
	private String uom;
	
	private String message;
	
	
	private String addedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BioVariableAddForm [id=" + id + ", name=" + name + ", description=" + description + ", symbol=" + symbol
				+ ", uom=" + uom + ", addedBy=" + addedBy + "]";
	}

	
}
