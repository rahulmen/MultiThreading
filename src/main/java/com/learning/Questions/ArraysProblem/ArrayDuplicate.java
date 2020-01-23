package com.learning.Questions.ArraysProblem;

public class ArrayDuplicate {


        public static int removeDuplicates(int[] nums) {
            int count =0;
            int begin =0;

            for(int i=0;i<nums.length-1;i++){

                while(nums[i]==nums[i+1] && i<nums.length-2){
                    i++;
                }
                nums[begin]=nums[i];
                count++;
                begin++;

                if(i==nums.length-2 && nums[i+1]!=nums[i]){
                    nums[begin]=nums[i+1];
                    count++;
                }

            }
            return count;
        }

    public static void main(String[] args){

            int[] arr = {0,0,1,1,1,2,2,3,3,4};

            int num = removeDuplicates(arr);

            System.out.print(num);

    }

    }

