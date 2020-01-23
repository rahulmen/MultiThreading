package com.learning.JavaReflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PrintMethodNameOfPassedClassUsingReflection {

    public static void main(String[] args){

        Method[] methods = Integer.class.getDeclaredMethods();

        for(Method method:methods){
            System.out.println(method.getName());
        }

        Class myclass = Integer.class;
        Field[] fields = myclass.getDeclaredFields();





















    }


}
