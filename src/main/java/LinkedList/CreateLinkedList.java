package LinkedList;

/*
* Program to demostrate LinkedList creating and accessing element of LinkedList
 */

public class CreateLinkedList {

    //First head Node of the LinkedList
     Node head;

    static class Node{
        //Contains two members one node data and next node address
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
        }
    }

    public void printLinkedList(){
        Node head1 = head;

        while(head1!=null){
            System.out.print(head1.data+" ");
            head1=head1.next;
        }

    }

    public static void main(String[] args){

        CreateLinkedList createLinkedList = new CreateLinkedList();

        //Node data set
        createLinkedList.head = new Node("Rahul");
        Node second = new Node("Kumar");
        Node third = new Node("Mendiratta");

        //Node pointing
        createLinkedList.head.next=second;
        second.next=third;


        createLinkedList.printLinkedList();






    }


}
