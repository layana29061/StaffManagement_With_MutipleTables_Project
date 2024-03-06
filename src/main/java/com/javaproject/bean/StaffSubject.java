package com.javaproject.bean;

public class StaffSubject {
	private int staffId;
	private int subjectId;
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
	@Override
	public String toString() {
		return "StaffSubject [staffId=" + staffId + ", subjectId=" + subjectId + "]";
	}
	
	
}
