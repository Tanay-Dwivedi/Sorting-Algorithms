package ThreeWayMergeSort;

public class ThreeWayMergeSort {
    public static void threeWayMergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int[] auxArray = new int[arr.length];
        mergeSort3Way(arr, 0, arr.length, auxArray);
    }

    private static void mergeSort3Way(int[] arr, int low, int high, int[] auxArray) {
        if (high - low < 2) {
            return;
        }

        int mid1 = low + ((high - low) / 3);
        int mid2 = low + 2 * ((high - low) / 3) + 1;

        mergeSort3Way(arr, low, mid1, auxArray);
        mergeSort3Way(arr, mid1, mid2, auxArray);
        mergeSort3Way(arr, mid2, high, auxArray);

        merge(arr, low, mid1, mid2, high, auxArray);
    }

    private static void merge(int[] arr, int low, int mid1, int mid2, int high, int[] auxArray) {
        int i = low, j = mid1, k = mid2, l = low;

        while (i < mid1 && j < mid2 && k < high) {
            if (arr[i] < arr[j]) {
                if (arr[i] < arr[k]) {
                    auxArray[l++] = arr[i++];
                } else {
                    auxArray[l++] = arr[k++];
                }
            } else {
                if (arr[j] < arr[k]) {
                    auxArray[l++] = arr[j++];
                } else {
                    auxArray[l++] = arr[k++];
                }
            }
        }

        while (i < mid1 && j < mid2) {
            if (arr[i] < arr[j]) {
                auxArray[l++] = arr[i++];
            } else {
                auxArray[l++] = arr[j++];
            }
        }

        while (j < mid2 && k < high) {
            if (arr[j] < arr[k]) {
                auxArray[l++] = arr[j++];
            } else {
                auxArray[l++] = arr[k++];
            }
        }

        while (i < mid1 && k < high) {
            if (arr[i] < arr[k]) {
                auxArray[l++] = arr[i++];
            } else {
                auxArray[l++] = arr[k++];
            }
        }

        while (i < mid1) {
            auxArray[l++] = arr[i++];
        }

        while (j < mid2) {
            auxArray[l++] = arr[j++];
        }

        while (k < high) {
            auxArray[l++] = arr[k++];
        }

        if (high - low >= 0) System.arraycopy(auxArray, low, arr, low, high - low);
    }
}
