import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree{
    Node root;
    public LeftViewOfBinaryTree(){
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
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node n=q.poll();
                if(i==0){
                    result.add(0,n.val);
                }
                if(n.left!=null){
                    q.offer(n.left);
                }
                if(n.right!=null){
                    q.offer(n.right);
                }
            }
        }
        return result;
        
    }
    public static void main(String[] args) {
        LeftViewOfBinaryTree lbst=new LeftViewOfBinaryTree();
        int[] arr={10,3,5,1,20};
        for(int num:arr){
            lbst.insert(num);
        }
        ArrayList<Integer> ans=lbst.leftView(lbst.root);
        System.out.println(ans.toString());
    }
}
class Node{
    int val;
    Node right;
    Node left;
    public Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}