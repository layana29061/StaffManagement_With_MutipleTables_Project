package com.javaproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaproject.exception.StaffExceptions;
import com.javaproject.model.Department;
import com.javaproject.model.Staff;
import com.javaproject.util.DBConnection;



public class StaffDaoImplementation implements StaffDaoInterface {

	String query="";
	
	//------------------ADMIN---------------------------------
	
	
//	--------------------displayAllDetails-------------------------------------------------
	
	public void displayAllStaffDetails() throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
			query = "select * from staff";
			PreparedStatement pstm = con.prepareStatement(query);
	    	ResultSet rs = pstm.executeQuery();
	    	
	    	while(rs.next()) {
	    		System.out.println("ID: " + rs.getInt("staff_id"));
	    	    System.out.println("Name: " + rs.getString("staff_name"));
	    	    System.out.println("Email: " + rs.getString("staff_email"));
	    	    System.out.println("PhoneNumber: " + rs.getString("staff_phonenumber"));
	    	    System.out.println("Gender: " + rs.getString("staff_gender"));
	    	    System.out.println("RoleId: " + rs.getInt("role_id"));
	    	    System.out.println("DepartmentId: " + rs.getInt("department_id"));
	    	    System.out.println("SubjectId: " + rs.getInt("subject_id"));
	    	}
	    	System.out.println("Completed.....");
	    	System.out.println();
	    	con.close();
	  
		}catch(Exception e) {
				throw new StaffExceptions("Error fetching all staff details");
		}
	}
	
	
//	--------------------displayStaffHandlingSameSubject----------------------------------------------

	public void displayStaffDetailsHandlingSameSubject(int subjectId) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
		    query = " select * from staff join subject \r\n"
		    		+ " using(subject_id)\r\n"
		    		+ " where subject_id= ?;";

		    PreparedStatement pstm = con.prepareStatement(query);
		    pstm.setInt(1, subjectId);
		    ResultSet rs = pstm.executeQuery();

		    while(rs.next()) {
		    	System.out.println("SubjectId: " + rs.getInt("subject_id"));
		    	System.out.println("ID: " + rs.getInt("staff_id"));
		        System.out.println("Name: " + rs.getString("staff_name"));
		        System.out.println("Email: " + rs.getString("staff_email"));
		        System.out.println("PhoneNumber: " + rs.getString("staff_phonenumber"));
		        System.out.println("Gender: " + rs.getString("staff_gender"));
		        System.out.println("RoleId: " + rs.getInt("role_id"));
		        System.out.println("DepartmentId: " + rs.getInt("department_id"));
		        System.out.println("Subject Name: " + rs.getString("subject_name"));
		    }
		    System.out.println();
		    System.out.println("Completed.....");
		    System.out.println();
		    con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error fetching  staff details  hadling same subject");
		}	
	}
	
//	------------------------------display_all_department-------------------------------------

	public void displayAllDepartmentDetails() throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
		    query = "SELECT * FROM department";

		    PreparedStatement pstm = con.prepareStatement(query);
		    ResultSet rs = pstm.executeQuery();

		    while(rs.next()) {
		    	System.out.println("Department ID: " + rs.getInt("department_id"));
		        System.out.println("Department Name: " + rs.getString("department_name"));
		    }
		    System.out.println();
		    System.out.println("Completed.....");
		    System.out.println();
		    con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error fetching all department details");
		}
		
	}
	
//	------------------------------display_staff_in_same_department-------------------------------------

	public void displayStaffInSameDepartment(int departmentId) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
		    query = "select staff_id,staff_name,department_id from staff join department\r\n"
		    		+ "using(department_id)\r\n"
		    		+ "where department_id = ?;";

		    PreparedStatement pstm = con.prepareStatement(query);
		    pstm.setInt(1, departmentId);
		    ResultSet rs = pstm.executeQuery();

		    while(rs.next()) {
		    	System.out.println("Staff Id: " + rs.getInt("staff_id"));
		        System.out.println("Name: " + rs.getString("staff_name"));
		    	System.out.println("Department Id: " + rs.getInt("department_id"));
		        
		    }
		    System.out.println();
		    System.out.println("Completed.....");
		    System.out.println();
		    con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error fetching staff details in same department");
		}
		
	}
	
//	------------------------------ adding new staff details-------------------------------------

	public void addNewStaffDetails(Staff staff) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
			String query = "insert into staff values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstm =con.prepareStatement(query);
			pstm.setInt(1,staff.getStaffId());
			pstm.setString(2,staff.getStaffName());
			pstm.setString(3,staff.getStaffEmail());
			pstm.setString(4,staff.getPhoneNumber());
			pstm.setString(5,staff.getGender());
			pstm.setInt(6,staff.getRoleId());
			pstm.setInt(7,staff.getDepartmentId());
			pstm.setInt(8,staff.getSubjectId());
			
			
			int count =pstm.executeUpdate();
			//return type of excuteUpdate is integer
			if(count!=0) {
				System.out.println("Staff Inserted Successfully!!!");
				 System.out.println();
			}else {
				System.out.println("Error.....!!!!");
			}
			 con.close();

		}catch(Exception e) {
			throw new StaffExceptions("Error adding new staff details ");
		}
	}

	
