package GnomeSort;

public class GnomeSort {
    public static void gnomeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // The array is already sorted or empty
        }

        int n = arr.length;
        int index = 0;

        while (index < n) {
            if (index == 0) {
                index++;
            }

            if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                // Swap the out-of-place elements
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}
