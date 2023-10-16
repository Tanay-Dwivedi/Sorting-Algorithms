package CocktailShakerSort;

public class CocktailShakerSort {
    public static void cocktailShakerSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            // Move from left to right
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
            right--;

            // Move from right to left
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    swapped = true;
                }
            }
            left++;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
