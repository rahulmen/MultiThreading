package com.learning.Questions.SortingProblem;

import java.io.*;
import java.util.*;

public class MaxNumberOfToys {


        // Complete the maximumToys function below.
        static int maximumToys(int[] prices, int k) {

            //Create dummy array and Take Array value whose value is less than K then take first t numbers whose sum <k

            List<Integer> newPrice = new ArrayList<Integer>();

            //Take only those values
            for(int i=0;i<prices.length;i++){
                if(prices[i]<=k){
                    newPrice.add(prices[i]);
                }
            }

            newPrice.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });

            int maxItem=0;
            for (int i=0;i<newPrice.size();i++){

                if(k-newPrice.get(i)>=0){
                    k-=newPrice.get(i);
                    maxItem++;
                }else{
                    continue;
                }
            }

            return maxItem;
                }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {

            int[] arr = {23,45,1,4,8,6,45,1000,234,2,6,56,75,342};

            int maxItem = maximumToys(arr, 100);

            System.out.println(maxItem);

        }
    }


