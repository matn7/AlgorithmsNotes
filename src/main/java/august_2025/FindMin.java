package august_2025;

public class FindMin {

    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};

        int[] nums = {3,4,5,1,2};

        FindMin findMin = new FindMin();
        int result = findMin.findMin(nums);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int findMin(int[] nums) {
        //  L     M     R
        // [4,5,6,7,0,1,2]
        //  0 1 2 3 4 5 6
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[l] <= nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
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
