package Stack;

/*
* Implementing Stack Using Array
*
* Stack is the type of datastructure which work on LIFO or FILO architecture means last element entered will be accessed first or
* First element entered in the stack will be accessed Last.
*
* Time complexity of any of the operation we can perform on stack can be O(1).
*
* Common Function of stack.
* 1. push() :- adding element at the top of stack if stack is full we will get StackOverflow Condition.
* 2. pop() :- removing element from the top of stack if stack is empty we will get StackUnderflow condition.
* 3. peek() :- getting element from the top of stack.
* 4. isEmpty() :- check if the stack is empty if yes it will return true else this method will return false;
*
*
* Practical Example :- Undo ReUndo Operation in computer.
*
*                       Navigate Operation in Web Browser.
*
*
*
*    *************INCORRECT LOGIC*****************
 */


public class ImplementingStackUsingArray {

    Element top;
    static Element[] stackElements = new Element[10];



    static class Element{

        //Element next;
        int data;

        public Element(int data){
            this.data=data;
        }
    }

    public void push(int data){
        //Write Logic Such as the data will be added to 0th Index and
        for(int i=0;i<stackElements.length;i++){
            if(stackElements[i]==null){
                stackElements[i]=new Element(data);
                top=stackElements[i];
                break;
            }
        }
    }

    public void pop(){

        for(int i=0;i<stackElements.length;i++){
            if(stackElements[i]==top){
                stackElements[i]=null;
                top=stackElements[i-1];
                break;
            }
        }


    }

    public Element peek(){
        return top;
    }

    public boolean isEmpty(){
        if(top==null){
            return true;
        }
        return false;
    }


    public void printStack(){
        for(int i=stackElements.length-1;i>=0;i--){
            if(stackElements[i]==null){
                continue;
            }
            System.out.print(stackElements[i].data+" ");
        }
    }

    public static void main(String[] args){

        ImplementingStackUsingArray implementingStackUsingArray = new ImplementingStackUsingArray();

        //Stack of length 5
        //Element[] stackElements = new Element[10];

        implementingStackUsingArray.top=new Element(1);

        //Pushing element in
        stackElements[0]= new Element(1);
        stackElements[1]=new Element(2);
        stackElements[2]=new Element(3);
        stackElements[3]= new Element(4);
        stackElements[4]=new Element(5);
        implementingStackUsingArray.top= stackElements[4];

        System.out.print("Original Stack : ");
        implementingStackUsingArray.printStack();

        System.out.print("\n"+"Add on the Top of the stack is : ");
        implementingStackUsingArray.push(6);
        implementingStackUsingArray.printStack();

        System.out.print("\n"+"Remove from the top of the stack : ");
        implementingStackUsingArray.pop();
        implementingStackUsingArray.printStack();

        System.out.print("\n"+"Fetch from the top of the stack : "+implementingStackUsingArray.peek().data);

        System.out.print("\n"+"Check is the stack is Empty : "+ implementingStackUsingArray.isEmpty());










    }

}
