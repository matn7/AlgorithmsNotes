package december_2023;

public class NonDecreasingArray {

    public static void main(String[] args) {
//        int[] nums = {4, 1, 2};
        int[] nums = {3, 2, 4, 1};
        System.out.println(checkPossibility(nums));
    }

    // O(n) time | O(1) space
    public static boolean checkPossibility(int[] nums) {
        int invalidIndex = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (invalidIndex != -1) {
                    return false;
                }
                invalidIndex = i;
            }
        }

        if (invalidIndex == -1) {
            return true;
        }
        if (invalidIndex == 0) {
            return true;
        }
        if (invalidIndex == nums.length - 2) {
            return true;
        }
        if (nums[invalidIndex] <= nums[invalidIndex + 2]) {
            return true;
        }
        if (nums[invalidIndex - 1] <= nums[invalidIndex + 1]) {
            return true;
        }
        return false;
    }

}
