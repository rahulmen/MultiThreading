package LinkedList;

/*
* Program to demostrate LinkedList creating and accessing element of LinkedList
 */

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample1{

    Node head;

    //Define the inner class as static so that the main class can access it.
    static class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }

    }

    //function to access element of the LinkedList

    public void printLinkedList(){
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }

    }

    public static void main(String[] args){

        LinkedListExample1 linkedListExample1 = new LinkedListExample1();

        //create three inner class Object (Node) and assign only data value to it and keep reference as null.
        linkedListExample1.head=new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        //Perform pointing of Node with each other
        linkedListExample1.head.next=second;
        second.next=third;

        linkedListExample1.printLinkedList();

    }

}
