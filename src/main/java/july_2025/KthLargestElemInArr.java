package july_2025;

import java.util.PriorityQueue;

public class KthLargestElemInArr {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        KthLargestElemInArr kthLargestElemInArr = new KthLargestElemInArr();
        int result = kthLargestElemInArr.findKthLargest(nums, k);
        System.out.println(result);

    }

    // O(n) time | O(n^2) in worst case | O(n) space
    public int findKthLargest(int[] nums, int k) {
        int kth = nums.length - k;
        quickSelect(nums, kth);
        return nums[kth];
    }

    private void quickSelect(int[] nums, int kth) {
        sort(nums, 0, nums.length - 1, kth);
    }

    private void sort(int[] nums, int start, int end, int kth) {
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

        if (e - 1 - start > end - (e + 1)) {
            sort(nums, start, e - 1, kth);
            sort(nums, e + 1, end, kth);
        } else {
            sort(nums, e + 1, end, kth);
            sort(nums, start, e - 1, kth);
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
                if (curr < num) {
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }
        return minHeap.peek();
    }

}
