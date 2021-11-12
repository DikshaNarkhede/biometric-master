package edu.cornell.cals.biomat.model.discreet;

import java.io.Serializable;
import java.util.List;

import edu.cornell.cals.biomat.dao.BioDiscreetData;


public class ShowBioDiscreetDataForm implements  Serializable{
	private static final long serialVersionUID = -4L;
	

	protected List<BioDiscreetData> bioDiscreetDatas;
	
	
	public List<BioDiscreetData> getBioDiscreetDatas() {
		return bioDiscreetDatas;
	}
	public void setBioDiscreetDatas(List<BioDiscreetData> bioDiscreetDatas) {
		this.bioDiscreetDatas = bioDiscreetDatas;
	}
	@Override
	public String toString() {
		return "ShowBioDiscreetDataForm [bioDiscreetDatas=" + bioDiscreetDatas + "]";
	}

}
