package StrandSort;

import java.util.*;

public class StrandSort {

    public static void strandSort(int[] arr) {
        List<Integer> al = new ArrayList<>();
        for (int aa : arr) {
            al.add(aa);
        }
        ss(al);
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
        }
    }

    public static void ss(List<Integer> ip) {
        // Create a sorted sublist with
        // the first item of the input list
        List<Integer> sublist = new ArrayList<>();
        sublist.add(ip.get(0));
        ip.remove(0);

        // Create an iterator for the input list
        ListIterator<Integer> it = ip.listIterator();

        // Traverse remaining items of the input list
        while (it.hasNext()) {
            // If the current item of the input list
            // is greater than the last added item
            // to the sublist, move the current item
            // to the sublist as sorted order is
            // maintained.
            if (it.next() > sublist.get(sublist.size() - 1)) {
                sublist.add(it.previous());
                it.remove();
            }
        }

        // Recur for the remaining items in
        // the input list.
        if (!ip.isEmpty()) {
            ss(ip);
        }

        // Merge the current sublist into the input list
        ip.addAll(sublist);
    }
}
