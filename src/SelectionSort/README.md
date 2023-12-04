# Selection Sort

<h2>Definition:-</h2>

Selection Sort is a straightforward sorting algorithm that works by repeatedly finding the minimum element from the
unsorted portion of the array and moving it to the sorted portion. It divides the input array into two parts, one sorted
and one unsorted, and gradually builds the sorted portion by selecting the smallest element each time. This process
continues until the entire array is sorted.

<h2>Time Complexity Analysis:-</h2>

The time complexity of Selection Sort is relatively straightforward to analyze. It is a comparison-based sorting
algorithm, and its performance primarily depends on the number of comparisons and swaps it makes.

Here's a breakdown of the time complexity of Selection Sort:

***- Number of Comparisons*** : In the worst case, Selection Sort performs roughly n^2 / 2 comparisons, where "n" is the
number
of elements in the array. This is because it compares each element with all remaining elements, even if they are already
in the correct position.

***- Number of Swaps*** : Selection Sort performs a maximum of "n" swaps. This is because for each pass, it selects the
minimum (
or maximum) element and swaps it with the element at the beginning of the unsorted portion. This process is repeated for
all elements in the array.

**• Best-case Time Complexity** : O(n^2)

**• Average-case Time Complexity** : O(n^2)

**• Worst-case Time Complexity** : O(n^2)

<h2>Space Complexity Analysis:-</h2>

It primarily depends on the amount of additional memory required for temporary variables and indices used during the
sorting process.

Selection Sort is an in-place sorting algorithm, which means it does not require additional memory proportional to the
size of the input data. It uses a constant amount of extra space for variables, indices, and temporary storage,
regardless of the size of the array being sorted.

**• Space Complexity** : O(1)

<h2>Advantages:-</h2>

1) **Simplicity** : Selection Sort is one of the simplest sorting algorithms to understand and implement. It's a good
   starting
   point for learning about sorting algorithms and computer science concepts.

2) **In-Place Sorting** : Selection Sort is an in-place sorting algorithm, meaning it doesn't require additional memory
   for
   sorting. It is memory-efficient, which can be crucial in situations with limited memory resources.

3) **Stability** : Selection Sort is a stable sorting algorithm. It means that the relative order of equal elements
   remains the
   same after sorting, which is important in some applications.

<h2>Dis-advantages:-</h2>

1) **Inefficiency** : Selection Sort has a time complexity of O(n^2), making it inefficient for large datasets. As the
   dataset
   size increases, the number of comparisons and swaps grows quadratically, resulting in slow performance.

2) **Lack of Adaptivity** : Selection Sort doesn't adapt to the initial order of elements. It always performs the same
   number of
   comparisons and swaps regardless of whether the data is partially sorted or completely unsorted.

3) **No Best-Case Improvement** : Even if the array is already sorted, Selection Sort will make the same number of
   comparisons
   as in the worst-case scenario. This is a significant disadvantage when compared to some other sorting algorithms with
   better best-case performance.

<h2>Uses:-</h2>

1) **Educational Tool** : Selection Sort is commonly used in computer science education to teach sorting algorithms and
   algorithm analysis.

2) **Small Datasets** : It's practical for sorting small arrays or lists, where its simplicity outweighs its
   inefficiency.

3) **Teaching Complexity** : It helps demonstrate the concept of algorithm complexity and how sorting algorithms
   efficiency
   relates to input size.

4) **Debugging and Testing** : Selection Sort can be used for quick and simple sorting during debugging and testing
   processes.

5) **Component in Other Algorithms** : It's integrated into more advanced sorting algorithms to handle smaller portions
   of data
   efficiently.

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
