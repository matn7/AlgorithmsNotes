package august_2024;

public class FindKthLargestV2 {

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 89, 4, 6, 8};
        int k = 6;

        int result = findKthLargest(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int findKthLargest(int[] nums, int k) {
        int kth = nums.length - k;

        quickSort(nums, kth);

        return nums[kth];
    }

    private static void quickSort(int[] nums, int kth) {
        quickSortHelper(nums, 0, nums.length - 1, kth);
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

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
