package june_2025;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> result = combinationSum2.combinationSum(candidates, target);
        System.out.println(result);
    }

    // O(n*2^n) time | O(n) space
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        dfs(candidates, 0, 0, target, part, result);
        return result;
    }

    private void dfs(int[] candidates, int idx, int sum, int target, List<Integer> part, List<List<Integer>> result) {
        if (target == sum) {
            result.add(new ArrayList<>(part)); // O(n)
            return;
        }
        if (sum > target || idx >= candidates.length) {
            return;
        }
        part.add(candidates[idx]);
        dfs(candidates, idx, sum + candidates[idx], target, part, result);
        part.remove(part.size() - 1);
        dfs(candidates, idx + 1, sum, target, part, result);
    }

}
