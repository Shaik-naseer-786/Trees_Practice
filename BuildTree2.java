import java.util.HashMap;

public class BuildTree2 {
    public Node buildTree( int[] postorder,int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private Node buildTreeHelper(int[] postorder, int postStart,int postEnd,  int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> map) {
        if (postStart>postEnd || inStart > inEnd) {
            return null;
        }

        Node root = new Node(postorder[postEnd]);

        int inroot=map.get(root.val);
        int numsleft=inroot-inStart;
        root.left=buildTreeHelper(postorder, postStart, postStart+numsleft-1, inorder, inStart, inroot-1, map);
        root.right=buildTreeHelper(postorder, postStart+numsleft, postEnd-1, inorder, inroot+1, inEnd, map);

        return root;
    }
    public static void main(String[] args) {
        int[] postorder = { 7,3,20,15,9 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        BuildTree2 solution = new BuildTree2();
        Node root = solution.buildTree(postorder, inorder);

        // Test the constructed tree by printing its inorder traversal
        solution.printInorder(root);
    }

    // Utility method to print the inorder traversal of a binary tree
    private void printInorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printInorder(node.left);
        
        printInorder(node.right);
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
