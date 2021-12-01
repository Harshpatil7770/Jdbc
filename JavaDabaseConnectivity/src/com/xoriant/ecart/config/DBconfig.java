package com.xoriant.ecart.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconfig {

	 static Connection conn=null;
	
	public static  Connection getConnection() {
		if(conn==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/amzoncart", "root", "root");
				/*
				 * System.out.
				 * println("========================= Connection Created Succesfully =========================="
				 * );
				 */
			}catch(Exception e) {
				System.out.println("=================Issue present at the time of Connectivity==============");
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		getConnection();
	}
}
