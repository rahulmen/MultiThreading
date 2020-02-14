package com.learning.JavaInnerClasses;

public class ClassA {

    interface inter1{
        int update();
    }

    class classinnerA implements inter1{

        @Override
        public int update() {
            return 10;
        }
    }

    public static void main(String... args){

        inter1 classinnerA = new ClassA().new classinnerA();
        System.out.println(classinnerA.update());

    }

}
