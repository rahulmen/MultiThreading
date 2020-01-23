package com.learning.Questions.StringProblem;


import java.io.*;
import java.util.*;


public class StringProblem3 {



        // Complete the isValid function below.
        static String isValid(String s) {

            char[] ch = s.toCharArray();

            HashMap<Character,Integer> map = new HashMap<Character,Integer>();

            int i=0;
            while(i<ch.length){
                if(map.containsKey(ch[i])){
                    map.put(ch[i],map.get(ch[i])+1);
                }else{
                    map.put(ch[i],1);
                }
                i++;
            }

            Collection<Integer> collection =  map.values();
            ArrayList<Integer> values = new ArrayList<>(collection);
            int min=0;
            int max=0;
            int maxCount=0;
            int minCount=0;

            for(int a=0;a<values.size();a++){

                if(a==0){
                    min = values.get(a);max=values.get(a);
                    maxCount++;minCount++;
                    continue;
                }

                if(values.get(a)>max){
                    max=values.get(a);
                    maxCount=0;
                    maxCount++;
                }else if(values.get(a)==max){
                    maxCount++;
                }

                if(values.get(a)<min){
                    min = values.get(a);
                    minCount=0;
                    minCount++;
                }else if(values.get(a)==min){
                    minCount++;
                }
            }

            if(values.size()==1){
                return "YES";
            }
            if(maxCount==1 && (max-min==1||max-1==0) && maxCount+minCount==values.size()){
                return "YES";
            }if (minCount==1 && (max-min==1 || min-1==0) &&  maxCount+min==values.size()){
                return "YES";
            }else{
                return "NO";
            }
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {


            String result = isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd");
            System.out.println(result);


        }
    }


    /*
    for(int a=0;a<values.size();a++){
                if(a==0){
                    min=values.get(a);max=values.get(a);
                    maxCount++;minCount++;
                    continue;
                }
                if(values.get(a)>max){
                    max=values.get(a);
                    maxCount=0;
                    maxCount++;
                }else if(values.get(a)==max){
                    maxCount++;
                }
                if(values.get(a)<min){
                    min = values.get(a);
                    minCount=0;
                }else if(values.get(a)==min){
                    minCount++;

                }
            }

            if(max-min>1 && (maxCount>1&&minCount>1)){
                return "NO";
            }

            else{
                return "YES";
            }
     */
