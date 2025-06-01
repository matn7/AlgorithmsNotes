package may_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII2 {

    public static void main(String[] args) {
        int[] candidates = {2, 2, 1, 2, 5};
        int target = 5;

        CombinationSumII2 combinationSumII2 = new CombinationSumII2();
        List<List<Integer>> result = combinationSumII2.combinationSum2(candidates, target);
        System.out.println(result);
    }

    // O(n*2^n) time | O(n) space
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target, sub, res);
        return res;
    }

    private void backtrack(int[] candidates, int i, int sum, int target, List<Integer> sub, List<List<Integer>> res) {
        if (target == sum) {
            res.add(new ArrayList<>(sub));
            return;
        }
        if (i >= candidates.length || sum > target) {
            return;
        }
        sub.add(candidates[i]);
        backtrack(candidates, i + 1, sum + candidates[i], target, sub, res);
        sub.remove(sub.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        backtrack(candidates, i + 1, sum, target, sub, res);
    }

}
