package TimSort;

public class TimSort {
    private static final int MIN_MERGE = 32;

    // Merge function to merge two sorted runs
    private static void mergeRuns(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        // Create temporary arrays for left and right subarrays
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        // Copy data to temporary arrays
        System.arraycopy(arr, left, leftArr, 0, len1);
        for (int i = 0; i < len2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        // Merge the two subarrays
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements of leftArr (if any)
        while (i < len1) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of rightArr (if any)
        while (j < len2) {
            arr[k++] = rightArr[j++];
        }
    }

    // Perform insertion sort on a run
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    // Sort the array using Tim Sort
    public static void timSort(int[] arr) {
        int n = arr.length;

        // Divide the array into runs and sort each run using insertion sort
        for (int i = 0; i < n; i += MIN_MERGE) {
            int right = Math.min((i + MIN_MERGE - 1), (n - 1));
            insertionSort(arr, i, right);
        }

        // Merge the sorted runs
        for (int size = MIN_MERGE; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = Math.min((left + size - 1), (n - 1));
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right) {
                    mergeRuns(arr, left, mid, right);
                }
            }
        }
    }
}
