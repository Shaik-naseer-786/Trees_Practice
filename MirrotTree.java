public class MirrotTree {
    static void mirror(Node node) {
        // Your code here
        if(node==null){
            return;
        }
        Node temp=node.left;
        node.left=node.right;
        node.right=temp;

        mirror(node.left);
        mirror(node.right);
    }
    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.val);
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);

        inorder(node);
        mirror(node);
        inorder(node);
    }   
}
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
        this.right=null;
        this.left=null;
    }
}
