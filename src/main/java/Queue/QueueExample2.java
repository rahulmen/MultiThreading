package Queue;

import org.testng.annotations.Test;

public class QueueExample2 {
    
    int front;
    int rear;
    int size;
    int capapcity;
    int[] array;
    
    QueueExample2(int capacity){
        this.capapcity=capacity;
        this.front=size=0;
        this.rear=capacity-1;
        this.array = new int[capacity];
    }
    
    public boolean isEmpty(QueueExample2 queueExample2){
        return queueExample2.size==0;
    }
    
    public boolean isFull(QueueExample2 queueExample2){
        return queueExample2.size==queueExample2.capapcity;
    }
    
    public int front(){
        return this.front;
    }
    
    public int rear(){
        return this.rear;
    }
    
    public void enQueue(int data){
        if(isFull(this)){
            return;
        }
        this.array[this.size%this.capapcity]=data;
        this.rear=data;
        this.size=this.size+1;
    }
    
    public int deQueue(){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        int data = this.array[this.front];
        this.array[this.front]=this.rear=this.array[this.front+1];
        this.size=this.size-1;
        return data;
    }
    
    

    public static void main(String... args){

        QueueExample2 queueExample2 = new QueueExample2(10);
        System.out.println(queueExample2.isEmpty(queueExample2));
        System.out.println(queueExample2.isFull(queueExample2));
        System.out.println(queueExample2.deQueue());
        queueExample2.enQueue(12);
        queueExample2.enQueue(13);
        System.out.println(queueExample2.front());
        System.out.println(queueExample2.rear());
        System.out.println(queueExample2.deQueue());
        System.out.println(queueExample2.deQueue());
        System.out.println(queueExample2.isEmpty(queueExample2));
        System.out.println(queueExample2.isFull(queueExample2));
        
    }
            
    
}
