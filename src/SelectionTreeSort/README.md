#  Selection Tree Sort
-----

## Definition:-

Selection Tree Sort is a sorting algorithm that utilizes the properties of binary search trees (BSTs) to sort an array of elements. In Selection Tree Sort, each element of the input array is inserted into a binary search tree. The tree is then traversed in-order, which results in the elements being visited in sorted order. Finally, the sorted elements are copied back into the original array. This algorithm combines the benefits of binary search trees for maintaining sorted data with the simplicity of in-order traversal to achieve sorting.

-----

## Time Complexity Analysis:-

The time complexity of Selection Tree Sort is \(O(n \log n)\) in the average case and \(O(n^2)\) in the worst case. This complexity arises from building the binary search tree (BST) from the input array, which takes \(O(n \log n)\) time on average if the tree remains balanced. However, in the worst case, such as when the input array is already sorted or nearly sorted, the BST may degenerate into a linear chain, resulting in \(O(n^2)\) time complexity for tree construction. Overall, the time complexity depends on the balance of the BST and the distribution of the input data.

-----

## Space Complexity Analysis:-

The space complexity of Selection Tree Sort is \(O(n)\), where \(n\) is the number of elements in the input array. This space complexity arises from the storage required for constructing the binary search tree (BST) from the input array. Additionally, an auxiliary array may be needed for storing the sorted elements temporarily during the in-order traversal of the BST. Overall, the space complexity remains linear with respect to the size of the input array.

-----

## Advantages:-

1. **Efficient for Partially Sorted Data**: Works well with partially sorted input.
2. **Stable Sorting**: Maintains relative order of equal elements.
3. **In-Place**: Memory-efficient, requires minimal additional space.

----

## Dis-advantages:-

1. **Unstable Worst-Case Time Complexity**: Can degrade to \(O(n^2)\) for certain inputs.
2. **Sensitive to Input**: Performance varies based on input characteristics.
3. **Complexity of Tree Operations**: Building and managing the binary search tree introduces overhead.

-----

## Uses:-

1. **Sorting Partially Sorted Data**: Effective for sorting data that is already partially sorted.
2. **Stable Sorting**: Maintains the order of equal elements, crucial for certain applications.
3. **Memory Efficiency**: Suitable for scenarios with limited memory resources due to its in-place nature.
4. **Educational Purposes**: Useful for teaching concepts of binary search trees and sorting algorithms.
5. **Small Datasets**: Suitable for sorting small datasets efficiently due to its simplicity and stability.

-----

## Explanation of how the code works:

```java
public class SelectionTreeSort {
```

Here, a class named `SelectionTreeSort` is defined. This class serves as a container for the selection tree sort algorithm and related methods.

```java
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
```

Within the `SelectionTreeSort` class, a nested static class `TreeNode` is defined. This class represents a node in the binary search tree used for selection tree sorting. Each node contains an integer `data`, as well as references to its left and right child nodes. The constructor initializes a node with the given data and sets its left and right child nodes to `null`.

```java
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
```

This method `insert` inserts a new node with the specified data into the binary search tree rooted at `root`. If the tree is empty (`root == null`), a new node is created with the given data. Otherwise, the method recursively inserts the data into the left subtree if it is less than the current node's data, or into the right subtree otherwise. Finally, it returns the root of the modified tree.

```java
    public static TreeNode buildSelectionTree(int[] array) {
        TreeNode root = null;
        for (int value : array) {
            root = insert(root, value);
        }
        return root;
    }
```

This method `buildSelectionTree` constructs a binary search tree from the elements of the input array. It iterates through each element of the array and inserts it into the tree using the `insert` method. Finally, it returns the root of the constructed tree.

```java
    public static void inOrderTraversal(TreeNode root, int[] array, int[] index) {
        if (root != null) {
            inOrderTraversal(root.left, array, index);
            array[index[0]++] = root.data;
            inOrderTraversal(root.right, array, index);
        }
    }
```

The `inOrderTraversal` method performs an in-order traversal of the binary search tree rooted at `root`. During traversal, it recursively visits the left subtree, processes the current node's data by storing it in the output array at the appropriate index, and then recursively visits the right subtree. The `index` array is used to keep track of the current index in the output array.

```java
    public static void selectionTreeSort(int[] array) {
        TreeNode root = buildSelectionTree(array);
        int[] index = {0};
        inOrderTraversal(root, array, index);
    }
}
```

This `selectionTreeSort` method is the entry point for selection tree sorting. It first constructs a binary search tree from the input array using the `buildSelectionTree` method. Then, it initializes an index array and calls the `inOrderTraversal` method to perform an in-order traversal of the tree, storing the sorted elements back into the input array. Finally, the array is sorted in ascending order using selection tree sort.

-----