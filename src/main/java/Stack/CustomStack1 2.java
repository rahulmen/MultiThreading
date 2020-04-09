package Stack;

/*
* Provided an input array using that Array Create an stack and implement push and pop method
 */

import java.util.Stack;

public class CustomStack1 {

    int[] stackSize;

    int top;

    CustomStack1(){
        top = -1;
        this.stackSize = new int[10];
    }

    CustomStack1(int size){
        top = -1;
        this.stackSize = new int[size];
    }

    public void push(int data){
        if(top>=stackSize.length-1){
            throw new RuntimeException("StackOverFlow Condition");
        }else{
            stackSize[++top]=data;
        }
    }

    public int pop(){
        if(top<0){
            throw new RuntimeException("StackUnderFlow Condition");
        }else{
         int x = stackSize[top--];
         return x;
        }
    }

    public int peek(){
        if(top==-1){
            throw new RuntimeException("Stack UnderFlow Condition");
        }else {
            return stackSize[top];
        }
        }

     public boolean empty(){
        return top<0;
     }


    public static void main(String... args){

        CustomStack1 customStack1 = new CustomStack1();
        customStack1.push(4);
        customStack1.push(6);
        customStack1.push(56);
        customStack1.push(64);
        System.out.println(customStack1.pop());
        System.out.println(customStack1.pop());
        System.out.println(customStack1.pop());
        System.out.println(customStack1.pop());






    }








}
