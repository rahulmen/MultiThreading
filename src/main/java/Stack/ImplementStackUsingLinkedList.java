package Stack;

public class ImplementStackUsingLinkedList {

    StackNode root;

    static class StackNode{

        int data;
        StackNode next;

        StackNode(int data){
            this.data=data;
        }

    }

    /*
    * This method will add a element in the StackNode time complexity is O(1)
     */
    public void push(int data){
        StackNode stackNode  = new StackNode(data);
        if(root==null){
          root=stackNode;
        }else{
            StackNode temp = root;
            root=stackNode;
            stackNode.next=temp;
        }
    }

    /*
    * this method should remove the last added element in the Stack as per LIFO or FILO condition.
     */

    public int pop(){
        int data=Integer.MIN_VALUE;
        if(root==null){
            throw new RuntimeException("Stack Underflow Condition");
        }else{
            data = root.data;
            root= root.next;
            return data;
        }
    }

    public int peek(){

        if(root==null){
            throw new RuntimeException("Stack Underflow Condition");
        }else{
            return root.data;
        }
    }

    public boolean isEmpty(){
        return root==null;
    }


    public static void main(String[] args){


        ImplementStackUsingLinkedList implementStackUsingLinkedList = new ImplementStackUsingLinkedList();
        implementStackUsingLinkedList.push(1);
        implementStackUsingLinkedList.push(5);
        implementStackUsingLinkedList.push(76);

        System.out.println(implementStackUsingLinkedList.isEmpty());

        System.out.println(implementStackUsingLinkedList.pop());
        System.out.println(implementStackUsingLinkedList.pop());

        System.out.println(implementStackUsingLinkedList.isEmpty());

        System.out.println(implementStackUsingLinkedList.pop());

        System.out.println(implementStackUsingLinkedList.isEmpty());




    }

}
