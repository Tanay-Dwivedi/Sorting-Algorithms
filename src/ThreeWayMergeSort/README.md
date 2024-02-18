#  Three Way Merge Sort
-----

## Definition:-

The Three-Way Merge Sort algorithm is an extension of the traditional merge sort, dividing the array into three parts instead of two. It recursively sorts each subarray individually, merging them back into a single sorted array. In the `ThreeWayMergeSort` class, the `threeWayMergeSort` method serves as the entry point, initializing an auxiliary array and calling the `mergeSort3Way` method to perform the sort.
The `mergeSort3Way` method recursively divides the array into three parts, sorts each part, and merges them. The `merge` method merges the sorted subarrays by comparing elements from each subarray and copying them into the auxiliary array in sorted order. Finally, the merged elements are copied back into the original array. This approach enhances merge sort's efficiency by reducing comparisons and swaps during merging, particularly beneficial for large arrays.

-----

## Time Complexity Analysis:-

The time complexity of the Three-Way Merge Sort algorithm is O(n log n) in the average and worst-case scenarios. This is because the algorithm recursively divides the array into three parts and merges them back together, similar to standard merge sort. The three-way partitioning reduces the number of comparisons needed during merging, but the overall time complexity remains the same.

-----

## Space Complexity Analysis:-

The space complexity of the Three-Way Merge Sort algorithm is O(n). This is because the algorithm requires additional space for an auxiliary array of the same size as the input array to perform the merging process. The space complexity remains linear with the size of the input array, regardless of the partitioning strategy used in the merge step.

-----

## Advantages:-

1. **Efficiency**: Three-way merge sort offers better performance compared to traditional merge sort when dealing with large datasets, as it reduces the number of comparisons and moves during the merge phase.
2. **Stability**: This sorting algorithm maintains the relative order of equal elements, making it stable for sorting applications where preserving the original order of equal elements is important.
3. **Adaptability**: Three-way merge sort can be adapted to various scenarios and datasets by adjusting the partitioning strategy in the merge step, allowing for optimization based on the characteristics of the input data.

----

## Dis-advantages:-

1. **Space Complexity**: Three-way merge sort requires additional space for an auxiliary array, increasing its space complexity compared to in-place sorting algorithms.
2. **Implementation Complexity**: Implementing the merge step for three partitions can be more complex and error-prone than standard merge sort, potentially leading to longer development and debugging times.
3. **Overhead**: The three-way merge process may introduce overhead due to additional comparisons and array movements, particularly in scenarios where the number of partitions is not optimal for the dataset, impacting performance.

-----

## Uses:-

1. **Large Datasets**: Three-way merge sort efficiently handles sorting large datasets, overcoming memory limitations encountered by traditional merge sort.
2. **External Sorting**: Adapted for external sorting, it's effective for sorting data too large to fit in memory, such as disk-based or external storage data.
3. **Parallel Processing**: Well-suited for parallel processing, it can leverage multi-core or distributed computing environments by efficiently dividing partitions among threads or processes.
4. **Optimized Merge**: With its capability to merge three partitions simultaneously, it's useful for optimizing merge operations, like merging multiple sorted streams or sequences.
5. **Stability**: Ensures stability by preserving the relative order of equal elements, making it suitable for sorting records or objects with multiple keys where maintaining order is crucial.

-----

## Explanation of how the code works:

```java
public class ThreeWayMergeSort {
```
This line declares the start of the `ThreeWayMergeSort` class. This class will contain methods for performing a three-way merge sort algorithm.

```java
    public static void threeWayMergeSort(int[] arr) {
```
This line declares a static method named `threeWayMergeSort`, which takes an array of integers `arr` as input. This method is responsible for initiating the three-way merge sort process.

```java
        if (arr == null || arr.length <= 1) {
            return;
        }
```
This block of code checks if the input array `arr` is null or has only one element. If either condition is true, there's no need to sort the array, so the method returns early.

```java
        int[] auxArray = new int[arr.length];
```
This line declares an auxiliary array `auxArray` with the same length as the input array `arr`. This auxiliary array will be used during the merge process to temporarily store sorted elements.

```java
        mergeSort3Way(arr, 0, arr.length, auxArray);
```
This line calls the `mergeSort3Way` method to perform the three-way merge sort on the input array `arr`. It passes the array, starting index (`0`), ending index (`arr.length`), and the auxiliary array.

```java
    private static void mergeSort3Way(int[] arr, int low, int high, int[] auxArray) {
```
This line declares a private static method named `mergeSort3Way`, responsible for recursively sorting the input array `arr` within a given range defined by `low` and `high` indices. It also takes an auxiliary array `auxArray` as input.

```java
        if (high - low < 2) {
            return;
        }
```
This block checks if the length of the sub-array is less than `2`. If it's `1` or `0`, the sub-array is already sorted, so the method returns early.

```java
        int mid1 = low + ((high - low) / 3);
        int mid2 = low + 2 * ((high - low) / 3) + 1;
```
These lines calculate the midpoints `mid1` and `mid2` of the current range `[low, high)` in the input array `arr`. These midpoints divide the array into three roughly equal-sized parts.

```java
        mergeSort3Way(arr, low, mid1, auxArray);
        mergeSort3Way(arr, mid1, mid2, auxArray);
        mergeSort3Way(arr, mid2, high, auxArray);
```
These lines recursively call `mergeSort3Way` on the three sub-arrays: `[low, mid1)`, `[mid1, mid2)`, and `[mid2, high)`. This step divides the array into smaller parts until each sub-array has `1` or `0` elements.

```java
        merge(arr, low, mid1, mid2, high, auxArray);
```
After sorting the sub-arrays, this line calls the `merge` method to merge the sorted sub-arrays back into the original array.

```java
    private static void merge(int[] arr, int low, int mid1, int mid2, int high, int[] auxArray) {
```
This line declares a private static method named `merge`, responsible for merging the sorted sub-arrays back into the original array. It takes the input array `arr`, starting index `low`, midpoints `mid1` and `mid2`, ending index `high`, and auxiliary array `auxArray` as parameters.

The `merge` method then proceeds to perform a three-way merge algorithm, combining the elements of the sub-arrays into a single sorted array.

```java
        if (high - low >= 0) System.arraycopy(auxArray, low, arr, low, high - low);
```
This line copies the sorted elements from the auxiliary array `auxArray` back to the original array `arr`, within the range `[low, high)`. It uses `System.arraycopy` to efficiently perform the copy operation.

```java
    }
}
```
These lines close the `merge` method and the `ThreeWayMergeSort` class definition.

-----