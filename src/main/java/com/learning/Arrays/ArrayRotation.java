package com.learning.Arrays;

public class ArrayRotation {

    protected static int[] array = {2,1,4,3,6,7,3};


    public static int[] rotateArray(){

        int arr[] = new int[array.length];
        for(int i=0;i<array.length;i++){
         arr[i]=array[array.length-i-1];
        }
        return arr;
    }

    public static void main(String[] args){

        int[] array = rotateArray();

        for(int array1:array){
            System.out.print(array1+" ");
        }

    }


}
