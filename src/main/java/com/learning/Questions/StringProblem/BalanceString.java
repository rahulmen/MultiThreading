package com.learning.Questions.StringProblem;

public class BalanceString {


    public int balancedStringSplit(String s) {

        int rCount=0;
        int lCount=0;
        int count = 0;
        int max=0;
        for(int i=0;i<s.length();i++){
            count = (s.charAt(i)=='R')?rCount++:lCount++;
            if(rCount==lCount){
                max++;
                rCount=0;
                lCount=0;
            }
        }

        return max;
    }



    public static void main(String[] args) {

        System.out.print(new BalanceString().balancedStringSplit("RLRRRLLRLL"));

    }

}
