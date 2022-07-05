package LL;

public class reverseLL {
    static reverseLL.Node head; // head of linked list;
    /* Linked list node */
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /* Function to print middle of linked list */
   public Node rev(Node head){
       Node curr=head;
       Node prev=null;
       while(curr!=null)
       {
           Node temp=curr.next;
           curr.next=prev;
           prev=curr;
           curr=temp;
       }
       return prev;
   }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        reverseLL.Node new_node = new reverseLL.Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* This function prints contents of linked list
       starting from  the given node */
    public void printList()
    {
        reverseLL.Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+"->");
            tnode = tnode.next;
        }
//        System.out.println("NULL");
    }

    public static void main(String [] args)
    {
        reverseLL llist = new reverseLL();
        for (int i=5; i>0; --i)
        {
            llist.push(i);
//            llist.printList();
            Node out=llist.rev(head);
            llist.printList();
        }
    }
}
