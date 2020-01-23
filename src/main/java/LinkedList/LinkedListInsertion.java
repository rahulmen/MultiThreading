package LinkedList;

public class LinkedListInsertion {

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

    public void push(int data){ //received head pointer now change it to point to new Node
        Node newNode = new Node(data);
        newNode.next=head;
        head = newNode;
    }


    public static void main(String[] args){

        LinkedListInsertion linkedListInsertion= new LinkedListInsertion();

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

        linkedListInsertion.push(5);

        linkedListInsertion.printLinkedList();


    }


}
