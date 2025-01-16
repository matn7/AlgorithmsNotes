package january_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> result = combinationSumII.combinationSum2(candidates, target);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, target, 0, curr);
        return res;
    }

    private void backtrack(int[] candidates, int target, int i, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i == candidates.length || target < 0) {
            return;
        }
        curr.add(candidates[i]);
        backtrack(candidates, target - candidates[i], i + 1, curr);
        curr.remove(curr.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        backtrack(candidates, target, i + 1, curr);
    }



}
