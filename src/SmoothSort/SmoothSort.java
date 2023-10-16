package SmoothSort;

public class SmoothSort {
    public static void smoothSort(int[] array) {
        int n = array.length;

        int p = 1;

        // Calculate initial p value according to the Smooth Sort formula
        while (p < n) {
            p = (3 * p) + 1;
        }
        p /= 3;

        while (p > 0) {
            for (int i = p; i < n; i++) {
                int t = array[i];
                int j = i;

                // Perform insertion sort-like operation
                for (; j >= p && t < array[j - p]; j -= p) {
                    array[j] = array[j - p];
                }

                // Insert the stored t value into the last known position
                array[j] = t;
            }

            if (p == 1) {
                p = 0;
            } else {
                p /= 3;
            }
        }
    }
}
