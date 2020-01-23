package Queue;

public class PriorityQueueImplementationUsingArray{

    int capacity,size;
    int front,rear;
    char[] ch;

    PriorityQueueImplementationUsingArray(int capacity){
        this.capacity=capacity;
        this.size=0;
        this.front=0;
        this.rear=this.capacity-1;
        this.ch = new char[this.capacity];
    }

    public char front(){
        return this.ch[this.front];
    }

    public char rear(){
        return this.ch[this.rear];
    }

    public boolean isFull(PriorityQueueImplementationUsingArray q){
        return q.size==q.capacity;
    }

    public boolean isEmpty(PriorityQueueImplementationUsingArray q){
        return q.size==0;
    }

    public void insert(char item){
        if(isFull(this)){
            return;
        }
        this.ch[(this.rear+1)%this.capacity]=item;
        this.size=this.size+1;
        this.rear=(this.rear+1)%this.capacity;
    }


    public char getHighestPriority(){
        char max = 'A';
        for(int i=0;i<ch.length;i++){
            if(this.ch[i]>max && this.ch[i]!='\u0000'){
                max = ch[i];
            }
        }
        return max;
    }

    public char deleteHighestPriority(){
        char max = 'A';
        int maxIndex = 0;
        for(int i=0;i<ch.length;i++){
            if(this.ch[i]>max && this.ch[i]!='\u0000'){
                max = ch[i];
                maxIndex=i;
            }
        }

        for(int i=maxIndex;i<this.ch.length;i++){
            this.ch[maxIndex]=this.ch[maxIndex+1];
        }
        return max;
    }


    public static void main(String... args){

        PriorityQueueImplementationUsingArray queue = new PriorityQueueImplementationUsingArray(26);
        System.out.println(queue.isFull(queue));
        System.out.println(queue.isEmpty(queue));
        queue.insert('A');
        System.out.println(queue.front());
        System.out.println(queue.rear());
        queue.insert('B');
        System.out.println(queue.front());
        System.out.println(queue.rear());
        queue.insert('C');
        queue.insert('D');
        queue.insert('E');
        queue.insert('F');
        queue.insert('G');
        System.out.println(queue.front());
        System.out.println(queue.rear());
        System.out.println(queue.isFull(queue));
        System.out.println(queue.isEmpty(queue));

        System.out.println(queue.getHighestPriority());
        System.out.println(queue.deleteHighestPriority());

        System.out.println(queue.getHighestPriority());
        System.out.println(queue.deleteHighestPriority());

    }


}
