package LL;

public class palindromeLL {
    static class Node{
       Node next;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    static void printLL(Node head) {
        Node cur = head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    static Node findmiddle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node reverseLL(Node head){
        Node curr=head,prev=null;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    static boolean isPalindrome(Node head){
        if(head==null || head.next==null) return true;
        Node mid=findmiddle(head);
        Node rev=reverseLL(mid);
        Node left=head;
        Node right=rev;
        while(right!=null)
        {
            if(left.data!=right.data) return false;
            left=left.next;
            right=right.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.next = new Node(3);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(4);
        printLL(head1);
        System.out.println(isPalindrome(head1));
    }

}
