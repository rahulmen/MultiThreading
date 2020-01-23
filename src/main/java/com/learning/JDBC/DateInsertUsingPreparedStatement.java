package com.learning.JDBC;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertUsingPreparedStatement {

    private static String url = "jdbc:mysql://127.0.0.1:3306/mysql";
    private static String username = "root";
    private static String password="root";
    private static String query = "insert into offerTemp (Empname,dop) VALUES (?,?)";

    public static void main(String[] args) {

        try(Connection con = DriverManager.getConnection(url,username,password)){
            try(PreparedStatement preparedStatement = con.prepareStatement(query)){
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter Employee Name : ");
                String empName = scan.next();
                System.out.print("Enter dop(yyyy-MM-dd) : ");
                String dop = scan.next();
                //Convert String into LocalDate
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = simpleDateFormat.parse(dop);
                long l = date.getTime();
                java.sql.Date date1 = new java.sql.Date(l);
                preparedStatement.setString(1,empName);
                preparedStatement.setDate(2,date1);
                preparedStatement.executeUpdate();
            }


        }catch(SQLException nsee){
            System.out.print(nsee.getCause());
            System.out.print(nsee.getMessage());
            nsee.printStackTrace();
        }catch(Exception nsee){
            nsee.printStackTrace();
        }





    }



}
