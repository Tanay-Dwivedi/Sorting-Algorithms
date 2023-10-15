package OddEvenSort;

public class OddEvenSort {
    public static void oddEvenSort(int[] arr) {
        int n = arr.length;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            // Perform the odd phase (comparing and swapping odd-indexed elements)
            for (int i = 1; i <= n - 2; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    sorted = false;
                }
            }

            // Perform the even phase (comparing and swapping even-indexed elements)
            for (int i = 0; i <= n - 2; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
