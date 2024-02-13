#  Counting Sort
-----

## Definition:-

Counting Sort is a non-comparison-based sorting algorithm that operates by counting the frequency of each distinct element in the input array and using this information to place the elements in sorted order. It is efficient when the range of input values is not significantly larger than the number of elements to be sorted.

-----

## Time Complexity Analysis:-

The time complexity of Counting Sort is O(n + k), where n is the number of elements in the input array and k is the range of the input values (the difference between the maximum and minimum values). This time complexity arises from the two main operations performed in Counting Sort:

1. Counting the frequencies of each element in the input array: This operation requires iterating through the entire input array once, resulting in O(n) time complexity.

2. Building the sorted output array: This operation involves iterating through the count array, which has a size proportional to the range of input values (k). Therefore, it has a time complexity of O(k).

Overall, the time complexity of Counting Sort is determined by the larger of the two operations, resulting in a time complexity of O(n + k). In practice, Counting Sort is efficient when the range of input values is relatively small compared to the number of elements to be sorted.

-----

## Space Complexity Analysis:-

The space complexity of Counting Sort is O(n + k), where n is the number of elements in the input array and k is the range of the input values (the difference between the maximum and minimum values). This space complexity arises from the following:

1. Count array: A count array is created to store the frequencies of each element in the input array. The size of this count array is determined by the range of input values (k), resulting in O(k) space complexity.

2. Output array: An output array is created to store the sorted elements. Its size is equal to the number of elements in the input array (n), resulting in O(n) space complexity.

Therefore, the total space complexity is the sum of the space required for the count array and the output array, which is O(n + k). In practice, Counting Sort is memory-efficient for scenarios where the range of input values is relatively small compared to the number of elements to be sorted.

-----

## Advantages:-

1. **Linear Time Complexity**: Counting Sort operates in linear time, O(n + k), making it highly efficient.
  
2. **Stable Sorting**: It preserves the relative order of equal elements, ensuring stability in sorting.

3. **Effective for Limited Ranges**: Counting Sort performs well when the range of input values is small compared to the number of elements.

----

## Dis-advantages:-

1. **Space Complexity**: Requires additional memory for the count array, making it inefficient for large ranges of input values.

2. **Limited Applicability**: Not suitable for sorting data with large ranges or floating-point numbers due to memory constraints.

3. **Not In-place**: Counting Sort typically requires additional space for the count array and output array, making it less memory-efficient than in-place sorting algorithms.

-----

## Uses:-

1. **Sorting Integers with Limited Range**: Counting Sort is highly effective for sorting integer arrays with a limited range of values, such as grades (0-100), ages, or product IDs.

2. **Histogram Generation**: It is utilized to generate histograms by counting occurrences of elements in a dataset, facilitating data analysis and visualization.

3. **Data Preprocessing**: Counting Sort serves as a preprocessing step in more complex algorithms, such as radix sort or bucket sort, to sort subranges efficiently.

4. **Sorting Characters**: Counting Sort can be applied to sort arrays of characters or strings, especially when the alphabet size is small, such as sorting strings based on ASCII values.

5. **External Sorting**: In certain scenarios, where data exceeds available memory, Counting Sort can be adapted for external sorting, efficiently sorting large datasets stored on disk by reading and writing blocks of data.

-----

## Explanation of how the code works:

```java
public class CountingSort {
```
- Defines a public class named `CountingSort`.

```java
    public static void countingSort(int[] arr) {
```
- Declares a public static method named `countingSort` which takes an array of integers `arr` as input and returns nothing.

```java
        if (arr == null || arr.length <= 1) {
            return;
        }
```
- Checks if the input array is null or has only one element. If so, it exits the method early as the array is already sorted or empty.

```java
        int max = arr[0];
        int min = arr[0];
```
- Initializes two variables, `max` and `min`, with the first element of the input array.

```java
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
```
- Iterates through the input array to find the maximum and minimum values.

```java
        int range = max - min + 1;
```
- Calculates the range of values in the input array.

```java
        int[] count = new int[range];
        int[] output = new int[arr.length];
```
- Initializes two arrays: `count`, which stores the frequency of each element, and `output`, which will store the sorted elements.

```java
        for (int j : arr) {
            count[j - min]++;
        }
```
- Counts the frequency of each element in the input array and stores it in the `count` array.

```java
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
```
- Calculates the cumulative frequency of each element in the `count` array.

```java
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
```
- Builds the output array by placing each element from the input array into its correct position based on the count array.

```java
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
```
- Copies the sorted elements from the `output` array back into the original input array. Finally, closes the method and class.

-----