package whiteboard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Quickselect {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 7, 6, 3};

        quickselect(array, 3);
    }

    // ********
    // * STAR - G *
    // ********

    // O(nlog(n)) time | O(n) space
    public static int quickselect(int[] array, int k) {
        // Write your code here.
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int element : array) {
            if (queue.size() < k) {
                queue.add(element);
            } else {
                int topElement = queue.peek();
                if (topElement > element) {
                    queue.poll();
                    queue.add(element);
                }
            }
        }

        return queue.peek();
    }

    // O(n) time | O(log(n)) space
    public static int quickselect2(int[] array, int k) {
        // Write your code here.
        if (array.length == 0 || k > array.length) {
            return -1;
        }
        quickSortHelper(array, 0, array.length - 1, k);
        int i = array[k-1];
        return i;
    }

    private static void quickSortHelper(int[] array, int start, int end, int k) {
        System.out.println("*");
        if (start > end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;

        while (s <= e) {
            if (array[s] > array[pivot] && array[e] < array[pivot]) {
                swap(array, s, e);
            }
            if (array[s] <= array[pivot]) {
                s++;
            }
            if (array[e] >= array[pivot]) {
                e--;
            }
        }
        swap(array, pivot, e);
        if (e == k - 1) {
            return;
        }
        if (e - 1 - start > end - (e + 1)) {
            quickSortHelper(array, start, e - 1, k);
            quickSortHelper(array, e + 1, end, k);
        } else {
            quickSortHelper(array, e + 1, end, k);
            quickSortHelper(array, start, e - 1, k);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
