/*
* 1. Batch Update help us to execute multiple query of a same batch on a single go hence improving performance of a system.
* 2. Without Batch Update using simple Statement total execution time to execute 1000 query

 1000*requestTime(1ms)+1000*responseTime(1ms)+1000*compileTime+1000*executeTime= 4000 ms

* 2. With Batch Update using simple Statement total execution time to execute 1000 query

 1*requestTime(1ms)+1*responseTime(1ms)+1000*compileTime+1000*executeTime= 2002 ms

* 2. Without Batch Update using simple PreparedStatement total execution time to execute 1000 query

 1000*requestTime(1ms)+1000*responseTime(1ms)+1*compileTime+1000*executeTime= 3000 ms

* 2. With Batch Update using simple PreparedStatement total execution time to execute 1000 query

 1*requestTime(1ms)+1*responseTime(1ms)+1*compileTime+1000*executeTime= 1003 ms
 */

package com.learning.JDBC;

import java.sql.*;

public class StatementBatchUpdate {


    private static String url = "jdbc:mysql://11.161.25.61/integrationtest_0";
    private static String username = "idev";
    private static String password="Root1234";

    private static String sqlQuery1 = "delete from databank where row_key = '162';";
    private static String sqlQuery2 = "delete from databank where row_key = '439';";
    private static String sqlQuery3 = "delete from databank where row_key = '93930';";

    public static void main(String... args){

        try(Connection con = DriverManager.getConnection(url,username,password)){
            try(Statement s = con.createStatement()){
                s.addBatch(sqlQuery1);
                s.addBatch(sqlQuery2);
                s.addBatch(sqlQuery3);
                int count = 0;
                int[] updateCount = s.executeBatch();
                for(int updateCountimp:updateCount){
                    count +=updateCountimp;
                }
                System.out.println("Number of Rows Deleted : "+count);
            }

        }catch(BatchUpdateException nsee){
            nsee.printStackTrace();
        }
        catch(SQLException nsee){
            nsee.printStackTrace();
        }
    }

    
}
