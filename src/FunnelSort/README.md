#  Funnel Sort
-----

## Definition:-

Funnel sort is a parallel sorting algorithm that divides an array into smaller subarrays, sorts each subarray independently, and then merges them using a specialized funnel merging process, where elements are interleaved in a specific pattern to achieve the final sorted order.
This algorithm aims to leverage parallelism efficiently and is particularly suitable for parallel architectures or multi-core systems.

-----

## Time Complexity Analysis:-

The time complexity of funnel sort is \( O(n \log n) \), where \( n \) is the number of elements in the input array. This complexity arises from the sorting step, typically performed with algorithms like quicksort or mergesort, which have a time complexity of \( O(n \log n) \). The merging step also contributes to the overall time complexity but is typically linear \( O(n) \) due to the interleaved nature of the merging process. Therefore, the dominant factor is the sorting step, leading to a time complexity of \( O(n \log n) \).

-----

## Space Complexity Analysis:-

The space complexity of funnel sort is \( O(n) \), where \( n \) is the number of elements in the input array. This space complexity arises primarily from the need to allocate additional memory for the buffer array used during the merging process. Additionally, some auxiliary space may be required for variables like counters and offsets during the sorting and merging steps. However, the space required is proportional to the size of the input array, making the space complexity linear with respect to \( n \).

-----

## Advantages:-

1. **Parallel Efficiency**: Funnel sort efficiently utilizes parallelism, dividing and sorting subarrays independently before merging, ideal for parallel architectures.
  
2. **Stability**: It preserves the relative order of equal elements, crucial for maintaining original data structures like records with multiple keys.
  
3. **Hardware Adaptability**: Funnel sort's design is adaptable to different hardware configurations, optimizing performance for specific architectures and processing units.

----

## Dis-advantages:-

1. **Space Overhead**: Funnel sort's buffer array during merging increases space complexity.
  
2. **Variable Efficiency**: It may not always surpass other algorithms like quicksort, especially for small inputs or single-core systems.
  
3. **Complex Implementation**: Implementing funnel sort correctly can be complex, requiring careful handling of parallelism and merging processes, potentially increasing development time and code complexity.

-----

## Uses:-

1. **Parallel Computing**: Funnel sort is valuable for parallel architectures, exploiting parallelism efficiently.

2. **Stable Sorting**: Its stability is useful when preserving the order of equivalent elements is critical.

3. **Multi-Key Sorting**: Ideal for sorting records with multiple keys while maintaining their original order.

4. **Adaptive Hardware**: Funnel sort adapts well to diverse hardware configurations, optimizing performance.

5. **Data Warehousing**: Suitable for sorting large datasets efficiently, making it relevant in data warehousing applications.

-----

## Explanation of how the code works:

```java
import java.util.Arrays;
```

The code begins with importing the `Arrays` class from the Java standard library. The `Arrays` class provides utility methods for working with arrays in Java.

```java
public class FunnelSort {
```

Next, a public class named `FunnelSort` is declared. This class contains a single static method `funnelSort`, which performs the sorting operation.

```java
public static void funnelSort(int[] array) {
```

The `funnelSort` method is defined to accept an integer array `array` as input. This method is responsible for sorting the elements of the input array using the FunnelSort algorithm.

```java
int n = array.length;

if (n <= 1) {
    return;
}
```

The length of the input array is stored in the variable `n`. If the length of the array is less than or equal to 1, indicating that the array is already sorted or contains only one element, the method returns early without performing any further operations.

```java
int maxVal = Arrays.stream(array).max().getAsInt();
int bitCount = 0;

while ((1 << bitCount) <= maxVal) {
    bitCount++;
}
```

The maximum value (`maxVal`) in the input array is determined using the `max()` method of the `Arrays` class. Then, the number of bits (`bitCount`) required to represent the maximum value is calculated. This is done by finding the smallest integer `bitCount` such that \( 2^{bitCount} \) is greater than `maxVal`.

```java
int[] buffer = new int[n];
int shift = 0;
int mask = (1 << bitCount) - 1;
```

An auxiliary array `buffer` of the same length as the input array is created to store intermediate results during the sorting process. Additionally, variables `shift` and `mask` are initialized. The `mask` is used to extract the relevant bits during the sorting process.

```java
for (int i = 0; i < bitCount; i++) {
```

A loop iterates `bitCount` times, corresponding to the number of bits needed to represent the maximum value in the array. This loop performs the sorting process.

```java
int[] count = new int[1 << bitCount];
int[] offset = new int[1 << bitCount];
```

Inside the loop, two auxiliary arrays `count` and `offset` are created, each with a size of \(2^{bitCount}\). These arrays are used to count the occurrences of values and calculate offsets during the sorting process.

```java
for (int value : array) {
    count[(value >> shift) & mask]++;
}
```

A nested loop iterates through each element of the input array `array`. For each element, the count of occurrences is incremented in the `count` array based on the value's position after applying the bit shift and mask operations.

```java
offset[0] = 0;
for (int j = 1; j < (1 << bitCount); j++) {
    offset[j] = offset[j - 1] + count[j - 1];
}
```

After counting the occurrences of each value, the `offset` array is populated. The `offset` array stores the starting positions for each value in the sorted order, facilitating the movement of elements into the buffer array.

```java
for (int value : array) {
    buffer[offset[(value >> shift) & mask]++] = value;
}
```

Another loop iterates through each element of the input array. For each element, its position in the sorted order is determined using the `offset` array, and the element is placed in the buffer array accordingly.

```java
int[] temp = array;
array = buffer;
buffer = temp;

shift += bitCount;
```

After sorting based on the current bit position, the `array` and `buffer` arrays are swapped, and the `shift` value is updated to move to the next bit position.

```java
if (array != buffer) {
    System.arraycopy(array, 0, buffer, 0, n);
}
```

Finally, if the `array` and `buffer` arrays are not the same (indicating that a swap occurred during the last iteration), the sorted array is copied from the `array` array to the `buffer` array using `System.arraycopy()`.

This concludes the explanation of the FunnelSort algorithm implemented in the provided code. It effectively sorts an input array in ascending order using a bitwise radix sort approach, leveraging parallelism and intermediate buffers for efficient sorting.

-----