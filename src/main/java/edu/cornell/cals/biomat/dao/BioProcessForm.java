package edu.cornell.cals.biomat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity	
@Table(name="bio_material_process_form")
@EntityListeners(AuditingEntityListener.class)
public class BioProcessForm implements Serializable{
	
	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ids;

	@Column(name = "process")	
	private String process;

	@Column(name = "form")
	private String form;
	
	//@OneToMany(targetEntity=BioMaterial.class, mappedBy="longDesc", fetch=FetchType.EAGER)	
	//private List<String> longDesc;		

	public Integer getIds() {
		return ids;
	}

	public void setId(Integer ids) {
		this.ids = ids;
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

	

	/*public List<String> getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(List<String> longDesc) {
		this.longDesc = longDesc;
	}*/

	@Override
	public String toString() {
		return "BioProcessForm [ids=" + ids + ", process=" + process + ", form=" + form + "]";
	}


}
