/*
 * This class demonstrate example of JDBC Prepared Statement
 *
 * Prepared statement need to be used only when we have to same query with same parameter multiple times.
 * Performance of Prepared statement is higher than normal Statement because in Prepared Statement query will be
 * compiled at the time of con.prepareStatement(selectSql) creating Prepare Statement and executed many times using
 * dymanic query.
 *
 * Advantage of Prepared Statement is it is SQL Injection attach proof where as we can have SQL injection attach in
 * prepared Statement.
 *
 */

package com.learning.JDBC;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrepareStatementExample1 {

    private static String url = "jdbc:mysql://11.161.25.61/integrationtest_0";
    private static String username = "idev";
    private static String password="Root1234";
    private static List<String> business_tag = new ArrayList<String>();
    private static String selectSql = "select order_id from databank where business_tag = ? LIMIT 1";
    private static String updateSql = "update databank set status = ? where row_key = ? LIMIT 1";


     @BeforeTest
     public static void loadBusinessTag(){
        business_tag.addAll(new ArrayList<>(Arrays.asList(
         "SPLITMAIN_AMOUNT_100_3SPLIT_T1",
         "SPLITMAIN_AMOUNT_100_3SPLIT_T1_DECIMAL",
         "SPLITMAIN_AMOUNT_100_3SPLIT_T1_FIRST_ORDER",
         "SPLITMAIN_AMOUNT_100_3SPLIT_T2",
         "SPLITMAIN_AMOUNT_100_3SPLIT_T21",
         "SPLITMAIN_AMOUNT_100_3SPLIT_T3",
         "SPLITMAIN_AMOUNT_100_3SPLIT_TN",
         "SPLITMAIN_AMOUNT_100_CREATEORDER_3SPLIT_T1")));
            }

    @Test
    public static void select(){

        try(Connection con = DriverManager.getConnection(url,username,password)){
            try(PreparedStatement s = con.prepareStatement(selectSql)){
                for(int i=0;i<business_tag.size();i++){
                    s.setString(1,business_tag.get(i));
                    ResultSet rs = s.executeQuery();
                    while(rs.next()){
                        System.out.print(business_tag.get(i)+" || "+rs.getString(1));
                        System.out.println();
                    }
                }
            }
        }catch(SQLException nsee){
            System.out.print(nsee.getCause());
            System.out.print(nsee.getMessage());
            nsee.printStackTrace();
        }

    }

    @Test
    public static void update(Object queryParameter1,Object queryParameter2){

         try(Connection con = DriverManager.getConnection(url,username,password)){
             try(PreparedStatement preparedStatement = con.prepareStatement(updateSql)){
                preparedStatement.setString(1,queryParameter1.toString());
                preparedStatement.setInt(2,(int)queryParameter2);
                preparedStatement.executeUpdate();
             }
         }catch(SQLException nsee){
             System.out.println (nsee.getCause());
             System.out.println(nsee.getMessage());
             nsee.printStackTrace();
         }
    }

    @DataProvider(name ="UpdateValue")
    public static Object[][] updateCount(){
         Object[][] obj = new Object[2][2];
         return obj;
    }
}
