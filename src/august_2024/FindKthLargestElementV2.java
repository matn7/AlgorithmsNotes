package august_2024;

import java.util.PriorityQueue;

public class FindKthLargestElementV2 {

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 89, 4, 6, 8};
        int k = 6;

        int result = kthLargest(nums, k);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public static int kthLargest(int[] nums, int k) {
        if (k < 0 || k > nums.length) {
            return -1;
        }

        int kth = nums.length - k;
        int[] result = quickSelect(nums, kth);


        return result[kth];
    }

    private static int[] quickSelect(int[] nums, int kth) {
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, nums.length);
        quickSortHelper(result, 0, nums.length - 1, kth);
        return result;
    }

    private static void quickSortHelper(int[] nums, int start, int end, int kth) {
        if (start > end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;

        while (s <= e) {
            if (nums[s] >= nums[pivot] && nums[e] <= nums[pivot]) {
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
        if (e == kth) {
            return;
        }

        if (end - (e + 1) > e - 1 - start) {
            quickSortHelper(nums, e + 1, end, kth);
            quickSortHelper(nums, start, e - 1, kth);
        } else {
            quickSortHelper(nums, start, e - 1, kth);
            quickSortHelper(nums, e + 1, end, kth);
        }

        //                  e+1      end
        // |**************v#^*********|
        // start          e-1
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
