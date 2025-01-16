package november_2024;

public class PivotIndex {

    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums = {-1,-1,0,1,1,0};

        PivotIndex pivotIndex = new PivotIndex();
        int result = pivotIndex.pivotIndex(nums);
        System.out.println(result);
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        int right = sum - nums[0];
        int idx = 1;
        while (idx < nums.length){
            if (left == right) {
                return idx - 1;
            }
            left += nums[idx - 1];
            right -= nums[idx];
            idx++;
        }
        if (left == right) {
            return idx - 1;
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - nums[i] - leftSum;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

}
