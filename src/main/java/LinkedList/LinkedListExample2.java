package LinkedList;

public class LinkedListExample2 {

    public Node head;
    static public class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public Node deleteDuplicates(Node buffer) {

        Node temp = buffer;
        Node temp1 = new Node(0);

        while(temp!=null){
            if(temp.data==temp.next.data){
                temp=temp.next;
            }else{
                temp1.next=temp.next;
            }
        }
        return temp1.next;
    }


    public void insertTop(int data){
        Node newNode = new Node(data);
        Node temp = head;
        newNode.next=temp;
        head=newNode;
    }

    public void insertafter(int data,Node previousNode){
        Node newNode = new Node(data);
        newNode.next=previousNode.next;
        previousNode.next=newNode;
    }

    public void insertend(int data){
        Node newNode=new Node(data);
        Node temp = head;
        while(temp.next!=null){
            head=temp.next;
        }
    }

    public void printLinkedList(){

        Node top = head;
        while(top!=null){
            System.out.print(top.data+" ");
            top = top.next;
        }

    }

    public static void main(String[] args){

        LinkedListExample2 linkedListExample2 = new LinkedListExample2();
        linkedListExample2.head=new Node(1);
        Node second = new Node(2);
        Node third = new Node(2);
        Node fourth = new Node(3);
        Node fifth = new Node(4);
       // Node sixth = new Node(4);


        linkedListExample2.head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        //fifth.next=sixth;

        linkedListExample2.deleteDuplicates(linkedListExample2.head);

        linkedListExample2.printLinkedList();

        linkedListExample2.insertTop(0);

        System.out.print("\n");
        linkedListExample2.printLinkedList();

        linkedListExample2.insertafter(4,third);

        System.out.print("\n");
        linkedListExample2.printLinkedList();


        linkedListExample2.insertend(6);

        System.out.print("\n");
        linkedListExample2.printLinkedList();










    }

}
