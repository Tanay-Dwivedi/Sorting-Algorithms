package BucketSort;
import java.util.*;
public class BucketSort {
    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // The array is already sorted or empty
        }

        int n = arr.length;
        int maxVal = findMaxValue(arr);

        // Create an array of buckets
        List<List<Integer>> buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute elements into buckets
        for (int j : arr) {
            int index = (int) ((j / (double) maxVal) * (n - 1));
            buckets.get(index).add(j);
        }

        // Sort each bucket using insertion sort or any other sorting algorithm
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatenate sorted buckets to get the final sorted array
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

    private static int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
