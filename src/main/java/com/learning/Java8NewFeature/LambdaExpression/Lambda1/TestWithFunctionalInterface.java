package com.learning.Java8NewFeature.LambdaExpression.Lambda1;

public class TestWithFunctionalInterface {

    public static void main(String... args){

        new Thread(() -> {System.out.print("New Thread Started");}).start();

    }

}
