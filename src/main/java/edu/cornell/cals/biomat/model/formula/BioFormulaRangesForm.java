package edu.cornell.cals.biomat.model.formula;

import java.util.List;

import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.dao.BioFormulaRange;

public class BioFormulaRangesForm {
	protected BioFormula bioFormula;
	protected List<BioFormulaRange> ranges;
	public BioFormula getBioFormula() {
		return bioFormula;
	}
	public void setBioFormula(BioFormula bioFormula) {
		this.bioFormula = bioFormula;
	}
	public List<BioFormulaRange> getRanges() {
		return ranges;
	}
	public void setRanges(List<BioFormulaRange> ranges) {
		this.ranges = ranges;
	}
	
}
