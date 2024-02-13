#  Cycle Sort
-----

## Definition:-

Cycle Sort is an in-place, unstable sorting algorithm that minimizes the number of memory writes by making use of cyclic rotations to sort the elements. The main idea behind Cycle Sort is to iterate through the array, placing each element in its correct sorted position, thereby forming cycles. This process continues until all elements are sorted. Cycle Sort has a time complexity of O(n^2), making it efficient for small datasets or when the number of memory writes is a concern.

-----

## Time Complexity Analysis:-

Cycle Sort's time complexity is O(n^2) on average, making it suitable for small datasets or situations where memory writes need to be minimized. Its performance can vary depending on the initial order of elements in the array. In the best-case scenario, when the array is already nearly sorted, Cycle Sort can achieve a time complexity closer to O(n).
However, in the worst-case scenario, where the array is in reverse order, the time complexity approaches O(n^2). Despite its quadratic time complexity, Cycle Sort's advantage lies in its ability to minimize the number of writes to memory, making it efficient in scenarios where memory write operations are costly.

-----

## Space Complexity Analysis:-

The space complexity of Cycle Sort is O(1), indicating that it requires constant extra space regardless of the size of the input array. This is because Cycle Sort performs sorting operations in-place, meaning it does not require any additional data structures or memory allocations proportional to the size of the input array.
Therefore, Cycle Sort is memory-efficient and suitable for sorting large datasets with limited available memory.

-----

## Advantages:-

1. **In-Place Sorting**: Cycle Sort operates directly on the input array without requiring additional memory, making it memory-efficient.

2. **Minimized Memory Writes**: It minimizes the number of writes to memory compared to other sorting algorithms, which can be advantageous in scenarios where memory write operations are expensive.

3. **Stable Sorting**: Cycle Sort preserves the relative order of equal elements, ensuring stability in sorting, which is beneficial in certain applications where maintaining the original order is important.

----

## Dis-advantages:-

1. **Quadratic Time Complexity**: Cycle Sort has a quadratic time complexity, O(n^2), making it less efficient for large datasets compared to algorithms with better time complexities.

2. **Unsuitable for Large Datasets**: Due to its quadratic time complexity, Cycle Sort may become impractical for sorting large datasets, as the execution time increases significantly.

3. **Unstable Sorting**: Cycle Sort is an unstable sorting algorithm, meaning it does not guarantee the preservation of the relative order of equal elements, which can be a drawback in certain applications where stability is required.

-----

## Uses:-

1. **Embedded Systems**: Cycle Sort is often used in embedded systems or low-resource environments where memory constraints are tight, as it requires minimal additional space.

2. **Data Streams**: It can be employed for sorting data streams where elements are continuously added, as it sorts the elements in-place without requiring additional memory allocations.

3. **Small Datasets**: Cycle Sort is suitable for sorting small datasets efficiently, especially when the number of elements is relatively small and memory write operations need to be minimized.

4. **Low-Level Programming**: It is commonly used in low-level programming scenarios, such as firmware development or device drivers, where direct manipulation of memory is essential.

5. **Educational Purposes**: Cycle Sort serves as an educational tool to understand sorting algorithms and their implementations due to its simplicity and ease of comprehension.

-----

## Explanation of how the code works:

```java
public class CycleSort {
```
- Declares a public class named `CycleSort`.

```java
    public static void cycleSort(int[] arr) {
```
- Declares a public static method named `cycleSort` that takes an array of integers `arr` as input and returns nothing.

```java
        if (arr == null || arr.length <= 1) {
            return;
        }
```
- Checks if the input array is null or has only one element. If so, the method returns immediately as there's nothing to sort.

```java
        int n = arr.length;
```
- Assigns the length of the input array `arr` to the variable `n`.

```java
        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {
```
- Initiates a loop that iterates over each element in the array except the last one. The loop variable `cycleStart` represents the starting index of the current cycle.

```java
            int item = arr[cycleStart];
            int pos = cycleStart;
```
- Retrieves the element at the current cycle start (`cycleStart`) and initializes a variable `pos` to store its position.

```java
            for (int i = cycleStart + 1; i < n; i++) {
```
- Initiates a nested loop that iterates over the remaining elements in the array.

```java
                if (arr[i] < item) {
                    pos++;
                }
            }
```
- Checks if the current element (`arr[i]`) is less than the current cycle start element (`item`). If so, increments the position (`pos`) to reflect the new correct position for the current element.

```java
            if (pos == cycleStart) {
                continue;
            }
```
- Checks if the current element is already in its correct position. If so, continues to the next iteration of the outer loop.

```java
            while (item == arr[pos]) {
                pos++;
            }
```
- Finds the next available position for the current element by iterating until reaching an element that is not equal to `item`.

```java
            int temp = arr[pos];
            arr[pos] = item;
            item = temp;
```
- Swaps the current element with the element at the new position (`pos`) and updates `item` with the element that was previously at the new position.

```java
            while (pos != cycleStart) {
                pos = cycleStart;
```
- Initiates another loop to handle the remaining elements in the current cycle, starting with the cycle start index.

```java
                for (int i = cycleStart + 1; i < n; i++) {
```
- Initiates a nested loop that iterates over the remaining elements in the array within the current cycle.

```java
                    if (arr[i] < item) {
                        pos++;
                    }
                }
```
- Similar to the previous loop, increments the position (`pos`) for elements that are less than `item`.

```java
                while (item == arr[pos]) {
                    pos++;
                }
```
- Finds the next available position for the current element within the current cycle.

```java
                temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
```
- Swaps the current element with the element at the new position within the current cycle and updates `item` accordingly.

```java
        }
    }
}
```
- Closes the method and class.

-----