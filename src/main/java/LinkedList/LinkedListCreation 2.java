package LinkedList;

public class LinkedListCreation {

    Node head;

    public static class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }

    }

    /*
    * Method that will iterate over the linked list starting from head and will print only data part of each Node.
     */
    public void printLinkedList(){

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

    }

    /*
    * Method that will add element at the top of the linked list logic is to
     */
    public void push(int data){
       Node newNode = new Node(data);
       newNode.next = head;
       head = newNode;

    }


    public void addAfter(int data,Node previousPosition){
        if(previousPosition==null){
            System.err.println("Previous Node can not be null");
        }

        Node newNode = new Node(data);
        newNode.next=previousPosition.next;
        previousPosition.next=newNode;

    }

    public static void main(String... args){

        LinkedListCreation linkedListCreation = new LinkedListCreation();

        //Created Nodes of Linked List and initialised data part only pointer part is still null
        linkedListCreation.head=new Node(10);
        Node second = new Node(15);
        Node third = new Node(20);
        Node fourth = new Node(25);

        //Initialising Pointer part of LinkedList such that first head Node next will point to second Node and so on
        linkedListCreation.head.next=second;
        second.next=third;
        third.next=fourth;

        //print Linked List
        linkedListCreation.printLinkedList();
        System.out.println();

        //add element at the head of linked List
        linkedListCreation.push(5);
        linkedListCreation.printLinkedList();
        System.out.println();

        //add element at the any position of linked List
        linkedListCreation.addAfter(23,third);
        linkedListCreation.printLinkedList();
        System.out.println();


    }


}
