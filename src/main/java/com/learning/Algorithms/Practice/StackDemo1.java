package com.learning.Algorithms.Practice;

public class StackDemo1 {

    int[] arr;
    int top = -1;

    StackDemo1(){
        arr=new int[10];
    }

    StackDemo1(int size){
        arr = new int[size];
    }

    public void push(int data){
        if(top>arr.length-1){
            throw new RuntimeException("Stack OverFlow");
        }
        arr[++top]=data;
    }

    public int pop(){

        if(top<0){
            throw new RuntimeException("Stack UnderFlow");
        }
        int data = arr[top];
        top = --top;
        return data;
    }

    public int peek(){
        if(top<0){
            throw new RuntimeException("Stack UnderFlow");
        }
        return arr[top];
    }


    public boolean isEmpty(){
        if(top<0){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args){
        StackDemo1 stackDemo1 = new StackDemo1();
        StackDemo1 stackDemo11 = new StackDemo1(100);
        stackDemo1.push(1);
        stackDemo1.push(2);
        stackDemo1.push(3);
        System.out.println(stackDemo1.peek());
        System.out.println(stackDemo1.pop());
        System.out.println(stackDemo1.peek());

    }



}
