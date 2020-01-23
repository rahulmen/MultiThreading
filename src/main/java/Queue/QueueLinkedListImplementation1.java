package Queue;


class Node1{

    Node1 next;
    int data;

    Node1(int data){
        this.data=data;
        this.next=null;
    }
}

class Queue1{

    Node1 front,rear;

    Queue1(){
        this.front=this.rear=null;
    }

    public void enQueue(int data){
        Node1 temp = new Node1(data);

        //Check if node inserted is the first Node in the Queue
        if(this.rear==null){
            this.rear=this.front=temp;
            return;
        }
        //If node inserted is not the first node then enter the temp node into next rear node
        this.rear.next=temp;
        this.rear=temp;
    }

    public int deQueue(){

        //If front is null so Queue is Empty and there is nothing to deQueue so method will return min Integer value.
        if(this.front==null){
            return Integer.MIN_VALUE;
        }

        //Else fetch data from front Node and reassign front.next into next
        int data = this.front.data;
        this.front = this.front.next;

        //Check if front.next is now null set rear also as null because now Queue is Empty again.
        if(this.front==null){
            this.rear=null;
        }
        return data;
    }

    public int front(){
        if(this.front==null){
            return Integer.MIN_VALUE;
        }
        return this.front.data;
    }

    public int rear(){
        if(this.rear==null){
            return Integer.MIN_VALUE;
        }
        return this.rear.data;
    }


}

public class QueueLinkedListImplementation1 {

    public static void main(String... args){
        Queue1 queue1 = new Queue1();
        queue1.enQueue(1);
        queue1.enQueue(2);
        System.out.println(queue1.front());
        System.out.println(queue1.rear());
        queue1.enQueue(3);
        System.out.println(queue1.deQueue());
        System.out.println(queue1.front());
        System.out.println(queue1.rear());
        System.out.println(queue1.deQueue());
        System.out.println(queue1.deQueue());

    }
}
