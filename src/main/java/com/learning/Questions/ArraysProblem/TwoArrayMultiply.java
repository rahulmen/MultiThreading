package com.learning.Questions.ArraysProblem;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Stack;

public class TwoArrayMultiply {


    public static int arraySum(Object[] obj1){

        System.out.print("Array Values :");
        int sum =0;
            for(Object obj3:obj1){
                System.out.print(obj3+" ");
                sum+=(Integer)obj3;
            }
            System.out.print("\n"+"Array Sum : ");
            return sum;

    }


    @Test(dataProvider = "multipleArray")
    public void ReverseStringTest(Object[] arrays){
        System.out.print((arraySum(arrays)));
    }


    @DataProvider(name = "multipleArray")
    public Object[][] provideData(){

        Object[][] obj = new Object[2][3];
        for(int i=0;i<obj.length;i++){
          for(int j=0;j<3;j++){
              obj[i][j]=i*j+j;
          }
        }
        return obj;
    }



}
