package com.learning.DemoProgram;

/*
* program to print

  *
 */

public class Paramid1 {

   static int astricCount = 51;

    public static void main(String[] args){

        int initialValue = 1;
        int temp1 = astricCount;
        int temp2=astricCount;

        while(astricCount>=initialValue){
            for(int i=0;i<temp1-1;i++){
                System.out.print(" ");
            }
            for(int i=0;i<initialValue;i++){
                System.out.print("*"+" ");
            }
            System.out.println();
            temp1 = temp1-2;
            initialValue=initialValue+2;
        }

        while(astricCount>0){
            for(int i=0;i<astricCount;i++){
                System.out.print("*"+" ");
            }
            System.out.println();
            astricCount= astricCount-2;

            for(int i=0;i<temp2-astricCount;i++){
                System.out.print(" ");
            }
        }

    }


}
