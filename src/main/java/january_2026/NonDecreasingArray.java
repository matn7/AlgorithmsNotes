package january_2026;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        boolean used = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (used) {
                    return false;
                }
                used = true;
                i--;
            }
        }
        return true;
    }

}
