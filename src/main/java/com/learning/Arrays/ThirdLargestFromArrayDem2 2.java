package com.learning.Arrays;

public class ThirdLargestFromArrayDem2 {


    public static int thirdLargest(int[] arr){

        int first = arr[0];
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){

            if(arr[i]>first){
                third=second;
                second=first;
                first = arr[i];

            }else if(arr[i]>second){
               third=second;
               second=arr[i];

            }else if(arr[i]>third){
                third=arr[i];
            }

        }

        return third;
    }


    public static void main(String[] args){

        int[] arr = {34,12,67,45,45,98,78,99,654,89,89};

        //Simple Way is to iterate complete array three times and find the nth maximum every time so in third iteration we will get
        //third highest number

        System.out.print("Third Largest : "+thirdLargest(arr));




    }

}
