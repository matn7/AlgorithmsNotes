package may_2024;

import java.util.PriorityQueue;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 6, 4, 2};
        int k = 2;

        int result = findElement2(array, k);
        System.out.println(result);
    }

    // O(nlog(k)) time | O(k) space
    public static int findElement(int[] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : array) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                Integer top = queue.peek();
                if (top < num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        return queue.peek();
    }

    // O(n) time | O(log(n)) space
    public static int findElement2(int[] array, int k) {
        int kth = array.length - k;

        quickSortHelper(array, 0, array.length - 1, kth);

        return array[kth];
    }

    private static void quickSortHelper(int[] array, int left, int right, int kth) {
        if (left > right) {
            return;
        }
        int pivot = left;
        int s = left + 1;
        int e = right;

        while (s <= e) {
            if (array[s] >= array[pivot] && array[e] <= array[pivot]) {
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
        if (e == kth) {
            return;
        }
        if (e - 1 - left > right - (e + 1)) {
            quickSortHelper(array, left, e - 1, kth);
            quickSortHelper(array, e + 1, right, kth);
        } else {
            quickSortHelper(array, e + 1, right, kth);
            quickSortHelper(array, left, e - 1, kth);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

























