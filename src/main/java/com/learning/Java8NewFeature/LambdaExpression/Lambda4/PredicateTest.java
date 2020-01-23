package com.learning.Java8NewFeature.LambdaExpression.Lambda4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {


    public static void main(String... args){

       List<String> names = new ArrayList<String>(Arrays.asList("test","Geek","GoodGeek","DemoGeek"));


       Predicate<String> predicate = (s) -> s.startsWith("t");

       for(String name:names){
           if(predicate.test(name)){
               System.out.println(name);
           }
       }

    }

}
