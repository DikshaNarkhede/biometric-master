package edu.cornell.cals.biomat.model.material;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.dao.BioMaterial;
import edu.cornell.cals.biomat.dao.BioVariable;
import edu.cornell.cals.biomat.model.BioMaterialCompositionModel;

public class BioMaterialGraphForm implements Serializable{
	private static final long serialVersionUID = 1143801111114953319L;
	private BioMaterial bioMaterial;
	private List<BioVariable> variableList;
	private List<BioVariable> dependentVariableList;
	private List<BioFormula> bioFormulaList;
	
	
	private Integer selectedBioMaterialId1;
	private Integer selectedBioMaterialId2;
	private Integer selectedBioMaterialId3;
	private Integer selectedBioMaterialId4;
	private Integer selectedBioMaterialId5;
	
	private Integer selectedBioVariableId1;
	private Integer selectedBioVariableId2;
	private Integer selectedBioVariableId3;
	private Integer selectedBioVariableId4;
	private Integer selectedBioVariableId5;
	
	private Integer selectedDependentBioVariableId;
	
	private Integer selectedBioFormulaId1;
	private Integer selectedBioFormulaId2;
	private Integer selectedBioFormulaId3;
	private Integer selectedBioFormulaId4;
	private Integer selectedBioFormulaId5;
	
	private Integer minRange = 50;
	private Integer maxRange = 100;
	
	private List<BioMaterialCompositionModel> bioMaterialCompositionModelList1; 
	private List<BioMaterialCompositionModel> bioMaterialCompositionModelList2; 
	private List<BioMaterialCompositionModel> bioMaterialCompositionModelList3; 
	private List<BioMaterialCompositionModel> bioMaterialCompositionModelList4; 
	private List<BioMaterialCompositionModel> bioMaterialCompositionModelList5; 
	
