#  Smooth Sort
-----

## Definition:-

Smooth Sort is a comparison-based sorting algorithm that extends the concepts of Shell Sort and Heap Sort. It was designed to have similar average-case time complexity to Heap Sort while maintaining better performance on already sorted input sequences. The algorithm iteratively reduces the gap size (increment factor) in a manner similar to Shell Sort, using the so-called "Hamming numbers" to determine the gap sequence.
Within each iteration, Smooth Sort performs an insertion sort-like operation on subarrays with a specific gap size, gradually reducing the gap until it reaches 1, at which point the algorithm degenerates into a standard insertion sort. Smooth Sort operates in-place, making it suitable for sorting large datasets with limited additional memory overhead.

-----

## Time Complexity Analysis:-

Smooth Sort has a time complexity of O(n log n) in the average case. However, it can degrade to O(n^2) in the worst case. This behavior arises due to its similarity to insertion sort when the gap size becomes 1, leading to potential quadratic behavior. Nevertheless, Smooth Sort generally performs well on average due to its optimized gap sequence derived from Hamming numbers.

-----

## Space Complexity Analysis:-

Smooth Sort has a space complexity of O(1) since it operates in-place, meaning it does not require additional space proportional to the input size. The algorithm performs sorting operations directly on the input array without allocating any auxiliary data structures, resulting in minimal memory usage.

-----

## Advantages:-

1. **Adaptive**: Smooth Sort adjusts to the input data's characteristics, performing efficiently on partially sorted arrays.

2. **In-Place**: It sorts elements within the original array, requiring minimal additional memory regardless of input size.

3. **Stable**: Preserves the relative order of equal elements, ensuring stability in sorting results.

----

## Dis-advantages:-

1. **Worst-Case Complexity**: Smooth Sort can degrade to O(n^2) time complexity in unfavorable scenarios, such as nearly sorted data.

2. **Complex Implementation**: Implementing Smooth Sort can be intricate compared to simpler sorting algorithms.

3. **Limited Usage**: It is not widely used in practice due to its complexity and the availability of more efficient sorting algorithms.

-----

## Uses:-

1. **Partial Sorting**: Smooth Sort is suitable for partially sorted datasets where elements are already mostly ordered.

2. **Memory Efficiency**: It's beneficial for sorting large datasets with limited memory resources due to its in-place nature.

3. **Stability Requirement**: When maintaining the relative order of equal elements is necessary, Smooth Sort ensures stability in sorting.

4. **Educational Purposes**: It serves as an educational tool to understand advanced sorting algorithms and their intricacies.

5. **Research and Analysis**: Smooth Sort is used in academic research and algorithm analysis to explore sorting algorithms' behaviors and properties.

-----

## Explanation of how the code works:

```java
public class SmoothSort {
    public static void smoothSort(int[] array) {
```

This code defines a class named `SmoothSort` with a single static method `smoothSort`. The method takes an integer array `array` as input and aims to sort it using the Smooth Sort algorithm.

```java
        int n = array.length;

        int p = 1;
```

Here, `n` is assigned the length of the input array `array`, representing the number of elements to be sorted. `p` is initialized to 1, which will be used as the gap sequence during the sorting process.

```java
        while (p < n) {
            p = (3 * p) + 1;
        }
        p /= 3;
```

This part of the code calculates the initial value of `p` according to the Smooth Sort formula. It iteratively updates `p` until it exceeds the length of the array `n`. The final value of `p` is calculated by dividing it by 3, preparing it for the sorting phase.

```java
        while (p > 0) {
```

The sorting process begins here, entering a loop that continues until the gap size `p` becomes zero. This loop iterates over decreasing gap sizes, performing sorting operations for each gap size.

```java
            for (int i = p; i < n; i++) {
                int t = array[i];
                int j = i;
```

Within this loop, each element of the array starting from index `p` is considered for sorting. `t` temporarily stores the value of the current element, and `j` represents the current index being processed.

```java
                for (; j >= p && t < array[j - p]; j -= p) {
                    array[j] = array[j - p];
                }
```

Here, an insertion sort-like operation is performed within the gap size `p`. The loop shifts elements to the right within the gap until finding the correct position for the current element `t`. 

```java
                array[j] = t;
            }

            if (p == 1) {
                p = 0;
            } else {
                p /= 3;
            }
        }
    }
}
```

After sorting for the current gap size `p`, the value of `p` is updated according to the Smooth Sort formula. If `p` reaches 1, indicating the final iteration, it is set to 0 to exit the sorting loop.

In summary, this code efficiently implements the Smooth Sort algorithm, dynamically adjusting the gap size during sorting to achieve optimal performance. The insertion sort-like operation within each gap ensures that elements are gradually rearranged into their correct positions, resulting in a sorted array.

-----