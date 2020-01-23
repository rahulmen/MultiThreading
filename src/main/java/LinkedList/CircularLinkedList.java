package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class CircularLinkedList {

        Node head;

    static class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next=null;
        }
    }

    public void checkIfCircular(){
        Node temp = head;
        boolean result = false;
        Set<String> NodeData = new HashSet<String>();
        while(temp!=null){
            result=NodeData.add(temp.data);
            if(result==false){
                System.out.print("Provided Linked List is Circular");
                break;
            }
            temp = temp.next;
        }
    }


    public static void main(String... args){
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        Node first = new Node("Rahul");
        Node second = new Node("Ravi");
        Node third = new Node("Rishab");
        Node fourth = new Node("Sahil");

        circularLinkedList.head=first;
        circularLinkedList.head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=first;

        circularLinkedList.checkIfCircular();



    }
}
