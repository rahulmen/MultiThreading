package com.learning.PrePrationAdobe.AdobeQuetions;

//Sort array with 0 1 and 2's

import org.testng.annotations.Test;

import java.util.Arrays;

public class Problem12 {

    private static int[] arr = {1,1,0,0,2,2,0,0,1,1,2};


    public void swap(int i1,int i2){
        int temp = arr[i1];
        arr[i1]=arr[i2];
        arr[i2]=temp;
    }

    public void sort(int[] arr){

        int l=0;
        int h=arr.length-1;
        int m =0;

        while(m<=h){

            if(arr[m]==1){
                m++;
            }else if(arr[m]==0){
                swap(l,m);
                l++;
                m++;
            }else{
                swap(m,h);
                h--;
            }

        }


    }

    @Test
    public void test1(){
        Problem12 problem12 = new Problem12();
        problem12.sort(problem12.arr);
        System.out.println(Arrays.toString(arr));
    }





}
