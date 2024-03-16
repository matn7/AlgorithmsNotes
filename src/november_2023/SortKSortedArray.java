package november_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4, 7, 6, 5};
        int k = 3;

        sortKSortedArray(arr, k);
    }

    // O(nlog(k)) time | O(k) space
    public static List<Integer> sortKSortedArray(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < Math.min(k, arr.length); i++) {
            queue.add(arr[i]);
        }


        for (int i = Math.min(k, arr.length); i < arr.length; i++) {
            queue.add(arr[i]);
            result.add(queue.poll());
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }

}
