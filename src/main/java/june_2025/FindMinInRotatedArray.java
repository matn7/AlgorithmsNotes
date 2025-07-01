package june_2025;

public class FindMinInRotatedArray {

    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {7,0,1,2,4,5,6};

        FindMinInRotatedArray findMinInRotatedArray = new FindMinInRotatedArray();
        int result = findMinInRotatedArray.findMin(nums);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int findMin(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        int res = nums[0];

        while (L <= R) {
            if (nums[L] < nums[R]) {
                res = Math.min(res, nums[L]);
                break;
            }
            int m = L + (R - L) / 2;
            res = Math.min(res, nums[m]);
            if (nums[m] >= nums[R]) {
                L = m + 1;
            } else {
                R = m - 1;
            }
        }
        return res;
    }

}
