package com.learning.Questions.StringProblem;



import org.testng.annotations.Test;

public class StringPatternCount {


    public String getPattern(String pattern){
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<pattern.length();i++){

            int count =1;
            char c = pattern.charAt(i);
            while(i<pattern.length()-1 && c==pattern.charAt(i+1)){
                count++;
                i++;
            }
            stringBuilder.append(c).append(count);

        }

        return stringBuilder.toString();
    }



    @Test
    public void printPattern(){

        System.out.print(new StringPatternCount().getPattern("AAABBBDDDGHWWWSSSKKKJJJz"));



    }




}
