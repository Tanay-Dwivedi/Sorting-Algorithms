package RadixSort;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // The array is already sorted or empty
        }

        int max = Arrays.stream(arr).max().getAsInt(); // Find the maximum value
        int digitPlace = 1;

        // Perform counting sort for each digit place (LSD to MSD)
        while (max / digitPlace > 0) {
            countingSortByDigit(arr, digitPlace);
            digitPlace *= 10;
        }
    }

    private static void countingSortByDigit(int[] arr, int digitPlace) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // Counting array for digits 0-9

        // Count the occurrences of each digit at the current digit place
        for (int j : arr) {
            int digit = (j / digitPlace) % 10;
            count[digit]++;
        }

        // Calculate cumulative counts to determine positions in the output
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array by placing elements at their correct positions
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / digitPlace) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the sorted elements back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }
}
