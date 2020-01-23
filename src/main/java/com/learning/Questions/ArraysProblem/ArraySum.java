package com.learning.Questions.ArraysProblem;

import java.util.Arrays;

public class ArraySum {


/*    public int[] plusOne(int[] digits) {

        double sum = 0;
        for(int i=0;i<digits.length;i++) {
            if (i < digits.length - 1) {
                sum = sum + digits[i];
                sum = sum * 10;
            } else {
                sum = sum + digits[i];
            }
        }

        double finalval = sum+1;

        String value = String.valueOf(finalval);

        int[] finalarr = new int[value.length()];

        for(int i=0;i<value.length();i++){
            int begin = i;
            int end = i+1;
            finalarr[i]= Integer.parseInt(value.substring(begin,end));
        }

        return finalarr;
    }*/


    public int[] plusOne(int[] digits) {


        int count = digits.length - 1;

        while (count >= 0) {
            if (digits[count] == 9) {
                if(count==0 && digits[count]==9){
                    digits[count]=0;
                    int[] arr = new int[digits.length+1];
                    for(int i=0;i<arr.length;i++){
                        if(i==0){
                            arr[i]=1;
                        }else{
                            arr[i]=digits[i-1];
                        }
                    }
                    digits=arr;
                    break;
                }
                digits[count] = 0;
                count--;
            } else {
                digits[count] = digits[count] + 1;
                break;
            }
        }
        return digits;
    }



    public static void main(String[] args){

        int[] arr = {9};


        System.out.print(Arrays.toString( new ArraySum().plusOne(arr)));

    }
}
