package star;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QuickSelect {

    public static void main(String[] args) {
        int[] nums = {8, 5, 2, 9, 7, 6, 3, 178, 89, 0, 8178, 90};

        QuickSelect quickSelect = new QuickSelect();
        int result = quickSelect.quickSelect(nums, 3);
        System.out.println(result);
//        int result2 = quickSelect.quickSelect2(nums, 3);
//        System.out.println(result2);
//        int result3 = quickSelect.quickSelect3(nums, 3);
//        System.out.println(result3);
    }

    // O(nlog(n)) time | O(n) space
    public int quickSelect(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                Integer top = queue.peek();
                if (top > num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        return queue.peek();
    }

    // O(nlog(n)) time | O(n) space
    public int quickSelect2(int[] nums, int k) {
        int[] sorted = quickSort(nums);
        return sorted[k - 1];
    }

    private int[] quickSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        quickSortHelper(0, nums.length - 1, nums);
        return nums;
    }

    private void quickSortHelper(int start, int end, int[] nums) {
        if (start >= end) {
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


        if (e - 1 - start > end - (e + 1)) {
            quickSortHelper(start, e - 1, nums);
            quickSortHelper(e + 1, end, nums);
        } else {
            quickSortHelper(e + 1, end, nums);
            quickSortHelper(start, e - 1, nums);
        }
    }

    // O(n) time | O(log(n)) space
    public int quickSelect3(int[] nums, int k) {
        int[] sorted = quickSort(nums, k);
        return sorted[k - 1];
    }

    private int[] quickSort(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        quickSortHelper(0, nums.length - 1, nums, k);
        return nums;
    }

    private void quickSortHelper(int start, int end, int[] nums, int k) {
        if (start >= end) {
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

        if (e == k) {
            return;
        }

        swap(nums, pivot, e);


        if (e - 1 - start > end - (e + 1)) {
            quickSortHelper(start, e - 1, nums, k);
            quickSortHelper(e + 1, end, nums, k);
        } else {
            quickSortHelper(e + 1, end, nums, k);
            quickSortHelper(start, e - 1, nums, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
