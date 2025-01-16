package december_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;

        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> result = combinationSumII.combinationSum2(candidates, target);
        System.out.println(result);
        // [2,3,5], target = 8
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0, candidates, 0, target, curr, result);
        return result;
    }

    private void backtrack(int i, int[] candidates, int total, int target, List<Integer> curr, List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (i == candidates.length || total > target) {
            return;
        }
        // include candidates[i]
        curr.add(candidates[i]);
        backtrack(i + 1, candidates, total + candidates[i], target, curr, result);
        curr.remove(curr.size() - 1);

        // skip candidates[i]
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        backtrack(i + 1, candidates, total, target, curr, result);
    }

}
