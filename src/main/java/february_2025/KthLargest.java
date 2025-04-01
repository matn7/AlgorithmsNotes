package february_2025;

public class KthLargest {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        KthLargest kthLargest = new KthLargest();
        int result = kthLargest.findKthLargest(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int findKthLargest(int[] nums, int k) {
        int kth = nums.length - k;
        return quickSort(nums, kth)[kth];
    }

    private int[] quickSort(int[] nums, int kth) {
        sort(nums, 0, nums.length - 1, kth);
        return nums;
    }

    private void sort(int[] nums, int left, int right, int kth) {
        if (left > right) {
            return;
        }
        int pivot = left;
        int l = left + 1;
        int r = right;

        while (l <= r) {
            if (nums[l] >= nums[pivot] && nums[r] <= nums[pivot]) {
                swap(nums, l, r);
            }
            if (nums[l] <= nums[pivot]) {
                l++;
            }
            if (nums[r] >= nums[pivot]) {
                r--;
            }
        }
        swap(nums, pivot, r);
        if (kth == r) {
            return;
        }

        if (r - 1 - left > right - (r + 1)) {
            sort(nums, left, r - 1, kth);
            sort(nums, r + 1, right, kth);
        } else {
            sort(nums, r + 1, right, kth);
            sort(nums, left, r - 1, kth);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
