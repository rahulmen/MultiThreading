package com.learning.Questions.StringProblem;
import java.io.*;

public class AnaGramsProblem {

    // Complete the makeAnagram function below.
        public static int numberNeeded(String first, String second) {

            int[] alphabets = new int[26];

            for(char ch : first.toCharArray()){
                alphabets[ch-'a']++;
            }
            for(char ch:second.toCharArray()){
                alphabets[ch-'a']--;
            }

            int deleteCount=0;
            for(int aplhabet:alphabets){
                deleteCount+=Math.abs(aplhabet);
            }

            return deleteCount;

        }



    public static void main(String[] args) throws IOException {

        //String a = scanner.nextLine();

        //String b = scanner.nextLine();

        int res = numberNeeded("abc", "wak");
        System.out.println(res);

    }
}

