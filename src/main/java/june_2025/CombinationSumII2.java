package june_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII2 {

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        CombinationSumII2 combinationSumII2 = new CombinationSumII2();
        List<List<Integer>> result = combinationSumII2.combinationSum2(candidates, target);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, part, result);
        return result;
    }

    private void dfs(int[] candidates, int target, int idx, int sum, List<Integer> part, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(part)); // O(n)
            return;
        }
        if (sum > target || idx >= candidates.length) {
            return;
        }
        part.add(candidates[idx]);
        dfs(candidates, target, idx + 1, sum + candidates[idx], part, result);
        part.remove(part.size() - 1);
        while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) {
            idx++;
        }
        dfs(candidates, target, idx + 1, sum, part, result);
    }

}
