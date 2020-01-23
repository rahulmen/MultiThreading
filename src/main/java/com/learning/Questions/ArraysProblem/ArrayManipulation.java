package com.learning.Questions.ArraysProblem;

import java.io.*;
import java.util.*;

public class ArrayManipulation {

        // Complete the arrayManipulation function below.
        static long arrayManipulation(int n, Integer[][] queries) {

            long[] array = new long[n+2];

            int length =0;
            int j=0;
            long max =0;
            while(length<queries.length){
                array[queries[length][j]]=array[queries[length][j]]+queries[length][j+2];
                array[queries[length][j+1]+1]=array[queries[length][j+1]+1]-queries[length][j+2];
                length++;
            }

            for(int i=1;i<array.length;i++){
                array[i]=array[i]+array[i-1];
                if(array[i]>max){
                    max=array[i];
                }
            }

            return max;



        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {

            Integer[][] queries = {{2,6,8},{3,5,7},{1,8,1},{5,9,15}};

            long result = arrayManipulation(10, queries);


            System.out.print(result);
            scanner.close();
        }
    }




    /*
    long[] array = new long[n];
            long max = 0;

            int i=0;
            while(i<queries.length){
                int j=0;
                int beginIndex = queries[i][j]-1;
                int endIndex = queries[i][j+1]-1;

                while(beginIndex<=endIndex){
                    array[beginIndex]=array[beginIndex]+queries[i][j+2];
                    if(array[beginIndex]>max){
                        max = array[beginIndex];
                    }
                    beginIndex++;
                }

                i++;
            }

            return max;
     */