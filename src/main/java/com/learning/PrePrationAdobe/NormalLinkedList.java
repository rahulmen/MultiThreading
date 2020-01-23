package com.learning.PrePrationAdobe;


public class NormalLinkedList {

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
            System.out.print(temp.data+" "+",");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertbefore(int data){
        Node node = new Node(data);
        node.next=head;
        head = node;
    }

    public void insertafter(int data,Node previous){

        Node temp = head;
        Node node = new Node(data);

        if(head==null){
            head = node;
            return;
        }


        node.next=previous.next;
        previous.next = node;
    }


    public void insertEnd(int data){
        Node temp = head;
        Node node = new Node(data);

        if(head==null){
            head = node;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next=node;
    }


    public void deleteNode(int data){

        Node temp = head;

        if(temp==null){
            return;
        }
        if(temp.data==data){
            head=temp.next;
            return;
        }
        while(temp!=null){
            if(temp.next.data==data){
                temp.next=temp.next.next;
                break;
            }
        }
    }


    public void reverse(Node node){

        Node temp = node;
        Node previous = null;
        Node head;

        while(temp!=null){
            head = temp.next;
            temp=previous;


        }



    }

    public static void main(String... args){

      NormalLinkedList normalLinkedList = new NormalLinkedList();
      normalLinkedList.head = new Node(1);
      Node second = new Node(5);
      Node third = new Node(10);

      normalLinkedList.head.next = second;
      second.next=third;

      normalLinkedList.printLinkedList();

      normalLinkedList.insertbefore(0);

      normalLinkedList.printLinkedList();

      normalLinkedList.printLinkedList();

      normalLinkedList.insertEnd(13);

      normalLinkedList.printLinkedList();

      normalLinkedList.insertafter(7,second);

      normalLinkedList.printLinkedList();

      normalLinkedList.deleteNode(0);

      normalLinkedList.printLinkedList();

      normalLinkedList.deleteNode(5);

      normalLinkedList.printLinkedList();

      normalLinkedList.reverse(normalLinkedList.head);

      normalLinkedList.printLinkedList();


    }


}
