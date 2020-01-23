package com.learning.Java8NewFeature.LambdaExpression.Lambda2;

public class MathOperationTest {

    public static void main(String... args) {


        MathOperation sum = (a,b) -> a+b;
        System.out.print(sum.add(3,6));
    }
}
