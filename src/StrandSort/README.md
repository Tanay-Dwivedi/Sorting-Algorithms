#  Strand Sort
-----

## Definition:-

Strand Sort is a comparison-based sorting algorithm that recursively divides the input list into sorted sublists and merges them back together until the entire list is sorted. It works by repeatedly extracting elements from the input list that are in increasing order, building sorted sublists, and merging them back into the input list.
The algorithm operates in-place and is stable, meaning it preserves the relative order of equal elements. However, it has a worst-case time complexity of O(n^2) and a best-case time complexity of O(n), making it less efficient than some other sorting algorithms for large datasets.

-----

## Time Complexity Analysis:-

The time complexity of Strand Sort is O(n^2) in the worst-case scenario and O(n) in the best-case scenario, where n is the number of elements in the input list.

-----

## Space Complexity Analysis:-

The space complexity of Strand Sort is O(n), where n is the number of elements in the input list. This is because the algorithm requires additional space to store intermediate sublists during the sorting process.

-----

## Advantages:-

1. **Simplicity:** Strand Sort is relatively easy to understand and implement compared to more complex sorting algorithms.
2. **Adaptive:** It performs well on partially sorted or nearly sorted lists, adapting its runtime to the existing order of elements.
3. **Stable:** Strand Sort maintains the relative order of equal elements, making it a stable sorting algorithm.

----

## Dis-advantages:-

1. **Inefficient for Large Data Sets:** Strand Sort has a time complexity of O(n^2) in the worst case, making it inefficient for large data sets.
2. **Extra Space Usage:** It requires additional space for creating sublists, which can be inefficient for sorting large arrays or lists.
3. **Not In-Place:** Strand Sort is not an in-place sorting algorithm, meaning it requires extra space proportional to the size of the input array or list.

-----

## Uses:-

1. **Small Data Sets:** It can be suitable for sorting small data sets where simplicity and ease of implementation are prioritized over efficiency.
2. **Educational Purposes:** Strand Sort can be used in educational settings to demonstrate sorting algorithms due to its simplicity.
3. **Hybrid Algorithms:** It can be incorporated as a component in hybrid sorting algorithms to improve their performance or stability.
4. **Embedded Systems:** In environments with limited resources such as embedded systems, Strand Sort's simplicity and low memory overhead may make it a viable option.
5. **Sorting Linked Lists:** It can be applied to sort linked lists efficiently since it does not require random access to elements.

-----

## Explanation of how the code works:

```java
   import java.util.*;
   ```
   - This line imports all classes from the `java.util` package, including `ArrayList` and `ListIterator`, which are needed for the implementation of the Strand Sort algorithm.

   ```java
   public class StrandSort {
   ```
   - This line defines the `StrandSort` class.

   ```java
   public static void strandSort(int[] arr) {
   ```
   - This line declares the `strandSort` method, which takes an array of integers as input and returns void.

   ```java
   List<Integer> al = new ArrayList<>();
   ```
   - This line creates a new `ArrayList` named `al` to store the elements of the input array.

   ```java
   for (int aa : arr) {
       al.add(aa);
   }
   ```
   - This loop iterates over each element in the input array `arr` and adds it to the `ArrayList` `al`.

   ```java
   ss(al);
   ```
   - This line calls the `ss` method to perform the sorting on the `ArrayList`.

   ```java
   for (int i = 0; i < al.size(); i++) {
       arr[i] = al.get(i);
   }
   ```
   - This loop iterates over each element in the `ArrayList` `al` and updates the corresponding element in the original array `arr`.

   ```java
   public static void ss(List<Integer> ip) {
   ```
   - This line declares the `ss` method, which takes a `List` of integers as input and returns void.

```java
    List<Integer> sublist = new ArrayList<>();
```
- This line creates a new `ArrayList` named `sublist` to store the sorted sublist.

```java
    sublist.add(ip.get(0));
```
- This line adds the first element of theinput list `ip` to the sublist.
```java
ListIterator<Integer> it = ip.listIterato();
```
- This line initializes a `ListIterator` totraverse the remaining elements of theinput list.
```java
while (it.hasNext()) {
```
- This loop iterates through the remainingelements of the input list.

```java
if (it.next() > sublist.get(sublist.size()- 1)) {
    sublist.add(it.previous());
    it.remove();
}
```
- This condition checks if the currentelement of the input list is greater thanthe last element of the sublist. If true,it adds the current element to the sublistin sorted order.

    ```java
    if (!ip.isEmpty()) {
        ss(ip);
    }
    ```
    - This line recursively calls the `ss` method with the remaining elements of the input list if it's not empty.

    ```java
    ip.addAll(sublist);
    ```
    - This line merges the current sublist into the input list.

This breakdown explains how each part of the code contributes to the implementation of the Strand Sort algorithm.

-----