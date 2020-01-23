package com.learning.Questions.StringProblem;

import org.testng.annotations.Test;

public class StringSum {


    public static int calculateSum(String pattern){


        int sum =0;
        for(int i=0;i<pattern.length();i++){

            int number = (int)pattern.charAt(i);
            if(number>48 && number<58) {
                sum = sum + Integer.parseInt(pattern.substring(i,i+1));
            }
        }


        return sum;

    }

    @Test
    public void sum(){

        System.out.print(calculateSum("1234567654fgujhdvjs432ebjfdbsh32"));
    }

}
