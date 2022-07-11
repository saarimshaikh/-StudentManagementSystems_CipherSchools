package com.Dinesh.StudentManagementSystems.model;

import org.springframework.stereotype.Component;

@Component
public class StudentRecord {

	private int rollNo;
	private String name;
	private int contactNo;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	
	
}
