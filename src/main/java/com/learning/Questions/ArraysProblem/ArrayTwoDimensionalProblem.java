package com.learning.Questions.ArraysProblem;

import java.io.*;
import java.util.*;

public class ArrayTwoDimensionalProblem {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int[][] arr1 = new int[arr.length-2][arr.length-2];


                int i=0;
                int max =Integer.MIN_VALUE;
                while(i<4){
                    int j=0;
                    while(j<4) {
                        arr1[i][j] = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] +
                                arr[i+2][j+1] + arr[i+2][j+2];
                        if(max<arr1[i][j] && max>0){
                            max = arr1[i][j];
                        }
                        j++;
                    }
                     i++;
                     j=0;

                    }

    return max;



    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6];

        int count =0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j]=count;
                count++;
            }
        }

        for(int[] arr1:arr){
            System.out.println();
            for(int arr2:arr1){
                System.out.print(arr2+" ");
            }
        }



        int result = hourglassSum(arr);


        System.out.println (result);


    }
}
