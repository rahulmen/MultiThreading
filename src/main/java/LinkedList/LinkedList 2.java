package LinkedList;

public class LinkedList {

    Node head;

    public static class Node{
        int data;
        Node pointer;

        Node(int data){
            this.data=data;
            this.pointer=null;
        }

    }

    public void printLinkedList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp= temp.pointer;
        }
    }

    public void push(int data){
        Node newNode = new Node(2);
        newNode.pointer=head;
        head=newNode;
    }

    public void insertAfter(int data,Node previousNode){

        Node newNode = new Node(data);
        newNode.pointer=previousNode.pointer;
        previousNode.pointer=newNode;

    }

    public static void main(String[] args){


        LinkedList linkedList = new LinkedList();
        linkedList.head= new Node(5);
        Node second = new Node(10);
        Node third = new Node(15);


        linkedList.head.pointer=second;
        second.pointer=third;

        //linkedList.printLinkedList();

        linkedList.push(2);

        linkedList.insertAfter(13,second);

        linkedList.printLinkedList();

    }

}
