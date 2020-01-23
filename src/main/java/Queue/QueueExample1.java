package Queue;

/*
* Implement Queue using Array
* Queue normal Operation
* 1. DeQueue {return integer}
* 2. EnQueue {takes int to add into Queue}
* 3. isEmpty {return boolean }
* 4. isFull {return boolean}
* 5. front {return front element from Queue}
* 6. rear {return rear element from Queue}
 */

public class QueueExample1 {

    int front;
    int rear;
    int capacity;
    int size;
    int[] array;

    QueueExample1(int capacity){
        this.capacity=capacity;
        this.front=size=0;
        this.rear=this.capacity-1;
        this.array = new int[this.capacity];
    }

    public boolean isEmpty(QueueExample1 queueExample1){
        return queueExample1.size==0;
    }

    public boolean isFull(QueueExample1 queueExample1){
        return (queueExample1.rear==queueExample1.capacity);
    }

    public int front(){
        return this.array[this.front];
    }

    public int rear(){
        return this.array[this.rear];
    }

    public void enQueue(int data){
        if(isFull(this)){
            return;
        }
        this.rear=(this.rear+1)%capacity;
        this.array[this.rear]=data;
        this.size=size+1;
    }

    public int deQueue(){
        if(isEmpty(this)) {
            return Integer.MIN_VALUE;
        }

        int data = this.array[this.front];
        this.front=this.front+1%this.capacity;
        this.size=this.size-1;
        return data;
    }


    public static void main(String... args){

        QueueExample1 queueExample1 = new QueueExample1(10);
        System.out.println(queueExample1.isEmpty(queueExample1));
        System.out.println(queueExample1.isFull(queueExample1));
        System.out.println(queueExample1.deQueue());
        queueExample1.enQueue(12);
        queueExample1.enQueue(13);
        System.out.println(queueExample1.front());
        System.out.println(queueExample1.rear());
        System.out.println(queueExample1.deQueue());
        System.out.println(queueExample1.deQueue());
        System.out.println(queueExample1.isEmpty(queueExample1));
        System.out.println(queueExample1.isFull(queueExample1));
    }

}
