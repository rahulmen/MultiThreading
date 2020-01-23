package Stack;

import java.util.Stack;

public class CustomStack {
    int size = 10;
    static int top = -1;
    int[] a;

    public CustomStack(){
        a = new int[size];
    }
    public CustomStack(int size){
        this.size = size;
        a = new int[size];
    }

    public void push(int data){
        if(top == size){
            System.out.println("stack is full can't push");
        }else{
            a[++top] = data;
        }
    }

    public int pop(){
        int data = -1 ;
        if(top == -1){
            System.out.println("Stack is empty nothing to pop");
            return data;
        }else{
            data = a[top];
            top--;
        }

        return data;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        /*int[] input = new int[5];
        for(int i=0;i<5;i++){
            int temp = i;
           input[i] = temp+5;
        }

        for(int x : input){
            stack.push(x);
        }
        int tempSize = top;
        for(int i=0;i<=tempSize;i++){
            System.out.println(stack.pop());
        }
*/
    }
}
