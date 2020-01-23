package com.learning.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Type4DriverDemo1 {
	
	static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://11.161.25.61:3306";
	
	static final String USER = "idev";
	static final String PASS = "Root1234";
	
	public static void main(String[] argss) throws Exception{


		try {
			Connection con = DriverManager.getConnection(DB_URL,USER,PASS);

			//sun.jdbc.odbc.JdbcOdbcConnection com1 = (sun.jdbc.odbc.JdbcOdbcConnection)DriverManager.getConnection("jdbc:odbc:demodsn1", "demo", "demo1");

			if(con!=null) {
				System.out.println("Connection Establish");
			}else {
				System.out.println("Connection not establish");
			}
			System.out.println(con.getClass().getName());

		}catch(SQLException nsee) {
			nsee.printStackTrace();
		}

	}}
