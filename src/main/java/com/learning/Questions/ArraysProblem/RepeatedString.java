package com.learning.Questions.ArraysProblem;

import java.io.*;
import java.util.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        char[] str = s.toCharArray();

        String temp = "";

        int i=0;
        long count=0;

        while(i<str.length){
            if(str[i]=='a'){
                count++;
            }
            i++;
        }

        long occurance = n/str.length;
        long remainder = n%str.length;
        count = count*occurance;

        i=0;
        while(i<remainder){
            if(str[i]=='a'){
                count++;
            }
            i++;
        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = "abc";
        long n = 10;

        long result = repeatedString(s, n);

        System.out.println(result);


    }
}
