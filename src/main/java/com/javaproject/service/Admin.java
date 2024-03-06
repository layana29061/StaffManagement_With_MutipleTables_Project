package com.javaproject.service;

import java.util.Scanner;

public class Admin {
	
	public void performAdminTask() {
		Scanner in =  new Scanner(System.in);
		Scanner str = new Scanner(System.in);
		do {
			System.out.println("Enter the number from the following for performing the operation.");
			System.out.println("1.Display all staff details");
			System.out.println("2.Display the staff details handling same subject.");
			System.out.println("3.Display all department details");
			System.out.println("4.Display the staff name working in same departments");
			System.out.println("5.Adding a new staff details");
			System.out.println("6.Adding a new department");
			System.out.println("7.Update department details");
			System.out.println("8.Update subject details");
			System.out.println("9.Delete the staff details");
			System.out.println("10.Exit");
			
			int choice = in.nextInt();
			
		}while(true);
		
	}
}
