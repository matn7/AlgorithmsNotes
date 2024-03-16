package october_2023;

public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 1};

        nonDecreasingArray(nums);

    }

    public static boolean nonDecreasingArray(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        boolean increasing = false;
        boolean decreasing = false;
        boolean flat = false;

        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1]; // 3
            int curr = nums[1]; // 2
            if (prev > curr) {
                // decreasing
                if (increasing) {
                    return false;
                }
                decreasing = true;
            } else if (prev < curr) {
                // increasing
                if (decreasing) {
                    return false;
                }
                increasing = true;
            } else {
                flat = true;
            }
        }
        return increasing;
    }

}
