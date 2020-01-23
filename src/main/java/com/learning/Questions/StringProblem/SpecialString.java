package com.learning.Questions.StringProblem;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

*/
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class SpecialString {

   /* public void getPalindrome(String name){


       Map<Character,Integer> map = new HashMap<Character,Integer>();

        int count=0;

        for(int i=0;i<name.length();i++){

        if(map.containsKey(name.charAt(i))){

            if(i>0 && name.charAt(i)==name.charAt(i-1)){
                count++;
            }
            map.put(name.charAt(i),map.get(name.charAt(i))+1);
           }else{
            map.put(name.charAt(i),1);
           }
       }

        System.out.println(map);
       System.out.println(map.size()+count);


    }*/


   public void gerSubString(String name){

       Set set = new HashSet();

       for(int i=0;i<name.length();i++){

          for(int j=i;j<name.length();j++){
                set.add(i);

                if(name.charAt(j)==name.charAt(j+1)){

                }



          }

       }


   }



    public static void main(String args[] ) throws Exception {


        new SpecialString().gerSubString("aaabbaa");


// a b c cc




        // Write your code here

    }
}
