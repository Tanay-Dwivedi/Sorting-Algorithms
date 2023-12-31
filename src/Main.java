import BitonicSort.BitonicSort;
import BlockSort.BlockSort;
import BogoSort.BogoSort;
import BubbleSort.BubbleSort;
import BucketSort.BucketSort;
import CocktailShakerSort.CocktailShakerSort;
import CombSort.CombSort;
import CountingSort.CountingSort;
import CycleSort.CycleSort;
import FlashSort.FlashSort;
import FunnelSort.FunnelSort;
import GnomeSort.GnomeSort;
import HeapSort.HeapSort;
import MergeSort.MergeSort;
import OddEvenSort.OddEvenSort;
import PancakeSort.PancakeSort;
import PigeonholeSort.PigeonholeSort;
import QuickSort.QuickSort;
import RadixSort.RadixSort;
import SelectionSort.SelectionSort;
import InsertionSort.InsertionSort;
import SelectionTreeSort.SelectionTreeSort;
import ShellSort.ShellSort;
import SleepSort.SleepSort;
import SmoothSort.SmoothSort;
import StoogeSort.StoogeSort;
import StrandSort.StrandSort;
import ThreeWayMergeSort.ThreeWayMergeSort;
import TimSort.TimSort;
import TreeSort.TreeSort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//         Input array from the user
        System.out.print("Enter the number of elements in the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        // Choose a sorting algorithm
        System.out.println("\nChoose a sorting algorithm (1-30):");
        System.out.println("1- Selection sort");
        System.out.println("2- Bubble sort");
        System.out.println("3- Insertion sort");
        System.out.println("4- Merge sort");
        System.out.println("5- Quick sort");
        System.out.println("6- Heap sort");
        System.out.println("7- Counting sort");
        System.out.println("8- Radix sort");
        System.out.println("9- Bucket Sort");
        System.out.println("10- Shell Sort");
        System.out.println("11- Cycle sort");
        System.out.println("12- Bogo Sort");
        System.out.println("13- Gnome sort");
        System.out.println("14- Strand sort");
        System.out.println("15- Bitonic sort");
        System.out.println("16- Pancake sorting");
        System.out.println("17- Sleep sort");
        System.out.println("18- Tree sort");
        System.out.println("19- Odd-Even sort");
        System.out.println("20- 3-way Merge sort");
        System.out.println("21- Stooge sort");
        System.out.println("22- Tim Sort");
        System.out.println("23- Comb sort");
        System.out.println("24- Pigeonhole sort");
        System.out.println("25- Cocktail shaker sort");
        System.out.println("26- Selection tree sort");
        System.out.println("27- Smooth sort");
        System.out.println("28- Funnel sort");
        System.out.println("29- Flash Sort");
        System.out.println("30- Block sort");

        System.out.print("Enter your choice: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> SelectionSort.selectionSort(arr);
            case 2 -> BubbleSort.bubbleSort(arr);
            case 3 -> InsertionSort.insertionSort(arr);
            case 4 -> MergeSort.mergeSort(arr);
            case 5 -> QuickSort.quickSort(arr);
            case 6 -> HeapSort.heapSort(arr);
            case 7 -> CountingSort.countingSort(arr);
            case 8 -> RadixSort.radixSort(arr);
            case 9 -> BucketSort.bucketSort(arr);
            case 10 -> ShellSort.shellSort(arr);
            case 11 -> CycleSort.cycleSort(arr);
            case 12 -> BogoSort.bogoSort(arr);
            case 13 -> GnomeSort.gnomeSort(arr);
            case 14 -> StrandSort.strandSort(arr);
            case 15 -> BitonicSort.bitonicSort(arr);
            case 16 -> PancakeSort.pancakeSort(arr);
            case 17 -> SleepSort.sleepSort(arr);
            case 18 -> TreeSort.treeSort(arr);
            case 19 -> OddEvenSort.oddEvenSort(arr);
            case 20 -> ThreeWayMergeSort.threeWayMergeSort(arr);
            case 21 -> StoogeSort.stoogeSort(arr);
            case 22 -> TimSort.timSort(arr);
            case 23 -> CombSort.combSort(arr);
            case 24 -> PigeonholeSort.pigeonholeSort(arr);
            case 25 -> CocktailShakerSort.cocktailShakerSort(arr);
            case 26 -> SelectionTreeSort.selectionTreeSort(arr);
            case 27 -> SmoothSort.smoothSort(arr);
            case 28 -> FunnelSort.funnelSort(arr);
            case 29 -> FlashSort.flashSort(arr);
            case 30 -> BlockSort.blockSort(arr);
            default -> System.out.println("Invalid choice. No sorting performed.");
        }

        // Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(arr));

    }
}