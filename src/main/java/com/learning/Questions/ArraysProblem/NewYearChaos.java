package com.learning.Questions.ArraysProblem;

import java.util.*;

public class NewYearChaos {

    static void minimumBribes(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        boolean SwappingNeeded = true;
        int swaps = 0;

        while (SwappingNeeded) {
            int i = 0;
            boolean swap = false;
            while (i < arr.length - 1) {
                if (arr[i + 1] < arr[i]) {
                    if (map.containsKey(arr[i])) {
                        map.put(arr[i], map.get(arr[i]) + 1);
                    } else {
                        map.put(arr[i], 1);
                    }
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    swap = true;
                    swaps++;
                }
                i++;

            }


            if (swap == true) {
                SwappingNeeded = true;
            } else {
                SwappingNeeded = false;
            }
        }

        Collection list = map.values();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() > 2) {
                System.out.print("Too chaotic");
                return;
            }

            System.out.println("Total Number of Swaps Performed : " + swaps);
            System.out.println(Arrays.toString(arr));

        }
    }

    public static void main(String... args) {


        int[] q = {2,5,1,3,4};

            minimumBribes(q);
        }

    }



    /*
    * Solution 1 :-
    *
    * int minBrines=0;

        for(int i=0;i<arr.length;i++){

            int swap =0;

            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                   swap++;
                if(swap>2)
                {
                System.out.println("Too chaotic");
                return;
                }
                }
            }

            minBrines=minBrines+swap;


        }
        System.out.println(minBrines);

     */

