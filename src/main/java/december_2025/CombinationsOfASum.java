package december_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsOfASum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        CombinationsOfASum combinationsOfASum = new CombinationsOfASum();
        List<List<Integer>> result = combinationsOfASum.combinationSum(candidates, target);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();

        // Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target, part, result);

        return result;
    }

    private void backtrack(int[] candidates, int i, int sum, int target, List<Integer> part, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(part));
            return;
        }
        if (sum > target || i >= candidates.length) {
            return;
        }

        // include
        part.add(candidates[i]);
        backtrack(candidates, i, sum + candidates[i], target, part, res);

        // not include
        part.remove(part.size() - 1);
        backtrack(candidates, i + 1, sum, target, part, res);
    }


}
