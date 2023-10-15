package CountingSort;

public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // The array is already sorted or empty
        }

        // Find the maximum and minimum values in the array
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int range = max - min + 1;
        int[] count = new int[range]; // Create a count array to store frequencies
        int[] output = new int[arr.length]; // Create an output array to store the sorted elements

        // Count the frequencies of each element in the input array
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        // Calculate the cumulative frequencies
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy the sorted elements back to the original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
