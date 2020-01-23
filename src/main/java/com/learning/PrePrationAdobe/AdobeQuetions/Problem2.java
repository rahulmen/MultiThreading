package com.learning.PrePrationAdobe.AdobeQuetions;

/*
Sort an Array with only 1's 2's and 0's
 */

import java.util.Arrays;

public class Problem2 {


    public static void main(String... args){

        int[] arr = {1,2,2,2,1,1,0,0,1,2,1,0,2,0,2,0};
        int count0=0,count1=0,count2=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count0++;
            }else if(arr[i]==1){
                count1++;
            }else{
                count2++;
            }
        }

       for(int i=0;i<arr.length;i++){

           if(i<count0){
               arr[i]=0;
               continue;
           }else if(i<count0+count1){
               arr[i]=1;
               continue;
           }else{
               arr[i]=2;
           }


       }


       System.out.println(Arrays.toString(arr));

    }

}
