package december_2025;

public class LonelyInteger {

    // O(n) time | O(1) space
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
