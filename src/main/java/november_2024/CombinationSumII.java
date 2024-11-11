package november_2024;

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

    // O(2^n) time
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), 0, target, candidates, res);
        return res;
    }

    private void dfs(List<Integer> curr, int pos, int target, int[] candidates, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target <= 0) {
            return;
        }
        int prev = -1;
        for (int i = pos; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (candidate == prev) {
                continue;
            }
            curr.add(candidates[i]);
            dfs(curr, i + 1, target - candidates[i], candidates, res);
            curr.remove(curr.size() - 1);
            prev = candidate;
        }
    }

}
