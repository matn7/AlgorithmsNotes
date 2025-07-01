package june_2025;

public class ConcatenationOfArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        ConcatenationOfArray concatenationOfArray = new ConcatenationOfArray();
        int[] concatenation = concatenationOfArray.getConcatenation(nums);
        System.out.println(concatenation);
    }

    // O(n) time | O(n) space
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];

        for (int i = 0; i < 2 * nums.length; i++) {
            ans[i] = nums[i % nums.length];
        }
        return ans;

    }

}
