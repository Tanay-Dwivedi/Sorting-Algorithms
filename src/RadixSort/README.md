#  Radix Sort
-----

## Definition:-

Radix sort is a non-comparison sorting algorithm that sorts elements by their individual digits or place values. It processes the elements one digit at a time, from the least significant digit (LSD) to the most significant digit (MSD) or vice versa, using a stable sorting algorithm like counting sort or bucket sort at each digit place. Radix sort performs sorting based on the digits of the elements, sorting them into buckets or groups according to their place values, such as units, tens, hundreds, etc.
By repeatedly sorting the elements based on each digit place, radix sort achieves a sorted array where the elements are sorted according to their entire numerical value. Radix sort is often used for sorting integer arrays with fixed-length keys, such as strings of fixed length or integer representations of data. It has a time complexity of \(O(d \times (n + k))\), where \(d\) is the number of digits or the key length, \(n\) is the number of elements, and \(k\) is the range of values for each digit place.

-----

## Time Complexity Analysis:-

Radix sort has a time complexity of \(O(d \times (n + k))\), where \(d\) is the number of digits or the key length, \(n\) is the number of elements, and \(k\) is the range of values for each digit place. It is efficient for sorting integer arrays with fixed-length keys, such as strings of fixed length or integer representations of data.

-----

## Space Complexity Analysis:-

Radix sort typically has a space complexity of \(O(n + k)\), where \(n\) is the number of elements and \(k\) is the range of values for each digit place. This space complexity arises from the need for additional storage to perform counting sort or bucket sort for each digit place. The space required is proportional to the number of elements in the input array and the range of values for each digit place.

-----

## Advantages:-

1. **Linear Time Complexity**: Radix sort achieves linear time complexity for integer arrays with fixed-length keys, making it efficient for large datasets.
  
2. **Stable Sorting**: It is a stable sorting algorithm, preserving the relative order of equal elements during sorting.
  
3. **Suitable for Fixed-Length Keys**: Radix sort is well-suited for sorting data with fixed-length keys, such as integers or strings of fixed length, where other sorting algorithms may be less efficient.

----

## Dis-advantages:-

1. **Space Complexity**: Radix sort may require significant additional storage, especially for datasets with a wide range of values.

2. **Limited Applicability**: It's primarily suitable for fixed-length keys and integer data, limiting its versatility compared to other sorting algorithms.

3. **Key Length Dependency**: Radix sort's efficiency can be impacted by the length of keys or digits in the dataset, potentially affecting its performance.

-----

## Uses:-

1. **Sorting Integer Arrays**: Radix sort is commonly used to sort arrays of integers efficiently.

2. **Fixed-Length Key Sorting**: It's employed for sorting data with fixed-length keys, such as strings of fixed length or integer representations.

3. **Database Management**: Radix sort is utilized in database systems for sorting large volumes of data, enhancing query performance and data retrieval.

4. **File System Organization**: File systems use radix sort to organize files and directories alphabetically or numerically, facilitating faster file access and management.

5. **Numerical Analysis**: Radix sort finds applications in numerical analysis and scientific computing for sorting numerical data, enhancing computational efficiency in various algorithms and simulations.

-----

## Explanation of how the code works:

```java
import java.util.Arrays;
```
The code imports the `Arrays` class from the Java utility package, which provides methods for working with arrays, such as finding the maximum value in an array.

```java
public class RadixSort {
```
Here, a public class named `RadixSort` is defined, which will contain the implementation of the radix sort algorithm.

```java
    public static void radixSort(int[] arr) {
```
The `radixSort` method is declared, which takes an integer array `arr` as input and sorts it using the radix sort algorithm.

```java
        if (arr == null || arr.length <= 1) {
            return; // The array is already sorted or empty
        }
```
The method checks if the input array is null or has only one element. If so, it returns immediately as the array is considered already sorted or empty.

```java
        int max = Arrays.stream(arr).max().getAsInt(); // Find the maximum value
        int digitPlace = 1;
```
The code finds the maximum value in the input array using the `max()` method from the `Arrays` class and stores it in the variable `max`. It initializes the `digitPlace` variable to `1`, representing the place value of the least significant digit.

```java
        while (max / digitPlace > 0) {
            countingSortByDigit(arr, digitPlace);
            digitPlace *= 10;
        }
```
A `while` loop is used to iterate through each digit place from the least significant digit (LSD) to the most significant digit (MSD). For each digit place, it calls the `countingSortByDigit` method to perform counting sort on the array based on the current digit place. After sorting for all digit places, the array becomes fully sorted.

```java
    private static void countingSortByDigit(int[] arr, int digitPlace) {
```
The `countingSortByDigit` method is declared, which takes the input array `arr` and the current digit place as parameters. This method performs counting sort on the array based on the specified digit place.

```java
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // Counting array for digits 0-9
```
The method initializes an output array `output` with the same size as the input array `arr`. It also initializes a counting array `count` with a size of `10`, corresponding to the digits `0` to `9`.

```java
        for (int j : arr) {
            int digit = (j / digitPlace) % 10;
            count[digit]++;
        }
```
A loop iterates through each element of the input array. For each element, it calculates the digit at the current digit place using integer division and modulus operations, then increments the count in the `count` array for that digit.

```java
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
```
This loop calculates the cumulative counts in the `count` array. Each element `count[i]` stores the position where elements with digit `i` should be placed in the output array, ensuring stable sorting.

```java
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / digitPlace) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
```
The loop iterates backward through the input array. For each element, it calculates the digit at the current digit place and uses the count array to determine the correct position for the element in the output array. It then decrements the count for that digit to handle duplicate elements.

```java
        System.arraycopy(output, 0, arr, 0, n);
```
Finally, the sorted elements are copied from the output array back to the original input array using the `System.arraycopy` method.

This completes the explanation of the Radix Sort algorithm implemented in the provided code. Radix Sort sorts elements based on their individual digits or place values, from the least significant digit (LSD) to the most significant digit (MSD), using counting sort at each digit place to achieve a fully sorted array.

-----