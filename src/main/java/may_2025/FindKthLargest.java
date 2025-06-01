package may_2025;

public class FindKthLargest {


    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        FindKthLargest findKthLargest = new FindKthLargest();
        int result = findKthLargest.findKthLargest(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int findKthLargest(int[] nums, int k) {
        int kth = nums.length - k;
        quickselect(nums, kth);
        return nums[kth];
    }

    private void quickselect(int[] nums, int kth) {
        quicksort(nums, 0, nums.length - 1, kth);
    }

    private void quicksort(int[] nums, int start, int end, int kth) {
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
            quicksort(nums, start, e - 1, kth);
            quicksort(nums, e + 1, end, kth);
        } else {
            quicksort(nums, e + 1, end, kth);
            quicksort(nums, start, e - 1, kth);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
