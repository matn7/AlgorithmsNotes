package may_2025;

public class FindMin {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        FindMin findMin = new FindMin();
        int result = findMin.findMin(nums);
        System.out.println(result);
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];
        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int m = (l + r) / 2; // l + (r-l)/2
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
