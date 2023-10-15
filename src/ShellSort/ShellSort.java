package ShellSort;

public class ShellSort {
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // The array is already sorted or empty
        }

        int n = arr.length;

        // Start with a large gap and reduce it in each iteration
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform Insertion Sort for elements at the current gap
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                // Shift elements that are greater than the current element to the right
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Place the current element in its correct position
                arr[j] = temp;
            }
        }
    }
}
