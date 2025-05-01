package april_2025;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        KthLargestElement kthLargestElement = new KthLargestElement();
        int result = kthLargestElement.findKthLargest(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int findKthLargest(int[] nums, int k) {
        int kth = nums.length - k;
        quickSelect(nums, kth);
        return nums[kth];
    }

    private void quickSelect(int[] nums, int kth) {
        sort(nums, 0, nums.length - 1, kth);
    }

    private void sort(int[] nums, int s, int e, int kth) {
        if (s >= e) {
            return;
        }
        int pivot = s;
        int start = s;
        int end = e;

        while (start <= end) {
            if (nums[start] >= nums[pivot] && nums[end] <= nums[pivot]) {
                swap(nums, start, end);
            }
            if (nums[start] <= nums[pivot]) {
                start++;
            }
            if (nums[end] >= nums[pivot]) {
                end--;
            }
        }
        swap(nums, pivot, end);
        if (end == kth) {
            return;
        }

        //                  end
        // s _______________*_________ e
        if (end - 1 - s > e - (end + 1)) {
            sort(nums, s, end - 1, kth);
            sort(nums, end + 1, e, kth);
        } else {
            sort(nums, end + 1, e, kth);
            sort(nums, s, end - 1, kth);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
