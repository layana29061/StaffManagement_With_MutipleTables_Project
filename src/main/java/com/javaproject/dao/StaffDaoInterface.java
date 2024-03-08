package com.javaproject.dao;

import com.javaproject.exception.StaffExceptions;
import com.javaproject.model.Department;
import com.javaproject.model.Staff;

public interface StaffDaoInterface {

	//AdminFunctionalities
	public void displayAllStaffDetails() throws StaffExceptions;
	public void displayStaffDetailsHandlingSameSubject(int subjectId) throws StaffExceptions;
	public void displayAllDepartmentDetails() throws StaffExceptions;
	public void displayStaffInSameDepartment(int departmentId) throws StaffExceptions;
	
	public void addNewStaffDetails(Staff staff) throws StaffExceptions;
	public void addNewDepartment(Department department) throws StaffExceptions;
	
	public void updateDepartmentDetails(int departmentId, String newDepartmentName) throws StaffExceptions;
	public void updateSubjectDetails(int subjectId, String newSubjectName) throws StaffExceptions;
	public void updateSalaryDetails(int staffId, double newSalary) throws StaffExceptions;
	
	public void deleteStaffDetails(int staffId) throws StaffExceptions;

	//StaffFunctionalities
	public void viewOwnDetails(int staffId) throws Exception;
	public void viewAssignedSubjects(int staffId) throws StaffExceptions ;
	public void viewAssignedDepartments(int staffId) throws StaffExceptions ;
	
	public void updateOwnEmailDetails(int staffId, String newEmail) throws StaffExceptions;
	public void updateOwnPhoneDetails(int staffId, String newPhoneNumber) throws StaffExceptions;
	
	//common
	public void exitApplication();
	
}
