package Stack;

/*
* To solve this problem when we will push data in Stack we have to keep two elements in the block one will keep Stack actual value and
* another will Keep maximum value in the stack so far.
 */

public class StackFindMax {
     int top;
     int max = Integer.MIN_VALUE;
     Block[] blocks;
     int defaultSize =10;

    //This is the Block we will have in stack basically we will have block of Stack.
    static class Block{
        int value,localMax;

        Block(){};

        Block(int value,int localMax){
            this.value=value;
            this.localMax=localMax;
        }

    }

    StackFindMax(int size){
        blocks=new Block[size];
        top = -1;
        for(int i=0;i<size;i++){
            blocks[i] = new Block();
        }
    }

    StackFindMax(){
        blocks=new Block[defaultSize];
        top =-1;
        for(int i=0;i<defaultSize;i++){
            blocks[i] = new Block();
        }
    }

    public void push(int data){

        if(top>=defaultSize-1){
            throw new StackOverflowError();
        }
        else{
            blocks[++top]=new Block(data,data);
            if(top==0){
                max=blocks[top].localMax;
            }else{
                if(blocks[top].localMax>max){
                    blocks[top-1].localMax=max;
                    max=blocks[top].localMax;
                }
            }
        }
    }

    public int pop(){
        if(top==-1){
            throw new RuntimeException("Stack is empty");
        }else{
            top = top-1;
            max = blocks[top-1].localMax;
        }

        return -1;
    }

    public void getmax(){
        System.out.println("Maximum Number in a stack : "+ max);
    }


    public static void main(String... args){

        StackFindMax stackFindMax = new StackFindMax(12);
        stackFindMax.push(3);
        stackFindMax.push(8);
        stackFindMax.push(2);
        stackFindMax.push(9);
        stackFindMax.push(3);
        stackFindMax.push(78);
        stackFindMax.getmax();
        stackFindMax.pop();
        stackFindMax.getmax();
        stackFindMax.pop();
        stackFindMax.getmax();








    }


}
