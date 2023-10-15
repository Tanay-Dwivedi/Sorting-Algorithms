package BitonicSort;
import java.util.*;
public class BitonicSort {
    public static void bitonicSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        // Divide the input array into two halves.
        int[] leftHalf = Arrays.copyOf(array, array.length / 2);
        int[] rightHalf = Arrays.copyOfRange(array, array.length / 2, array.length);

        // Recursively sort the two halves.
        bitonicSort(leftHalf);
        bitonicSort(rightHalf);

        // Merge the two sorted halves together.
        merge(array, leftHalf, rightHalf);
    }

    private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] < rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }

            k++;
        }

        // Add any remaining elements from the left half.
        while (i < leftHalf.length) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }

        // Add any remaining elements from the right half.
        while (j < rightHalf.length) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }

}