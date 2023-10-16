package CombSort;

public class CombSort {
    public static void combSort(int[] array) {
        int gap = array.length;
        boolean swapped = true;

        while (gap > 1 || swapped) {
            // Calculate the gap using the shrink factor (typically 1.3)
            gap = getNextGap(gap);

            swapped = false;

            // Compare elements with the calculated gap
            for (int i = 0; i < array.length - gap; i++) {
                if (array[i] > array[i + gap]) {
                    // Swap elements if they are out of order
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    private static int getNextGap(int gap) {
        // Shrink the gap using a common shrink factor, typically 1.3
        gap = (gap * 10) / 13;

        // Ensure the gap is at least 1
        return Math.max(gap, 1);

    }
}
