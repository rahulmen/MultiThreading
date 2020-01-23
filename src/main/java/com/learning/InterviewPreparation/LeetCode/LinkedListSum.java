package com.learning.InterviewPreparation.LeetCode;


/*
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

import java.util.List;

public class LinkedListSum {

    ListNode head;

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode out = null;
        int carry = 0;
        int globalSum = 0;
        String finalSum = "";


        while(l1!=null || l2!=null){
            int sum = l1.data+l2.data;
            if(sum>10){
                carry++;
                int data = sum-10;
                out=new ListNode(data);
            }else{
                if(carry==0) {
                    out = new ListNode(sum);
                    out = out.next;
                }else{


                }
            }
            l1=l1.next;
            l2=l2.next;
        }









       return out;
    }

    static class ListNode{

        ListNode next;
        int data;

        ListNode(int data){
            this.data=data;
            this.next=null;
        }

    }


    public static void main(String... args){

        ListNode firstA = new ListNode(2);
        ListNode secondA = new ListNode(4);
        ListNode thirdA = new ListNode(3);

        LinkedListSum linkedListSumA = new LinkedListSum();
        linkedListSumA.head = firstA;
        firstA.next=secondA;
        secondA.next=thirdA;

        ListNode firstB = new ListNode(5);
        ListNode secondB = new ListNode(6);
        ListNode thirdB = new ListNode(4);

        LinkedListSum linkedListSumB = new LinkedListSum();
        linkedListSumB.head=firstB;
        firstB.next=secondB;
        secondB.next=thirdB;


        addTwoNumbers(linkedListSumA.head,linkedListSumB.head);



    }

    }
