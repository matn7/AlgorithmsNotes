package august_2025;

import java.util.PriorityQueue;

public class KthLargestElem {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        KthLargestElem kthLargest = new KthLargestElem();
        int result = kthLargest.findKthLargest(nums, k);
        System.out.println(result);
    }

    // O(n log(n)) time | O(n) space
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

        //                     e
        // start---------------*-------------end
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


    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
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


}
