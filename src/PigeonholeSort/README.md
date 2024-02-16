# Pigeonhole Sort
-----

## Definition:-

Pigeonhole sort is a non-comparison sorting algorithm that works by distributing elements into "pigeonholes" based on their values. It is typically used for sorting lists of integers where the range of values is relatively small compared to the number of elements. The algorithm consists of two main steps: placing each element into its corresponding pigeonhole and then reconstructing the sorted array from the pigeonholes.
Pigeonhole sort has a time complexity of \(O(n + N)\), where \(n\) is the number of elements in the array and \(N\) is the range of values. It is suitable for sorting datasets with a small range of integer values.

-----

## Time Complexity Analysis:-

Pigeonhole sort has a time complexity of \(O(n + N)\), where \(n\) is the number of elements in the array and \(N\) is the range of values. This arises from iterating over the array once to place elements into pigeonholes and then reconstructing the sorted array from the pigeonholes.

-----

## Space Complexity Analysis:-

Pigeonhole sort has a space complexity of \(O(N)\), where \(N\) is the range of values present in the input array. This arises from the need to allocate memory for the pigeonholes, which are used to temporarily hold elements during the sorting process.
The size of the pigeonholes array is proportional to the range of values in the array, ensuring that each distinct value has its own storage space. While efficient for datasets with a limited range of values, the space required by the pigeonholes may become significant for arrays with a large range of values, limiting its applicability in memory-constrained environments. Nonetheless, pigeonhole sort's linear time complexity makes it efficient for sorting datasets with a relatively small range of values compared to the number of elements.

-----

## Advantages:-

1. **Linear Time Complexity**: Pigeonhole sort has a linear time complexity \(O(n + N)\), making it efficient for sorting datasets with a small range of values compared to the number of elements.

2. **Stable Sorting**: It is a stable sorting algorithm, meaning that elements with equal values maintain their relative order after sorting.

3. **Simple Implementation**: Pigeonhole sort is easy to understand and implement, requiring minimal complex logic compared to some other sorting algorithms.

----

## Dis-advantages:-

1. **Space Complexity**: Pigeonhole sort's space complexity is \(O(N)\), where \(N\) is the range of values in the input array, which can be significant for large ranges.

2. **Limited Applicability**: It is less suitable for datasets with a large range of values or when memory resources are limited due to its space complexity.

3. **Not In-Place**: Pigeonhole sort requires additional space for the pigeonholes, making it less memory-efficient compared to some in-place sorting algorithms, particularly for large datasets.

-----

## Uses:-

1. **Small Range Data Sorting**: Pigeonhole sort is ideal for sorting datasets with a small range of integer values efficiently.

2. **Stable Sorting Requirements**: When maintaining the relative order of equal elements is necessary, pigeonhole sort serves as a stable sorting algorithm.

3. **Educational Purposes**: Due to its simplicity, pigeonhole sort is often used in educational settings to introduce sorting algorithms and basic concepts of computer science.

4. **Preprocessing Step**: It can be employed as a preprocessing step in more complex algorithms or as part of a larger sorting strategy.

5. **Sorting in Limited Memory Environments**: Pigeonhole sort can be useful in situations where memory resources are limited, provided the range of values in the dataset is manageable.

-----

## Explanation of how the code works:

```java
import java.util.Arrays;

public class PigeonholeSort {
```

The code begins by defining a class named `PigeonholeSort`. It imports the `Arrays` class from the Java utility package to utilize array-related functions.

```java
    public static void pigeonholeSort(int[] array) {
```

Inside the class, there is a public static method named `pigeonholeSort`. This method takes an integer array `array` as input and is responsible for sorting the elements of the array using the Pigeonhole Sort algorithm.

```java
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        int range = max - min + 1;
```

The method calculates the minimum and maximum values present in the input array using the `min()` and `max()` methods of the `Arrays` class. It then computes the range of values in the array by subtracting the minimum from the maximum and adding 1 to account for zero-based indexing.

```java
        int[] pigeonholes = new int[range];
```

An integer array named `pigeonholes` is initialized with a size equal to the range of values in the array. This array will be used to temporarily hold elements during the sorting process.

```java
        // Place each element into its corresponding pigeonhole
        for (int value : array) {
            pigeonholes[value - min]++;
        }
```

Next, the method iterates through each element in the input array. For each element, it determines its corresponding pigeonhole by subtracting the minimum value from the element's value and increments the count in that pigeonhole.

```java
        // Reconstruct the sorted array from the pigeonholes
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (pigeonholes[i] > 0) {
                array[index] = i + min;
                pigeonholes[i]--;
                index++;
            }
        }
```

After placing all elements into their respective pigeonholes, the method reconstructs the sorted array by iterating through the pigeonholes array. For each non-empty pigeonhole, it updates the original array with the corresponding values, effectively sorting the array. Finally, the sorted array is returned.

This concludes the explanation of the PigeonholeSort algorithm implemented in the provided code. It efficiently sorts an array of integers with a small range of values by distributing elements into pigeonholes and reconstructing the sorted array from them.

-----