import java.util.ArrayList;
import java.util.List;

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

public class BSTtraversal {
    Node root;

    public BSTtraversal() {
        this.root = null;
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

    public List<Integer> preorder(Node root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        helper2(root, output);
        return output;
    }

    private void helper2(Node root2, List<Integer> output) {
        if (root != null) {
            output.add(root.val);
            helper2(root.left, output);
            helper2(root.right, output);
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        helper3(root, output);
        return output;
    }

    private void helper3(Node root2, List<Integer> output) {
        if (root != null) {

            helper3(root.left, output);

            helper3(root.right, output);
            output.add(root.val);
        }
    }

    public static void main(String[] args) {
        BSTtraversal bst = new BSTtraversal();
        bst.insert(10);
        bst.insert(20);
        bst.insert(3);
        bst.insert(5);
        // List<Integer> ans1 = bst.inorder(bst.root);
        // System.out.println("inorder: " + ans1.toString());
        // System.out.println();
        // List<Integer> ans2 = bst.preorder(bst.root);
        // System.out.println("preorder: " + ans2.toString());
        // System.out.println();
        List<Integer> ans3 = bst.postorder(bst.root);
        System.out.println("postorder: " + ans3.toString());
    }
}