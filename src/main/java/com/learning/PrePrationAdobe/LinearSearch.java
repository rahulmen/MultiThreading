package com.learning.PrePrationAdobe;

public class LinearSearch {


    public static void main(String... args){

        int[] arr = {679,4321,12543,6543,1,465432,1265432,114321};


        int max = arr[0];
        for(int i=1;i<arr.length;i++){

            if(arr[i]>max){
                max = arr[i];
            }
        }

        System.out.print(max);
    }


}
