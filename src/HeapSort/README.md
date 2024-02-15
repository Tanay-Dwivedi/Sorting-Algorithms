#  Heap Sort
-----

## Definition:-

Heap sort is a comparison-based sorting algorithm that operates by first building a max heap from the array to be sorted and then repeatedly extracting the maximum element from the heap and placing it at the end of the array. The process of building a max heap rearranges the elements of the array such that every parent node is greater than or equal to its children, ensuring that the maximum element is at the root.
After building the max heap, the algorithm iteratively extracts the maximum element (the root of the heap) and places it at the end of the array. This operation is repeated until the entire array is sorted. Heap sort has a time complexity of \(O(n \log n)\) and is considered an efficient sorting algorithm, particularly for large datasets.

-----

## Time Complexity Analysis:-

Heap sort has a time complexity of \(O(n \log n)\) in all cases, where \(n\) is the number of elements in the input array. This complexity arises from the two main steps of the algorithm: building the heap (\(O(n)\)) and repeatedly extracting the maximum element and restoring the heap property (\(O(\log n)\)) for each element. The overall time complexity is dominated by the heapify operation, which is performed \(n\) times during the sorting process. Therefore, heap sort is efficient for sorting large datasets.

-----

## Space Complexity Analysis:-

Heap sort has a space complexity of \(O(1)\), indicating that it requires constant additional space regardless of the size of the input array. This is because the algorithm operates in-place, modifying the input array without requiring additional memory proportional to the size of the array. Therefore, heap sort is memory-efficient and suitable for sorting large datasets with limited memory resources.

-----

## Advantages:-

1. **Efficiency**: Heap sort has a time complexity of \(O(n \log n)\) in all cases, making it efficient for sorting large datasets.
   
2. **In-Place Sorting**: It sorts the array in-place, requiring only a constant amount of additional memory, which is advantageous for memory-constrained environments.

3. **Stability**: Unlike some other sorting algorithms, heap sort is stable, meaning it preserves the relative order of equal elements, which can be useful in certain applications.

----

## Dis-advantages:-

1. **Non-Adaptive**: Heap sort lacks adaptability to nearly sorted arrays or small datasets due to its consistent \(O(n \log n)\) time complexity.

2. **Variable Performance**: While it guarantees \(O(n \log n)\) time complexity, heap sort's performance may vary based on input data, leading to less predictable behavior.

3. **Overhead**: Heap sort incurs additional overhead for maintaining the heap structure, potentially resulting in slightly slower performance on systems with limited memory or for small datasets.

-----

## Uses:-

1. **Efficient Sorting**: Heap sort is suitable for sorting large datasets efficiently due to its \(O(n \log n)\) time complexity.

2. **In-Place Sorting**: It operates in-place, making it memory-efficient and suitable for systems with limited memory resources.

3. **Priority Queues**: Heap sort is commonly used to implement priority queues, where elements are stored and retrieved based on their priority.

4. **External Sorting**: It can be utilized as part of external sorting algorithms for sorting large datasets that do not fit into main memory.

5. **Operating Systems**: Heap sort is used in various operating system implementations for tasks such as scheduling processes based on their priority levels.

-----

## Explanation of how the code works:

```java
public class HeapSort {
```

This line declares a public class named `HeapSort`.

```java
    public static void heapSort(int[] arr) {
```

Here, a public static method named `heapSort` is defined. This method takes an integer array `arr` as input and is responsible for sorting the elements of the array using the Heap sort algorithm.

```java
        if (arr == null || arr.length <= 1) {
            return; // The array is already sorted or empty
        }
```

This conditional statement checks if the input array is null or has a length less than or equal to 1. If either condition is true, it means the array is already sorted or empty, and the method returns early without performing any further operations.

```java
        int n = arr.length;
```

An integer variable `n` is declared and assigned the length of the input array `arr`.

```java
        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
```

This loop builds a max heap from the elements of the input array. It starts from the last non-leaf node (`n/2 - 1`) and iterates backwards towards the root of the heap, calling the `heapify` method for each node to ensure the heap property is maintained.

```java
        // Extract elements from the heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Move the current root to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
```

After building the max heap, this loop repeatedly extracts elements from the heap one by one. It swaps the root (maximum element) with the last element of the heap, reduces the heap size by one, and then calls the `heapify` method to restore the heap property.

```java
    }

    private static void heapify(int[] arr, int n, int root) {
```

This line declares a private static method named `heapify`. This method takes three parameters: the input array `arr`, the size of the heap `n`, and the index of the root node `root`.

```java
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
```

Three integer variables are declared: `largest`, `leftChild`, and `rightChild`. `largest` is initialized with the index of the root node, while `leftChild` and `rightChild` store the indices of the left and right children of the root node, respectively.

```java
        // If the left child is larger than the root
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // If the right child is larger than the current largest
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
```

These conditional statements check if the left and right children of the root node exist and whether they are greater than the current largest element. If so, the `largest` variable is updated to reflect the index of the larger child.

```java
        // If the largest is not the root
        if (largest != root) {
            int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
```

If the largest element is not the root, a swap operation is performed between the root and the largest element. Then, the `heapify` method is recursively called on the affected subtree to ensure the heap property is maintained.

This concludes the explanation of the HeapSort algorithm implemented in the provided code. It constructs a max heap from the input array and then repeatedly extracts the maximum element to sort the array in ascending order.

-----