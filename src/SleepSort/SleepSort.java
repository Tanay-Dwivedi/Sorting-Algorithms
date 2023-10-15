package SleepSort;

import java.util.concurrent.CountDownLatch;

public class SleepSort {
    public static void sleepSort(int[] arr) {
        CountDownLatch doneSignal = new CountDownLatch(arr.length);

        for (int num : arr) {
            new Thread(() -> {
                try {
                    Thread.sleep(num * 100L); // Sleep for num * 100 milliseconds
                    System.out.print(num + " ");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    doneSignal.countDown();
                }
            }).start();
        }

        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("\nbelow is the original array");
    }
}
