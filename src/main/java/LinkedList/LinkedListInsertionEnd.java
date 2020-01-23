package LinkedList;

public class LinkedListInsertionEnd {

    Node head;

    static class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;

        }
    }

    public void printLinkedList(){
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next; //This will return next Node address
        }

    }

    public void insertAfter(int data,Node previousNode){

        if(previousNode.next==null){
            System.err.print("Previous node can not be null");
            return;
        }

        Node newNode = new Node(data);
        newNode.next=previousNode.next;
        previousNode.next=newNode;


    }

    public void insertEnd(int data){
        Node newNode = new Node(data);
        Node temp = head;

        while(temp.next!=null){
        temp=temp.next;
        }
        temp.next=newNode;

    }

    public void push(int data){ //received head pointer now change it to point to new Node
        LinkedListInsertionEnd.Node newNode = new LinkedListInsertionEnd.Node(data);
        newNode.next=head;
        head = newNode;
    }



    public static void main(String[] args){

        LinkedListInsertionEnd linkedListInsertion= new LinkedListInsertionEnd();

        //Four Nodes created with int data initilised but pointer not yet initialised
        linkedListInsertion.head=new Node(10);
        Node second = new Node(15);
        Node third = new Node(20);
        Node fourth = new Node(25);

        //Perform Pointing
        linkedListInsertion.head.next=second;
        second.next=third;
        third.next=fourth;

        //Before push
        System.out.print("Before Push : ");
        linkedListInsertion.printLinkedList();
        System.out.println();

        //afterpush
        System.out.print("AfterPush Push : ");
        linkedListInsertion.push(3);
        linkedListInsertion.printLinkedList();
        System.out.println();

        //After Insert after any random element
        System.out.print("After Insert after : ");
        linkedListInsertion.insertAfter(17,second);
        linkedListInsertion.printLinkedList();
        System.out.println();

        //After Insert after any end element
        System.out.print("After Insert end : ");
        linkedListInsertion.insertEnd(30);
        linkedListInsertion.printLinkedList();
        System.out.println();
    }


}
