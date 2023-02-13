package com.sample.jpaCollection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
public class Branch {
	@Column (name="branchName")
	private String Brname;
	@Column (name="studCapacity")
	private int capacity;
	@Column (name="FacultyBranch")
	private int noOfFaculty;

	public String getName() {
		return Brname;
	}

	public void setName(String name) {
		this.Brname = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNoOfFaculty() {
		return noOfFaculty;
	}

	public void setNoOfFaculty(int noOfFaculty) {
		this.noOfFaculty = noOfFaculty;
	}

}
