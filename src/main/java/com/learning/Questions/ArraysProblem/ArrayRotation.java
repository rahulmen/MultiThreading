package com.learning.Questions.ArraysProblem;

import java.io.*;
import java.util.*;

public class ArrayRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

        int[] temp = new int[a.length];
        int beginIndex = d;

        int i=0;
        while(beginIndex<a.length){
            temp[i]=a[beginIndex];
            beginIndex++;
            i++;
        }
        int j=0;
        while(j<d){
            temp[i]=a[j];
            i++;j++;
        }

        return temp;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

            int[] arr = {1,2,3,4,5,6,7,8,9};


        System.out.print(Arrays.toString(rotLeft(arr,5)));


    }
}
