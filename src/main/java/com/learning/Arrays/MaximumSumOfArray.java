package com.learning.Arrays;

public class MaximumSumOfArray {

    int[] arr = {3,2,5,9,4};

    //4 3 2 5 9

    public  int maxSumOfArray(int[] arr,int index){

        int sum=0;
        if(index>arr.length-1){
            throw new RuntimeException("Array Index Out of Bound Exception");
        }

        int[] newArray = new int[this.arr.length]; //declated array os same size

        for(int i=index;i<newArray.length;i++){
            newArray[i-index]=arr[i];
        }

        for(int i=0;i<index;i++){
            newArray[newArray.length-index+i]=arr[i];
        }


        for(int i=0;i<newArray.length;i++){
            sum = sum + (newArray[i]*i);
        }

        return sum;

    }


    public static void main(String[] args){


        MaximumSumOfArray maximumSumOfArray = new MaximumSumOfArray();

        int max=0;
        for(int i = 0;i<maximumSumOfArray.arr.length;i++) {
            int sum = maximumSumOfArray.maxSumOfArray(maximumSumOfArray.arr,i);
            if(sum>max){
                System.out.print(i);
                max = sum;
            }
        }
        System.out.print("Maximum of an Array is :"+max);


    }

}
