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

public class PreparedStatementBatchUpdate {

    private static String url = "jdbc:mysql://11.161.25.61/integrationtest_0";
    private static String username = "idev";
    private static String password="Root1234";

    private static String sqlQuery = "select row_key from databank where business_tag = \"MERCHANT_STATUS_NORMAL\" and status = \"INVALID\" LIMIT 3;\n";
    private static String sqlQuery2 = "delete from databank where row_key = ? and status = null";

    public static void main(String... args){

        try(Connection con = DriverManager.getConnection(url,username,password)){
            try(Statement s = con.createStatement()){
                ResultSet rs = s.executeQuery(sqlQuery);
                try(PreparedStatement rs2 = con.prepareStatement(sqlQuery2)){
                    while(rs.next()){
                        rs2.setInt(1,rs.getInt("row_key"));
                        rs2.addBatch(sqlQuery2);
                    }
                    int []deleteCount = rs2.executeBatch();
                    int actualDeleteCount =0;
                    for(int deleteCount1:deleteCount){
                        actualDeleteCount+=deleteCount1;
                    }
                    System.out.print("The Number of rows Deleted : "+actualDeleteCount);
                }
        }
    }catch(BatchUpdateException nsee){
            nsee.printStackTrace();
        }
        catch(SQLException nsee){
            nsee.printStackTrace();
        }


}

    
}
