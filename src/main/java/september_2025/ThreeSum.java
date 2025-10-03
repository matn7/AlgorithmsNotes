package september_2025;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        // [-4, -1, -1, 0, 1, 2]
        //       i   j        ka
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
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
                    result.add(Arrays.asList(num1, num2, num3));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
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
