/*
package com.learning.DailyCheckUtility;

import com.integration.core.base.IntegrationBaseTest;
import com.integration.core.template.GlobalService;
import com.integration.service.settlement.db.Ob10AddDbCheck;
import com.integration.test.action.context.TestContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static com.integration.core.dbcheck.utils.Ob10Util.InitializeConnection;
import static com.integration.core.dbcheck.utils.Ob10Util.obGroupDataSourceMap;

public abstract class DailyCheckImpl extends IntegrationBaseTest implements Executor{

    @Autowired
    private Ob10AddDbCheck ob10AddDbCheck;

    private UtilityClass utilityClass = new UtilityClass();

    DailyCheckImpl(){
        super();
    }

    private static Properties properties;
    private static FileInputStream fileInputStream;
    public static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(DailyCheckImpl.class);
        try {
            properties = new Properties();
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/integration/testcase/baseline_pg/basicability/merchantSettle/DailyCheckUtility/dbconfig.properties");
            properties.load(fileInputStream);
        }catch(FileNotFoundException nsee){
            logger.error(nsee.getCause());
            logger.error(nsee.getMessage());
        }catch(IOException nsee){
            logger.error(nsee.getCause());
            logger.error(nsee.getMessage());
        }

    }

    //Write dynamic query which can take different merchants from List
    private static String batchUpdateQuery = properties.getProperty("batchUpdateQuery");
    private static String merchantShadQuery = properties.getProperty("merchantShadQuery");
    private static String checkCurrentEnv = properties.getProperty("checkCurrentEnv");

     public static Properties getProperties(){
        return DailyCheckImpl.properties;
     }

    @Override
    public void executor(String var1) {

    }

    */
/*
     *Get total number of merchants in that Sharding Bit passed
     *//*

    protected Map<String,List<String>> getShardingMerchants(String shardingBits,String shardingDBName) {
        */
/*
         * Code to get shading merchant and return list
         *//*

        Map<String,List<String>> merchantList = executeQuery(shardingBits,shardingDBName);
        return merchantList;
    }


    */
/*
    * Establish Connection to OB
     *//*

    @Override
    public Connection getConnection(String dbName) {
        Connection connection = null;
        logger.info("dbName : " + dbName);
        initDataSource(dbName);
        try{
          connection = InitializeConnection(dbName);
        }catch(SQLException nsee){
         logger.error("Something wrong about OB1.0 connection:" + nsee.getMessage(), nsee);
        }
        return connection;
    }

    */
/*
     * Will Perform Query on passing shading Bit
     *//*


    @Override
    public Map<String,List<String>> executeQuery(String shardingBits,String shardingDBName) {
        logger.info("sql : "+merchantShadQuery);
        String property=properties.getProperty("dayCount");
        int compareDays=Integer.parseInt(property.split(";")[0]);
        Map<String,List<String>> previousDayMerchant = null;
        Map<String,List<String>> ignoreMerchantMap = new HashMap<String,List<String>>();

        try {
            try (Connection connection = getConnection(shardingDBName)) {
                try (Statement statement = connection.createStatement()) {
                    statement.setQueryTimeout(30);
                    for(int shardingBit=0;shardingBit<=9;shardingBit++){
                        shardingBits = shardingBits.substring(0,2)+shardingBit;
                        String query1 = String.format(checkCurrentEnv,properties.getProperty("updateShadQuery")+shardingBits);
                        ResultSet resultSet1= statement.executeQuery(query1);
                        List<String> ignoreMerchants = new ArrayList<String>();
                        while(resultSet1.next()){
                            ignoreMerchants.add(resultSet1.getString("merchant_id"));
                        }
                        ignoreMerchantMap.put(shardingBits,ignoreMerchants);
                    }
                    l1:
                    for(int daycount=0;daycount<compareDays;daycount++){
                        String date =UtilityClass.getDate(daycount);
                        Map<String,List<String>> currMerchantsmap = new HashMap<String,List<String>>();
                        l2:
                        for(int shardingBit=0;shardingBit<=9;shardingBit++){
                            shardingBits = shardingBits.substring(0,2)+shardingBit;
                            String query = String.format(merchantShadQuery,properties.getProperty("selectShadQuery")+shardingBits,date+"%");
                            ResultSet resultSet= statement.executeQuery(query);
                            List<String> merchants = new ArrayList<String>();
                            while(resultSet.next()){
                                merchants.add(resultSet.getString("m_id"));
                            }
                            merchants.removeAll(ignoreMerchantMap.get(shardingBits));
                            currMerchantsmap.put(shardingBits,merchants);
                        }
                        if(daycount==0) {
                            logger.info("Triggering retain Operation on days : "+ date);
                            previousDayMerchant = currMerchantsmap;
                            continue l1;
                        }else{
                            logger.info("Triggering retain Operation on days : "+ date);
                            previousDayMerchant=utilityClass.commonMerchant(currMerchantsmap,previousDayMerchant);
                        }
                    }
                }
            }
        } catch (SQLException nsee) {
            logger.error("Something wrong about OB1.0 operation:" + nsee.getMessage(), nsee);
        }
        return previousDayMerchant;
    }

    */
