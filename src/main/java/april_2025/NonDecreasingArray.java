package april_2025;

public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
//        int[] nums = {4, 2, 1};

        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        boolean result = nonDecreasingArray.checkPossibility(nums);
        System.out.println(result);
    }

    public boolean checkPossibility(int[] nums) {
        int invalidCount = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i];
            int next = nums[i + 1];
            if (curr > next) {
                invalidCount++;
            }
        }
        return invalidCount <= 1;
    }

    // O(n) time | O(1) space
    public boolean checkPossibility2(int[] nums) {
        int invalidIdx = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (invalidIdx != -1) {
                    return false;
                }
                invalidIdx = i;
            }
        }
        if (invalidIdx == -1) {
            return true; // strictly increasing
        }
        if (invalidIdx == 0) {
            return true;
        }
        if (invalidIdx == nums.length - 2) {
            return true;
        }
        if (nums[invalidIdx] <= nums[invalidIdx + 2]) {
            return true;
        }
        if (nums[invalidIdx - 1] <= nums[invalidIdx + 1]) {
            return true;
        }
        return false;
    }

}
