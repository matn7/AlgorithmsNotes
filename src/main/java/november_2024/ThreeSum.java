package november_2024;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        int start = 0;
        while (start < nums.length) {
            int l = start + 1;
            int r = nums.length - 1;
            int sum = 0;
            while (l < r) {
                sum = nums[start] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> oneRes = new ArrayList<>();
                    String key = nums[start] + ":" + nums[l] + ":" + nums[r];
                    if (!seen.contains(key)) {
                        oneRes.add(nums[start]);
                        oneRes.add(nums[l]);
                        oneRes.add(nums[r]);
                        result.add(oneRes);
                        seen.add(key);
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
            start++;
        }

        return result;
    }

}
