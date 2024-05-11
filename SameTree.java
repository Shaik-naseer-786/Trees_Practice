public class SameTree {
    Node p;
    Node q;

    public SameTree() {
        this.p = null;
        this.q = null;
    }

    public void insertP(int val) {
        p = insert(p, val);
    }

    public void insertQ(int val) {
        q = insert(q, val);
    }

    private Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    

    private boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        
    }

    public static void main(String[] args) {
        SameTree tree = new SameTree();
        tree.insertP(5);
        tree.insertP(3);
        tree.insertP(8);

        SameTree anotherTree = new SameTree();
        anotherTree.insertQ(5);
        anotherTree.insertQ(3);
        anotherTree.insertQ(8);

        SameTree ans=new SameTree();
        System.out.println(ans.isSameTree(tree.p, anotherTree.q));
    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
