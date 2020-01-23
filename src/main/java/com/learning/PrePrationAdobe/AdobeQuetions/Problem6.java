package com.learning.PrePrationAdobe.AdobeQuetions;

import java.util.Scanner;

public class Problem6 {

    public static void main(String... args){

        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();

        String s= "HOTSTAR";

        String newString = s1.concat(s1);

        if(newString.contains(s)){
            System.out.print("TRUE");
        }else{
            System.out.print("FALSE");

        }


    }



}
