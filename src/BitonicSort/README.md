# Bitonic Sort

<h2>Definition:-</h2>

Bitonic Sort is a parallel sorting algorithm that builds a bitonic sequence from the input array and then repeatedly
splits it into two halves. The two halves are sorted in opposite directions and then merged. The main idea behind
Bitonic Sort is to create a bitonic sequence, which is a sequence that starts with the elements in ascending order and
then switches to descending order.

<h2>Time Complexity Analysis:-</h2>

Bitonic Sort, a parallel sorting algorithm, demonstrates a uniform time complexity across various scenarios. In the
worst-case scenario, where the input array forms a bitonic sequence transitioning from ascending to descending order,
the algorithm's time complexity is O(log^2 n). This is attributed to the necessity of performing comparisons and swaps
for each element in the array. Similarly,
the average-case time complexity remains O(log^2 n), reflecting the consistent performance of the algorithm across
diverse input sequences. In the best-case scenario,
Bitonic Sort still maintains a time complexity of O(log^2 n), as the nature of the algorithm involves
log^2 n stages regardless of the input. This uniformity in time complexity ensures predictable performance
characteristics,
especially relevant for real-time systems.

**• Best-case Time Complexity** : O(log^2 n)
The best-case time complexity of Bitonic Sort is O(log^2 n). Unlike some other sorting algorithms, Bitonic Sort doesn't
have a distinct best-case scenario, as it always performs log^2 n stages.

**• Average-case Time Complexity** : O(log^2 n)

The average-case time complexity of Bitonic Sort is also O(log^2 n). The algorithm's performance is consistent across
different types of input sequences due to its divide-and-conquer
nature.

**• Worst-case Time Complexity** : O(log^2 n)

The worst-case time complexity of Bitonic Sort is O(log^2 n). This occurs when the input array is a bitonic sequence
that starts in ascending order and then switches to descending
order. In this case, every comparison and swap operation must be performed.

<h2>Space Complexity Analysis:-</h2>

The space complexity of Bitonic Sort is determined by the algorithm's recursive structure. With each recursive call,
additional space is required for the
generation of bitonic sequences, leading to a logarithmic increase in space complexity. This space requirement is
categorized as auxiliary space, extending beyond the input space. Despite the potential for in-place implementations,
Bitonic Sort is commonly executed in an out-of-place manner due to the intricate nature of in-place manipulations. In
summary, the space complexity of Bitonic Sort is intricately linked to the depth of recursion and the creation of
bitonic sequences, making it essential to consider the specific memory requirements when implementing the algorithm in
different computing environments.

**• Space Complexity** : O(log^2 n)

1) **Space Complexity** : The space complexity of Bitonic Sort is O(log^2 n). This arises from the recursive nature of
   the algorithm. In each recursive call, additional space is required for the
   bitonic sequences generated.

2) **Auxiliary Space** : The auxiliary space complexity (space required beyond input space) is O(log^2 n). Each
   recursive call involves creating new bitonic sequences, leading to a logarithmic increase in space complexity.

3) **In-Place vs. Out-of-Place** : Bitonic Sort is typically implemented in an out-of-place manner, meaning it requires
   additional memory for the recursive calls and bitonic sequences. While it's possible to implement a variant of
   Bitonic Sort in-place, it often involves complex manipulations and is
   less practical for certain scenarios.

<h2>Advantages:-</h2>

1) **Parallelization** : Bitonic Sort can be efficiently parallelized, making it suitable for parallel computing
   architectures.

2) **Predictable Performance** : The algorithm exhibits consistent performance characteristics, making it suitable for
   real-time systems.

3) **Applicability to Certain Architectures** : Bitonic Sort can be efficiently implemented on parallel architectures
   like GPUs, where the parallel nature of the algorithm can be fully utilized.

<h2>Dis-advantages:-</h2>

1) **Limited Applicability** : Bitonic Sort is not as versatile as some other sorting algorithms, and its efficiency
   depends on the ability to parallelize the sorting process.

2) **Not as Efficient as Some Sequential Algorithms** : In sequential settings, algorithms like Merge Sort or QuickSort
   may outperform Bitonic Sort for general cases.

3) **Not In-Place** : Bitonic Sort typically requires additional space for the recursive calls, making it less
   memory-efficient in some scenarios.

<h2>Uses:-</h2>

1) **Parallel Computing** : Bitonic Sort is well-suited for parallel computing environments, where the sorting task can
   be divided among multiple processors.

2) **GPU Sorting** : Due to its parallel nature, Bitonic Sort is often used in graphics processing units (GPUs) for
   efficient sorting of large datasets.

3) **Network Design** : Bitonic Sort has applications in network design and communication protocols, where it is used
   for sorting messages in certain network topologies.

4) **Signal Processing** : In some signal processing applications, Bitonic Sort can be employed for sorting data in
   parallel.

5) **Cryptographic Applications** : Bitonic Sort's predictable performance makes it suitable for certain cryptographic
   applications where deterministic behavior is desired.

<br>

***Explanation of how the code works***:

- The selectionSort method takes an array of integers (int[] arr) as input and
  sorts it in ascending order.

- The length of the input array is obtained and stored in the variable n.

- The sorting process begins with a loop that iterates through the array. The outer
  loop, controlled by the variable i, goes from 0 to n-1. It represents the current
  index where the minimum element will be placed in the sorted portion of the array.

- Inside the outer loop, an assumption is made that the element at index i is the
  the minimum element in the unsorted portion of the array and this index is stored in
  the variable minIndex.

- A nested loop, controlled by the variable j, starts from i+1 and continues to n-1.
  This loop is used to find the index of the minimum element in the remaining unsorted
  portion of the array.

- In the inner loop, a comparison is made between the element at index j and the element
  at the current minIndex. If the element at index j is smaller, the minIndex is updated to j.

- After finding the index of the minimum element in the unsorted portion, a swap is performed
  between the element at index i and the minimum element. This places the minimum element at
  the current index i, effectively expanding the sorted portion of the array by one element.

- The process continues in the outer loop, where i is incremented, and the next minimum element
  is found and placed in the appropriate position.

- Once the entire array is iterated and the loop completes, the input array arr is sorted in ascending order.
