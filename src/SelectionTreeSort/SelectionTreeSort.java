package SelectionTreeSort;


public class SelectionTreeSort {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static TreeNode buildSelectionTree(int[] array) {
        TreeNode root = null;
        for (int value : array) {
            root = insert(root, value);
        }
        return root;
    }

    public static void inOrderTraversal(TreeNode root, int[] array, int[] index) {
        if (root != null) {
            inOrderTraversal(root.left, array, index);
            array[index[0]++] = root.data;
            inOrderTraversal(root.right, array, index);
        }
    }

    public static void selectionTreeSort(int[] array) {
        TreeNode root = buildSelectionTree(array);
        int[] index = {0};
        inOrderTraversal(root, array, index);
    }
}
