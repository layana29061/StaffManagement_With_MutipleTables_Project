
package com.javaproject.service;

import java.util.Scanner;

import com.javaproject.dao.StaffDaoImplementation;
import com.javaproject.dao.StaffDaoInterface;

public class StaffAccess {
	public void performStaffTask() throws Exception {
		Scanner in =  new Scanner(System.in);
		Scanner str = new Scanner(System.in);
		
		System.out.println("Welcome to Staff Management Application......!!!");
		System.out.println("------------------------------------------------");
		
		do {
			System.out.println("Enter the number from the following for performing the operation.");
			System.out.println("1.View own details ");
			System.out.println("2.View Assigned subjects.");
			System.out.println("3.View Assigned department");
			System.out.println("4.Update your Email");
			System.out.println("5.Update your Phone number");
			System.out.println("6.Exit");

			System.out.println();
			System.out.println("Enter your choice: ");
			int choice =in.nextInt();
			StaffDaoInterface dao = new StaffDaoImplementation();
			int id;
			switch(choice) {
			
			case 1: 
				System.out.println("Displaying the staff details");
				System.out.println("-----------------------------");
				System.out.println("Enter your id: ");
				id = in.nextInt();
                dao.viewOwnDetails(id);
				break;
				
			case 2:
				System.out.println("Displaying Assigned Subjects");
				System.out.println("-----------------------------");
				System.out.println("Enter your id: ");
				id = in.nextInt();
                dao.viewAssignedSubjects(id);
				break;
				
			case 3:
				System.out.println("Displaying Assigned Departments");
				System.out.println("-----------------------------");
				System.out.println("Enter your Staff id: ");
				id  = in.nextInt();
                dao.viewAssignedDepartments(id);
				break;
				
			case 4:
				System.out.println("Updating Your  Email");
				System.out.println("---------------------");
				System.out.println("Enter your staff id: ");
				id = in.nextInt();
				System.out.println("Enter your new email address: ");
				String email =str.nextLine();
                dao.updateOwnEmailDetails(id,email);
				break;
			
			case 5:
				System.out.println("Updating Your Phone number");
				System.out.println("---------------------");
				System.out.println("Enter your staff id: ");
				id = in.nextInt();
				System.out.println("Enter your new phone number: ");
				String phn =str.nextLine();
                dao.updateOwnPhoneDetails(id,phn);
				break;
				
			case 6:
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
