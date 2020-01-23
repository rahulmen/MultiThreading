package com.learning.DailyCheckUtility;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface Executor {

    void executor(String var1) ;

    Connection getConnection(String dbName);

    Map<String,List<String>> executeQuery(String shardingBits, String shardingDBName);

    int[] executeBatch(Map<String, List<String>> merchantList, String dbName);


}


