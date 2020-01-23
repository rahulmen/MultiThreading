package com.learning.PrePrationAdobe.AdobeQuetions;


/*
Sort an array who has only 0,1,2
 */

import java.util.Arrays;

public class Problem11 {


    public static void sortArray(int[] arr){

        int l=0;int h=arr.length-1;
        int m=0;

        while(m<=h){

            if(arr[m]==1){
                m++;
            }else if (arr[m]==0){
                int temp = arr[l];
                arr[l]=arr[m];
                arr[m]=temp;
                l++;
                m++;
            }else{
                int temp = arr[h];
                arr[h]=arr[m];
                arr[m]=temp;
                h--;
            }

        }

    }

    public static void main(String... args){

        int[] arr = {0,1,2,0,1,2};

        sortArray(arr);

        System.out.println(Arrays.toString(arr));

    }

}
