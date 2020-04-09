package com.learning.JDBC;

import org.apache.log4j.Logger;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class SQLInjectionAttackStatement {

    static Logger logger = Logger.getLogger(BatchProcessSqlExecute.class);


    private static String url = "jdbc:mysql://11.161.25.61/integrationtest_0";
    private static String username = "idev";
    private static String password="Root1234";

    //private static String selectSql = "select order_id from databank where business_tag = ?";


    public static void main(String[] args){

        try(Connection con = DriverManager.getConnection(url,username,password)){
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the business_tag : ");
            String column = scan.next();
            try(Statement statement = con.createStatement()){
                String query = "select * from databank where business_tag ='"+column+"' LIMIT 1;";
                ResultSet rs = statement.executeQuery(query);
                int count =0;
                while(rs.next()){
                    count++;
                    break;
                }
                if(count>0){
                    System.out.print("SQL Injection Attack Acheived");
                }
                else{
                    System.out.print("SQL Injection Attack Not Acheived");
                }


            }
        }catch(SQLException nsee){
            System.out.print(nsee.getCause());
            System.out.print(nsee.getMessage());
            nsee.printStackTrace();
        }


    }

}
