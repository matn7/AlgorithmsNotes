package problems.other;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargestElementInList {
    // Quick sort
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 4, 6, 8};
        //             *
        // 2, 3, 4, 5, 6, 8
        int k = 3;

        FindKthLargestElementInList findKthLargestElementInList = new FindKthLargestElementInList();
        int result = findKthLargestElementInList.findKthLargest(nums, k);
        System.out.println();
    }

    // ********
    // * STAR - G *
    // ********

    // O(n) time | O(log(n)) space
    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length - 1, k);
    }

    private int select(int[] list, int l, int r, int index) {
        if (l == r) {
            return list[l];
        }
        int pivot_idx = new Random().nextInt(r - l) + l;
        // move the pivot to the beginning of list
        swap(list, l, pivot_idx);

        // partition
        int i = l;
        for (int j = l + 1; j < r + 1; j++) {
            if (list[j] < list[l]) {
                i += 1;
                swap(list, i, j);
            }
        }

        // move pivot to correct location
        swap(list, i, l);

        // recursively partition one side
        if (index == i) {
            return list[i];
        } else if (index < i) {
            return select(list, l, i - 1, index);
        } else {
            return select(list, i+1, r, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // O(nlog(n)) time | O(log(n)) space
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // O(klog(n)) time | O(n) space
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                Integer top = queue.peek(); // 4
                if (top < num) { // 4 < 8
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        Integer result = queue.peek();
        return result;
    }
}
