import java.util.ArrayList;
import java.util.List;

public class LowestAncestor {
    Node root;
    public LowestAncestor(){
        this.root=null;
    }
    public void insert(int val) {
        root = insert(root, val);
    }

    public Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        }
        if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }
    public Node lowest(Node root,Node p,Node q){
        if(root==null || root.val==p.val|| root.val==q.val){
            return root;
        }
        Node left=lowest(root.left, p, q);
        Node right=lowest(root.right, p, q);
        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        return root;
    }
    public List<Integer> inorder(Node root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        helper1(root, output);
        return output;

    }
    private void helper1(Node root, List<Integer> output) {
        if (root != null) {
            helper1(root.left, output);
            output.add(root.val);
            helper1(root.right, output);
        }
    }
    public static void main(String[] args) {
        LowestAncestor lst=new LowestAncestor();
        int[] arr={7,2,4,20,8,3,6};
        for(int i:arr){
            lst.insert(i);
        }
        
        // System.out.println(ans);
        List<Integer> ans=lst.inorder(lst.root);
        System.out.println(ans.toString());

        Node p=new Node(2);
        Node q=new Node(6);
        Node res=lst.lowest(lst.root,p , q);
        System.out.println(res.val);
    }
}
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
