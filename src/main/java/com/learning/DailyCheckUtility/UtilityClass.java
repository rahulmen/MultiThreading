/*
package com.learning.DailyCheckUtility;

import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class UtilityClass {

    public static final Logger logger;
    static List<File> propertiesFilePath = getProjectPropertiesFileAbsolutePath();

    static{
        logger = LoggerFactory.getLogger(UtilityClass.class);
    }

    */
/*
     * method to convert complete merchant map(shade base) to map excluding merchant used in automation suite.
     * @complete
     *//*


      class MapCustomisation<merchantIgnoreMap,merchantIncludeMap>{

        private Map<String,List<String>> merchantIgnoreMap ;
        private Map<String,List<String>> merchantIncludeMap ;

        public MapCustomisation(Map merchantIgnoreMap,Map merchantIncludeMap){
            this.merchantIgnoreMap=merchantIgnoreMap;
            this.merchantIncludeMap=merchantIncludeMap;
        }

        public Map<String, List<String>> getMerchantIgnoreMap() {
            return merchantIgnoreMap;
        }

        public Map<String, List<String>> getMerchantIncludeMap() {
            return merchantIncludeMap;
        }

    }


    protected MapCustomisation find(Map<String,List<String>> merchantIds) {
        Map<String,List<String>> merchantIgnoreMap = new HashMap<String,List<String>>();
        Map<String,List<String>> merchantIncludeMap = new HashMap<String,List<String>>();
        Set<Map.Entry<String,List<String>>> merchantIgnoreSet = merchantIds.entrySet();
        Iterator<Map.Entry<String,List<String>>> iterator = merchantIgnoreSet.iterator();

        while(iterator.hasNext()){
            List<String> merchantIgnoreList = new ArrayList<String>();
            List<String> merchantIncludeList = new ArrayList<String>();
            Map.Entry<String,List<String>> entry = iterator.next();
            String shadingBit = entry.getKey();
            List<String> list = entry.getValue();
            logger.info("Triggering Project properties search Operation on ShadingBit:" + shadingBit);
            Iterator<String> iterator1 = list.iterator();
            while(iterator1.hasNext()){
                String merchantId = iterator1.next();
                if(findMerchant(merchantId)){
                    merchantIgnoreList.add(merchantId);
                }else{
                    merchantIncludeList.add(merchantId);
                }
            }
            merchantIgnoreMap.put(shadingBit,merchantIgnoreList);
            merchantIncludeMap.put(shadingBit,merchantIncludeList);
        }
        MapCustomisation mapCustomisation = new MapCustomisation(merchantIgnoreMap,merchantIncludeMap);
        return mapCustomisation;
    }


    */
/*
        *Method to compare two Map and return common values
     *//*


    public Map<String,List<String>> commonMerchant(Map<String,List<String>> currentDay,Map<String,List<String>> previousDay){
        Map<String,List<String>> common = new HashMap<String,List<String>>();

        Set<Map.Entry<String,List<String>>> currentDaySet = currentDay.entrySet();
        Iterator<Map.Entry<String,List<String>>> iterator = currentDaySet.iterator();

        Set<Map.Entry<String,List<String>>> previousDaySet = previousDay.entrySet();
        Iterator<Map.Entry<String,List<String>>> iterator1 = previousDaySet.iterator();
        while(iterator1.hasNext()){
            List<String> currentDayList = new ArrayList<String>();
            List<String> previousDayList = new ArrayList<String>();

            Map.Entry<String,List<String>> currententry = iterator.next();
            Map.Entry<String,List<String>> previousentry = iterator1.next();
            String shadingBit = currententry.getKey();
            String shadingBit1 = previousentry.getKey();
            List<String> list = currententry.getValue();
            List<String> list1 = previousentry.getValue();
            list1.retainAll(list);
            common.put(shadingBit,list1);
            }
        return common;
        }



    */
/*
     *  object level method to find merchants used in automation.
     * @Completed
     *//*


    protected boolean findMerchant(String merchantId) {

        boolean result = false;
        BufferedReader bufferedReader = null;
        FileReader fileReader=null;

        Iterator<File> itr = propertiesFilePath.iterator();

        while(itr.hasNext()){
            try {
                try {
                    fileReader = new FileReader(itr.next());
                    bufferedReader = new BufferedReader(fileReader);
                    String line = bufferedReader.readLine();
                    while(line!=null) {
                        if (line.contains(merchantId)) {
                            result = true;
                            break;
                        }else{
                            line=bufferedReader.readLine();
                        }
                    }
                } finally {
                    bufferedReader.close();
                }
            }catch(IOException nsee){
                logger.error(nsee.getCause());
                logger.error(nsee.getMessage());
            }
        }
        return result;
    }


    */
/*
     * Get three length Sharding Bits as per the sharding bit passed
     *//*


    public String getShardingBit(String shardingBit) {
        String baseBits = "0";
        if (shardingBit.length() == 1) {
            baseBits = baseBits + "0" + shardingBit;
        } else {
            baseBits = baseBits + shardingBit;
        }
        return baseBits;
    }


    */
/*
     *  class level method to return all properties files present in resource
     * @incomplete
     *//*


    public static List<File> getProjectPropertiesFileAbsolutePath(){
        String currentDirectory = System.getProperty("user.dir")+"/src/test/resources";
        File file = new File(currentDirectory);
        List<File> directories = new ArrayList<>();
        directories.add(file);

        List<File> propertiesFile = new ArrayList<>();

        List<String> filterWildcards = new ArrayList<>();
        filterWildcards.add("*.properties");

        FileFilter typeFilter = new WildcardFileFilter(filterWildcards);

        while (directories.isEmpty() == false){
            {
                List<File> subDirectories = new ArrayList();

                for(File f : directories)
                {
                    subDirectories.addAll(Arrays.asList(f.listFiles((FileFilter) DirectoryFileFilter.INSTANCE)));
                    propertiesFile.addAll(Arrays.asList(f.listFiles(typeFilter)));
                }
                directories.clear();
                directories.addAll(subDirectories);
            }
        }
        return propertiesFile;

    }

    */
/*
    *Return Date as per minusDays
    *//*


    public static String getDate(int minusDays){
        LocalDate date = LocalDate.now();
        date=date.minusDays(minusDays);
        String[] date1 = date.toString().split("-");
        String date2="";
        for(String actualDate:date1){
            date2=date2+actualDate;
        }
        return date2;
    }

    */
/*
     * Get merchant ShadingBit
     *//*


    public static String getMerchantShadingBit(String merchantId){
        String shadingBit = "0";
        int merchantSize = merchantId.length();
        String[] shadingBitArray = merchantId.split("");
        shadingBit=shadingBit+shadingBitArray[merchantSize-3]+shadingBitArray[merchantSize-2];
        return shadingBit;
    }

}
*/
