package com.learning.PrePrationAdobe;

public class CheckLinkedListLoop {

    Node head;
    int loopCount;

    static class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public boolean checkLoop(Node node){

        Node temp,temp1;
        int count;
        if(node!=null) {
            temp = node;
            temp1 = node;
            count = 1;
        }else{
         return false;
        }

        while(true){
            temp = temp.next;
            temp1 = temp1.next.next;
            count++;
            if(temp.next==null || temp1.next==null || temp1.next.next==null){
                return false;
            }
            if (temp.next == temp1.next.next) {
                loopCount=count;
                return true;
                }
        }
    }







    public boolean checkLoop2(Node node){

        Node temp,temp1;
        int count=0;
        if(node!=null){
            temp=temp1=node;
        }else{
            return false;
        }

        while(true) {
            if (temp.next != null && temp1.next != null && temp1.next.next != null) {
                temp = temp.next;
                temp1 = temp1.next.next;
                count++;

                if (temp == temp1) {
                    loopCount = count;
                    return true;
                }
            }else{
                return false;
            }
        }
    }

    public static void main(String... args){

        CheckLinkedListLoop checkLinkedListLoop = new CheckLinkedListLoop();
        checkLinkedListLoop.head = new Node(1);
        Node first= new Node(2);
        Node second = new Node(3);
        Node third = new Node (4);
        Node fourth = new Node(5);

        checkLinkedListLoop.head.next = first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=first;
        boolean result = checkLinkedListLoop.checkLoop2(checkLinkedListLoop.head);
        System.out.println(result);
        System.out.println(checkLinkedListLoop.loopCount);

    }
}
