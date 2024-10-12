package may_2024;

public class KadenesAlgorithm {

    public static void main(String[] args) {
        int[] nums = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};

        int result = kadanesAlgorithm(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int kadanesAlgorithm(int[] nums) {
        int maxNumHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxNumHere = Math.max(maxNumHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxNumHere);
        }

        return maxSoFar;
    }


}
