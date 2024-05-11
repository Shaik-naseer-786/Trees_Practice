public class MaximumPathSum {
    Node root;
    public MaximumPathSum(){
        this.root=null;
    }
    public void insert(int val){
        root=insert(root,val);
    }
    public Node insert(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if(val<root.val){
            root.left=insert(root.left, val);
        }
        if(val>root.val){
            root.right=insert(root.right, val);
        }
        return root;
    }
    public int maxPathSum(Node root) {
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        helper(root,max);
        return max[0];

    }
    private int helper(Node root, int[] max) {
        if(root==null){
            return 0;
        }
        int left=Math.max(0,helper(root.left, max) );
        int right=Math.max(0, helper(root.right, max));
        max[0]=Math.max(max[0],right+left+root.val);
        return Math.max(left,right)+root.val;
    }
    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(root.val+" ");
            display(root.right);
        }
    }
    public static void main(String[] args) {
        MaximumPathSum mp=new MaximumPathSum();
        int[] arr={10,15,5,6,3,12,20};
        for(int i:arr){
            mp.insert(i);
        }
        mp.display(mp.root);
        System.out.println();
        System.out.println(mp.maxPathSum(mp.root));
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