//	------------------------------ adding new department details-------------------------------------

	public void addNewDepartment(Department department) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
			String query = "insert into department values(?,?)";
			
			PreparedStatement pstm =con.prepareStatement(query);
			pstm.setInt(1,department.getDepartment_id());
			pstm.setString(2,department.getDepartment_name());
			int count =pstm.executeUpdate();
			
			//return type of excuteUpdate is integer
			if(count!=0) {
				System.out.println("Department Inserted Successfully!!!");
				 System.out.println();
			}else {
				System.out.println("Error.....!!!!");
			}
			 con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error adding new department details ");
		}

	}
	
//---------------------------updateDepartment---------------------------------------------------------
	
	public void updateDepartmentDetails(int departmentId, String newDepartmentName) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
		    query = "update department set department_name = ? where department_id = ?";
		    PreparedStatement pstm = con.prepareStatement(query);
		    pstm.setString(1, newDepartmentName);
		    pstm.setInt(2, departmentId);
		    int rowsUpdated = pstm.executeUpdate();
		    if (rowsUpdated > 0) {
		        System.out.println("The department was updated successfully!");
		        System.out.println();
		    }else {
		    	System.out.println("Error..!");
		    	System.out.println();
		    }
		    con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error updating  department details ");
		}
	    
	}
	
//	------------------------------updateSubject--------------------------------------------------------
	
	public void updateSubjectDetails(int subjectid, String newSubjectName) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
		    query = "update subject set subject_name = ? where subject_id = ?";
		    PreparedStatement pstm = con.prepareStatement(query);
		    pstm.setString(1, newSubjectName);
		    pstm.setInt(2, subjectid );
		    int rowsUpdated = pstm.executeUpdate();
		    if (rowsUpdated > 0) {
		        System.out.println("The subject was updated successfully!");
		        System.out.println();
		    }else {
		    	System.out.println("Error..!");
		    	System.out.println();
		    }
		    con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error updating  subject details ");
		}
	    
	}
	
//	-------------------------------updateSalary------------------------------------------------------
	
	
	public void updateSalaryDetails(int staffId, double newSalary) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
		    query = "UPDATE roles SET staff_salary= ? \r\n"
		    		+ "WHERE role_id =(select role_id from staff where staff_id= ?);";
		    PreparedStatement pstm = con.prepareStatement(query);
		    pstm.setDouble(1, newSalary);
		    pstm.setInt(2, staffId);
		    int rowsUpdated = pstm.executeUpdate();
		    if (rowsUpdated > 0) {
		        System.out.println("The salary was updated successfully ........!!!!!!!");
		        System.out.println();
		    } else {
		        System.out.println("Error in updating salary ");
		        System.out.println();
		    }
		    con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error updating  salary details ");
		}
	    
	}


//	------------------------------deleteStaff------------------------------------------------------

	public void deleteStaffDetails(int staffId) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
		    query = "delete from staff where staff_id = ?";
		    PreparedStatement pstm = con.prepareStatement(query);
		    pstm.setInt(1, staffId);
		    int rowsDeleted = pstm.executeUpdate();
		    if (rowsDeleted > 0) {
		        System.out.println("The staff member was deleted successfully!");
		        System.out.println();
		    }else {
		    	System.out.println("Error..!");
		    	System.out.println();
		    }
		    con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error deleting  staff details ");
		}
	    
	}

	
//	--------------------------STAFF-----------------------------------------------------------------
//	================================================================================================
//	=================================================================================================

	
//	 -------------------------viewDetails-----------------------------------------------------
	
	public void viewOwnDetails(int staffId) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
		    query = "SELECT * FROM staff WHERE staff_id = ? ";

		    PreparedStatement pstm = con.prepareStatement(query);
		    pstm.setInt(1, staffId);
		    ResultSet rs = pstm.executeQuery();

		    if(rs.next()) {
		    	System.out.println("ID: " + rs.getInt("staff_id"));
		        System.out.println("Name: " + rs.getString("staff_name"));
		        System.out.println("Email: " + rs.getString("staff_email"));
		        System.out.println("PhoneNumber: " + rs.getString("staff_phonenumber"));
		        System.out.println("Gender: " + rs.getString("staff_gender"));
		        System.out.println("RoleId: " + rs.getInt("role_id"));
		        System.out.println("DepartmentId: " + rs.getInt("department_id"));
		        System.out.println("SubjectId: " + rs.getInt("subject_id"));
		    }
		    System.out.println();
		    System.out.println("Completed.....");
		    System.out.println();
		    con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error viewing  staff details ");
		}
	    

	}
	
