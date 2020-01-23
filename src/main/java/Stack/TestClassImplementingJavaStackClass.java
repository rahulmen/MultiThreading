package Stack;

import java.util.Stack;

public class TestClassImplementingJavaStackClass {

    protected static Stack<Integer> stack = new Stack<Integer>(); //Create Static stack which will be common for whole class

    public static void push_stack(Stack stack){
        for(int i=0;i<5;i++){
            stack.push(i);
        }

    }

    /* This method will remove all the element from the stack */

    public static void pop_stack(Stack stack,int num){
        for(int i=0;i<5;i++){
            stack.pop();
        }
    }

    public static Integer peek_stack(){
        return stack.peek();
    }

    public static int search_stack(int num){
       return stack.search(num);
    }

    public static boolean empty_stack(){
        return stack.empty();
    }



    public static void main(String[] args){

        push_stack(stack);







    }
}
