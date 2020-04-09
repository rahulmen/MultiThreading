
package com.learning.Algorithms.Practice;

import java.util.Arrays;
import java.util.Scanner;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class Stack {
    public static void main(String args[]) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int arraySize = s.nextInt();                 // Reading input from STDIN
        // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        int[] arrayData = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            arrayData[i] = s.nextInt();
        }


        Arrays.sort(arrayData);

        StackArrayNew stackArray = new StackArrayNew(arraySize);


        for (int i = 0; i < arraySize; i++) {


            if (stackArray.isEmpty()) {
                stackArray.push(arrayData[i]);
            }

            else if (stackArray.getStackValue() < arrayData[i]) {

                stackArray.pop();
                stackArray.push(arrayData[i]);




            } else if (stackArray.getStackValue() == arrayData[i]) {

                if (stackArray.isContainLessValue(arrayData[i])) {
                     stackArray.pop();
                     stackArray.push(arrayData[i]);

                } else {
                    stackArray.push(arrayData[i]);
                }


            }

        }
        // Write your code here
        int count = 0;
        while (!stackArray.isEmpty()) {
            // System.out.println(stackArray.getStackValue());
            count += stackArray.getStackValue();
            stackArray.pop();
        }
        System.out.println(count);

    }


}


class StackArrayNew {

    private int maxSize;

    private static int[] stackArray;

    private int top;


    public StackArrayNew(int s) {

        maxSize = s;

        stackArray = new int[maxSize];

        top = -1;// No items in stack
    }

    public void push(int item) {
        stackArray[++top] = item; //Increment top and insert item
    }

    public long pop() {
        return stackArray[top--];
    }

    public boolean pop(int element) {

        for (int i = 0; i < stackArray.length; i++) {

            if (stackArray[i] == element) {
                for (int k = i; k < stackArray.length - 1; k++)
                    stackArray[k] = stackArray[k + 1];
                return true;
            }
        }
        return false;
    }


    public boolean isEmpty() {
        return (top == -1);
    }


    public int getStackValue() {
        return stackArray[top];
    }

    public boolean isFull() {

        return (top == maxSize - 1);
    }

    public boolean getElement(int element) {
        for (int i = 0; i < stackArray.length; i++) {
            if (stackArray[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int containLessValue(int element) {
        int nElem = stackArray.length;
        int value = -1;
        for (int i = 0; i < nElem; i++) {
            if (stackArray[i] < element && stackArray[i] != 0) {
                value = stackArray[i];
                stackArray[i] = stackArray[i + 1];
            }

        }
        return value;

    }

    public boolean isContainLessValue(int element) {

        for (int i = 0; i < stackArray.length; i++) {

            if(stackArray[i]==element-1 && stackArray[i] != 0){
                stackArray[i] = stackArray[i + 1];
                return true;
            }
        }
        return false;
    }


}
