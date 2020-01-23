package com.learning.Questions.StringProblem;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Stack;

public class ReverseString {


    public static String reverse(String name){
        String[] names = name.split(" ");
        Stack<String> stack = new Stack<String>();
        for(String n:names){
            stack.push(n);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop()+" ");
        }
        return stringBuilder.toString();
    }


    @Test(dataProvider = "reverseStringData")
    public void ReverseStringTest(String name){
        System.out.println("Actual String is : "+name);
        System.out.println("Reverse String is : "+reverse(name));
        System.out.println("===================================");
    }


    @DataProvider(name = "reverseStringData")
    public Object[] provideData(){
        return new Object[]{"Demo Test Is","Name is Rahul"};
    }



}
