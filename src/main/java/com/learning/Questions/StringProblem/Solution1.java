package com.learning.Questions.StringProblem;

import java.io.*;
import java.util.*;

public class Solution1 {

   /* // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        //Sort the socks as per the color using Insertion Sort

        for (int i = 1; i < n; i++) {

            int value = ar[i];
            int j = i - 1;

            while (j >= 0 && ar[j] > value) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = value;
        }


        int pair = 0;
        for (int j = 0; j < ar.length-1;) {
            if(ar[j]==ar[j+1]){
                pair++;
                j+=2;
            }else{
                j+=1;
            }
        }

        return pair;

    }
*/


     // Complete the sockMerchant function below.
     static int sockMerchant(int n, int[] ar) {

         HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

         for(Integer i : ar){

             if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
             }else{
                 map.put(i,1);
             }
         }

         System.out.println(map);

         Set set = map.entrySet();
         Iterator<Map.Entry<Integer,Integer>> itr = set.iterator();

         int pair = 0;

         while(itr.hasNext()){

             Map.Entry<Integer,Integer> mp = itr.next();
             pair = pair + mp.getValue()/2;
         }

         return pair;
     }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        /*int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }*/

        int n =10;
        int[] ar = {1,1,3,1,2,1,3,3,3,3};

        System.out.println(sockMerchant(n, ar));
       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/

     //  System.out.print(result);
    }
}

