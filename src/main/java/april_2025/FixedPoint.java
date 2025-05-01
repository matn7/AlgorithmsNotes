package april_2025;

public class FixedPoint {

    public static void main(String[] args) {
//        int[] nums = {-5, -4, -3, 2, 6, 7, 8, 9, 10, 11, 12};
//        int[] nums = {-5, -4, -3, 2, 4, 5, 8, 9, 10, 11, 12};
        int[] nums = {-5, 1, 3, 4};

        FixedPoint fixedPoint = new FixedPoint();
        int result = fixedPoint.fixedPointRec(nums);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public int fixedPointRec(int[] nums) {
        int result = helper(nums, 0, nums.length - 1, Integer.MAX_VALUE);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int helper(int[] nums, int L, int R, int res) {
        if (L > R) {
            return res;
        }
        int mid = (L + R) / 2; // (L + (R - L) / 2)
        int num = nums[mid];
        if (mid == num) {
            res = Math.min(res, mid);
            return helper(nums, L, mid - 1, res);
        } else if (num > mid) {
            return helper(nums, L, mid - 1, res);
        } else {
            return helper(nums, mid + 1, R, res);
        }
    }


    // O(log(n)) time | O(1) space
    public int fixedPoint(int[] nums) {
        int L = 0;
        int R = nums.length - 1;

        int res = Integer.MAX_VALUE;
        while (L <= R) {
            int mid = (L + R) / 2; // (L + (R - L) / 2)
            int num = nums[mid];
            if (mid == num) {
                res = Math.min(res, mid);
                R = mid - 1;
            } else if (num > mid) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
