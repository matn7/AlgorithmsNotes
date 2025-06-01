package may_2025;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0, 1, 1};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int l = k + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[k] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[k], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return new ArrayList<>(result);
    }

}
