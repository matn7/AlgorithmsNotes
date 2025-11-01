package october_2025;

public class ConcatenationOfArray {

    public static void main(String[] args) {
        int[] nums = {1,2,1};

        ConcatenationOfArray concatenationOfArray = new ConcatenationOfArray();
        int[] result = concatenationOfArray.getConcatenation(nums);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[2 * nums.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = nums[i % nums.length];
        }

        return result;
    }

}
