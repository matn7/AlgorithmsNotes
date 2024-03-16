package december_2023;

import java.util.PriorityQueue;

public class FindTheKthLargestElementInAList {

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 4, 6, 8};
        int k = 3;

        int result = quickSelect(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int quickSelect(int[] nums, int k) {
        int kth = nums.length - k;
        quickSort(nums, 0, nums.length - 1, kth);
        return nums[kth];
    }

    private static void quickSort(int[] nums, int start, int end, int kth) {
        if (start > end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;
        // 3, 5, 2, 4, 6, 8
        // p  s           e
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

        //                 e
        // ################*##########
        // start                    end
        if (e - 1 - start > end - (e + 1)) {
            quickSort(nums, start, e - 1, kth);
            quickSort(nums, e + 1, end, kth);
        } else {
            quickSort(nums, e + 1, end, kth);
            quickSort(nums, start, e - 1, kth);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // O(nlog(k)) time | O(n) space
    public static int findElement(int[] nums, int k) {
        if (nums.length == 0 || k < 0 || k > nums.length) {
            throw new RuntimeException("Invalid input");
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 3, 5, 2, 4, 6, 8
        //                *

        //   5
        // 6    8
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                Integer peek = queue.peek(); // 2
                if (peek < num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }

        return queue.peek();
    }

}
