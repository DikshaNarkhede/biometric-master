package edu.cornell.cals.biomat.model.material;

import java.io.Serializable;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import edu.cornell.cals.biomat.dao.BioGrouping;
import edu.cornell.cals.biomat.dao.BioMaterial;

public class BioMaterialSearchForm implements Serializable{
	private static final long serialVersionUID = -6859715018342757198L;
	@NotEmpty
	private String bioMaterialName;
	private String usdaOnly;
	protected List<Long> selectedBioMaterial;
	@OneToMany(targetEntity=BioGrouping.class, mappedBy="materialsInGroup", fetch=FetchType.EAGER)
	private List<String> materialsInGroup;
	private List<Long> id;
	private String groupName;
	private String selectmaterialid;
	private String selectgroupid;
	private List<BioGrouping> selectedGroupName;
	private List<String> materialName;
	@NotEmpty
	private String process;
	@NotEmpty
	private String form;
	private String message;

	public String getBioMaterialName() {
		return bioMaterialName;
	}
	public String getUsdaOnly() {
		return usdaOnly;
	}
	public void setUsdaOnly(String usdaOnly) {
		this.usdaOnly = usdaOnly;
	}
	public void setBioMaterialName(String bioMaterialName) {
		this.bioMaterialName = bioMaterialName;
	}

	public List<Long> getSelectedBioMaterial() {
		return selectedBioMaterial;
	}
	public void setSelectedBioMaterial(List<Long> selectedBioMaterial) {
		this.selectedBioMaterial = selectedBioMaterial;
	}
	public List<String> getMaterialsInGroup() {
		return materialsInGroup;
	}
	public void setMaterialsInGroup(List<String> materialsInGroup) {
		this.materialsInGroup = materialsInGroup;
	}
	public List<Long> getId() {
		return id;
	}
	public void setId(List<Long> id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getSelectmaterialid() {
		return selectmaterialid;
	}
	public void setSelectmaterialid(String selectmaterialid) {
		this.selectmaterialid = selectmaterialid;
	}
	public String getSelectgroupid() {
		return selectgroupid;
	}
	public void setSelectgroupid(String selectgroupid) {
		this.selectgroupid = selectgroupid;
	}
	public List<BioGrouping> getSelectedGroupName() {
		return selectedGroupName;
	}
	public void setSelectedGroupName(List<BioGrouping> selectedGroupName) {
		this.selectedGroupName = selectedGroupName;
	}
	public List<String> getMaterialName() {
		return materialName;
	}
	public void setMaterialName(List<String> materialName) {
		this.materialName = materialName;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "BioMaterialSearchForm [bioMaterialName=" + bioMaterialName + ", usdaOnly=" + usdaOnly
				+ ", selectedBioMaterial=" + selectedBioMaterial + ", materialsInGroup=" + materialsInGroup + ", id="
				+ id + ", groupName=" + groupName + ", selectmaterialid=" + selectmaterialid + ", selectgroupid="
				+ selectgroupid + ", selectedGroupName=" + selectedGroupName + ", materialName=" + materialName
				+ ", process=" + process + ", form=" + form + ", message=" + message + "]";
	}

}
