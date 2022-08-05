package LL;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data=data;
    }
}
public class mergeTwoSortedLL {
    static Node mergeTwoList(Node head1,Node head2){
        Node head=null,tail=null;
        Node a=head1,b=head2;
        if(a==null)return b;
        if(b==null) return a;
        if(a.data<=b.data){
            head=a;
            tail=a;
            a=a.next;
        }else{
            head=b;
            tail=b;
            b=b.next;
        }
        while(a!=null && b!=null){
            if(a.data<=b.data){
                tail.next=a;
                tail=a;
                a=a.next;
            }
            else{
                tail.next=b;
                tail=b;
                b=b.next;
            }
        }
        if(a==null) tail.next=b;
        if(b==null) tail.next=a;
        return head;

    }
    static void printLL(Node head) {
       Node cur = head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);
//        head1.next.next.next = new Node(5);
//        head1.next.next.next.next = new Node(6);
//		head1.next.next.next.next.next = new Node(5);
//		head1.next.next.next.next.next.next = new Node(6);
//		head1.next.next.next.next.next.next.next = new Node(7);
        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);
//        head2.next.next.next = new Node(7);
        Node head=mergeTwoList(head1,head2);
        printLL(head);
    }
}
