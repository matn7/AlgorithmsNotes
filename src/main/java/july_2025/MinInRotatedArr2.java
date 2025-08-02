package july_2025;

public class MinInRotatedArr2 {

    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {11,13,15,17};
//        int[] nums = {3,4,5,1,2};
        int[] nums = {5,1,2,3,4};
        MinInRotatedArr2 minInRotatedArr2 = new MinInRotatedArr2();
        int result = minInRotatedArr2.findMin(nums);
        System.out.println(result);
    }

    // Intuition:
    // - sorted
    // - brute force - O(n) just loop one time
    // Approach:
    // - apply binary search
    // - keep checking min
    // - terminate if nums[l] <= nums[r]
    // Complexity:
    // O(log(n)) time | O(1) space
    // Code:

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while (l <= r) {
            if (nums[l] <= nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int m = (l + r) / 2; // (l + (r - l) / 2)
            res = Math.min(res, nums[m]);
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
         }

        return res;
    }

}
