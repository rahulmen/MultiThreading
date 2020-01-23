package com.learning.DemoProgram;

public class Paramid2 {

    public static void print(int rows){

        for(int i=0;i<rows;i++){

            for(int j=0;j<=rows-i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<=i;k++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }

        for(int i=rows;i>=0;i--){

            for(int j=0;j<=rows-i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<=i;k++){
                System.out.print("*"+" ");
            }
            System.out.println();

        }

    }




    public static void main(String... args){

        int rows = 9;
        print(rows);

    }
}
