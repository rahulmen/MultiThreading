package com.learning.Java8NewFeature.LambdaExpression.Lambda1;

public class TestWithoutFunctionInterface {

    public static void main(String... args){

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.print("New Thread Started");
            }
        }).start();
    }
}
