package FlashSort;

public class FlashSort {
    public static void flashSort(int[] arr) {
        int n = arr.length;

        // Step 1: Find the minimum and maximum values in the array
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Step 2: Calculate the divisor and initialize the distribution array
        double divisor = (max - min) / (double) (n - 1);
        int[] distribution = new int[n];
        int[] sortedArr = new int[n];

        // Step 3: Count the elements in each class and store the counts in the distribution array
        for (int j : arr) {
            int index = (int) ((j - min) / divisor);
            distribution[index]++;
        }

        // Step 4: Calculate the number of elements in each class
        for (int i = 1; i < n; i++) {
            distribution[i] += distribution[i - 1];
        }

        // Step 5: Copy the elements to their correct positions in the sorted array
        for (int i = n - 1; i >= 0; i--) {
            int index = (int) ((arr[i] - min) / divisor);
            sortedArr[--distribution[index]] = arr[i];
        }

        // Step 6: Copy the sorted array back to the original array
        System.arraycopy(sortedArr, 0, arr, 0, n);
    }
}
