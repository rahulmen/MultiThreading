package com.learning.PrePrationAdobe.AdobeQuetions;

/*
Check number is odd or even without using modulas
 */

import java.util.Scanner;

public class Problem1 {


    public static void main(String... args){

        Scanner scan = new Scanner(System.in);
        long num = scan.nextLong();

        long newNum= (num/2)*2;

        if(num==newNum){
            System.out.println("Even Number");
        }else{
            System.out.println("Odd Number");
        }



    }


}
