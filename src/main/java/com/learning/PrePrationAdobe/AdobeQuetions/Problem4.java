package com.learning.PrePrationAdobe.AdobeQuetions;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {


    public static void main(String... args){

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int[] arr = {2,3,4,1,9};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int i=0,j=arr.length-1;

        while(i<j){

           if(arr[i]+arr[j]==num){
               System.out.println(arr[i]+" "+arr[j]);
               break;
           }else if(arr[i]+arr[j]<num){
               i++;
           }else{
               j--;
           }

        }














    }




}
