package Queue;

public class QueueExampleArrayImplementation {

    int front,rear,size,capacity;
    int[] array;

    QueueExampleArrayImplementation(int capacity){
        this.capacity=capacity;
        this.front=size=0;
        this.rear=capacity-1;
        this.array=new int[capacity];
    }

    public boolean isEmpty(QueueExampleArrayImplementation queueExample){
        return queueExample.size==0;
    }

    public boolean isFull(QueueExampleArrayImplementation queueExample){
        return queueExample.size==queueExample.capacity;
    }

    public int front(){
        if(isEmpty(this))
            return Integer.MAX_VALUE;
        return this.array[this.front];
    }

    public int rear(){
        if(isEmpty(this))
            return Integer.MIN_VALUE;
        return this.array[this.rear%this.capacity];
    }

    public void enQueue(int data){
        if(isFull(this))
            return;
        this.size=this.size+1;
        this.rear=this.rear+1;
        this.array[this.rear%this.capacity]=data;
    }

    public int deQueue(){
        if(isEmpty(this))
            return Integer.MIN_VALUE;
        int data = this.array[this.front];
        this.front= this.front+1%this.capacity;
        this.size=this.size-1;
        return data;
    }


    public static void main(String... args){

        QueueExampleArrayImplementation queueExample = new QueueExampleArrayImplementation(10);
        System.out.println(queueExample.isEmpty(queueExample));
        System.out.println(queueExample.isFull(queueExample));
        queueExample.enQueue(10);
        queueExample.enQueue(20);
        System.out.println(queueExample.deQueue());
        System.out.println(queueExample.front());
        System.out.println(queueExample.rear());
        System.out.println(queueExample.deQueue());
        System.out.println(queueExample.front());
        System.out.println(queueExample.rear());
        System.out.println(queueExample.isEmpty(queueExample));
        System.out.println(queueExample.isFull(queueExample));

    }

}
