package edu.cornell.cals.biomat.model.measurement;

public class MeasurementPair{
	
	private Integer id;
	private String name;
	
	private Double  measurementValue;
	private Double errorValue;
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
	public Double getMeasurementValue() {
		return measurementValue;
	}
	public void setMeasurementValue(Double measurementValue) {
		this.measurementValue = measurementValue;
	}
	public Double getErrorValue() {
		return errorValue;
	}
	public void setErrorValue(Double errorValue) {
		this.errorValue = errorValue;
	}
	@Override
	public String toString() {
		return "MeasurementPair [id=" + id + ", name=" + name + ", measurementValue=" + measurementValue
				+ ", errorValue=" + errorValue + "]";
	}
	

	
	
}