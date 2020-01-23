package com.learning.PrePrationAdobe.AdobeQuetions;

import java.util.Scanner;

public class Problem7 {

    public static void main(String... args){

        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();

        String s= "HOTSTAR";  //STARHOT

        int i=0;
        int count=0;
        int j=s1.length()-1;

        while(count<s1.length()){

            if(s1.length()!=s.length()){
                System.out.println("String are not of Same Size");
                break;
            }
            else if(s1==s){
                System.out.println("String Matched");
                break;
            }else{
                while(true){
                    char c1 = s.charAt(j);
                    char c2 = s.charAt(j-1);
                    c1=s.charAt(j-1);
                }
            }

        }


    }


}
