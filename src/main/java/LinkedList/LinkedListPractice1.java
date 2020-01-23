package LinkedList;

public class LinkedListPractice1 {

    Node head;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next=null;
        }
    }


    public void printLinkedList(){

        System.out.println();
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }


    public void addFirst(int data){
        Node new_node = new Node(data);
        new_node.next=head;
        head = new_node;
    }


    public void addMiddle(int data,Node previous){

        Node new_node = new Node(data);
        Node temp = previous.next;
        previous.next=new_node;
        new_node.next=temp;
    }


    public void addLast(int data){
        Node node = new Node(data);
        if(head==null){
            throw new RuntimeException("Head can not be null");
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        head.next=node;
    }

    public static void main(String... args){

        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        LinkedListPractice1 linkedListPractice1 = new LinkedListPractice1();
        linkedListPractice1.head=first;
        linkedListPractice1.head.next=second;
        second.next=third;
        third.next=fourth;

        linkedListPractice1.printLinkedList();

        linkedListPractice1.addFirst(5);

        linkedListPractice1.printLinkedList();

        linkedListPractice1.addMiddle(23,second);

        linkedListPractice1.printLinkedList();

        linkedListPractice1.addLast(100);

        linkedListPractice1.printLinkedList();











    }


}
