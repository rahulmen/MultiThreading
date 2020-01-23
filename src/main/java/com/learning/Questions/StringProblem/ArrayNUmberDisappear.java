/*
package com.learning.Questions.StringProblem;

import java.util.*;

public class ArrayNUmberDisappear {

    public List<Integer> findDisappearedNumbers(int[] nums) {


        List<Integer> list = new ArrayList<Integer>();

        if(nums.length==0){
            return list;
        }

        int[] arr = new int[nums.length];

        for(int i=1;i<nums.length;i++){

            if(nums[i]>0 && nums[i]<nums.length){
                arr[nums[i]]=1;
            }
        }
        for(int arr1:arr){
            if(arr1==0) {
                list.add(index);
                index++;
            }else{
                index++;
            }
        }

        return list;

    }


    public static void main(String... args){

        List<Integer> list = new ArrayNUmberDisappear().findDisappearedNumbers(new int[]{1,1});

        System.out.print(list);



    }
}
*/
