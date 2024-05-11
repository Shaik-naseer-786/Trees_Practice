public class BuildBST {
    Node root;
    public BuildBST(){
        root=null;
    }
    public Node bstFromPreorder(int[] preorder) {
        root=new Node(preorder[0]);
        for(int i:preorder){
            helper(root,i);
        }
        return root;
    }
    private Node helper(Node root, int i) {
        if(root==null){
            root=new Node(i);
            return root;
        }
        if(root.val>i){
            root.left=helper(root.left, i);
        }
        if(root.val<i){
            root.right= helper(root.right, i);
        }
        return root;
    }
    public void display(Node res){
        if(res!=null){
            System.out.print(res.val+" ");
            display(res.left);
            
            display(res.right);
        }
    }
    public static void main(String[] args) {
        int[] preorder={8,5,1,7,10,12};
        BuildBST bst=new BuildBST();
        Node res=bst.bstFromPreorder(preorder);

        bst.display(res);
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
