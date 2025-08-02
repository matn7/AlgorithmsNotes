package july_2025;

public class RemoveDuplicates {

    // O(n) time | O(1) space
    public int removeDuplicates(int[] nums) {
        int L = 0;
        int R = 0;

        while (R < nums.length) {
            nums[L] = nums[R];
            while (R < nums.length && nums[L] == nums[R]) {
                R++;
            }
            L++;
        }
        return L;
    }

}
