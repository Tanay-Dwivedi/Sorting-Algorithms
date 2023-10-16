package PigeonholeSort;

import java.util.Arrays;

public class PigeonholeSort {
    public static void pigeonholeSort(int[] array) {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        int range = max - min + 1;

        int[] pigeonholes = new int[range];

        // Place each element into its corresponding pigeonhole
        for (int value : array) {
            pigeonholes[value - min]++;
        }

        // Reconstruct the sorted array from the pigeonholes
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (pigeonholes[i] > 0) {
                array[index] = i + min;
                pigeonholes[i]--;
                index++;
            }
        }
    }
}
