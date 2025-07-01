package june_2025;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        MissingNumber missingNumber = new MissingNumber();
        int result = missingNumber.missingNumber(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = n;

        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }

}
