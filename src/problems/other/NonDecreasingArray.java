package problems.other;

public class NonDecreasingArray {

    public static void main(String[] args) {
//        int[] nums = {4, 1, 2};
        int[] nums = {3, 2, 4, 1};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        boolean result = nonDecreasingArray.checkPossibility(nums);
        System.out.println();
    }

    // index = n - 2 index
    // index = 0 index
    // n[index] <= n[index]
    // n[index - 1] <= n[index + 1]

    // O(n) time | O(1) space
    public boolean checkPossibility(int[] nums) {

        int invalid_index = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (invalid_index != -1) {
                    return false;
                }
                invalid_index = i;
            }
        }

        if (invalid_index != -1) {
            return true;
        }
        if (invalid_index == 0) {
            return true;
        }
        if (invalid_index == nums.length - 2) {
            return true;
        }
        if (nums[invalid_index] <= nums[invalid_index + 2]) {
            return true;
        }
        if (nums[invalid_index - 1] <= nums[invalid_index + 1]) {
            return true;
        }
        return false;
    }

}
