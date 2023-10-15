package PancakeSort;

public class PancakeSort {
    // Sorts the input array using the Pancake Sort algorithm.
    public static void pancakeSort(int[] arr) {
        int n = arr.length;

        // Iterate through the array to sort it.
        for (int currSize = n; currSize > 1; currSize--) {
            // Find the index of the maximum element in the current unsorted subarray.
            int maxIndex = findMaxIndex(arr, currSize);

            // If the maximum element is not at the end of the subarray, perform flips to move it to the end.
            if (maxIndex != currSize - 1) {
                flip(arr, maxIndex);
                flip(arr, currSize - 1);
            }
        }
    }

    // Finds the index of the maximum element in the given subarray of arr.
    private static int findMaxIndex(int[] arr, int n) {
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            // Update maxIndex if a larger element is found.
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Reverses the elements in the subarray arr[0...i].
    private static void flip(int[] arr, int i) {
        int start = 0;
        while (start < i) {
            // Swap elements between start and i.
            int temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }
}
