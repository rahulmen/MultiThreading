package com.learning.Questions.StringProblem;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        char[] ch = s.toCharArray();

        int i=0;
        int delete =0;
        while(i<ch.length-1){
            if(ch[i]==ch[i+1]){
                delete++;
            }
            i++;
        }

        return delete;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


            int result = alternatingCharacters("ABABABAB");


    }
}
