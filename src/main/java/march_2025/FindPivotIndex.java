package march_2025;

public class FindPivotIndex {

    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums = {2,1,-1};

        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int result = findPivotIndex.pivotIndex(nums);
        System.out.println(result);
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i + 1] = sum;
        }

        for (int i = 1; i <= nums.length; i++) {
            int toLeft = prefixSum[i - 1];
            int toRight = prefixSum[prefixSum.length - 1] - prefixSum[i];
            if (toLeft == toRight) {
                return i - 1;
            }
        }

        return -1;
    }

}
