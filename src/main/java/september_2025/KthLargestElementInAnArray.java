package september_2025;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 4;

        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        int result = kthLargestElementInAnArray.findKthLargest(nums, k);
        System.out.println(result);

    }

    // O(nlog(n)) time | O(n) space
    public int findKthLargest(int[] nums, int k) {
        int kth = nums.length - k;
        sort(nums, kth);
        return nums[kth];
    }

    private void sort(int[] nums, int kth) {
        quickSort(nums, 0, nums.length - 1, kth);
    }

    private void quickSort(int[] nums, int start, int end, int kth) {
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
        if (kth == e) {
            return;
        }
        //                  e-1       end
        // +-----------------*--------+
        // start              e+1
        if (e - 1 - start > end - (e + 1)) {
            quickSort(nums, start, e - 1, kth);
            quickSort(nums, e + 1, end, kth);
        } else {
            quickSort(nums, e + 1, end, kth);
            quickSort(nums, start, e - 1, kth);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // O(n log(k)) time | O(k) space
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else {
                int curr = minHeap.peek();
                if (num > curr) {
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }
        return minHeap.peek();
    }

    // O(nlog(n)) time | O(n) space
    public int findKthLargest1(int[] nums, int k) {
        int kth = nums.length - k;
        Arrays.sort(nums);
        return nums[kth];
    }

}
