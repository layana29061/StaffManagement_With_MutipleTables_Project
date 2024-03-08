package com.javaproject.presentation;

import java.util.Scanner;

import com.javaproject.service.Admin;
import com.javaproject.service.StaffAccess;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
       Scanner sc =new Scanner(System.in);
       
       System.out.println("Tell us your identity \n Staff or Admin : ");
       String identity = sc.next();
       
       if(identity.toLowerCase().equals("admin")) {
    	   Admin admin =new Admin();
    	   admin.performAdminTask();
       }else if(identity.toLowerCase().equals("staff")) {
    	   StaffAccess staffaccess= new StaffAccess();
    	   staffaccess.performStaffTask();
       }else {
    	   System.out.println("Invalid Input.....!!!");
       }
       sc.close();
    }
}
