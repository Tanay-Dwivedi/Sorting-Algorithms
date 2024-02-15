#  Insertion Sort
-----

## Definition:-

Insertion sort is a simple comparison-based sorting algorithm that builds the final sorted array one element at a time. It iterates through the array, selecting one element at a time and placing it in its correct position within the already sorted portion of the array. At each iteration, the selected element is compared with the elements in the sorted portion, and if necessary, elements are shifted to the right to make space for the selected element.
This process continues until all elements are sorted. Insertion sort has a time complexity of \(O(n^2)\) in the worst case and \(O(n)\) in the best case, making it efficient for small datasets or partially sorted arrays.

-----

## Time Complexity Analysis:-

Insertion sort has a time complexity of \(O(n^2)\) in the worst case scenario, where \(n\) is the number of elements in the input array. This complexity arises because, in the worst case, each element needs to be compared and potentially moved to its correct position within the sorted portion of the array. However, in the best case scenario where the array is already sorted, Insertion sort has a time complexity of \(O(n)\), making it efficient for nearly sorted arrays or small datasets.

-----

## Space Complexity Analysis:-

Insertion sort has a space complexity of \(O(1)\), indicating that it requires constant additional space regardless of the size of the input array. This is because the algorithm operates in-place, modifying the input array without requiring additional memory proportional to the size of the array. Therefore, Insertion sort is memory-efficient and suitable for sorting large datasets with limited memory resources.

-----

## Advantages:-

1. **Simple**: Insertion sort's straightforward implementation makes it easy to understand and implement.

2. **Efficient for Small Data**: It excels with small datasets or nearly sorted lists due to its \(O(n)\) best-case time complexity.

3. **Adaptive**: Insertion sort adapts efficiently to partially sorted arrays, performing well in real-world scenarios.

----

## Dis-advantages:-

1. **Quadratic Time Complexity**: Insertion sort's time complexity is \(O(n^2)\) in the worst case, making it inefficient for large datasets.

2. **Not Suitable for Large Data**: Its performance degrades significantly with larger datasets compared to more efficient algorithms like merge sort or quicksort.

3. **High Sensitivity to Input Order**: Insertion sort's performance heavily depends on the initial order of elements, leading to varying efficiency for different input distributions.

-----

## Uses:-

1. **Small Data Sets**: Insertion sort is suitable for sorting small arrays efficiently due to its simplicity and \(O(n)\) best-case time complexity.

2. **Online Algorithms**: It's used in scenarios where data is continuously arriving and needs to be sorted incrementally, as Insertion sort efficiently incorporates new elements into the sorted portion of the array.

3. **Hybrid Algorithms**: Insertion sort is often used as a component in hybrid sorting algorithms like Timsort, which combines insertion sort with merge sort to achieve better performance.

4. **Nearly Sorted Data**: It performs well on nearly sorted or partially sorted lists, making it useful in situations where data exhibits some level of pre-ordering.

5. **Teaching and Learning**: Insertion sort is commonly used in educational settings to introduce the concept of sorting algorithms due to its simplicity and ease of implementation.

-----

## Explanation of how the code works:

```java
public class InsertionSort {
```

This code declares a class named `InsertionSort`.

```java
    public static void insertionSort(int[] arr) {
```

Within the class, there is a public static method named `insertionSort`. This method takes an integer array `arr` as input and is responsible for sorting the elements of the array using the Insertion sort algorithm.

```java
        int n = arr.length;
```

Here, an integer variable `n` is declared and assigned the length of the input array `arr`.

```java
        for (int i = 1; i < n; i++) {
```

This loop iterates through the array starting from the second element (`i = 1`) and continues until the last element.

```java
            // Store the current element to be inserted into the sorted portion of the array
            int currentElement = arr[i];
            int j = i - 1;
```

Within the loop, the current element to be inserted into the sorted portion of the array is stored in the variable `currentElement`. Additionally, an integer variable `j` is initialized to `i - 1` to track the position where `currentElement` should be inserted.

```java
            // Move elements of the sorted portion of the array that are greater than the current element
            // to the right by one position
            while (j >= 0 && arr[j] > currentElement) {
                arr[j + 1] = arr[j];
                j--;
            }
```

This nested while loop iterates backwards through the sorted portion of the array, shifting elements to the right if they are greater than `currentElement`. This creates space for `currentElement` to be inserted at the correct position within the sorted portion of the array.

```java
            // Insert the current element into its correct position in the sorted portion of the array
            arr[j + 1] = currentElement;
        }
    }
}
```

After finding the correct position for `currentElement`, it is inserted into the array at `j + 1`, which is its correct position within the sorted portion of the array.

This concludes the explanation of the InsertionSort algorithm implemented in the provided code. It iteratively builds the sorted portion of the array by inserting each element into its correct position, resulting in a fully sorted array at the end of the process.

-----