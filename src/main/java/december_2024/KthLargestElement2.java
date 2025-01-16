package december_2024;

public class KthLargestElement2 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        KthLargestElement2 kthLargest = new KthLargestElement2();
        int result = kthLargest.findKthLargest(nums, k);
        System.out.println(result);
    }

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        int pivot = nums[r];
        int p = l;

        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }
        int temp = nums[p];
        nums[p] = nums[r];
        nums[r] = temp;

        if (p > k) { // smaller portion
            return quickSelect(nums, l, p - 1, k);
        } else if (p < k) {
            return quickSelect(nums, p + 1, r, k);
        } else {
            return nums[p];
        }
    }

}
