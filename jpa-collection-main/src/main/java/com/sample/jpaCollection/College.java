package com.sample.jpaCollection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="CollegeTable")
public class College {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	private int slNo;
	private int colCode;
	private String name;
	@ElementCollection
	private List<Branch> branch = new ArrayList<Branch>();

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public int getColCode() {
		return colCode;
	}

	public void setColCode(int colCode) {
		this.colCode = colCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Branch> getBranch() {
		return branch;
	}

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

}
