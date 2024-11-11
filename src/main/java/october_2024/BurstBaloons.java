package october_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BurstBaloons {

    public static void main(String[] args) {
        BurstBaloons burstBaloons = new BurstBaloons();
        int[] nums = {3, 1, 5, 8};
        int result = burstBaloons.maxCoins(nums);
        System.out.println(result);
    }

    // leetcode 312

    // O(n!) time | O(n!) space
    public int maxCoins(int[] nums) {
        List<Integer> numsArr = new ArrayList<>();
        for (int num : nums) {
            numsArr.add(num);
        }
        Map<String, Integer> cache = new HashMap<>();
        Max max = new Max(0);
        helper(numsArr, 0, max, cache);
        return max.max;
    }

    private void helper(List<Integer> numsArr, int sum, Max max, Map<String, Integer> cache) {
        String key = getKey(numsArr, sum);
        if (cache.containsKey(key)) {
            return;
        }
        if (numsArr.size() == 0) {
            max.max = Math.max(max.max, sum);
        } else {
            for (int i = 0; i < numsArr.size(); i++) {
                List<Integer> newNumsArr = new ArrayList<>(numsArr);
                int newSum = sum;
                int leftMul = 1;
                int rightMul = 1;
                if (i + 1 < numsArr.size()) {
                    leftMul = newNumsArr.get(i + 1);
                }
                if (i - 1 >= 0) {
                    rightMul = newNumsArr.get(i - 1);
                }
                int removed = newNumsArr.remove(i);
                newSum += (leftMul * removed * rightMul);
                helper(newNumsArr, newSum, max, cache);
            }
        }
        cache.put(key, max.max);
    }

    private String getKey(List<Integer> numsArr, int sum) {  // Updated to include sum
        StringBuilder builder = new StringBuilder();
        builder.append(sum).append(":");  // Include sum in the key
        for (Integer n : numsArr) {
            builder.append(n).append(",");  // Add delimiter for clarity
        }
        return builder.toString();
    }

    static class Max {
        int max;

        public Max(int max) {
            this.max = max;
        }
    }

}
