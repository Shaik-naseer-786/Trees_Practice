import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indexMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> indexMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

       
        TreeNode root = new TreeNode(preorder[preStart]);

        
        int inRootIndex = indexMap.get(root.val);

        
        int leftSubtreeSize = inRootIndex - inStart;

        
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart,
                inRootIndex - 1, indexMap);

        
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, inRootIndex + 1,
                inEnd, indexMap);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        BuildTree solution = new BuildTree();
        TreeNode root = solution.buildTree(preorder, inorder);

        // Test the constructed tree by printing its inorder traversal
        solution.printInorder(root);
    }

    // Utility method to print the inorder traversal of a binary tree
    private void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
