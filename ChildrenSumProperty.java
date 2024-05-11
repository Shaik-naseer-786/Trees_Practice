public class ChildrenSumProperty {
    public static boolean isParentSum(Node root) {
        // Write your code here.
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        int sum=0;
        if(root.left!=null){
            sum+=root.left.val;
        }
        if(root.right!=null){
            sum+=root.right.val;
        }
        return (sum==root.val) && isParentSum(root.left) && isParentSum(root.right);
    }
    public static void main(String[] args) {
        Node node=new Node(3);
        node.left=new Node(2);
        node.right=new Node(1);
        System.out.println(isParentSum(node));
    }
}
class Node{
    int val;
    Node right;
    Node left;
    public Node(int val){
        this.val=val;
        this.right=null;
        this.left=null;
    }
}
