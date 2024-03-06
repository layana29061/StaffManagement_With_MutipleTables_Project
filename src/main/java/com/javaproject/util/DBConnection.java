package com.javaproject.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
static Connection con;
	
	public static Connection createDBConnection() throws Exception{
		String url="jdbc:mysql://localhost:3306/sms";
		String username="root";
		String Password="root";
		con= DriverManager.getConnection(url,username,Password);
		//getConnection returning the connection
		return con;
	}
}
