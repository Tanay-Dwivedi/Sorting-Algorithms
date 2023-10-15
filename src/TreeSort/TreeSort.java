package TreeSort;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class TreeSort {
    Node root;

    public TreeSort() {
        root = null;
    }

    // Function to insert a new key into the BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Perform in-order traversal of the BST
    public void inOrder(Node root, int[] arr, int[] index) {
        if (root != null) {
            inOrder(root.left, arr, index);
            arr[index[0]++] = root.key;
            inOrder(root.right, arr, index);
        }
    }

    public static void treeSort(int[] arr) {
        TreeSort treeSort = new TreeSort();
        for (int num : arr) {
            treeSort.insert(num);
        }

        int[] index = {0};
        treeSort.inOrder(treeSort.root, arr, index);
    }
}
