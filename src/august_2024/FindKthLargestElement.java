package august_2024;

import java.util.PriorityQueue;

public class FindKthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 89, 4, 6, 8};
        int k = 6;

        int result = kthLargest(nums, k);
        System.out.println(result);

        int result2 = kthLargestV2(nums, k);
        System.out.println(result2);
    }

    // O(nlog(k)) time | O(n) space
    public static int kthLargestV2(int[] nums, int k) {
        if (k < 0 || k > nums.length) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                Integer peek = queue.peek();
                if (num > peek) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        return queue.peek();
    }

    // O(nlog(n)) time | O(n) space
    public static int kthLargest(int[] nums, int k) {
        if (k < 0 || k > nums.length) {
            return -1;
        }
        // sort - O(nlog(n)) time
        int[] result = quickSort(nums);

        int kth = nums.length - k;

        return result[kth];
    }

    private static int[] quickSort(int[] nums) {
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, nums.length);
        quickSortHelper(result, 0, nums.length - 1);
        return result;
    }

    private static void quickSortHelper(int[] nums, int start, int end) {
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

        if (end - (e + 1) > e - 1 - start) {
            quickSortHelper(nums, e + 1, end);
            quickSortHelper(nums, start, e - 1);
        } else {
            quickSortHelper(nums, start, e - 1);
            quickSortHelper(nums, e + 1, end);
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
