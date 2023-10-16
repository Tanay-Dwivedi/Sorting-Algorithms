package SelectionSort;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Assume the current index 'i' contains the minimum value
            int minIndex = i;

            // Find the index of the minimum element in the remaining unsorted portion of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    // If a smaller element is found, update the index of the minimum
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the element at the current index (i)
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
