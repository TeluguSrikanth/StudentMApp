package com.skv.www.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.skv.www.db.DBConnection;
import com.skv.www.model.Student;

public class StudentDao implements StudentDaoInterface{

	@Override
	public boolean insertStudent(Student s) {
		
		boolean flag=false;
		
		try {
			
			Connection con=DBConnection.createConnection();
			String query="insert into student_details(sname, clgname, city, percentage) values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, s.getName());
			pst.setString(2, s.getClgname());
			pst.setString(3, s.getCity());
			pst.setDouble(4, s.getPercentage());
			pst.executeUpdate();
			
			flag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return flag;
	}

	@Override
	public void showAllStudents() {
	
		try {
			
			Connection con=DBConnection.createConnection();
			String query="select * from student_details";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("Roll no :"+rs.getInt(1)+"\n"
						+ "Name : "+rs.getString(2)+"\n"
								+ "ClgName :"+rs.getString(3)+"\n"
										+ "City"+rs.getString(4)+"\n"
												+ "Percentage :" +rs.getDouble(5));
				
				System.out.println("_____________________________________");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean showStudentById(int roll) {
	
		boolean flag=false;
          try {
			
			Connection con=DBConnection.createConnection();
			String query="select * from student_details where rollnum="+roll;
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("Roll no :"+rs.getInt(1)+"\n"
						+ "Name : "+rs.getString(2)+"\n"
								+ "ClgName :"+rs.getString(3)+"\n"
										+ "City"+rs.getString(4)+"\n"
												+ "Percentage :" +rs.getDouble(5));
				
				
				flag=true;
				//System.out.println("_____________________________________");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean delete(int roll) {
		
		boolean flag=false;
		
		try {
			
			Connection con= DBConnection.createConnection();
			String query="delete from student_details where rollnum="+roll;
			PreparedStatement pst=con.prepareStatement(query);
			pst.executeUpdate();
			
			flag=true;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean update(int roll, String update, int ch, Student s) {
	
		int choice=ch;
		boolean flag=false;
		
		try {
			if(choice==1) {
			Connection con=DBConnection.createConnection();
			String query="update student_details set sname=? where rollnum=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, update);
			pst.setInt(2, roll);
			pst.executeUpdate();
			flag=true;
			}
			
			else if(choice==2) {
				Connection con=DBConnection.createConnection();
				String query="update student_details set clgname=? where rollnum=?";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, update);
				pst.setInt(2, roll);
				pst.executeUpdate();
				flag=true;
				}
			else {
				System.out.println("Wrong choice");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return flag;
	}

	
//		 int choice=ch;
//	        boolean flag=false;
//	        try{
//	            if(choice==1){
//	                Connection con=DBConnection.createConnection();
//	                String query="update student_details set sname=? where rollnum=?";
//	                PreparedStatement ps=con.prepareStatement(query);
//	                ps.setString(1,update);
//	                ps.setInt(2,roll);
//	                ps.executeUpdate();
//	                flag=true;
//
//	            }
//
//	        }catch (Exception ex){
//	            ex.printStackTrace();
//	        }
//	        return flag;
//		
//	}	
//	
}
