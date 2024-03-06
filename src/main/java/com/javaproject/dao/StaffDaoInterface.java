package com.javaproject.dao;

public interface StaffDaoInterface {

	//AdminFunctionalities
	public void displayAllStaffDetails();
	public void displayStaffDetailsHandlingSameSubject(int subjectId);
	public void displayAllDepartmentDetails();
	public void displayStaffInSameDepartment(int departmentId);
	public void addNewStaffDetails(int staffId, String staffName, String staffEmail, String staffPhoneNumber, String staffGender, int roleId, int departmentId);
	public void addNewDepartment(int departmentId, String departmentName);
	public void updateDepartmentDetails(String oldDepartmentName, String newDepartmentName);
	public void updateSubjectDetails(String oldSubjectName, String newSubjectName);
	public void deleteStaffDetails(int staffId);

	//StaffFunctionalities
	public void viewOwnDetails(int staffId);
	public void viewAssignedSubjects(int staffId) ;
	public void viewAssignedDepartments(int departmentId) ;
	public void updateOwnDetails(int staffId, String newEmail, String newPhoneNumber);
	public void updateOwnSubjectDetails(String oldSubjectName, String newSubjectName);
	public void updateSalaryDetails(int staffId, double newSalary);
	
	//common
	public void exitApplication();
	
}
