package december_2024;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] nums = {4, -1, 2, -7, 3, 4};

        KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm();
        int result = kadanesAlgorithm.kadanes(nums);
        System.out.println(result);
    }

    public int kadanes(int[] nums) {
        // [4, -1, 2, -7, 3, 4]
        int maxNumHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            maxNumHere = Math.max(num, maxNumHere + num);
            maxSoFar = Math.max(maxSoFar, maxNumHere);
        }

        return maxSoFar;
    }

}
