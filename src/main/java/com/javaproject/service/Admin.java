package com.javaproject.service;

import java.util.Scanner;


import com.javaproject.dao.StaffDaoImplementation;
import com.javaproject.dao.StaffDaoInterface;
import com.javaproject.exception.StaffExceptions;
import com.javaproject.model.Department;
import com.javaproject.model.Staff;
import com.javaproject.validation.Validation;

public class Admin {
	
	public void performAdminTask() throws Exception  {
		Scanner in =  new Scanner(System.in);
		Scanner str = new Scanner(System.in);
		System.out.println("Welcome to Staff Management Application......!!!");
		System.out.println("------------------------------------------------");
		do {
			System.out.println("No. of operation can be performed: ");
			System.out.println("1.Display all staff details");
			System.out.println("2.Display the staff details handling same subject.");
			System.out.println("3.Display all department details");
			System.out.println("4.Display the staff name working in same departments");
			System.out.println("5.Adding a new staff details");
			System.out.println("6.Adding a new department");
			System.out.println("7.Update department details");
			System.out.println("8.Update subject details");
			System.out.println("9.Update Salary details");
			System.out.println("10.Delete the staff details");
			System.out.println("11.Exit");
			
			System.out.println();
			System.out.println("Enter your choice: ");
			int choice =in.nextInt();
			
			StaffDaoInterface dao = new StaffDaoImplementation();
			StaffDaoImplementation sd = new StaffDaoImplementation();
			Validation validation =new Validation();
			
			int id;
			int subjectid;
			switch(choice) {
				case 1: 
					System.out.println("Displaying all staff details");
					System.out.println("----------------------------");
					dao.displayAllStaffDetails();
					break;
					
				case 2:
					System.out.println("Displaying the staff details handling same subject");
					System.out.println("--------------------------------------------------");
					System.out.println("Enter the subject id");
					subjectid=in.nextInt();
					dao.displayStaffDetailsHandlingSameSubject(subjectid);
					break;
					
				case 3:
					System.out.println("Displaying the all department details");
					System.out.println("-----------------------------------------");
					dao.displayAllDepartmentDetails();
					break;
					
				case 4:
					System.out.println("Displaying the staff name working in same departments");
					System.out.println("-----------------------------------------");			
					id=in.nextInt();
					dao.displayStaffInSameDepartment(id);
					break;
					
				case 5:
					Staff staff = new Staff();

					System.out.println("The last entered staff ID is: " + sd.getLastId());
					
					System.out.println("Enter the staff id: ");
                    int staffid = in.nextInt();
                    
                    System.out.println("Enter the staff name: ");
                    String name = str.nextLine();
                    if(!validation.isValidName(name)) {
            			name = validation.askForCorrectName();
            		}
                    
                    System.out.println("Enter the email: ");
                    String mail = str.nextLine();
                    if(!validation.isValidEmail(mail)) {
            			name = validation.askForCorrectEmail();
            		}
                    
                    System.out.println("Enter the pnno: ");
                    String phone = str.nextLine();
                    if(!validation.isValidMobileNumber(phone)) {
            			name = validation.askForCorrectMobileNumber();
            		}
                    
                    System.out.println("Enter the gender: ");
                    String gender = str.nextLine();
                    if(!validation.isValidGender(phone)) {
            			name = validation.askForCorrectGender();
            		}
                    
                    System.out.println("Enter the role id: ");
                    int roleid = in.nextInt();
 
                    System.out.println("Enter the department id: ");
                    int deptid = in.nextInt();
 
                    System.out.println("Enter the subject id: ");
                    int subid= in.nextInt();

                    
                    staff.setStaffId(staffid);
                    staff.setStaffName(name);
                    staff.setStaffEmail(mail);
                    staff.setPhoneNumber(phone);
                    staff.setGender(gender);
                    staff.setRoleId(roleid);
                    staff.setDepartmentId(deptid);
                    staff.setSubjectId(subid);
                  
					dao.addNewStaffDetails(staff);
					break;
					
				case 6:
					Department department = new Department();
					
					System.out.println("The last entered ID is: " + sd.getLastDepartmentId());
					
					System.out.println("Enter the department id: ");
                    int depid = in.nextInt();
 
                    System.out.println("Enter the department name: ");
                    String deptname = str.nextLine();
                    
                    department.setDepartment_id(depid);
                    department.setDepartment_name(deptname);
                    
                    dao.addNewDepartment(department);
					break;
					
				case 7 :
				    System.out.println("Displaying the updated department details:");
				    System.out.println("-----------------------------------------");
				    System.out.println("Enter the department id to be modified:");
				    id = in.nextInt();
				    System.out.println("Enter the new department name:");
				    String dept_name = str.nextLine();
				    dao.updateDepartmentDetails(id, dept_name);
				    break;
				    
				case 8:
				    System.out.println("Updating the subject details:");
				    System.out.println("-----------------------------------------");
				    System.out.println("Enter the subject id to be modified");
				    int subject_id = in.nextInt();
				    System.out.println("Enter the new subject name");
				    String newSubjectName = str.nextLine();
				    dao.updateSubjectDetails(subject_id, newSubjectName);
				    break;
				
				case 9:
				    System.out.println("Updating the salary details");
				    System.out.println("------------------------------");
				    System.out.println("Enter the staff_id");
				    id = in.nextInt();
				    System.out.println("Enter the new salary:");
				    double newSalary = in.nextDouble();
				    dao.updateSalaryDetails(id, newSalary);
				    break;    
				    
				case 10:
				    System.out.println("Deleting the staff details");
				    System.out.println("-----------------------------");
				    System.out.println("Enter the staff_id to be deleted");
				    id = in.nextInt();
				    dao.deleteStaffDetails(id);
				    break;
				    
				case 11:
					System.out.println("Thank You For Using Our Application....!!!");
					System.out.println("---------------------");
					dao.exitApplication();
					
				default:
					System.out.println("Enter valid choice....!");
					break;
			}
			
		}while(true);
		
	}
}
