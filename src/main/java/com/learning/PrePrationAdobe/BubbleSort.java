package com.learning.PrePrationAdobe;

import java.util.Arrays;

public class BubbleSort {


    public static void main(String... args){

        int[] arr = {5,1,4,2,8};

       for(int i=0;i<arr.length-1;i++){

           boolean flag = false;

           for(int j=0;j<arr.length-i-1;j++){

               if(arr[j]>arr[j+1]){
                   int temp = arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
                   if(flag==false) {
                       flag = true;
                   }
               }

           }

           if(flag==false){
               break;
           }else{
               continue;
           }





        }

        System.out.println(Arrays.toString(arr));


    }

}