//	-------------------------------viewSubjects------------------------------------------------

	public void viewAssignedSubjects(int staffId) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
			query ="select staff_id,staff_name,st.subject_id,subject_name\r\n"
						+ "from staff st join subject sub\r\n"
						+ "on st.subject_id=sub.subject_id\r\n"
						+ "where staff_id = " + staffId;
			
	   	 	PreparedStatement pstm = con.prepareStatement(query);
	    	ResultSet rs = pstm.executeQuery();
	    	if(rs.next()) {
	    		System.out.println("ID: " + rs.getInt("staff_id"));
	    	    System.out.println("Name: " + rs.getString("staff_name"));
	    	    System.out.println("SubjectId: " + rs.getInt("subject_id"));
	    	    System.out.println("SubjectName: " + rs.getString("subject_name"));
	    	}
	    	System.out.println();
	    	System.out.println("Completed.....");
	    	System.out.println();
	    	 con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error viewing  assigned subject details ");
		}
		
	}
	
//	-------------------------------viewDepartments------------------------------------------

	public void viewAssignedDepartments(int staffId) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
			query="select staff_id,staff_name,department_id,department_name\r\n"
					+ "from staff join department \r\n"
					+ "using(department_id)\r\n"
					+ "where staff_id= " +staffId;

	   	 	PreparedStatement pstm = con.prepareStatement(query);
	    	ResultSet rs = pstm.executeQuery();
	    	
	    	if(rs.next()) {
	    		System.out.println("ID: " + rs.getInt("staff_id"));
	    	    System.out.println("Name: " + rs.getString("staff_name"));
	    	    System.out.println("DepartmentId: " + rs.getString("department_id"));
	    	    System.out.println("DepartmentName: " + rs.getString("department_name"));
	    	}
	    	System.out.println();
	    	System.out.println("Completed.....");
	    	System.out.println();
	    	 con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error viewing  assigned department details ");
		}
		
	}

	
//	--------------------------------emailUpdate----------------------------------------

	public void updateOwnEmailDetails(int staffId, String newEmail) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
			query ="update staff set staff_email =? "
					+ "where staff_id= ? ";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1,newEmail);
			pstm.setInt(2,staffId);
	    	int rs = pstm.executeUpdate();
	    	if(rs>0) {
	    		System.out.println("Updated Email Successfully.....!!!!");
	    		System.out.println();
	    	}else {
	    		System.out.println("Error Occured!! !! !!");
	    		System.out.println();
	    	}
	    	 con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error in updating email details ");
		}

	}
	
//	------------------------------phoneNumber------------------------------------------
	

	public void updateOwnPhoneDetails(int staffId, String newPhoneNumber) throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
			query ="update staff set staff_phonenumber= ? "
					+ "where staff_id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1,newPhoneNumber);
			pstm.setInt(2, staffId);
	    	int rs = pstm.executeUpdate();
	    	if(rs>0) {
	    		System.out.println("Updated PhoneNumber Successfully.....!!!!");
	    		System.out.println();
	    	}else {
	    		System.out.println("Error Occured!! !! !!");
	    		System.out.println();
	    	}
	    	 con.close();
		}catch(Exception e) {
			throw new StaffExceptions("Error in updating phone details ");
		}
		
	}
	
	
//	-------------------------------exitApplication----------------------------------------------
	
	public void exitApplication() {
		System.out.println("Have a nice day.......!!!!!!!!");
		System.exit(0);
		
	}
	
//------------------------getting last_staff_id----------------------------------------------------
	
	
	public int getLastId() throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
		    String query = "SELECT staff_id FROM staff ORDER BY staff_id DESC LIMIT 1";

		    PreparedStatement pstm = con.prepareStatement(query);
		    ResultSet rs = pstm.executeQuery();

		    if(rs.next()) {
		        return rs.getInt("staff_id");
		    } else {
		        return 0; // Return 0 or any suitable value when there are no records in the table
		    }
		    
		}catch(Exception e) {
			throw new StaffExceptions("Error in getting last staff id ");
		}
	    
	}

//------------------------getting last_department_id----------------------------------------------------
	
	
	public int getLastDepartmentId() throws StaffExceptions {
		try {
			Connection con = DBConnection.createDBConnection();
		    String query = "SELECT department_id FROM department ORDER BY department_id DESC LIMIT 1";

		    PreparedStatement pstm = con.prepareStatement(query);
		    ResultSet rs = pstm.executeQuery();

		    if(rs.next()) {
		        return rs.getInt("department_id");
		    } else {
		        return 0; // Return 0 or any suitable value when there are no records in the table
		    }
		}catch(Exception e) {
			throw new StaffExceptions("Error in getting last department id ");
		}
	    
	}

}
