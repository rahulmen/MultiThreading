package LinkedList;

public class LinkedListInsertionMiddle {

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




    public static void main(String[] args){

        LinkedListInsertionMiddle linkedListInsertion= new LinkedListInsertionMiddle();

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
        linkedListInsertion.printLinkedList();
        System.out.println();

        linkedListInsertion.insertAfter(17,second);



        linkedListInsertion.printLinkedList();


    }


}
