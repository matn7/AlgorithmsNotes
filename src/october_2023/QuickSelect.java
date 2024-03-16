package october_2023;

import java.awt.*;
import java.util.PriorityQueue;

public class QuickSelect {

    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 2, 0, 1}; // [0, 1, 2, 3, 4, 5]
        int k = 3;

        quickSelect(nums, k);
        int result = quickSelectIterative(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int quickSelectIterative(int[] nums, int k) {
        k = k % nums.length;
        int idx = nums.length - k;

        quickSort(nums, 0, nums.length - 1, idx);

        return nums[idx];
    }

    private static void quickSort(int[] nums, int start, int end, int idx) {
        if (start > end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;

        while (s <= e) {
            if (nums[s] > nums[pivot] && nums[e] < nums[pivot]) {
                swap(nums, s, e);
            }
            if (nums[s] <= nums[pivot]) {
                s++;
            }
            if (nums[e] >= nums[pivot]) {
                e--;
            }
        }
        swap(nums, pivot, e);
        if (e == idx) {
            return;
        }

        if (e - 1 - start > end - (e + 1)) {
            quickSort(nums, start, e - 1, idx);
            quickSort(nums, e + 1, end, idx);
        } else {
            quickSort(nums, e + 1, end, idx);
            quickSort(nums, start, e - 1, idx);
        }

        // start                 e             end
        // ====================='*'=============
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // O(klog(n)) time | O(k) space
    public static int quickSelect(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < Math.min(k, nums.length)) {
                queue.add(nums[i]);
            } else {
                Integer topElement = queue.peek();
                int currElement = nums[i];
                if (currElement > topElement) {
                    queue.poll();
                    queue.add(currElement);
                }
            }
        }
        return queue.peek();
    }

}
