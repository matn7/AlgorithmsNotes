package march_2024;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);
    }

    // O(n) time | O(1) space
    public static int[] moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[zeroIndex] = num;
                zeroIndex++;
            }
        }

        for (int i = zeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }

}
