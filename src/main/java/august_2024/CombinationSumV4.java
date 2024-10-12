package august_2024;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumV4 {

    // O(2^n) time | O(2^n) space
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void findCombinations(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));  // Add a copy of the current combination to the result
            return;
        }

        if (target < 0) {
            return;  // If the remaining target becomes negative, no point in continuing
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);  // Choose the current candidate
            findCombinations(candidates, target - candidates[i], i, current, result);  // Recursively explore further
            current.remove(current.size() - 1);  // Backtrack by removing the last added candidate
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(candidates, target);
        System.out.println(combinations);
    }
}