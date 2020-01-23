package Queue;

     class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    class Queue{

        Node rear,front;

        Queue(){
            this.rear=this.front=null;
        }

        public void enQueue(Node node){
            Node temp = node;
            if(rear==null){
                this.rear=this.front=temp;
                return;
            }
            this.rear.next=temp;
            this.rear=temp;
        }

        public Node deQueue(){

            if(this.front==null){
                return new Node(Integer.MIN_VALUE);
            }
            Node temp = this.front;
            this.front=this.front.next;

            if(this.front==null){
                this.rear=null;
            }
            return temp;
        }
    }


public class QueueLinkedListImplementation {

    public static void main(String... args){
      Queue queue = new Queue();
      queue.enQueue(new Node(1));
      queue.enQueue(new Node(2));
      System.out.println(queue.deQueue().data);
      queue.enQueue(new Node(3));
      System.out.println(queue.deQueue().data);
      System.out.println(queue.deQueue().data);

    }

}
