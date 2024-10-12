package march_2024;

public class ValidMountainArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 4, 3, 1};

        boolean result = validMountain(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static boolean validMountain(int[] nums) {
        int i = 1;

        while (i < nums.length && nums[i] > nums[i - 1]) {
            i++;
        }
        if (i == 1 || i == nums.length) {
            return false;
        }
        while (i < nums.length && nums[i] < nums[i - 1]) {
            i++;
        }
        return i == nums.length;
    }

}
