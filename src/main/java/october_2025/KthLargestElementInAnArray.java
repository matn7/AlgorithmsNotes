package october_2025;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        int result = kthLargestElementInAnArray.findKthLargest(nums, k);
        System.out.println(result);

    }

    // O(n * logg(k)) time | O(k) space
    public int findKthLargest(int[] nums, int k) {
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

    // O(nlog(n)) time | O(log(n)) space
    public int findKthLargest2(int[] nums, int k) {
        int kth = nums.length - k;
        quikSort(nums, 0, nums.length - 1, kth);
        return nums[kth];
    }

    private void quikSort(int[] nums, int start, int end, int kth) {
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
            quikSort(nums, start, e - 1, kth);
            quikSort(nums, e + 1, end, kth);
        } else {
            quikSort(nums, e + 1, end, kth);
            quikSort(nums, start, e - 1, kth);
        }

        // *--------------------------*------*
        // start                      e      end
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
