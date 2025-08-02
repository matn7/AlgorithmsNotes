package july_2025;

public class MinInRotatedArr {

    public static void main(String[] args) {
        int[] nums = {11,13,15,17};

        MinInRotatedArr minInRotatedArr = new MinInRotatedArr();
        int result = minInRotatedArr.findMin(nums);
        System.out.println(result);
    }

    public int findMin(int[] nums) {
        int res = nums[0];
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (nums[l] <= nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int m = (l + r) / 2;
            res = Math.min(res, nums[m]);
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }

}
