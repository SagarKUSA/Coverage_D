package com.coverage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="coverage")
public class Coverage {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String coverageName;
	private String coverageGroup;
	private Boolean policyCoverage;
	private Boolean vechicleCoverage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoverageName() {
		return coverageName;
	}
	public void setCoverageName(String coverageName) {
		this.coverageName = coverageName;
	}
	public String getCoverageGroup() {
		return coverageGroup;
	}
	public void setCoverageGroup(String coverageGroup) {
		this.coverageGroup = coverageGroup;
	}
	public Boolean getPolicyCoverage() {
		return policyCoverage;
	}
	public void setPolicyCoverage(Boolean policyCoverage) {
		this.policyCoverage = policyCoverage;
	}
	public Boolean getVechicleCoverage() {
		return vechicleCoverage;
	}
	public void setVechicleCoverage(Boolean vechicleCoverage) {
		this.vechicleCoverage = vechicleCoverage;
	}
	@Override
	public String toString() {
		return "Coverage [id=" + id + ", coverageName=" + coverageName + ", coverageGroup=" + coverageGroup
				+ ", policyCoverage=" + policyCoverage + ", vechicleCoverage=" + vechicleCoverage + "]";
	} 
	
	


}
