package november_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, 0, 0, target, part, result);

        return result;
    }

    private void backtrack(int[] candidates, int i, int sum, int target, List<Integer> part, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(part));
            return;
        }
        if (i == candidates.length || sum > target) {
            return;
        }
        part.add(candidates[i]); // include
        backtrack(candidates, i, sum + candidates[i], target, part, result);
        part.remove(part.size() - 1); // not include
        backtrack(candidates, i + 1, sum, target, part, result);
    }

}
