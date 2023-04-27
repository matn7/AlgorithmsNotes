package coderpro;

import java.util.Arrays;
import java.util.PriorityQueue;

public class QuickSelect {

    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 2, 0, 1};
        int k = 3;

        QuickSelect quickSelect = new QuickSelect();
        quickSelect.quickSelectMy(nums, k);

        int result = quickSelect.quickSelect(nums, k);
        System.out.println(result);
    }

    // ********
    // * STAR *
    // ********

    // O(n) time | O(1) space
    public int quickSelect(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int pivotIndex = partition(arr, left, right);
            if (pivotIndex == k) {
                return arr[pivotIndex];
            } else if (pivotIndex > k) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
        return -1;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }

    public int findKthLargest2(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

    public int quickSelectMy(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
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
        if (queue.isEmpty()) {
            return -1;
        }
        Integer result = queue.peek();
        return result;
    }

    //                  3
    //              4       5
    
}
