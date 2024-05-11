public class TreetoLinkedList {
    TreeNode root;
    
    public TreetoLinkedList(){
        this.root=null;
    }
    public void flatten(TreeNode root) {
        
        if(root==null){
            return ;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=null;
        TreeNode curr=root;
        while(curr.right!=null){
            curr=curr.right;
        }
        curr.right=temp;
    }
    public void insert(int val){
        root=insert(root,val);
    }
    public TreeNode insert(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left=insert(root.left, val);
        }
        if(val>root.val){
            root.right=insert(root.right, val);
        }
        return root;
    }
    public void display(TreeNode root){
        while(root!=null){
            System.out.print(root.val+" ");
            root=root.right;
        }
    }
    public static void main(String[] args) {
        int[] arr={5,4,1,3,8,6,7,9,10};
        TreetoLinkedList tl=new TreetoLinkedList();
        for(int i:arr){
            tl.insert(i);
        }
        tl.flatten(tl.root);
        tl.display(tl.root);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
        this.right=null;
        this.left=null;
    }
}
