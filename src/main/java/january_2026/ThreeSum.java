package january_2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 1 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int num1 = nums[i];

            while (j < k) {
                int num2 = nums[j];
                int num3 = nums[k];

                int sum = num1 + num2 + num3;
                if (sum == 0) {
                    result.add(List.of(num1, num2, num3));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

}
