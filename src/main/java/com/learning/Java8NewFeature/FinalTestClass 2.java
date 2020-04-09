package com.learning.Java8NewFeature;

final class FinalTestClass {

     FinalTestClass(){
        System.out.print("This is a no arg constructor");
    }

    FinalTestClass(String name){
        System.out.print("This is a one arg constructor");
    }


    public static void main(){

         FinalTestClass testClass = new FinalTestClass();

    }



}
