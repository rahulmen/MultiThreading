package com.learning.PrePrationAdobe.AdobeQuetions;

import java.util.Scanner;

public class Problem10 {

    public static void main(String... args){

        Scanner scan = new Scanner(System.in);
        long num = scan.nextInt();

       long by = num & 1;

       if(by==1){
           System.out.println("ODD");
       }else{
           System.out.println("EVEN");
       }
    }

}
