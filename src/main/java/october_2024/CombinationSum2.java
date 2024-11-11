package october_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;

        CombinationSum2 combinationSum = new CombinationSum2();
        int result = combinationSum.combinationSum4(nums, target);
        System.out.println(result);
    }

    // O(m*t) time | O(t) space
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int total = 1; total < target + 1; total++) {
            dp.put(total, 0);
            for (int n : nums) {
                dp.put(total, dp.getOrDefault(total - n, 0) + dp.get(total));
            }
        }
        return dp.get(target);
    }



}