/*
     * Will Perform Batch Update on passed merchant List
     *//*


    @Override
    public int[] executeBatch(Map<String,List<String>> merchantMap,String shardingDBName) {
        logger.info("sql : "+batchUpdateQuery);
        int[] result =null;
        try{
            try(Connection connection = getConnection(shardingDBName)){
                try (Statement statement = connection.createStatement()) {
                    statement.setQueryTimeout(30);

                        Set merchantSet = merchantMap.entrySet();
                        Iterator<Map.Entry<String,List<String>>> iterator = merchantSet.iterator();
                        while(iterator.hasNext()){

                            Map.Entry<String,List<String>> entry = iterator.next();
                            String shadingBit = entry.getKey();
                            List<String> merchantList = entry.getValue();
                            Iterator<String> iterator1 = merchantList.iterator();

                            while(iterator1.hasNext()){
                                    String merchantId = iterator1.next();
                                    String merchantShadingBits= utilityClass.getMerchantShadingBit(merchantId);
                                    String query = String.format(batchUpdateQuery,properties.getProperty("update" +
                                            "ShadQuery")+merchantShadingBits,merchantId);
                                    statement.addBatch(query);
                            }
                            logger.info("Merchants added for Batch Update shadingBit :" + shadingBit);
                        }

                    result = statement.executeBatch();
                    int count =0;
                    for(int totalCount:result){
                        count+=totalCount;
                    }
                    logger.info("Total merchants Contracts Updated in " + shardingDBName +": "+ count);
                    logger.info("Merchants Updated in shardingDBName :" + shardingDBName);

                }
            }
        }catch(SQLException nsee){
            logger.error("Something wrong about OB1.0 operation:" + nsee.getMessage(), nsee);
        }
        return result;

    }

    */
/**
     * Initialize the OB10 data source
     *
     * @param dbName
     *//*

    private static void initDataSource(String dbName) {

        try {
            if (!obGroupDataSourceMap.containsKey(dbName)) {
                ObGroupDataSource obGroupDataSource = null;
                String url = TestContextHolder.getDbConfig().getProperty("ob10_" + dbName + "_url");

                String username = TestContextHolder.getDbConfig().getProperty("ob10_" + dbName + "_fullname");
                String password = TestContextHolder.getDbConfig().getProperty("ob10_" + dbName + "_password");
                if (StringUtil.isNotEmpty(url) && StringUtil.isNotEmpty(username) && StringUtil.isNotEmpty(password)) {
                    obGroupDataSource = new ObGroupDataSource();
                    obGroupDataSource.setParamURL(url);
                    obGroupDataSource.setFullUsername(username);
                    obGroupDataSource.setEncryptedPassword(password);
                    obGroupDataSource.init();
                } else {
                    logger.error("Failed to get db info from db config, please take a check");
                    GlobalService.appendNewLine("Failed to get db info from db config, please take a check");
                }
                obGroupDataSourceMap.put(dbName, obGroupDataSource);
                logger.info("put datasource object:" + dbName + " into datasource pool!");
                GlobalService.appendNewLine("put datasource object:" + dbName + " into datasource pool!");
            }


        } catch (SQLException e) {
            logger.error("Failed to Initialize OB10 data source:" + e.getMessage());
            GlobalService.appendNewLine("Failed to Initialize OB10 data source:" + e.getMessage());
        }

    }
}*/
