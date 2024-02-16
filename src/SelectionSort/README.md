# Selection Sort
-----

## Definition:-

Selection sort is a simple comparison-based sorting algorithm that divides the input array into two sub-arrays: a sorted sub-array and an unsorted sub-array. It repeatedly selects the smallest (or largest) element from the unsorted sub-array and swaps it with the element at the beginning of the unsorted sub-array.
This process continues until the entire array is sorted. Selection sort has a time complexity of \(O(n^2)\), making it inefficient for large datasets, but it is easy to implement and requires minimal additional memory, as it performs sorting in-place.

-----

## Time Complexity Analysis:-

Selection sort has a time complexity of \(O(n^2)\), where \(n\) is the number of elements in the array. This is because it involves nested loops, iterating over the entire array to find the minimum element in each pass and performing \(n\) iterations for \(n\) elements in the array. Despite its simplicity, selection sort's time complexity makes it inefficient for sorting large datasets.

-----

## Space Complexity Analysis:-

Selection sort has a space complexity of \(O(1)\) because it operates directly on the input array without requiring additional space proportional to the size of the input. It sorts the array in place by swapping elements, so the amount of extra space used remains constant, regardless of the size of the input array. Therefore, selection sort is memory-efficient and suitable for situations where memory usage is a concern.

-----

## Advantages:-

1. **Simplicity**: Selection sort is easy to understand and implement due to its straightforward logic and minimalistic approach.

2. **In-Place Sorting**: It sorts the array in place, requiring only a constant amount of additional memory, making it memory-efficient, especially for large datasets.

3. **Stable**: Selection sort is a stable sorting algorithm, meaning it preserves the relative order of equal elements during sorting, which can be advantageous in certain scenarios.

----

## Dis-advantages:-

1. **Inefficiency**: Selection sort has a time complexity of \(O(n^2)\), making it inefficient for sorting large datasets, as it requires a quadratic number of comparisons and swaps.

2. **Lack of Adaptability**: It does not adapt to the input data, meaning it performs the same number of comparisons and swaps regardless of whether the input is partially sorted or completely unsorted.

3. **Unsuitable for Large Datasets**: Due to its quadratic time complexity, selection sort becomes increasingly inefficient as the size of the dataset grows, making it unsuitable for sorting large arrays compared to more efficient algorithms like merge sort or quick sort.

-----

## Uses:-

1. **Educational Use**: Often taught in computer science courses for its simplicity.

2. **Small Datasets**: Suitable for sorting small arrays due to its simplicity.

3. **Embedded Systems**: Used in environments with limited resources.

4. **Baseline Testing**: Can serve as a baseline for testing other sorting algorithms.

5. **Online Sorting**: Applied in scenarios requiring real-time sorting with minimal overhead.

-----

## Explanation of how the code works:

```java
public class SelectionSort {
```

This declares a class named `SelectionSort`. It encapsulates the selection sort algorithm.

```java
    public static void selectionSort(int[] arr) {
```

This line defines a method `selectionSort`, which takes an array of integers `arr` as input and returns void. This method will perform the selection sort algorithm on the input array.

```java
        int n = arr.length;
```

This initializes an integer `n` with the length of the input array `arr`, representing the number of elements in the array.

```java
        for (int i = 0; i < n - 1; i++) {
```

This line starts a loop that iterates over the array from index 0 to `n - 1`. This loop represents each pass of the selection sort algorithm.

```java
            int minIndex = i;
```

Inside the loop, `minIndex` is initialized to the current value of `i`, assuming that the current index `i` contains the minimum value.

```java
            for (int j = i + 1; j < n; j++) {
```

This nested loop iterates over the unsorted portion of the array, starting from index `i + 1`, to find the index of the minimum element.

```java
                if (arr[j] < arr[minIndex]) {
```

Within the nested loop, it checks if the element at index `j` is less than the element at `minIndex`. If so, it updates `minIndex` to `j`.

```java
                    minIndex = j;
                }
            }
```

At the end of the inner loop, `minIndex` will contain the index of the minimum element in the unsorted portion of the array.

```java
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
```

After finding the minimum element's index, the code swaps the element at index `i` with the minimum element found at index `minIndex`.

```java
        }
    }
}
```

This concludes the `selectionSort` method and the `SelectionSort` class definition. The method sorts the input array in ascending order using the selection sort algorithm.

-----