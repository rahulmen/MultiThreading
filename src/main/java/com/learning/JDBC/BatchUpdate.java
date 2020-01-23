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

* Batch Update concept applicable only for non-Select Query if we will select query in Batch Update then we will get
* java.sql.BatchUpdateException

 */

package com.learning.JDBC;

public class BatchUpdate {


}
