package InsertionSort;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            // Store the current element to be inserted into the sorted portion of the array
            int currentElement = arr[i];
            int j = i - 1;

            // Move elements of the sorted portion of the array that are greater than the current element
            // to the right by one position
            while (j >= 0 && arr[j] > currentElement) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the current element into its correct position in the sorted portion of the array
            arr[j + 1] = currentElement;
        }
    }
}
