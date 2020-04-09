package LinkedList;

public class LinkedListComplete {

    Node head;

    static class Node{
        String name;
        Node next;
        Node(String name){
            this.name =name;
            this.next=null;
        }
    }

    public void printLinkedList(){
        Node temp = head;
        if(temp==null){
            System.err.print("Head Cann't be empty!!");
        }
        while(temp!=null){
            System.out.print(temp.name+" ");
            temp = temp.next;
        }
    }

    public void push(String data){
        Node temp = new Node(data);
        temp.next=head;
        head = temp;
    }

    public void afterInsert(String data,Node previousNode){
        if(previousNode.next==null){
            System.err.print("Previous Node Pointer can not ne null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next=previousNode.next;
        previousNode.next=newNode;

    }

    public void afterEnd(String data){
        Node endNode = new Node(data);
        Node temp = head;

        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next=endNode;
    }


    public static void main(String[] args){

        LinkedListComplete linkedListComplete = new LinkedListComplete();
        linkedListComplete.head=new Node("Name");
        Node second=new Node("is");
        Node third = new Node("Rahul");

        linkedListComplete.head.next=second;
        second.next=third;

        System.out.print("Intial LinkedList : ");
        linkedListComplete.printLinkedList();

        //Insert Node at the beginning of the LinkedList

        System.out.print("\n"+"After insert at the Beginning of LinkedList : ");
        linkedListComplete.push("My");
        linkedListComplete.printLinkedList();

        System.out.print("\n"+"After insert at the middle of LinkedList : ");
        linkedListComplete.afterInsert("Mr.",second);
        linkedListComplete.printLinkedList();

        System.out.print("\n"+"After insert at the end of LinkedList : ");
        linkedListComplete.afterEnd("Mendiratta");
        linkedListComplete.printLinkedList();


    }



}
