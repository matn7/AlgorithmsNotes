package october_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;

        CombinationSum combinationSum = new CombinationSum();
        int result = combinationSum.combinationSum42(nums, target);
        System.out.println(result);
    }

    // O(m*t) time | O(t) space
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        return helper(nums, 0, target, cache);
    }

    private int helper(int[] nums, int current, int target, Map<Integer, Integer> cache) {
        if (current == target) {
            return 1;
        }
        if (cache.containsKey(current)) {
            return cache.get(current);
        }
        int res = 0;
        for (int n : nums) {
            int newCurrent = n + current;
            if (newCurrent > target) {
                continue;
            }
            res += helper(nums, newCurrent, target, cache);
        }
        cache.put(current, res);
        return res;
    }

    public int combinationSum42(int[] nums, int target) {
        List<List<Integer>> sums = new ArrayList<>();
        helper2(nums, 0, new ArrayList<>(), target, sums);
        return sums.size();
    }

    private void helper2(int[] nums, int current, List<Integer> currNums, int target, List<List<Integer>> sums) {
        if (current == target) {
            sums.add(currNums);
        } else {
            for (int n : nums) {
                int newCurrent = n + current;
                if (newCurrent > target) {
                    continue;
                }
                List<Integer> newCurrNums = new ArrayList<>(currNums);
                newCurrNums.add(n);
                helper2(nums, newCurrent, newCurrNums, target, sums);
            }
        }
    }

    public int combinationSum43(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> cache = new HashMap<>();
        helper3(nums, 0, new ArrayList<>(), target, cache);
        return cache.getOrDefault(target, new ArrayList<>()).size();
    }

    private void helper3(int[] nums, int current, List<Integer> currNums, int target, Map<Integer, List<List<Integer>>> cache) {
        if (current == target) {
            // Add a copy of currNums to the cache for the current sum
            cache.computeIfAbsent(current, k -> new ArrayList<>()).add(new ArrayList<>(currNums));
            return;
        }

        if (current > target) {
            return; // No need to proceed if we exceed the target
        }

        // Check if we have cached results for the current sum
        if (cache.containsKey(current)) {
            // If cached, add those combinations to the results
            for (List<Integer> combination : cache.get(current)) {
                // Add a copy of the cached combination
                cache.computeIfAbsent(current, k -> new ArrayList<>()).add(new ArrayList<>(combination));
            }
            return;
        }

        for (int n : nums) {
            int newCurrent = n + current;
            List<Integer> newCurrNums = new ArrayList<>(currNums);
            newCurrNums.add(n);
            helper3(nums, newCurrent, newCurrNums, target, cache);
        }
    }

}
