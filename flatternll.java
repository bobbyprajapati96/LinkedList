package LL;
class Node {
    int data;
    Node left,right;
    Node(int key)
    {
        data=key;
        left=right=null;
    }
}
public class flatternll {
    Node root;
    public  void flat(Node node){
        if(node ==null) return;
        // Or if it is a leaf node
        if(node.left ==null && node.right==null) return;
        // If root.left children exists then we have to make
        // it node.right (where node is root)
        if(node.left!=null)
        {
            flat(node.left);
            Node temp=node.right;
            node.right=node.left;
            node.left=null;
            // Find the position to insert the stored value
            Node curr=node.right;
            while(curr.right!=null)
            {
                curr=curr.right;
            }
            // Insert the stored value
            curr.right=temp;
        }
        flat(node.right);
    }
    public void inOrder(Node node)
    {
        if(node==null) return;
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    public static void main(String[] args)
    {
        flatternll tree = new flatternll();

        /*    1
            /   \
           2     5
          / \     \
         3   4     6 */

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.right = new Node(6);

        System.out.println(
                "The Inorder traversal after flattening binary tree ");
        tree.flat(tree.root);
        tree.inOrder(tree.root);
    }
}
