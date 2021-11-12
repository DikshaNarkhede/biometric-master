package edu.cornell.cals.biomat.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bio_relation")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class BioRelation implements Serializable{

	private static final long serialVersionUID = 4L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private int y_variable_id;
	@NotNull
	private int x1_variable_id;
	private int x2_variable_id;
	private int x3_variable_id;
	private int x4_variable_id;
	private int x5_variable_id;
	private int x6_variable_id;
	private int x7_variable_id;
	private int x8_variable_id;
	private int x9_variable_id;
	private int x10_variable_id;
	
	private String addedBy;
	private String updatedBy;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "y_variable_id", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable yBioVariable;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "x1_variable_id", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable x1BioVariable;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "x2_variable_id", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable x2BioVariable;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "x3_variable_id", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable x3BioVariable;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "x4_variable_id", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable x4BioVariable;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "x5_variable_id", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable x5BioVariable;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "x6_variable_id", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable x6BioVariable;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "x7_variable_id", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable x7BioVariable;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "x8_variable_id", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable x8BioVariable;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "x9_variable_id", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable x9BioVariable;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "x10_variable_id", nullable = false, insertable=false, updatable=false)
    @JsonIgnore
    private BioVariable x10BioVariable;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getyVariableId() {
		return y_variable_id;
	}

	public void setyVariableId(int yVariableId) {
		this.y_variable_id = yVariableId;
	}
	public int getX1VariableId() {
		return x1_variable_id;
	}

	public void setX1VariableId(int x1VariableId) {
		this.x1_variable_id = x1VariableId;
	}

	public int getX2VariableId() {
		return x2_variable_id;
	}

	public void setX2VariableId(int x2VariableId) {
		this.x2_variable_id = x2VariableId;
	}

	public int getX3VariableId() {
		return x3_variable_id;
	}

	public void setX3VariableId(int x3VariableId) {
		this.x3_variable_id = x3VariableId;
	}

	public int getX4VariableId() {
		return x4_variable_id;
	}

	public void setX4VariableId(int x4VariableId) {
		this.x4_variable_id = x4VariableId;
	}

	public int getX5VariableId() {
		return x5_variable_id;
	}

	public void setX5VariableId(int x5VariableId) {
		this.x5_variable_id = x5VariableId;
	}

	public int getX6VariableId() {
		return x6_variable_id;
	}

	public void setX6VariableId(int x6VariableId) {
		this.x6_variable_id = x6VariableId;
	}

	public int getX7VariableId() {
		return x7_variable_id;
	}

	public void setX7VariableId(int x7VariableId) {
		this.x7_variable_id = x7VariableId;
	}

	public int getX8VariableId() {
		return x8_variable_id;
	}

	public void setX8VariableId(int x8VariableId) {
		this.x8_variable_id = x8VariableId;
	}

	public int getX9VariableId() {
		return x9_variable_id;
	}

	public void setX9VariableId(int x9VariableId) {
		this.x9_variable_id = x9VariableId;
	}

	public int getX10VariableId() {
		return x10_variable_id;
	}

	public void setX10VariableId(int x10VariableId) {
		this.x10_variable_id = x10VariableId;
	}

	public BioVariable getX1BioVariable() {
		return x1BioVariable;
	}

	public void setX1BioVariable(BioVariable x1BioVariable) {
		this.x1BioVariable = x1BioVariable;
	}

	public BioVariable getX2BioVariable() {
		return x2BioVariable;
	}

	public void setX2BioVariable(BioVariable x2BioVariable) {
		this.x2BioVariable = x2BioVariable;
	}

	public BioVariable getX3BioVariable() {
		return x3BioVariable;
	}

	public void setX3BioVariable(BioVariable x3BioVariable) {
		this.x3BioVariable = x3BioVariable;
	}

	public BioVariable getX4BioVariable() {
		return x4BioVariable;
	}

	public void setX4BioVariable(BioVariable x4BioVariable) {
		this.x4BioVariable = x4BioVariable;
	}

	public BioVariable getX5BioVariable() {
		return x5BioVariable;
	}

	public void setX5BioVariable(BioVariable x5BioVariable) {
		this.x5BioVariable = x5BioVariable;
	}

	public BioVariable getX6BioVariable() {
		return x6BioVariable;
	}

	public void setX6BioVariable(BioVariable x6BioVariable) {
		this.x6BioVariable = x6BioVariable;
	}

	public BioVariable getX7BioVariable() {
		return x7BioVariable;
	}

	public void setX7BioVariable(BioVariable x7BioVariable) {
		this.x7BioVariable = x7BioVariable;
	}

	public BioVariable getX8BioVariable() {
		return x8BioVariable;
	}

	public void setX8BioVariable(BioVariable x8BioVariable) {
		this.x8BioVariable = x8BioVariable;
	}

	public BioVariable getX9BioVariable() {
		return x9BioVariable;
	}

	public void setX9BioVariable(BioVariable x9BioVariable) {
		this.x9BioVariable = x9BioVariable;
	}

	public BioVariable getX10BioVariable() {
		return x10BioVariable;
	}

	public void setX10BioVariable(BioVariable x10BioVariable) {
		this.x10BioVariable = x10BioVariable;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public BioVariable getyBioVariable() {
		return yBioVariable;
	}

	public void setyBioVariable(BioVariable yBioVariable) {
		this.yBioVariable = yBioVariable;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "BioRelation [id=" + id + ", yVariableId=" + y_variable_id + ", x1VariableId=" + x1_variable_id
				+ ", x2VariableId=" + x2_variable_id + ", x3VariableId=" + x3_variable_id + ", x4VariableId=" + x4_variable_id
				+ ", x5VariableId=" + x5_variable_id + ", x6VariableId=" + x6_variable_id + ", x7VariableId=" + x7_variable_id
				+ ", x8VariableId=" + x8_variable_id + ", x9VariableId=" + x9_variable_id + ", x10VariableId="
				+ x10_variable_id + ", addedBy=" + addedBy + ", updatedBy=" + updatedBy + ", yBioVariable=" + yBioVariable
				+ ", x1BioVariable=" + x1BioVariable + ", x2BioVariable=" + x2BioVariable + ", x3BioVariable="
				+ x3BioVariable + ", x4BioVariable=" + x4BioVariable + ", x5BioVariable=" + x5BioVariable
				+ ", x6BioVariable=" + x6BioVariable + ", x7BioVariable=" + x7BioVariable + ", x8BioVariable="
				+ x8BioVariable + ", x9BioVariable=" + x9BioVariable + ", x10BioVariable=" + x10BioVariable
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}


    
    
    
    
    
}
