package july_2025;

public class PivotIndex {

    public static void main(String[] args) {

//        int[] nums = {1,7,3,6,5,6};
        int[] nums = {2,1,-1};

        PivotIndex pivotIndex = new PivotIndex();
        int result = pivotIndex.pivotIndex(nums);
        System.out.println(result);
    }

    // Intuition:
    // - brute force - calc left - calc right from idx, check
    // - repeated work
    // - pre-compute than check in O(1) time ranges
    // Approach:
    // - prefix sum
    // Complexity:
    // O(n) time | O(n) space create -> O(n) time search -> O(2n) time
    // Code:

    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        int leftSum = 0;
        int rightSum = prefixSum[nums.length - 1] - prefixSum[0];
        if (leftSum == rightSum) {
            return 0;
        }
        int idx = 1;
        while (idx < nums.length) {
            leftSum = prefixSum[idx - 1];
            rightSum = prefixSum[nums.length - 1] - prefixSum[idx];
            if (leftSum == rightSum) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

}