	public BioMaterial getBioMaterial() {
		return bioMaterial;
	}
	public void setBioMaterial(BioMaterial bioMaterial) {
		this.bioMaterial = bioMaterial;
	}
	public List<BioVariable> getVariableList() {
		return variableList;
	}
	public void setVariableList(List<BioVariable> variableList) {
		this.variableList = variableList;
	}
	public List<BioVariable> getDependentVariableList() {
		return dependentVariableList;
	}
	public void setDependentVariableList(List<BioVariable> dependentVariableList) {
		this.dependentVariableList = dependentVariableList;
	}
	public Integer getMinRange() {
		return minRange;
	}
	public void setMinRange(Integer minRange) {
		this.minRange = minRange;
	}
	public Integer getMaxRange() {
		return maxRange;
	}
	public void setMaxRange(Integer maxRange) {
		this.maxRange = maxRange;
	}
	public List<BioFormula> getBioFormulaList() {
		return bioFormulaList;
	}
	public void setBioFormulaList(List<BioFormula> bioFormulaList) {
		this.bioFormulaList = bioFormulaList;
	}
	public Integer getSelectedBioMaterialId1() {
		return selectedBioMaterialId1;
	}
	public void setSelectedBioMaterialId1(Integer selectedBioMaterialId1) {
		this.selectedBioMaterialId1 = selectedBioMaterialId1;
	}
	public Integer getSelectedBioMaterialId2() {
		return selectedBioMaterialId2;
	}
	public void setSelectedBioMaterialId2(Integer selectedBioMaterialId2) {
		this.selectedBioMaterialId2 = selectedBioMaterialId2;
	}
	public Integer getSelectedBioMaterialId3() {
		return selectedBioMaterialId3;
	}
	public void setSelectedBioMaterialId3(Integer selectedBioMaterialId3) {
		this.selectedBioMaterialId3 = selectedBioMaterialId3;
	}
	public Integer getSelectedBioMaterialId4() {
		return selectedBioMaterialId4;
	}
	public void setSelectedBioMaterialId4(Integer selectedBioMaterialId4) {
		this.selectedBioMaterialId4 = selectedBioMaterialId4;
	}
	public Integer getSelectedBioMaterialId5() {
		return selectedBioMaterialId5;
	}
	public void setSelectedBioMaterialId5(Integer selectedBioMaterialId5) {
		this.selectedBioMaterialId5 = selectedBioMaterialId5;
	}
	public Integer getSelectedBioVariableId1() {
		return selectedBioVariableId1;
	}
	public Integer getSelectedBioVariableId2() {
		return selectedBioVariableId2;
	}
	public Integer getSelectedBioVariableId3() {
		return selectedBioVariableId3;
	}
	public Integer getSelectedBioVariableId4() {
		return selectedBioVariableId4;
	}
	public Integer getSelectedBioVariableId5() {
		return selectedBioVariableId5;
	}
	public void setSelectedBioVariableId1(Integer selectedBioVariableId1) {
		this.selectedBioVariableId1 = selectedBioVariableId1;
	}
	public void setSelectedBioVariableId2(Integer selectedBioVariableId2) {
		this.selectedBioVariableId2 = selectedBioVariableId2;
	}
	public void setSelectedBioVariableId3(Integer selectedBioVariableId3) {
		this.selectedBioVariableId3 = selectedBioVariableId3;
	}
	public void setSelectedBioVariableId4(Integer selectedBioVariableId4) {
		this.selectedBioVariableId4 = selectedBioVariableId4;
	}
	public void setSelectedBioVariableId5(Integer selectedBioVariableId5) {
		this.selectedBioVariableId5 = selectedBioVariableId5;
	}
	public Integer getSelectedDependentBioVariableId() {
		return selectedDependentBioVariableId;
	}
	public void setSelectedDependentBioVariableId(Integer selectedDependentBioVariableId) {
		this.selectedDependentBioVariableId = selectedDependentBioVariableId;
	}
	public Integer getSelectedBioFormulaId1() {
		return selectedBioFormulaId1;
	}
	public void setSelectedBioFormulaId1(Integer selectedBioFormulaId1) {
		this.selectedBioFormulaId1 = selectedBioFormulaId1;
	}
	public Integer getSelectedBioFormulaId2() {
		return selectedBioFormulaId2;
	}
	public void setSelectedBioFormulaId2(Integer selectedBioFormulaId2) {
		this.selectedBioFormulaId2 = selectedBioFormulaId2;
	}
	public Integer getSelectedBioFormulaId3() {
		return selectedBioFormulaId3;
	}
	public void setSelectedBioFormulaId3(Integer selectedBioFormulaId3) {
		this.selectedBioFormulaId3 = selectedBioFormulaId3;
	}
	public Integer getSelectedBioFormulaId4() {
		return selectedBioFormulaId4;
	}
	public void setSelectedBioFormulaId4(Integer selectedBioFormulaId4) {
		this.selectedBioFormulaId4 = selectedBioFormulaId4;
	}
	public Integer getSelectedBioFormulaId5() {
		return selectedBioFormulaId5;
	}
	public void setSelectedBioFormulaId5(Integer selectedBioFormulaId5) {
		this.selectedBioFormulaId5 = selectedBioFormulaId5;
	}
	public List<BioMaterialCompositionModel> getBioMaterialCompositionModelList1() {
		return bioMaterialCompositionModelList1;
	}
	public void setBioMaterialCompositionModelList1(List<BioMaterialCompositionModel> bioMaterialCompositionModelList) {
		this.bioMaterialCompositionModelList1 = bioMaterialCompositionModelList;
	}
	public List<BioMaterialCompositionModel> getBioMaterialCompositionModelList2() {
		return bioMaterialCompositionModelList2;
	}
	public void setBioMaterialCompositionModelList2(List<BioMaterialCompositionModel> bioMaterialCompositionModelList) {
		this.bioMaterialCompositionModelList2 = bioMaterialCompositionModelList;
	}
	public List<BioMaterialCompositionModel> getBioMaterialCompositionModelList3() {
		return bioMaterialCompositionModelList3;
	}
	public void setBioMaterialCompositionModelList3(List<BioMaterialCompositionModel> bioMaterialCompositionModelList) {
		this.bioMaterialCompositionModelList3 = bioMaterialCompositionModelList;
	}
	public List<BioMaterialCompositionModel> getBioMaterialCompositionModelList4() {
		return bioMaterialCompositionModelList4;
	}
	public void setBioMaterialCompositionModelList4(List<BioMaterialCompositionModel> bioMaterialCompositionModelList) {
		this.bioMaterialCompositionModelList4 = bioMaterialCompositionModelList;
	}
	public List<BioMaterialCompositionModel> getBioMaterialCompositionModelList5() {
		return bioMaterialCompositionModelList5;
	}
	public void setBioMaterialCompositionModelList5(List<BioMaterialCompositionModel> bioMaterialCompositionModelList) {
		this.bioMaterialCompositionModelList5 = bioMaterialCompositionModelList;
	}
	public List<Integer> getSelectedBioMaterialIdList() {
		List<Integer> selectedBioMaterialList = new ArrayList<>();
		selectedBioMaterialList.add(this.selectedBioMaterialId1);
		selectedBioMaterialList.add(this.selectedBioMaterialId2);
		selectedBioMaterialList.add(this.selectedBioMaterialId3);
		selectedBioMaterialList.add(this.selectedBioMaterialId4);
		selectedBioMaterialList.add(this.selectedBioMaterialId5);
		return selectedBioMaterialList;
	}
	public List<Integer> getSelectedBioVariableIdList() {
		List<Integer> selectedBioVariableIdList = new ArrayList<>();
		selectedBioVariableIdList.add(this.selectedBioVariableId1);
		selectedBioVariableIdList.add(this.selectedBioVariableId2);
		selectedBioVariableIdList.add(this.selectedBioVariableId3);
		selectedBioVariableIdList.add(this.selectedBioVariableId4);
		selectedBioVariableIdList.add(this.selectedBioVariableId5);
		return selectedBioVariableIdList;
	}
	public List<Integer> getSelectedBioFormulaIdList() {
		List<Integer> selectedBioFormulaIdList = new ArrayList<>();
		selectedBioFormulaIdList.add(this.selectedBioFormulaId1);
		selectedBioFormulaIdList.add(this.selectedBioFormulaId2);
		selectedBioFormulaIdList.add(this.selectedBioFormulaId3);
		selectedBioFormulaIdList.add(this.selectedBioFormulaId4);
		selectedBioFormulaIdList.add(this.selectedBioFormulaId5);
		return selectedBioFormulaIdList;
	}
	public List<List<BioMaterialCompositionModel>> getBioMaterialCompositionModelListList() {
		List<List<BioMaterialCompositionModel>> bioMaterialCompositionModelListList = new ArrayList<>();
		bioMaterialCompositionModelListList.add(this.bioMaterialCompositionModelList1);
		bioMaterialCompositionModelListList.add(this.bioMaterialCompositionModelList2);
		bioMaterialCompositionModelListList.add(this.bioMaterialCompositionModelList3);
		bioMaterialCompositionModelListList.add(this.bioMaterialCompositionModelList4);
		bioMaterialCompositionModelListList.add(this.bioMaterialCompositionModelList5);
		return bioMaterialCompositionModelListList;
	}
}
