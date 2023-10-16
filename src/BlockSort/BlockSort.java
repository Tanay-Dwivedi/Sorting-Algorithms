package BlockSort;

import java.util.Arrays;

public class BlockSort {
    public static void blockSort(int[] arr) {
        int blockSize = 4;
        int min = arr[0];
        int max = arr[0];

        // Find the minimum and maximum values in the array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Calculate the range of values
        int range = max - min + 1;

        // Calculate the number of blocks needed
        int numBlocks = (range + blockSize - 1) / blockSize;

        // Create and initialize the blocks
        int[][] blocks = new int[numBlocks][blockSize];
        int[] blockSizes = new int[numBlocks];

        // Distribute elements into blocks
        for (int value : arr) {
            int blockIndex = (value - min) / blockSize;
            int elementIndex = blockSizes[blockIndex];

            blocks[blockIndex][elementIndex] = value;
            blockSizes[blockIndex]++;

            if (blockSizes[blockIndex] == blockSize) {
                // Block is full, sort it
                Arrays.sort(blocks[blockIndex]);
            }
        }

        // Sort each block individually
        for (int i = 0; i < numBlocks; i++) {
            Arrays.sort(blocks[i], 0, blockSizes[i]);
        }

        // Merge the sorted blocks back into the original array
        int currentIndex = 0;
        for (int i = 0; i < numBlocks; i++) {
            System.arraycopy(blocks[i], 0, arr, currentIndex, blockSizes[i]);
            currentIndex += blockSizes[i];
        }
    }
}