package Queue;

class Node3{

    char data;
    Node3 next;

    Node3(char data){
        this.data=data;
        this.next=null;
    }
}

class Queue3{

    Node3 front,rear;

    Queue3(){
        this.front=this.rear=null;
    }

    public void insert(char ch){
        Node3 temp = new Node3(ch);

        if(this.front==null){
            this.front=this.rear=temp;
            return;
        }
        this.rear.next=temp;
        this.rear=temp;
    }

   /* public char getHighestPriority(){


    }*/

    public boolean isEmpty(){
        return this.front==null;
    }

    public char front(){
        if(isEmpty()){
            System.out.print("Queue is Empty");
            return '\u0000';
        }
        return this.front.data;
    }

    public char rear(){
        if(isEmpty()){
            System.out.print("Queue is Empty");
            return '\u0000';
        }
        return this.rear.data;
    }
}


public class PriorityQueueImplementationUsingLinkedList {

    public static void main(String... args){

        Queue3 queue3 = new Queue3();
        System.out.println(queue3.front());
        System.out.println(queue3.rear());
        queue3.insert('A');
        System.out.println(queue3.front());
        System.out.println(queue3.rear());
        queue3.insert('B');
        System.out.println(queue3.front());
        System.out.println(queue3.rear());

    }



}
