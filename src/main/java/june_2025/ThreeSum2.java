package june_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum2 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        ThreeSum2 threeSum2 = new ThreeSum2();
        List<List<Integer>> result = threeSum2.threeSum(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num1 = nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int num2 = nums[j];
                int num3 = nums[k];

                int sum = num1 + num2 + num3;
                if (sum == 0) {
                    result.add(Arrays.asList(num1, num2, num3));
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }


}
