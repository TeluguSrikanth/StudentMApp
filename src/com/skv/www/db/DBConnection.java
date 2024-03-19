package com.skv.www.db;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {

	static Connection con;
	
	public static Connection createConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String user="root";
			String pass="root";
			String url="jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false";
			
			con=DriverManager.getConnection(url,user,pass);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return con;
		
	}
	
}
