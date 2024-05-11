class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class InorderPreorderSuccessor {
    static Node inSuc = null;
    static Node preSuc = null;

    public static void findInOrderSuccessor(Node root, int key) {
        if (root == null)
            return;

        if (root.data == key) {
            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null)
                    temp = temp.left;
                inSuc = temp;
            }
            return;
        }

        if (key < root.data) {
            inSuc = root;
            findInOrderSuccessor(root.left, key);
        } else {
            findInOrderSuccessor(root.right, key);
        }
    }

    public static void findPreOrderSuccessor(Node root, int key) {
        if (root == null)
            return;

        if (root.data == key) {
            if (root.left != null) {
                preSuc = root.left;
            }
            return;
        }

        if (key < root.data) {
            preSuc = root;
            findPreOrderSuccessor(root.left, key);
        } else {
            findPreOrderSuccessor(root.right, key);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);

        int key = 15;

        findInOrderSuccessor(root, key);
        findPreOrderSuccessor(root, key);

        System.out.println("Inorder successor of " + key + " is " + (inSuc != null ? inSuc.data : "null"));
        System.out.println("Preorder successor of " + key + " is " + (preSuc != null ? preSuc.data : "null"));
    }
}
