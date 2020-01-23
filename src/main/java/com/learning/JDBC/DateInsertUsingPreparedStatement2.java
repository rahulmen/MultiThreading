package com.learning.JDBC;

import java.sql.*;
import java.util.Scanner;

public class DateInsertUsingPreparedStatement2 {

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
                java.sql.Date date = Date.valueOf(dop);
                preparedStatement.setString(1,empName);
                preparedStatement.setDate(2,date);
                int insertCount = preparedStatement.executeUpdate();

                if(insertCount>0){
                    System.out.print("Row Inserted");
                }else{
                    System.out.print("Row Not Inserted");
                }

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
