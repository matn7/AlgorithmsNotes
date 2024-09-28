package problems.other;

public class FixedPoint {

    public static void main(String[] args) {
//        int[] nums = {-5, 1, 3, 4, 5, 6, 7, 8, 9};
        int[] nums = {1, 2, 3, 3, 99, 100, 102, 189, 286};

        FixedPoint fixedPoint = new FixedPoint();
        int result = fixedPoint.find_fixed_point(nums);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int find_fixed_point_iterative(int[] nums) {
        int low = 0;
        int high = nums.length;

        while (low != high) {
            int mid = (low + high) / 2;
            if (nums[mid] == mid) {
                return mid;
            }
            if (nums[mid] < mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // O(log(n)) time | O(log(n)) space
    public int find_fixed_point(int[] nums) {
        return find_fixed_point_helper(0, nums.length - 1, nums);
    }

    private int find_fixed_point_helper(int low, int high, int[] nums) {
        if (low == high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (nums[mid] == mid) {
            return mid;
        }
        if (nums[mid] < mid) {
            return find_fixed_point_helper(mid + 1, high, nums);
        } else {
            return find_fixed_point_helper(low, mid - 1, nums);
        }

    }


    // O(nlog(n)) time | O(1) space
    public int fixedPoint(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        //  0  1  2  3  4  5  6  7  8   index
        // ----------------------------
        // -5, 1, 3, 4, 5, 6, 7, 8, 9
        //              *

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;

    }

}
