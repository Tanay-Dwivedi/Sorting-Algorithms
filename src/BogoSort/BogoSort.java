package BogoSort;

import java.util.Random;

public class BogoSort {
    // Sorts the input array using the Bogo Sort algorithm.
    public static void bogoSort(int[] arr) {
        while (!isSorted(arr)) {
            // Continue shuffling until the array is sorted.
            shuffle(arr);
        }
    }

    // Checks if the input array is sorted in non-decreasing order.
    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // If any adjacent elements are out of order, return false.
                return false;
            }
        }
        // If the loop completes without returning false, the array is sorted.
        return true;
    }

    // Shuffles the elements in the input array randomly.
    private static void shuffle(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            // Generate a random index within the remaining unshuffled part of the array.
            int index = rand.nextInt(i + 1);
            // Swap the current element with the randomly selected element.
            swap(arr, i, index);
        }
    }

    // Swaps two elements in the array.
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
