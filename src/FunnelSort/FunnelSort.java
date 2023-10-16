package FunnelSort;

import java.util.Arrays;

public class FunnelSort {
    public static void funnelSort(int[] array) {
        int n = array.length;

        if (n <= 1) {
            return; // Already sorted
        }

        int maxVal = Arrays.stream(array).max().getAsInt();
        int bitCount = 0;

        // Calculate the number of bits needed to represent the maximum value
        while ((1 << bitCount) <= maxVal) {
            bitCount++;
        }

        int[] buffer = new int[n];
        int shift = 0;
        int mask = (1 << bitCount) - 1;

        for (int i = 0; i < bitCount; i++) {
            int[] count = new int[1 << bitCount];
            int[] offset = new int[1 << bitCount];

            // Count the occurrences of each value for the current bit
            for (int value : array) {
                count[(value >> shift) & mask]++;
            }

            // Calculate the offsets for each value
            offset[0] = 0;
            for (int j = 1; j < (1 << bitCount); j++) {
                offset[j] = offset[j - 1] + count[j - 1];
            }

            // Move values into the buffer using offsets
            for (int value : array) {
                buffer[offset[(value >> shift) & mask]++] = value;
            }

            // Swap the arrays
            int[] temp = array;
            array = buffer;
            buffer = temp;

            shift += bitCount;
        }

        // Copy the sorted array back to the original array
        if (array != buffer) {
            System.arraycopy(array, 0, buffer, 0, n);
        }
    }
}
