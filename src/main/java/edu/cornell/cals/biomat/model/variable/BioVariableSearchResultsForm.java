package edu.cornell.cals.biomat.model.variable;

import java.util.List;

import edu.cornell.cals.biomat.dao.BioVariable;

public class BioVariableSearchResultsForm {
protected BioVariableSearchForm bioVariableSearchForm;
	
	protected List<BioVariable> bioVariables;
	
	private int currentPage;
	private int lastPage;
	
	private int pagerStart;
	private int pagerEnd;
	public BioVariableSearchForm getBioVariableSearchForm() {
		return bioVariableSearchForm;
	}
	public void setBioVariableSearchForm(BioVariableSearchForm bioVariableSearchForm) {
		this.bioVariableSearchForm = bioVariableSearchForm;
	}
	public List<BioVariable> getBioVariables() {
		return bioVariables;
	}
	public void setBioVariables(List<BioVariable> bioVariables) {
		this.bioVariables = bioVariables;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getPagerStart() {
		return pagerStart;
	}
	public void setPagerStart(int pagerStart) {
		this.pagerStart = pagerStart;
	}
	public int getPagerEnd() {
		return pagerEnd;
	}
	public void setPagerEnd(int pagerEnd) {
		this.pagerEnd = pagerEnd;
	}
	@Override
	public String toString() {
		return "BioVariableSearchResultsForm [bioVariableSearchForm=" + bioVariableSearchForm + ", bioVariables="
				+ bioVariables + ", currentPage=" + currentPage + ", lastPage=" + lastPage + ", pagerStart="
				+ pagerStart + ", pagerEnd=" + pagerEnd + "]";
	}
	
	
	
}
