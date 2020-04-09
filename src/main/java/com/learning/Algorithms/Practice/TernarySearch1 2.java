package com.learning.Algorithms.Practice;

import org.testng.annotations.Test;

public class TernarySearch1 {

    static int[] arr = new int[]{12, 15, 17, 21, 23, 26, 32, 37, 43, 47, 54, 59, 65, 68, 77, 79, 89, 90, 95, 99};

    /*
     *Binary Search Method to return index of any array
     */

    public static int getIndexUsingBinarySearch(int minIndex, int maxIndex, int find) {

        while (maxIndex >= 0) {
            int midIndex = (maxIndex + minIndex) / 2;

            if (find > arr[midIndex]) {
                return getIndexUsingBinarySearch(midIndex + 1, maxIndex, find);
            } else if (find < arr[midIndex]) {
                return getIndexUsingBinarySearch(0, midIndex - 1, find);
            } else {
                return midIndex;
            }
        }
        return -1;
    }

    public static int getIndexUsingTernarySearch(int minIndex, int maxIndex, int find) {

        if (maxIndex >= 0) {

            int midIndex1 = minIndex + (maxIndex-minIndex) / 3;
            int midIndex2 = maxIndex - (maxIndex-minIndex) / 3;

            if (find == arr[midIndex1]) {
                return midIndex1;
            }
            if (find == arr[midIndex2]) {
                return midIndex2;
            }
            if (find < arr[midIndex1]) {
                return getIndexUsingTernarySearch(0, midIndex1 - 1, find);
            } else if (find > arr[midIndex2]) {
                return getIndexUsingTernarySearch(midIndex2 + 1, maxIndex, find);
            } else {
                return getIndexUsingTernarySearch(minIndex + 1, maxIndex - 1, find);
            }

        }


        return -1;
    }


    @Test
    public void getindex() {


            System.out.println("Index fetch using Binary Search : "+getIndexUsingBinarySearch(0, arr.length - 1, 59));
            System.out.println("Index fetch using Ternary Search : "+ getIndexUsingTernarySearch(0, arr.length - 1, 59));



    }

}
