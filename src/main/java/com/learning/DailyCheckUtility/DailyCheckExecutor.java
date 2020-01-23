/*
package com.learning.DailyCheckUtility;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DailyCheckExecutor extends DailyCheckImpl{

    public static final Logger logger;

    static{
        logger = LoggerFactory.getLogger(DailyCheckImpl.class);
    }

    public DailyCheckExecutor(){
        super();
    }

    private static Properties properties = DailyCheckImpl.getProperties();

    private static String dbName = properties.getProperty("dbName");

    @Test
    public void updateOldMerchant() {

        //Object of Utility and this
        UtilityClass utilityClass = new UtilityClass();
        DailyCheckExecutor dailyCheckExecutor = new DailyCheckExecutor();

       for(int shardingBit=0;shardingBit<100;shardingBit+=10) {

           //Map to set merchantList and MerchantIgnoreList as per shading Bits
           Map<String,List<String>> merchantIgnoreMap = new HashMap<String,List<String>>();
           Map<String,List<String>> mainMerchantMap = new HashMap<String,List<String>>();
           String shardingDbName = null;

           //List containing all merchants as shade (Complete)
           Map<String,List<String>> shadingMerchantMap=null;

           //Get sharding bit like 000 to 099 (complete)
           String shardingBits = utilityClass.getShardingBit(String.valueOf(shardingBit)); //complete

           //Sub-library OB1.0 has ten libraries (complete)
           String library = shardingBits.substring(1, 2) + 0; //complete

           //paytm_asc (settlement), paytm_aqc (acquisition)
           shardingDbName = dbName + library;

           //Get Total merchant present whose last bill date is greater than 20 days into Map (complete)
           shadingMerchantMap = dailyCheckExecutor.getShardingMerchants(shardingBits, shardingDbName); //Incomplete

           //Check if that merchant is used in automation suite or not if yes put that into ignore list
           UtilityClass.MapCustomisation mapCustomisation=utilityClass.find(shadingMerchantMap);
           Map<String, List<String>> merchantsIgnored = mapCustomisation.getMerchantIgnoreMap();
           Map<String,List<String>> merchantInclude = mapCustomisation.getMerchantIncludeMap();

           merchantIgnoreMap.putAll(merchantsIgnored);
           mainMerchantMap.putAll(merchantInclude);

           //Call Batch Update using mainMerchantMap
           dailyCheckExecutor.executeBatch(mainMerchantMap,shardingDbName);

       }
    }


       }





*/
