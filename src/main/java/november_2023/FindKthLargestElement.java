package november_2023;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargestElement {

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 6, 4, 2};
        int k = 2;

        int result = findKthLargestV3(array, k);
        System.out.println(result);

        int result2 = findKthLargestV2(array, k);
        System.out.println(result2);

        int result3 = findKthLargest(array, k);
        System.out.println(result3);
    }

    // O(n) time | O(n) space
    public static int findKthLargest(int[] array, int k) {
        if (array.length == 0) {
            return -1;
        }
        int kth = array.length - k;
        quickSort(array, 0, array.length - 1, kth);
        return array[kth];
    }

    private static void quickSort(int[] array, int start, int end, int kth) {
        if (start > end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;

        while (s <= e) {
            if (array[s] > array[pivot] && array[e] < array[pivot]) {
                swap(array, s, e);
                s++;
                e--;
            }
            if (array[s] <= array[pivot]) {
                s++;
            }
            if (array[e] >= array[pivot]) {
                e--;
            }
        }

        swap(array, pivot, e);
        if (e == kth) {
            return;
        }

        if (end - (e + 1) < e - 1 - start) {
            quickSort(array, start, e - 1, kth);
            quickSort(array, e + 1, end, kth);
        } else {
            quickSort(array, e + 1, end, kth);
            quickSort(array, start, e - 1, kth);
        }

        //            e-1 e+1
        // ##############*##########
        // start                   end
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // O(nlog(k)) time | O(k) space
    public static int findKthLargestV2(int[] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // [5, 3, 1, 6, 4, 2]
        //        *
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (queue.size() < k) {
                queue.add(num);
            } else {
                int curr = queue.peek();
                if (num > curr) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }

        return queue.peek();
    }

    // O(nlog(n)) time | O(n) space
    public static int findKthLargestV3(int[] array, int k) {
        int kth = array.length - k;
        Arrays.sort(array);
        return array[kth];
    }

}
