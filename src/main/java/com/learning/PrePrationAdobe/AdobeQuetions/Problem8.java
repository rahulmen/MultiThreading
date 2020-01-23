package com.learning.PrePrationAdobe.AdobeQuetions;

//Print 1 to 100 without using loop

public class Problem8 {

    int num = 0;


    public void printNuber() {

        if (num < 100) {
            num++;
            System.out.println(num);
            printNuber();
        }
    }

        public static void main(String[] args){

            new Problem8().printNuber();

        }


    }




