package com.learning.PrePrationAdobe.AdobeQuetions;

import java.util.*;

public class Problem5 {



    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int[] arr = {2,3,4,1,9};

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){

            int temp = num-arr[i];

            if(set.contains(temp)){
                System.out.println(arr[i]+" "+temp);
            }
            set.add(arr[i]);
        }

    }





}
