package com.learning.Arrays;

public class ThirdLargestFromArray {


    public static void main(String[] args){

        int[] arr = {34,12,67,45,98,78,99,654,89};

        //Simple Way is to iterate complete array three times and find the nth maximum every time so in third iteration we will get
        //third highest number

        int max=arr[0];
        int secondMax = arr[0];
        int thirdMax = arr[0];
        for(int i=0;i<3;i++) {

            int maxIndex= i;
            for (int j = 0; j < arr.length-1; j++) {

                if(i==0) {
                    if (arr[j+1] > max) {
                        max = arr[j+1];
                    }
                }else if(i==1){
                    if(arr[j]>=secondMax && arr[j]<max){
                        secondMax= arr[j];
                    }
                }else{
                    if(arr[j]>=thirdMax && arr[j]<secondMax){
                        thirdMax=arr[j];
                    }
                }

            }
        }

        System.out.print(thirdMax);



    }

}
