package com.learning.Algorithms.Practice;


import java.util.Scanner;

public class InsertionSort {

//      Sample Input
 //     7 4 7 3 9 6 5


    //Ascending Order
    private static int[] insertionSort1(int[] arr){

        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            for(int j=0;j<i;j++){
                if(arr[j]>num){
                    //swap postion of i and j
                    int temp = arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
            }
        return arr;
        }


    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Size of an Array : ");
        int SizeOfArray = scan.nextInt();
        int[] arr = new int[SizeOfArray];
        System.out.print("Enter elements in an Array : ");

        for(int i=0;i<arr.length;i++){
            arr[i]=scan.nextInt();
        }

        int [] sortedArray = insertionSort1(arr);

        for(int sortedArray1:sortedArray){
            System.out.print(sortedArray1+" ");
        }




    }

}
