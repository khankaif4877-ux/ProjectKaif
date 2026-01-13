package com.Akshay.testYantra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	public Statement state = null;
	public Connection con = null;
 public void getDataFromDatabase() {
	 try {
		 Driver d = new Driver();
		 DriverManager.registerDriver(d);
		 con = DriverManager.getConnection("Dburl,Dbusername,Dbpassword");
		 state = con.createStatement();
		 
		
	} catch (Exception e) {
		
	}
 }
 
 
}
