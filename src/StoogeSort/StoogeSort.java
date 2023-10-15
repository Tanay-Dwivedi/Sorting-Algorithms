package StoogeSort;

public class StoogeSort {
    // Entry point for the Stooge Sort algorithm.
    public static void stoogeSort(int[] arr) {
        stoogeSortHelper(arr, 0, arr.length - 1);
    }

    // Recursive function for Stooge Sort.
    private static void stoogeSortHelper(int[] arr, int low, int high) {
        if (low >= high) {
            // If the subarray has 0 or 1 elements, it's already sorted.
            return;
        }

        if (arr[low] > arr[high]) {
            // If the first and last elements are out of order, swap them.
            swap(arr, low, high);
        }

        if (high - low + 1 > 2) {
            // If there are three or more elements in the subarray, recursively sort.
            int t = (high - low + 1) / 3;
            stoogeSortHelper(arr, low, high - t);      // Sort the first 2/3 of the array.
            stoogeSortHelper(arr, low + t, high);      // Sort the last 2/3 of the array.
            stoogeSortHelper(arr, low, high - t);      // Sort the first 2/3 of the array again.
        }
    }

    // Helper function to swap two elements in the array.
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
