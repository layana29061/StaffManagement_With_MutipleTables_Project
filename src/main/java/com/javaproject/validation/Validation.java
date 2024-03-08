package com.javaproject.validation;


import java.util.Scanner;

import com.javaproject.exception.StaffExceptions;

public class Validation {
	public boolean isValidGender(String gender){
        if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
            return true;
        } else {
        	return false;
            //throw new StaffExceptions("Invalid gender entered");
        }
    }

    public boolean isValidMobileNumber(String mobileNumber){
        String regex = "^(0|91)?[6-9][0-9]{9}$";
        if(mobileNumber.matches(regex)) {
            return true;
        } else {
        	return false;
            //throw new StaffExceptions("Invalid mobile number entered");
        }
    }

    public boolean isValidName(String name){
        if(name.matches("^[A-Za-z\\s]{2,29}$")) {
            return true;
        } else {
        	return false;
            //throw new StaffExceptions("Invalid name entered");
        }
    }



    public boolean isValidEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if(email.matches(regex)) {
            return true;
        } else {
        	return false;
            //throw new StaffExceptions("Invalid email entered");
        }
    }

    public String askForCorrectGender(){
        Scanner sc = new Scanner(System.in);
        String gender;
        while(true) {
            System.out.println("Enter the correct gender(Male/Female)");
            gender = sc.nextLine();
            if(isValidGender(gender)) {
                break;
            }
        }
        sc.close();
        return gender;
    }

    public String askForCorrectName(){
        Scanner sc = new Scanner(System.in);
        String name;
        while(true) {
            System.out.println("Enter the correct name");
            name = sc.next();
            if(isValidName(name)) {
                break;
            }
        }
        sc.close();
        return name;
    }

    public String askForCorrectEmail(){
        Scanner sc = new Scanner(System.in);
        String email;
        while(true) {
            System.out.println("Enter the correct email");
            email = sc.nextLine();
            if(isValidEmail(email)) {
                break;
            }
        }
        sc.close();
        return email;
    }

    public String askForCorrectMobileNumber(){
		Scanner sc = new Scanner(System.in);
		String mobileNumber;
		while(true) {
			System.out.println("Invalid mobile number\nEnter the correct mobile number");
			mobileNumber = sc.nextLine();
			boolean isValidMobileNumber = isValidMobileNumber(mobileNumber);
			if(isValidMobileNumber) 
				break;
		}
		sc.close();
		return mobileNumber;
	}
}
