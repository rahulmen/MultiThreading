package com.learning.Questions.ArraysProblem;

import java.io.*;

public class JumpingCloudProblem {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jump=0;

        for(int i=0;i<=c.length-2;){

            if(i>=c.length-2){
                jump++;
                break;
            }

            if(c[i+1]==0){
                if(c[i+2]==0){
                    jump++;
                    i=i+2;
                    continue;
                }else{
                    jump++;
                    i=i+1;
                    continue;
                }

            }else if(c[i+1]==1){
                jump++;
                i=i+2;
                continue;
            }
        }

        return jump;

    }


    public static void main(String[] args) throws IOException {

        int[] arr = {0,0,0,1,0,0};

        int jump = jumpingOnClouds(arr);

        System.out.print(jump);

    }
}
