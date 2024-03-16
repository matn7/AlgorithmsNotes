package october_2023;

import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, -3, -4, 2, 1, 3};
        int k = 2;

        // k < 0 ? No
        // k > arr.len ? Yes
        sortKSortedArray(arr, k);
    }

    // O(nlog(k)) time | O(k) space
    public static int[] sortKSortedArray(int[] arr, int k) {
        if (arr.length == 0) {
            return arr;
        }
        int[] result = new int[arr.length];

        int idx = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i <= Math.min(k, arr.length - 1); i++) {
            queue.add(arr[i]);
            idx++;
        }
        int counter = 0;
        for (int i = idx; i < arr.length; i++) {
            Integer top = queue.poll();
            result[counter] = top;
            queue.add(arr[idx]);
            counter++;
            idx++;
        }

        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            result[counter] = top;
            counter++;
        }

        return result;
    }

}
