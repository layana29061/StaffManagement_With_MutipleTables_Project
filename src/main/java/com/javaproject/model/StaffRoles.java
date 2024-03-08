package com.javaproject.model;

public class StaffRoles {
	private int roleId;
	private String staffPosition;
	private int staffYearOfExperience;
	private Double salary;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getStaffPosition() {
		return staffPosition;
	}
	public void setStaffPosition(String staffPosition) {
		this.staffPosition = staffPosition;
	}
	public int getStaffYearOfExperience() {
		return staffYearOfExperience;
	}
	public void setStaffYearOfExperience(int staffYearOfExperience) {
		this.staffYearOfExperience = staffYearOfExperience;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "StaffRoles [roleId=" + roleId + ", staffPosition=" + staffPosition + ", staffYearOfExperience="
				+ staffYearOfExperience + ", salary=" + salary + "]";
	}	
	
	
	
}
