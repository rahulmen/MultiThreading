package LinkedList;

public class LinkedListDemo1 {

    Node head;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }

    public void printLinkedList(){
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String... args){
        LinkedListDemo1 linkedListDemo1 = new LinkedListDemo1();

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        LinkedListDemo1 linkedListDemo11 = new LinkedListDemo1();
        linkedListDemo1.head = first;
        first.next=second;
        second.next=third;


        linkedListDemo1.printLinkedList();






    }
}
