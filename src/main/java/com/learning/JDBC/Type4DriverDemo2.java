package com.learning.JDBC;

import java.sql.*;

public class Type4DriverDemo2 {

	static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://11.161.25.61:3306/integrationtest_0";

	static final String USER = "idev";
	static final String PASS = "Root1234";

	final static String query = "select merchant_id,order_id,product_code,pay_amount,fee_amount,tax_amount,status," +
			"business_tag from databank where business_tag = 'SPLITSUB_PERCENTAGE_100_3SPLIT_T1' LIMIT 1;";

	public static void main(String[] argss) throws Exception{


		try(Connection con = DriverManager.getConnection(DB_URL,USER,PASS)) {
			if(con==null) {
				System.out.println("Connection not Establish");
			}else {
				Statement s = con.createStatement();
				boolean b = s.execute(query);


				if(b==true){
					ResultSet rs = s.executeQuery(query);
					while(rs.next()){
						System.out.println(rs.getString(1)+"-----"+rs.getString(2)+
								"-----"+rs.getString(3)+"-----"+rs.getString(4)+"-----"+rs.getString(5)
								+"-----"+rs.getString(6)+"-----"+rs.getString(7)+"-----"+rs.getString(8));
				}
				}
				else if (b==false){
					int rowEffected = s.executeUpdate(query);
				}
			}

		}catch(SQLException nsee) {
			nsee.printStackTrace();
		}
		catch(Exception nsee){
			nsee.printStackTrace();
		}

	}}
