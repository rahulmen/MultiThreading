package com.learning.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Type1DriverDemo1 {

	public static void main(String[] argss) throws Exception{

		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
		try {
			Connection con = DriverManager.getConnection("jdbc:odbc:demodsn1", "demo", "demo1");

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
