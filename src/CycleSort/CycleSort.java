package CycleSort;

public class CycleSort {
    public static void cycleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // The array is already sorted or empty
        }

        int n = arr.length;

        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {
            int item = arr[cycleStart];
            int pos = cycleStart;

            // Find the correct position for the current item
            for (int i = cycleStart + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }

            // If the item is already in its correct position, continue to the next cycle
            if (pos == cycleStart) {
                continue;
            }

            // Move the item to its correct position by rotating the cycle
            while (item == arr[pos]) {
                pos++;
            }

            int temp = arr[pos];
            arr[pos] = item;
            item = temp;

            while (pos != cycleStart) {
                pos = cycleStart;

                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }

                while (item == arr[pos]) {
                    pos++;
                }

                temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
        }
    }
}
