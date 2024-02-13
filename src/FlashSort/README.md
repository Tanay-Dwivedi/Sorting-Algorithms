#  Flash Sort
-----

## Definition:-

Flash Sort is a distribution-based sorting algorithm that divides the input array into classes, based on their values, and sorts them accordingly. It operates by determining the minimum and maximum values in the array and dividing the range into equal-sized classes. Each element is then placed into its corresponding class, and the counts of elements in each class are calculated. Finally, the elements are sorted within each class and copied back to the original array. Flash Sort is efficient for sorting datasets with a relatively small range of values and has a time complexity of O(n+k), where n is the number of elements in the array and k is the range of values.

-----

## Time Complexity Analysis:-

Flash Sort exhibits a time complexity of O(n+k), where n represents the number of elements in the array, and k signifies the range of values within the dataset. This complexity arises from the algorithm's ability to efficiently partition the input into distinct classes based on the value range, followed by sorting within each class.
Flash Sort's performance shines particularly when the range of values is significantly smaller than the number of elements, allowing for optimal distribution and sorting operations. However, it may exhibit suboptimal performance when the range of values approaches or exceeds the number of elements, as it relies heavily on the uniformity of value distribution across classes for efficiency.

-----

## Space Complexity Analysis:-

Flash Sort typically exhibits a space complexity of O(n), where n is the number of elements in the input array. This space complexity arises primarily from the need to store auxiliary arrays for distribution and sorting purposes.
The algorithm's space usage remains linear with respect to the input size, making it memory-efficient and suitable for sorting large datasets with limited available memory.

-----

## Advantages:-

1. **Efficient for Small Ranges**: Flash Sort performs exceptionally well when sorting datasets with a relatively small range of values compared to the number of elements.

2. **Linear Time Complexity**: It boasts a linear time complexity of O(n+k), making it highly efficient for datasets with a small range of values.

3. **In-Place Sorting**: Flash Sort operates in-place, requiring minimal additional memory beyond the input array, which enhances its memory efficiency.

----

## Dis-advantages:-

1. **Sensitive to Distribution**: Flash Sort's efficiency heavily depends on the uniform distribution of values across classes, making it less effective for datasets with unevenly distributed values.

2. **Not Stable**: Flash Sort is not a stable sorting algorithm, meaning it does not guarantee the preservation of the relative order of equal elements.

3. **Not Suitable for Large Ranges**: It may exhibit suboptimal performance when sorting datasets with a range of values approaching or exceeding the number of elements, as it relies on the range being significantly smaller.

-----

## Uses:-

1. **Sorting Small Datasets**: Flash Sort is efficient for sorting small to medium-sized datasets, particularly when the range of values is relatively small.

2. **Data Preprocessing**: It can be employed as a preprocessing step in data analysis tasks, such as data cleaning and normalization, due to its linear time complexity.

3. **Numerical Analysis**: Flash Sort is commonly used in numerical analysis and scientific computing applications for sorting arrays of numerical data efficiently.

4. **Database Operations**: It finds application in database systems for sorting large datasets with a relatively small range of values, improving query performance.

5. **Embedded Systems**: Flash Sort is suitable for implementation in embedded systems and real-time applications with limited memory resources, as it requires minimal additional space beyond the input array.

-----

## Explanation of how the code works:

```java
public class FlashSort {
```
- Declares a public class named `FlashSort`.

```java
    public static void flashSort(int[] arr) {
```
- Declares a public static method named `flashSort` which takes an integer array `arr` as input and does not return any value.

```java
        int n = arr.length;
        int min = arr[0];
        int max = arr[0];
```
- Declares three integer variables `n`, `min`, and `max`, and initializes `n` with the length of the input array `arr`, `min`, and `max` with the first element of the array `arr`.

```java
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
```
- Iterates over the elements of the input array `arr` starting from the second element (index 1) to find the minimum and maximum values in the array. Updates `min` and `max` accordingly.

```java
        double divisor = (max - min) / (double) (n - 1);
        int[] distribution = new int[n];
        int[] sortedArr = new int[n];
```
- Calculates the divisor, which is used to determine the distribution of elements into classes. Initializes two integer arrays `distribution` and `sortedArr` of size `n`.

```java
        for (int j : arr) {
            int index = (int) ((j - min) / divisor);
            distribution[index]++;
        }
```
- Iterates over the elements of the input array `arr`. Calculates the index of each element's class based on its value, updates the count of elements in each class in the `distribution` array.

```java
        for (int i = 1; i < n; i++) {
            distribution[i] += distribution[i - 1];
        }
```
- Calculates the cumulative sum of elements in the `distribution` array, ensuring that it represents the starting index of each class in the sorted order.

```java
        for (int i = n - 1; i >= 0; i--) {
            int index = (int) ((arr[i] - min) / divisor);
            sortedArr[--distribution[index]] = arr[i];
        }
```
- Places each element of the input array `arr` into its correct position in the `sortedArr` array based on its class. Decrements the count of elements in the corresponding class in the `distribution` array after placing each element.

```java
        System.arraycopy(sortedArr, 0, arr, 0, n);
```
- Copies the sorted elements from the `sortedArr` array back into the original input array `arr`.

```java
    }
}
```
- Closes the `flashSort` method and the `FlashSort` class.

This code performs Flash Sort, a distribution-based sorting algorithm that partitions the input array into classes based on value ranges and efficiently sorts them. It utilizes auxiliary arrays for distribution and sorting purposes and achieves linear time complexity for sorting datasets with a relatively small range of values compared to the number of elements.

-----