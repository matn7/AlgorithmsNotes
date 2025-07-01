package june_2025;

public class FindMinInRotatedArr2 {

    public static void main(String[] args) {
//        int[] nums = {3,4,5,1,2};
//        int[] nums ={4,5,6,7,0,1,2};
//        int[] nums = {11,13,15,17};
//        int[] nums = {3, 1, 2};

        int[] nums = {7, 0, 1, 2, 4, 5, 6};

        FindMinInRotatedArr2 findMin = new FindMinInRotatedArr2();
        int result = findMin.findMin(nums);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while (l <= r) {
            if (nums[l] <= nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int m = (l + r) / 2;
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
