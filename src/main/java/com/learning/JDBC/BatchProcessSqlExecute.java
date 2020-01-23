package com.learning.JDBC;

import com.mysql.cj.log.LogFactory;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class BatchProcessSqlExecute {

    static Logger logger = Logger.getLogger(BatchProcessSqlExecute.class);

    private static String username = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/mysql";
    private static String mySqlClassName = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(""));
            Properties prop = new Properties();
            if (prop == null) {
                prop.load(fileInputStream);
            }
        }catch (FileNotFoundException nsee){
            nsee.printStackTrace();
        }catch(IOException nsee){
            nsee.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {

        Connection con = DriverManager.getConnection(url, username, password);
        if (con == null) {
            logger.error("Connection Not Establish!!");
        } else {
            logger.info("Connection Establish!!");
            System.out.println("Connection Establish");
        }
        return con;
    }


    public static ResultSet executeQuery(String sqlquery) throws SQLException {
        Connection con = BatchProcessSqlExecute.getConnection();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(sqlquery);
        return rs;
    }


    public static int executeUpdate(String sqlquery) throws SQLException {
        Connection con = BatchProcessSqlExecute.getConnection();
        Statement s = con.createStatement();
        int rowUpdatecnt = s.executeUpdate(sqlquery);
        return rowUpdatecnt;
    }


    public static boolean execute(String sqlquery) throws SQLException {
        Statement s = null;
        boolean queryType = false;
        Connection con = BatchProcessSqlExecute.getConnection();
        s = con.createStatement();
        queryType = s.execute(sqlquery);
        return queryType;
    }

    @Test
    public void queryUpdate(){

    }
}


