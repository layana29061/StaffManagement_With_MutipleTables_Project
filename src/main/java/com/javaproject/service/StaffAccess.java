package com.javaproject.service;

import java.util.Scanner;

public class StaffAccess {
	public void performStaffTask() {
		Scanner in =  new Scanner(System.in);
		Scanner str = new Scanner(System.in);
		do {
			System.out.println("Enter the number from the following for performing the operation.");
			System.out.println("1.View own details ");
			System.out.println("2.View Assigned subjects.");
			System.out.println("4.View Assigned department");
			System.out.println("3.Update email and phone number");
			System.out.println("4.Update Own subject details");
			System.out.println("5.Update Own salary details");
			System.out.println("6.Exit");
			
			int choice = in.nextInt();
			
		}while(true);
		
	}
}
