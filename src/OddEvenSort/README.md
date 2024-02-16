#  Odd Even Sort
-----

## Definition:-

Odd-even sort, also known as brick sort or parity sort, is a parallel sorting algorithm that operates by iteratively comparing and swapping adjacent elements in a list. It is a variation of bubble sort and performs two phases: the odd phase and the even phase. In the odd phase, it compares and swaps elements at odd indices (1, 3, 5, ...) with their adjacent elements. Similarly, in the even phase, it compares and swaps elements at even indices (0, 2, 4, ...) with their adjacent elements.
This process continues until the list becomes sorted. Odd-even sort is simple to implement and has a time complexity of \(O(n^2)\) in the worst case. It is often used in parallel computing environments due to its inherent parallelism.

-----

## Time Complexity Analysis:-

Odd-even sort has a time complexity of \(O(n^2)\) in the worst case, similar to bubble sort, where \(n\) is the number of elements in the array. This complexity arises because the algorithm iterates through the array multiple times, comparing and swapping adjacent elements until the array is sorted. Despite its simplicity, odd-even sort is not as efficient as other sorting algorithms, such as quicksort or merge sort, for larger datasets.

-----

## Space Complexity Analysis:-

Odd-even sort has a space complexity of \(O(1)\), indicating that it requires constant additional space regardless of the size of the input array. This is because the algorithm operates in-place, modifying the input array without requiring additional memory proportional to the size of the array. Therefore, odd-even sort is memory-efficient and suitable for sorting large datasets with limited memory resources.

-----

## Advantages:-

1. **Simple**: Odd-even sort is straightforward to implement, making it suitable for educational purposes and simple sorting tasks.
  
2. **In-Place**: It sorts elements within the input array itself, requiring only constant extra space, which is memory-efficient.
  
3. **Parallelizable**: Odd-even sort's parallel nature allows for efficient execution on parallel computing environments or multi-core processors, potentially enhancing performance.

----

## Dis-advantages:-

1. **Inefficiency**: Odd-even sort has a time complexity of \(O(n^2)\) in the worst case, making it inefficient for large datasets compared to more efficient algorithms.

2. **Limited Applicability**: It may not be suitable for all types of data or sorting scenarios, particularly when efficiency is a primary concern.

3. **Sequential Nature**: Despite its potential for parallelization, odd-even sort may not always achieve significant performance gains on systems with limited parallel processing capabilities.

-----

## Uses:-

1. **Educational Use**: Commonly employed for educational purposes due to its simplicity, aiding in understanding sorting algorithms.

2. **Small Datasets**: Suitable for efficiently sorting small datasets when simplicity is prioritized over performance.

3. **Parallel Computing**: Utilized in parallel computing environments for its inherent parallelism, allowing concurrent sorting across multiple processors.

4. **Embedded Systems**: In-place nature and low space complexity make it suitable for sorting in memory-constrained environments, like embedded systems.

5. **Baseline Testing**: Used as a reference sorting algorithm for debugging and testing more complex sorting algorithms.

-----

## Explanation of how the code works:

```java
public class OddEvenSort {
```

This code defines a class named `OddEvenSort`.

```java
    public static void oddEvenSort(int[] arr) {
```

Inside the class, there is a public static method named `oddEvenSort`. This method takes an integer array `arr` as input and is responsible for sorting the elements of the array using the odd-even sort algorithm.

```java
        int n = arr.length;
        boolean sorted = false;
```

The method starts by getting the length of the input array `arr` and initializing a boolean variable `sorted` to `false`. This variable will be used to track whether any swaps are made during the sorting process.

```java
        while (!sorted) {
            sorted = true;
```

A while loop is initiated, which continues until the array is fully sorted. At the beginning of each iteration, `sorted` is set to `true`, assuming the array is already sorted unless proven otherwise.

```java
            // Perform the odd phase (comparing and swapping odd-indexed elements)
            for (int i = 1; i <= n - 2; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    sorted = false;
                }
            }
```

Within the loop, an odd phase is performed, where elements at odd indices are compared with their adjacent elements. If an element is greater than its adjacent element, they are swapped, and `sorted` is set to `false` to indicate that a swap occurred.

```java
            // Perform the even phase (comparing and swapping even-indexed elements)
            for (int i = 0; i <= n - 2; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    sorted = false;
                }
            }
```

Following the odd phase, an even phase is executed. Similar to the odd phase, elements at even indices are compared and swapped if necessary. Again, `sorted` is set to `false` if any swaps occur.

```java
        }
    }
```

The loop continues until no swaps are made during both the odd and even phases, indicating that the array is fully sorted.

```java
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

Finally, there is a private static method named `swap`, which takes an array `arr` and two indices `i` and `j`. This method is responsible for swapping the elements at positions `i` and `j` in the array. It is called within the `oddEvenSort` method to perform the element swaps during the sorting process.

This concludes the explanation of the OddEvenSort algorithm implemented in the provided code. It iteratively performs odd and even phases of comparisons and swaps until the array is fully sorted.

-----