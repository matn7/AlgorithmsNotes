package april_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {1, 5, 2, 1, 2};
        int target = 5;

        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> result = combinationSumII.combinationSum2(candidates, target);
        System.out.println(result);
    }

    // O(n*2^n) time | O(n) space
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int idx, int sum, int target, List<Integer> curr, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (sum > target || idx == candidates.length) {
            return;
        }
        curr.add(candidates[idx]);
        backtrack(candidates, idx + 1, sum + candidates[idx], target, curr, result);
        curr.remove(curr.size() - 1);

        while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) {
            idx++;
        }
        backtrack(candidates, idx + 1, sum, target, curr, result);
    }

}
