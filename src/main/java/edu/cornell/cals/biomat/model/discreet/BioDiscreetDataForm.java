package edu.cornell.cals.biomat.model.discreet;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import edu.cornell.cals.biomat.excel.MyCell;


public class BioDiscreetDataForm implements  Serializable{
	private static final long serialVersionUID = -4L;
	
	
	
	private Long id;
	@NotNull
	private Long materialId;
	private String authorName;
	private String year;
	
	@NotNull
	private int yVariableId;
	
	MultipartFile file;
	
	Map<Integer, List<MyCell>> data = new HashMap<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getyVariableId() {
		return yVariableId;
	}

	public void setyVariableId(int yVariableId) {
		this.yVariableId = yVariableId;
	}

	public Map<Integer, List<MyCell>> getData() {
		return data;
	}

	public void setData(Map<Integer, List<MyCell>> data) {
		this.data = data;
	}
	
	

}
